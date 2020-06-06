package com.imgui.impl

import cimgui.internal.*
import cimgui.internal.ImDrawVert
import com.imgui.*
import com.imgui.ImDrawData
import com.imgui.ImGuiBackendFlags
import com.imgui.ImGuiConfigFlags
import com.kgl.opengl.*
import io.ktor.utils.io.core.*
import kotlinx.cinterop.*

//----------------------------------------
// OpenGL    GLSL      GLSL
// version   version   string
//----------------------------------------
//  2.0       110       "#version 110"
//  2.1       120       "#version 120"
//  3.0       130       "#version 130"
//  3.1       140       "#version 140"
//  3.2       150       "#version 150"
//  3.3       330       "#version 330 core"
//  4.0       400       "#version 400 core"
//  4.1       410       "#version 410 core"
//  4.2       420       "#version 410 core"
//  4.3       430       "#version 430 core"
//  ES 2.0    100       "#version 100"      = WebGL 1.0
//  ES 3.0    300       "#version 300 es"   = WebGL 2.0
//----------------------------------------

actual class ImGuiOpenGL3
actual constructor(
	glslVersionString: String,
	isOpenGLES: Boolean
) : Closeable {
	private val glVersion: Int
	private val glIsOpenGLES: Boolean = isOpenGLES
	private val glHasPolygonMode: Boolean
	private val glHasUnpackRowLength: Boolean
	private val glHasSamplerBinding: Boolean
	private val glHasClipOrigin: Boolean
	private val glMayHaveVertexOffset: Boolean

	private val fontTexture: UInt
	private val shaderHandle: UInt
	private val vertHandle: UInt
	private val fragHandle: UInt
	private val attribLocationTex: Int
	private val attribLocationProjMtx: Int
	private val attribLocationVtxPos: Int
	private val attribLocationVtxUV: Int
	private val attribLocationVtxColor: Int
	private val vboHandle: UInt
	private val elementsHandle: UInt

	init {
		//@formatter:off
		glVersion = if (!glIsOpenGLES) glGetInteger(GL_MAJOR_VERSION) * 100 + glGetInteger(GL_MINOR_VERSION) * 10 else 200
		//@formatter:on
		glHasPolygonMode = glVersion >= 200
		glHasUnpackRowLength = glVersion >= 200
		glHasSamplerBinding = glVersion >= 320
		glHasClipOrigin = glVersion >= 450
		glMayHaveVertexOffset = !glIsOpenGLES

		val io = ImGui.getIO()
		io.ptr.pointed.BackendRendererUserData = StableRef.create(this).asCPointer()
		// io.backendRendererName = "ImGui OpenGL3"
		if (glMayHaveVertexOffset) {
			// We can honor the ImDrawCmd::VtxOffset field, allowing for large meshes.
			io.backendFlags = io.backendFlags or ImGuiBackendFlags.RendererHasVtxOffset
		}
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.RendererHasViewports

		// Make a dummy GL call (we don't actually need the result)
		// IF YOU GET A CRASH HERE: it probably means that you haven't initialized the OpenGL function loader used by this code.
		// Desktop OpenGL 3/4 need a function loader. See the IMGUI_IMPL_OPENGL_LOADER_xxx explanation above.
		val currentTexture = glGetInteger(GL_TEXTURE_BINDING_2D)
		// Make a dummy test call.
		check(currentTexture >= 0)

		if (ImGuiConfigFlags.ViewportsEnable in io.configFlags) {
			initPlatformInterface()
		}

		// Create device objects
		// Backup GL state
		val lastTexture = glGetInteger(GL_TEXTURE_BINDING_2D)
		val lastArrayBuffer = glGetInteger(GL_ARRAY_BUFFER_BINDING)
		val lastVertexArray = if (!glIsOpenGLES) glGetInteger(GL_VERTEX_ARRAY_BINDING) else 0

		// Parse GLSL version string
		val glslVersion = glslVersionString.takeLast(3).toInt()

		val vertexShader: String
		val fragmentShader: String
		when {
			glslVersion < 130 -> {
				vertexShader = Shaders.vertexShaderGLSL120
				fragmentShader = Shaders.fragmentShaderGLSL120
			}
			glslVersion >= 410 -> {
				vertexShader = Shaders.vertexShaderGLSL410Core
				fragmentShader = Shaders.fragmentShaderGLSL410Core
			}
			glslVersion == 300 -> {
				vertexShader = Shaders.vertexShaderGLSL300ES
				fragmentShader = Shaders.fragmentShaderGLSL300ES
			}
			else -> {
				vertexShader = Shaders.vertexShaderGLSL130
				fragmentShader = Shaders.fragmentShaderGLSL130
			}
		}

		fun checkShader(handle: UInt, description: String) {
			val status = glGetShaderi(handle, GL_COMPILE_STATUS)
			val infoLog = glGetShaderInfoLog(handle)
			if (infoLog.isNotBlank()) {
				println(infoLog)
			}

			check(status == GL_TRUE.toInt()) { "ERROR: Failed to compile $description!" }
		}

		fun checkProgram(handle: UInt, description: String) {
			val status = glGetProgrami(handle, GL_LINK_STATUS)
			val infoLog = glGetProgramInfoLog(handle)
			if (infoLog.isNotBlank()) {
				println(infoLog)
			}

			check(status == GL_TRUE.toInt()) { "ERROR: Failed to compile $description!" }
		}

		vertHandle = glCreateShader(GL_VERTEX_SHADER)
		glShaderSource(vertHandle, "$glslVersionString\n$vertexShader")
		glCompileShader(vertHandle)
		checkShader(vertHandle, "vertex shader")

		fragHandle = glCreateShader(GL_FRAGMENT_SHADER)
		glShaderSource(fragHandle, "$glslVersionString\n$fragmentShader")
		glCompileShader(fragHandle)
		checkShader(fragHandle, "fragment shader")

		shaderHandle = glCreateProgram()
		glAttachShader(shaderHandle, vertHandle)
		glAttachShader(shaderHandle, fragHandle)
		glLinkProgram(shaderHandle)
		checkProgram(shaderHandle, "shader program")

		attribLocationTex = glGetUniformLocation(shaderHandle, "Texture")
		attribLocationProjMtx = glGetUniformLocation(shaderHandle, "ProjMtx")
		attribLocationVtxPos = glGetAttribLocation(shaderHandle, "Position")
		attribLocationVtxUV = glGetAttribLocation(shaderHandle, "UV")
		attribLocationVtxColor = glGetAttribLocation(shaderHandle, "Color")

		vboHandle = glGenBuffer()
		elementsHandle = glGenBuffer()

		// Create fonts texture
		fontTexture = glGenTexture()
		memScoped {
			val pixels = allocPointerTo<UByteVar>()
			val width = alloc<IntVar>()
			val height = alloc<IntVar>()

			// Load as RGBA 32-bits (75% of the memory is wasted, but default font is so small)
			// because it is more likely to be compatible with user's existing shaders.
			// If your ImTextureId represent a higher-level concept than just a GL texture id,
			// consider calling GetTexDataAsAlpha8() instead to save on GPU memory.
			ImFontAtlas_GetTexDataAsRGBA32(io.fonts!!.ptr, pixels.ptr, width.ptr, height.ptr, null)

			// Upload texture to graphics system
			glBindTexture(GL_TEXTURE_2D, fontTexture)
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR.toInt())
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR.toInt())
			if (glHasUnpackRowLength) glPixelStorei(GL_UNPACK_ROW_LENGTH, 0)
			//@formatter:off
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA.toInt(), width.value, height.value, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels.value)
			//@formatter:on
		}

		// Store our identifier
		io.fonts!!.ptr.pointed.TexID = fontTexture.toLong().toCPointer()

		// Restore modified GL state
		glBindTexture(GL_TEXTURE_2D, lastTexture.toUInt())
		glBindBuffer(GL_ARRAY_BUFFER, lastArrayBuffer.toUInt())
		if (!glIsOpenGLES) glBindVertexArray(lastVertexArray.toUInt())
	}

	actual fun newFrame() {}

	private fun setupRenderState(drawData: ImDrawData, fbWidth: Int, fbHeight: Int, vertexArrayObject: UInt) {
		// Setup render state: alpha-blending enabled, no face culling, no depth testing, scissor enabled, polygon fill
		glEnable(GL_BLEND)
		glBlendEquation(GL_FUNC_ADD)
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
		glDisable(GL_CULL_FACE)
		glDisable(GL_DEPTH_TEST)
		glEnable(GL_SCISSOR_TEST)
		if (glHasPolygonMode) {
			glPolygonMode(GL_FRONT_AND_BACK, GL_FILL)
		}

		glViewport(0, 0, fbWidth, fbHeight)
		val l = drawData.displayPos.x
		val r = drawData.displayPos.x + drawData.displaySize.x
		val t = drawData.displayPos.y
		val b = drawData.displayPos.y + drawData.displaySize.y

		//@formatter:off
		val orthoProjection = floatArrayOf(
			2.0f/(r-l),   0.0f,         0.0f,   0.0f,
			0.0f,         2.0f/(t-b),   0.0f,   0.0f,
			0.0f,         0.0f,        -1.0f,   0.0f,
			(r+l)/(l-r),  (t+b)/(b-t),  0.0f,   1.0f
		)
		//@formatter:on
		glUseProgram(shaderHandle)
		glUniform1i(attribLocationTex, 0)
		glUniformMatrix4fv(attribLocationProjMtx, 1, false, orthoProjection.refTo(0))
		if (glHasSamplerBinding) {
			// We use combined texture/sampler state. Applications using GL 3.3 may set that otherwise.
			glBindSampler(0U, 0U)
		}

		if (!glIsOpenGLES) glBindVertexArray(vertexArrayObject)

		// Bind vertex/index buffers and setup attributes for ImDrawVert
		glBindBuffer(GL_ARRAY_BUFFER, vboHandle)
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, elementsHandle)
		glEnableVertexAttribArray(attribLocationVtxPos.toUInt())
		glEnableVertexAttribArray(attribLocationVtxUV.toUInt())
		glEnableVertexAttribArray(attribLocationVtxColor.toUInt())
		//@formatter:off
		glVertexAttribPointer(attribLocationVtxPos.toUInt(),   2, GL_FLOAT,         false, sizeOf<ImDrawVert>().toInt(), 0L.toCPointer<ByteVar>())
		glVertexAttribPointer(attribLocationVtxUV.toUInt(),    2, GL_FLOAT,         false, sizeOf<ImDrawVert>().toInt(), (sizeOf<FloatVar>() * 2).toCPointer<ByteVar>())
		glVertexAttribPointer(attribLocationVtxColor.toUInt(), 4, GL_UNSIGNED_BYTE, true,  sizeOf<ImDrawVert>().toInt(), (sizeOf<FloatVar>() * (2 + 2)).toCPointer<ByteVar>())
		//@formatter:on
	}

	// OpenGL3 Render function.
	// (this used to be set in io.renderDrawListsFn and called by ImGui::Render(), but you can now call this directly from your main loop)
	// Note that this implementation is little overcomplicated because we are saving/setting up/restoring every OpenGL state explicitly, in order to be able to run within any OpenGL engine that doesn't do so.
	actual fun renderDrawData(drawData: ImDrawData) {
		val fbWidth = (drawData.displaySize.x * drawData.framebufferScale.x).toInt()
		val fbHeight = (drawData.displaySize.y * drawData.framebufferScale.y).toInt()
		if (fbWidth <= 0 || fbHeight <= 0) return

		// Backup GL state
		val lastActiveTexture = glGetInteger(GL_ACTIVE_TEXTURE)
		glActiveTexture(GL_TEXTURE0)
		val lastProgram = glGetInteger(GL_CURRENT_PROGRAM)
		val lastTexture = glGetInteger(GL_TEXTURE_BINDING_2D)
		val lastSampler = if (glHasSamplerBinding) glGetInteger(GL_SAMPLER_BINDING) else 0
		val lastArrayBuffer = glGetInteger(GL_ARRAY_BUFFER_BINDING)
		val lastVertexArrayObject = if (!glIsOpenGLES) glGetInteger(GL_VERTEX_ARRAY_BINDING) else 0
		val lastPolygonMode = IntArray(2)
		if (glHasPolygonMode) lastPolygonMode.usePinned { glGetIntegerv(GL_POLYGON_MODE, it.addressOf(0)) }
		val lastViewport = IntArray(4); lastViewport.usePinned { glGetIntegerv(GL_VIEWPORT, it.addressOf(0)) }
		val lastScissorBox = IntArray(4); lastScissorBox.usePinned { glGetIntegerv(GL_SCISSOR_BOX, it.addressOf(0)) }
		val lastBlendSrcRGB = glGetInteger(GL_BLEND_SRC_RGB)
		val lastBlendDstRGB = glGetInteger(GL_BLEND_DST_RGB)
		val lastBlendSrcAlpha = glGetInteger(GL_BLEND_SRC_ALPHA)
		val lastBlendDstAlpha = glGetInteger(GL_BLEND_DST_ALPHA)
		val lastBlendEquationRGB = glGetInteger(GL_BLEND_EQUATION_RGB)
		val lastBlendEquationAlpha = glGetInteger(GL_BLEND_EQUATION_ALPHA)
		val lastEnableBlend = glIsEnabled(GL_BLEND)
		val lastEnableCullFace = glIsEnabled(GL_CULL_FACE)
		val lastEnableDepthTest = glIsEnabled(GL_DEPTH_TEST)
		val lastEnableScissorTest = glIsEnabled(GL_SCISSOR_TEST)
		val clipOriginLowerLeft = !glHasClipOrigin || glGetInteger(GL_CLIP_ORIGIN) != GL_UPPER_LEFT.toInt()

		// Setup desired GL state
		// Recreate the VAO every time (this is to easily allow multiple GL contexts to be rendered to. VAO are not shared among GL contexts)
		// The renderer would actually work without any VAO bound, but then our VertexAttrib calls would overwrite the default one currently bound.
		val vertexArrayObject = if (!glIsOpenGLES) glGenVertexArray() else 0U
		setupRenderState(drawData, fbWidth, fbHeight, vertexArrayObject)

		// Will project scissor/clipping rectangles into framebuffer space
		val clipOff = drawData.displayPos         // (0,0) unless using multi-viewports
		val clipScale = drawData.framebufferScale // (1,1) unless using retina display which are often (2,2)

		// Render command lists
		for (n in 0 until drawData.cmdListsCount) {
			val cmdList = drawData.ptr.pointed.CmdLists!![n]!!.pointed

			// Upload buffer
			//@formatter:off
			glBufferData(GL_ARRAY_BUFFER, cmdList.VtxBuffer.Size * sizeOf<ImDrawVert>(), cmdList.VtxBuffer.Data, GL_STREAM_DRAW)
			glBufferData(GL_ELEMENT_ARRAY_BUFFER, cmdList.IdxBuffer.Size * sizeOf<ImDrawIdxVar>(), cmdList.IdxBuffer.Data, GL_STREAM_DRAW)
			//@formatter:on

			for (cmd_i in 0 until cmdList.CmdBuffer.Size) {
				val pcmd = cmdList.CmdBuffer.Data!![cmd_i]
				if (pcmd.UserCallback != null) {
					// User callback, registered via ImDrawList::AddCallback()
					// (ImDrawCallback_ResetRenderState is a special callback value used by the user to request the renderer to reset render state.)
					if (pcmd.UserCallback == ImDrawCallback_ResetRenderState) {
						setupRenderState(drawData, fbWidth, fbHeight, vertexArrayObject)
					} else {
						pcmd.UserCallback!!(cmdList.ptr, pcmd.ptr)
					}
				} else {
					// Project scissor/clipping rectangles into framebuffer space
					val x = (pcmd.ClipRect.x - clipOff.x) * clipScale.x
					val y = (pcmd.ClipRect.y - clipOff.y) * clipScale.y
					val z = (pcmd.ClipRect.z - clipOff.x) * clipScale.x
					val w = (pcmd.ClipRect.w - clipOff.y) * clipScale.y

					if (x < fbWidth && y < fbHeight && z >= 0 && w >= 0.0f) {
						// Apply scissor/clipping rectangle
						if (clipOriginLowerLeft) {
							glScissor(x.toInt(), (fbHeight - w).toInt(), (z - x).toInt(), (w - y).toInt())
						} else {
							// Support for GL 4.5 rarely used glClipControl(GL_UPPER_LEFT)
							glScissor(x.toInt(), y.toInt(), z.toInt(), w.toInt())
						}

						// Bind texture, Draw
						glBindTexture(GL_TEXTURE_2D, pcmd.TextureId.toLong().toUInt())

						val indexType = if (sizeOf<ImDrawIdxVar>() == 2L) GL_UNSIGNED_SHORT else GL_UNSIGNED_INT
						val indexOffset = (pcmd.IdxOffset.toLong() * sizeOf<ImDrawIdxVar>()).toCPointer<CPointed>()
						//@formatter:off
						if (glMayHaveVertexOffset) {
							glDrawElementsBaseVertex(GL_TRIANGLES, pcmd.ElemCount.toInt(), indexType, indexOffset, pcmd.VtxOffset.toInt())
						} else {
							glDrawElements(GL_TRIANGLES, pcmd.ElemCount.toInt(), indexType, indexOffset)
						}
						//@formatter:on
					}
				}
			}
		}

		if (!glIsOpenGLES) {
			glDeleteVertexArray(vertexArrayObject)
		}

		// Restore modified state
		glUseProgram(lastProgram.toUInt())
		glBindTexture(GL_TEXTURE_2D, lastTexture.toUInt())
		if (glHasSamplerBinding) glBindSampler(0U, lastSampler.toUInt())
		glActiveTexture(lastActiveTexture.toUInt())
		glBindBuffer(GL_ARRAY_BUFFER, lastArrayBuffer.toUInt())
		if (!glIsOpenGLES) glBindVertexArray(lastVertexArrayObject.toUInt())
		glBlendEquationSeparate(lastBlendEquationRGB.toUInt(), lastBlendEquationAlpha.toUInt())
		//@formatter:off
		glBlendFuncSeparate(lastBlendSrcRGB.toUInt(), lastBlendDstRGB.toUInt(), lastBlendSrcAlpha.toUInt(), lastBlendDstAlpha.toUInt())
		//@formatter:on
		if (lastEnableBlend) glEnable(GL_BLEND) else glDisable(GL_BLEND)
		if (lastEnableCullFace) glEnable(GL_CULL_FACE) else glDisable(GL_CULL_FACE)
		if (lastEnableDepthTest) glEnable(GL_DEPTH_TEST) else glDisable(GL_DEPTH_TEST)
		if (lastEnableScissorTest) glEnable(GL_SCISSOR_TEST) else glDisable(GL_SCISSOR_TEST)
		if (glHasPolygonMode) glPolygonMode(GL_FRONT_AND_BACK, lastPolygonMode[0].toUInt())
		if (lastEnableBlend) glEnable(GL_BLEND) else glDisable(GL_BLEND)
		glViewport(lastViewport[0], lastViewport[1], lastViewport[2], lastViewport[3])
		glScissor(lastScissorBox[0], lastScissorBox[1], lastScissorBox[2], lastScissorBox[3])
	}

	override fun close() {
		shutdownPlatformInterface()

		// Destroy device objects
		glDeleteBuffers(2, cValuesOf(vboHandle, elementsHandle))
		glDetachShader(shaderHandle, vertHandle)
		glDetachShader(shaderHandle, fragHandle)
		glDeleteShader(vertHandle)
		glDeleteShader(fragHandle)
		glDeleteProgram(shaderHandle)

		// Destroy fonts texture
		val io = ImGui.getIO().ptr.pointed
		glDeleteTexture(fontTexture)
		io.Fonts!!.pointed.TexID = null

		io.BackendRendererUserData?.asStableRef<ImGuiOpenGL3>()?.dispose()
	}

	//--------------------------------------------------------------------------------------------------------
	// MULTI-VIEWPORT / PLATFORM INTERFACE SUPPORT
	// This is an _advanced_ and _optional_ feature, allowing the back-end to create and handle multiple viewports simultaneously.
	// If you are new to dear imgui or creating a new binding for dear imgui, it is recommended that you completely ignore this section first..
	//--------------------------------------------------------------------------------------------------------

	private fun initPlatformInterface() {
		val platformIO = ImGui.getPlatformIO().ptr.pointed
		platformIO.Renderer_RenderWindow = staticCFunction { viewport, _ ->
			val imGuiOpenGL3 = ImGui.getIO().ptr.pointed.BackendRendererUserData!!.asStableRef<ImGuiOpenGL3>().get()
			glClearColor(0f, 0f, 0f, 1f)
			glClear(GL_COLOR_BUFFER_BIT)
			imGuiOpenGL3.renderDrawData(ImDrawData(viewport!!.pointed.DrawData!!))
		}
	}

	private fun shutdownPlatformInterface() {
		ImGui.destroyPlatformWindows()
	}

	companion object {
		private val ImDrawCallback_ResetRenderState: ImDrawCallback? = (-1L).toCPointer()
	}
}

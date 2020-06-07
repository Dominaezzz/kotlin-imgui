package com.imgui.impl

import cimgui.internal.*
import com.imgui.ImGui
import com.imgui.ImGuiBackendFlags
import com.kgl.opengl.*
import io.ktor.utils.io.core.Closeable
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

actual class ImguiOpenGL3 actual constructor(
		glslVersionStr: String,
		private val useVertexArray: Boolean, // if !IMGUI_IMPL_OPENGL_ES2
		private val unpackRowLength: Boolean,
		private val usePolygonMode: Boolean,
		private val useSamplerBinding: Boolean,
		private val useClipOrigin: Boolean,
		private val useDrawWithBaseVertex: Boolean
) : Closeable {

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
		val io = ImGui.getIO().ptr.pointed
		// io.BackendRendererName = "ImGui OpenGL3".cstr
		if (useDrawWithBaseVertex) {
			// We can honor the ImDrawCmd::VtxOffset field, allowing for large meshes.
			io.BackendFlags = io.BackendFlags or ImGuiBackendFlags.RendererHasVtxOffset.value
		}

		// Make a dummy GL call (we don't actually need the result)
		// IF YOU GET A CRASH HERE: it probably means that you haven't initialized the OpenGL function loader used by this code.
		// Desktop OpenGL 3/4 need a function loader. See the IMGUI_IMPL_OPENGL_LOADER_xxx explanation above.
		val currentTexture = glGetInteger(GL_TEXTURE_BINDING_2D)
		// Make a dummy test call.
		check(currentTexture >= 0)

		// Create device objects
		val lastTexture = glGetInteger(GL_TEXTURE_BINDING_2D)
		val lastArrayBuffer = glGetInteger(GL_ARRAY_BUFFER_BINDING)
		val lastVertexArray = if (useVertexArray) glGetInteger(GL_VERTEX_ARRAY_BINDING) else 0

		val glslVersion = glslVersionStr.takeLast(3).toInt()

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

		fun checkShader(handle: UInt, desc: String) {
			val status = memScoped {
				val value = alloc<IntVar>()
				glGetShaderiv(handle, GL_COMPILE_STATUS, value.ptr)
				value.value
			}
			val infoLog = glGetShaderInfoLog(handle)
			if (infoLog.isNotBlank()) {
				println(infoLog)
			}

			check(status == GL_TRUE.toInt()) { "ERROR: Failed to compile $desc!" }
		}
		fun checkProgram(handle: UInt, desc: String) {
			val status = memScoped {
				val value = alloc<IntVar>()
				glGetProgramiv(handle, GL_LINK_STATUS, value.ptr)
				value.value
			}
			val infoLog = glGetProgramInfoLog(handle)
			if (infoLog.isNotBlank()) {
				println(infoLog)
			}

			check(status == GL_TRUE.toInt()) { "ERROR: Failed to compile $desc!" }
		}

		vertHandle = glCreateShader(GL_VERTEX_SHADER)
		glShaderSource(vertHandle, "$glslVersionStr\n$vertexShader")
		glCompileShader(vertHandle)
		checkShader(vertHandle, "vertex shader")

		fragHandle = glCreateShader(GL_FRAGMENT_SHADER)
		glShaderSource(fragHandle, "$glslVersionStr\n$fragmentShader")
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

		vboHandle = memScoped {
			val value = alloc<UIntVar>()
			glGenBuffers(1, value.ptr)
			value.value
		}
		elementsHandle = memScoped {
			val value = alloc<UIntVar>()
			glGenBuffers(1, value.ptr)
			value.value
		}

		fontTexture = memScoped {
			val texture = alloc<UIntVar>()
			glGenTextures(1, texture.ptr)
			texture.value
		}
		createFontsTexture()

		// Restore modified GL state
		glBindTexture(GL_TEXTURE_2D, lastTexture.toUInt())
		glBindBuffer(GL_ARRAY_BUFFER, lastArrayBuffer.toUInt())
		if (useVertexArray) glBindVertexArray(lastVertexArray.toUInt())
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
		if (usePolygonMode) {
			glPolygonMode(GL_FRONT_AND_BACK, GL_FILL)
		}

		glViewport(0, 0, fbWidth, fbHeight)
		val L = drawData.DisplayPos.x
		val R = drawData.DisplayPos.x + drawData.DisplaySize.x
		val T = drawData.DisplayPos.y
		val B = drawData.DisplayPos.y + drawData.DisplaySize.y

		val orthoProjection = floatArrayOf(
				2.0f/(R-L),   0.0f,         0.0f,   0.0f,
				0.0f,         2.0f/(T-B),   0.0f,   0.0f,
				0.0f,         0.0f,        -1.0f,   0.0f,
				(R+L)/(L-R),  (T+B)/(B-T),  0.0f,   1.0f
		)
		glUseProgram(shaderHandle)
		glUniform1i(attribLocationTex, 0)
		glUniformMatrix4fv(attribLocationProjMtx, 1, GL_FALSE.toUByte(), orthoProjection.refTo(0))
		if (useSamplerBinding) {
			glBindSampler(0U, 0U) // We use combined texture/sampler state. Applications using GL 3.3 may set that otherwise.
		}

		if (useVertexArray) glBindVertexArray(vertexArrayObject)

		// Bind vertex/index buffers and setup attributes for ImDrawVert
		glBindBuffer(GL_ARRAY_BUFFER, vboHandle)
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, elementsHandle)
		glEnableVertexAttribArray(attribLocationVtxPos.toUInt())
		glEnableVertexAttribArray(attribLocationVtxUV.toUInt())
		glEnableVertexAttribArray(attribLocationVtxColor.toUInt())
		glVertexAttribPointer(attribLocationVtxPos.toUInt(),   2, GL_FLOAT,         GL_FALSE.toUByte(), sizeOf<ImDrawVert>().toInt(), 0L.toCPointer<ByteVar>())
		glVertexAttribPointer(attribLocationVtxUV.toUInt(),    2, GL_FLOAT,         GL_FALSE.toUByte(), sizeOf<ImDrawVert>().toInt(), (sizeOf<FloatVar>() * 2).toCPointer<ByteVar>())
		glVertexAttribPointer(attribLocationVtxColor.toUInt(), 4, GL_UNSIGNED_BYTE, GL_TRUE.toUByte(),  sizeOf<ImDrawVert>().toInt(), (sizeOf<FloatVar>() * (2 + 2)).toCPointer<ByteVar>())
	}

	// OpenGL3 Render function.
	// (this used to be set in io.RenderDrawListsFn and called by ImGui::Render(), but you can now call this directly from your main loop)
	// Note that this implementation is little overcomplicated because we are saving/setting up/restoring every OpenGL state explicitly, in order to be able to run within any OpenGL engine that doesn't do so.
	actual fun renderDrawData(data: com.imgui.ImDrawData) {
		val drawData: ImDrawData = data.ptr.pointed

		val fbWidth = (drawData.DisplaySize.x * drawData.FramebufferScale.x).toInt()
		val fbHeight = (drawData.DisplaySize.y * drawData.FramebufferScale.y).toInt()
		if (fbWidth <= 0 || fbHeight <= 0) return

		// Backup GL state
		val lastActiveTexture = glGetInteger(GL_ACTIVE_TEXTURE)
		glActiveTexture(GL_TEXTURE0)
		val lastProgram = glGetInteger(GL_CURRENT_PROGRAM)
		val lastTexture = glGetInteger(GL_TEXTURE_BINDING_2D)
		val lastSampler = if (useSamplerBinding) glGetInteger(GL_SAMPLER_BINDING) else 0
		val lastArrayBuffer = glGetInteger(GL_ARRAY_BUFFER_BINDING)
		val lastVertexArrayObject = if (useVertexArray) glGetInteger(GL_VERTEX_ARRAY_BINDING) else 0
		val lastPolygonMode = IntArray(2)
		if (usePolygonMode) lastPolygonMode.usePinned { glGetIntegerv(GL_POLYGON_MODE, it.addressOf(0)) }
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
		val clipOriginLowerLeft = if (useClipOrigin) {
			val lastClipOrigin = glGetInteger(GL_CLIP_ORIGIN)
			lastClipOrigin != GL_UPPER_LEFT.toInt()
		} else {
			true
		}

		// Setup desired GL state
		// Recreate the VAO every time (this is to easily allow multiple GL contexts to be rendered to. VAO are not shared among GL contexts)
		// The renderer would actually work without any VAO bound, but then our VertexAttrib calls would overwrite the default one currently bound.
		val vertexArrayObject = if (useVertexArray) {
			glGenVertexArray()
		} else {
			0U
		}
		setupRenderState(drawData, fbWidth, fbHeight, vertexArrayObject)

		// Will project scissor/clipping rectangles into framebuffer space
		val clipOff = drawData.DisplayPos         // (0,0) unless using multi-viewports
		val clipScale = drawData.FramebufferScale // (1,1) unless using retina display which are often (2,2)

		// Render command lists
		for (n in 0 until drawData.CmdListsCount) {
			val cmdList = drawData.CmdLists!![n]!!.pointed

			// Upload buffer
			glBufferData(GL_ARRAY_BUFFER, cmdList.VtxBuffer.Size * sizeOf<ImDrawVert>(), cmdList.VtxBuffer.Data, GL_STREAM_DRAW)
			glBufferData(GL_ELEMENT_ARRAY_BUFFER, cmdList.IdxBuffer.Size * sizeOf<ImDrawIdxVar>(), cmdList.IdxBuffer.Data, GL_STREAM_DRAW)

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
							glScissor(x.toInt(), y.toInt(), z.toInt(), w.toInt()) // Support for GL 4.5 rarely used glClipControl(GL_UPPER_LEFT)
						}

						// Bind texture, Draw
						glBindTexture(GL_TEXTURE_2D, pcmd.TextureId.toLong().toUInt())

						val indexType = if (sizeOf<ImDrawIdxVar>() == 2L) GL_UNSIGNED_SHORT else GL_UNSIGNED_INT
						val indexOffset = (pcmd.IdxOffset.toLong() * sizeOf<ImDrawIdxVar>()).toCPointer<CPointed>()
						if (useDrawWithBaseVertex) {
							glDrawElementsBaseVertex(GL_TRIANGLES, pcmd.ElemCount.toInt(), indexType, indexOffset, pcmd.VtxOffset.toInt())
						} else {
							glDrawElements(GL_TRIANGLES, pcmd.ElemCount.toInt(), indexType, indexOffset)
						}
					}
				}
			}
		}

		if (useVertexArray) {
			glDeleteVertexArrays(1, cValuesOf(vertexArrayObject))
		}

		// Restore modified state
		glUseProgram(lastProgram.toUInt())
		glBindTexture(GL_TEXTURE_2D, lastTexture.toUInt())
		if (useSamplerBinding) glBindSampler(0U, lastSampler.toUInt())
		glActiveTexture(lastActiveTexture.toUInt())
		glBindBuffer(GL_ARRAY_BUFFER, lastArrayBuffer.toUInt())
		if (useVertexArray) glBindVertexArray(lastVertexArrayObject.toUInt())
		glBlendEquationSeparate(lastBlendEquationRGB.toUInt(), lastBlendEquationAlpha.toUInt())
		glBlendFuncSeparate(lastBlendSrcRGB.toUInt(), lastBlendDstRGB.toUInt(), lastBlendSrcAlpha.toUInt(), lastBlendDstAlpha.toUInt())
		if (lastEnableBlend) glEnable(GL_BLEND) else glDisable(GL_BLEND)
		if (lastEnableCullFace) glEnable(GL_CULL_FACE) else glDisable(GL_CULL_FACE)
		if (lastEnableDepthTest) glEnable(GL_DEPTH_TEST) else glDisable(GL_DEPTH_TEST)
		if (lastEnableScissorTest) glEnable(GL_SCISSOR_TEST) else glDisable(GL_SCISSOR_TEST)
		if (usePolygonMode) glPolygonMode(GL_FRONT_AND_BACK, lastPolygonMode[0].toUInt())
		if (lastEnableBlend) glEnable(GL_BLEND) else glDisable(GL_BLEND)
		glViewport(lastViewport[0], lastViewport[1], lastViewport[2], lastViewport[3])
		glScissor(lastScissorBox[0], lastScissorBox[1], lastScissorBox[2], lastScissorBox[3])
	}

	private fun createFontsTexture() {
		val io = ImGui.getIO().ptr.pointed

		val lastTexture = glGetInteger(GL_TEXTURE_BINDING_2D)

		memScoped {
			val pixels = allocPointerTo<UByteVar>()
			val width = alloc<IntVar>()
			val height = alloc<IntVar>()

			// Load as RGBA 32-bits (75% of the memory is wasted, but default font is so small) because it is more likely to be compatible with user's existing shaders. If your ImTextureId represent a higher-level concept than just a GL texture id, consider calling GetTexDataAsAlpha8() instead to save on GPU memory.
			ImFontAtlas_GetTexDataAsRGBA32(io.Fonts, pixels.ptr, width.ptr, height.ptr, null)

			// Upload texture to graphics system
			glBindTexture(GL_TEXTURE_2D, fontTexture)
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR.toInt())
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR.toInt())
			if (unpackRowLength) glPixelStorei(GL_UNPACK_ROW_LENGTH, 0)
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA.toInt(), width.value, height.value, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels.value)
		}

		// Store our identifier
		io.Fonts!!.pointed.TexID = fontTexture.toLong().toCPointer()

		// Restore state
		glBindTexture(GL_TEXTURE_2D, lastTexture.toUInt())
	}

	private fun destroyFontsTexture() {
		val io = ImGui.getIO().ptr.pointed
		glDeleteTextures(1, cValuesOf(fontTexture))
		io.Fonts!!.pointed.TexID = null
	}

	override fun close() {
		glDeleteBuffers(2, cValuesOf(vboHandle, elementsHandle))
		glDetachShader(shaderHandle, vertHandle)
		glDetachShader(shaderHandle, fragHandle)
		glDeleteShader(vertHandle)
		glDeleteShader(fragHandle)
		glDeleteProgram(shaderHandle)

		destroyFontsTexture()
	}

	companion object {
		private val ImDrawCallback_ResetRenderState: ImDrawCallback? = (-1L).toCPointer()
	}
}

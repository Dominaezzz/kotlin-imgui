package com.imgui.impl

import cimgui.internal.*
import com.imgui.ImGui
import com.imgui.ImGuiBackendFlags
import kotlinx.io.core.Closeable
import org.lwjgl.opengl.*

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

	private val fontTexture: Int
	private val shaderHandle: Int
	private val vertHandle: Int
	private val fragHandle: Int
	private val attribLocationTex: Int
	private val attribLocationProjMtx: Int
	private val attribLocationVtxPos: Int
	private val attribLocationVtxUV: Int
	private val attribLocationVtxColor: Int
	private val vboHandle: Int
	private val elementsHandle: Int

	init {
		val io = ImGui.getIO().ptr
		// io.backendRendererName = "ImGui OpenGL3".cstr
		if (useDrawWithBaseVertex) {
			// We can honor the ImDrawCmd::VtxOffset field, allowing for large meshes.
			io.backendFlags = io.backendFlags or ImGuiBackendFlags.RendererHasVtxOffset.value
		}

		GL.createCapabilities()

		// Make a dummy GL call (we don't actually need the result)
		// IF YOU GET A CRASH HERE: it probably means that you haven't initialized the OpenGL function loader used by this code.
		// Desktop OpenGL 3/4 need a function loader. See the IMGUI_IMPL_OPENGL_LOADER_xxx explanation above.
		val currentTexture = GL30.glGetInteger(GL30.GL_TEXTURE_BINDING_2D)
		// Make a dummy test call.
		check(currentTexture >= 0)

		// Create device objects
		val lastTexture = GL30.glGetInteger(GL30.GL_TEXTURE_BINDING_2D)
		val lastArrayBuffer = GL30.glGetInteger(GL30.GL_ARRAY_BUFFER_BINDING)
		val lastVertexArray = if (useVertexArray) GL30.glGetInteger(GL30.GL_VERTEX_ARRAY_BINDING) else 0

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

		fun checkShader(handle: Int, desc: String) {
			val status = GL30.glGetShaderi(handle, GL30.GL_COMPILE_STATUS)
			val infoLog = GL30.glGetShaderInfoLog(handle)
			if (infoLog.isNotBlank()) {
				println(infoLog)
			}

			check(status == GL30.GL_TRUE) { "ERROR: Failed to compile $desc!" }
		}
		fun checkProgram(handle: Int, desc: String) {
			val status = GL30.glGetProgrami(handle, GL30.GL_LINK_STATUS)
			val infoLog = GL30.glGetProgramInfoLog(handle)
			if (infoLog.isNotBlank()) {
				println(infoLog)
			}

			check(status == GL30.GL_TRUE) { "ERROR: Failed to compile $desc!" }
		}

		vertHandle = GL30.glCreateShader(GL30.GL_VERTEX_SHADER)
		GL30.glShaderSource(vertHandle, "$glslVersionStr\n$vertexShader")
		GL30.glCompileShader(vertHandle)
		checkShader(vertHandle, "vertex shader")

		fragHandle = GL30.glCreateShader(GL30.GL_FRAGMENT_SHADER)
		GL30.glShaderSource(fragHandle, "$glslVersionStr\n$fragmentShader")
		GL30.glCompileShader(fragHandle)
		checkShader(fragHandle, "fragment shader")

		shaderHandle = GL30.glCreateProgram()
		GL30.glAttachShader(shaderHandle, vertHandle)
		GL30.glAttachShader(shaderHandle, fragHandle)
		GL30.glLinkProgram(shaderHandle)
		checkProgram(shaderHandle, "shader program")

		attribLocationTex = GL30.glGetUniformLocation(shaderHandle, "Texture")
		attribLocationProjMtx = GL30.glGetUniformLocation(shaderHandle, "ProjMtx")
		attribLocationVtxPos = GL30.glGetAttribLocation(shaderHandle, "Position")
		attribLocationVtxUV = GL30.glGetAttribLocation(shaderHandle, "UV")
		attribLocationVtxColor = GL30.glGetAttribLocation(shaderHandle, "Color")

		vboHandle = GL15.glGenBuffers()
		elementsHandle = GL30.glGenBuffers()

		fontTexture = GL30.glGenTextures()
		createFontsTexture()

		// Restore modified GL state
		GL30.glBindTexture(GL30.GL_TEXTURE_2D, lastTexture)
		GL30.glBindTexture(GL30.GL_ARRAY_BUFFER, lastArrayBuffer)
		if (useVertexArray) GL30.glBindVertexArray(lastVertexArray)
	}

	actual fun newFrame() {}

	private fun setupRenderState(drawData: ImDrawData, fbWidth: Int, fbHeight: Int, vertexArrayObject: Int) {
		// Setup render state: alpha-blending enabled, no face culling, no depth testing, scissor enabled, polygon fill
		GL30.glEnable(GL30.GL_BLEND)
		GL30.glBlendEquation(GL30.GL_FUNC_ADD)
		GL30.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA)
		GL30.glDisable(GL30.GL_CULL_FACE)
		GL30.glDisable(GL30.GL_DEPTH_TEST)
		GL30.glEnable(GL30.GL_SCISSOR_TEST)
		if (usePolygonMode) {
			GL30.glPolygonMode(GL30.GL_FRONT_AND_BACK, GL30.GL_FILL)
		}

		GL30.glViewport(0, 0, fbWidth, fbHeight)
		val L = drawData.displayPos.x
		val R = drawData.displayPos.x + drawData.displaySize.x
		val T = drawData.displayPos.y
		val B = drawData.displayPos.y + drawData.displaySize.y

		val orthoProjection = floatArrayOf(
				2.0f/(R-L),   0.0f,         0.0f,   0.0f,
				0.0f,         2.0f/(T-B),   0.0f,   0.0f,
				0.0f,         0.0f,        -1.0f,   0.0f,
				(R+L)/(L-R),  (T+B)/(B-T),  0.0f,   1.0f
		)
		GL30.glUseProgram(shaderHandle)
		GL30.glUniform1i(attribLocationTex, 0)
		GL30.glUniformMatrix4fv(attribLocationProjMtx, false, orthoProjection)
		if (useSamplerBinding) {
			GL33.glBindSampler(0, 0) // We use combined texture/sampler state. Applications using GL 3.3 may set that otherwise.
		}

		if (useVertexArray) GL30.glBindVertexArray(vertexArrayObject)

		// Bind vertex/index buffers and setup attributes for ImDrawVert
		GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, vboHandle)
		GL30.glBindBuffer(GL30.GL_ELEMENT_ARRAY_BUFFER, elementsHandle)
		GL30.glEnableVertexAttribArray(attribLocationVtxPos)
		GL30.glEnableVertexAttribArray(attribLocationVtxUV)
		GL30.glEnableVertexAttribArray(attribLocationVtxColor)
		val sizeOfFloat = 4L
		val sizeOfImDrawVert = ((2 * sizeOfFloat) + (2 * sizeOfFloat) + (4 * 1)).toInt()
		GL30.glVertexAttribPointer(attribLocationVtxPos, 2, GL30.GL_FLOAT, false, sizeOfImDrawVert, 0L)
		GL30.glVertexAttribPointer(attribLocationVtxUV, 2, GL30.GL_FLOAT, false, sizeOfImDrawVert, sizeOfFloat * 2)
		GL30.glVertexAttribPointer(attribLocationVtxColor, 4, GL30.GL_UNSIGNED_BYTE, true, sizeOfImDrawVert, sizeOfFloat * (2 + 2))
	}

	// OpenGL3 Render function.
	// (this used to be set in io.renderDrawListsFn and called by ImGui::Render(), but you can now call this directly from your main loop)
	// Note that this implementation is little overcomplicated because we are saving/setting up/restoring every OpenGL state explicitly, in order to be able to run within any OpenGL engine that doesn't do so.
	actual fun renderDrawData(data: com.imgui.ImDrawData) {
		val drawData: ImDrawData = data.ptr

		val fbWidth = (drawData.displaySize.x * drawData.framebufferScale.x).toInt()
		val fbHeight = (drawData.displaySize.y * drawData.framebufferScale.y).toInt()
		if (fbWidth <= 0 || fbHeight <= 0) return

		// Backup GL state
		val lastActiveTexture = GL30.glGetInteger(GL30.GL_ACTIVE_TEXTURE)
		GL30.glActiveTexture(GL30.GL_TEXTURE0)
		val lastProgram = GL30.glGetInteger(GL30.GL_CURRENT_PROGRAM)
		val lastTexture = GL30.glGetInteger(GL30.GL_TEXTURE_BINDING_2D)
		val lastSampler = if (useSamplerBinding) GL30.glGetInteger(GL33.GL_SAMPLER_BINDING) else 0
		val lastArrayBuffer = GL30.glGetInteger(GL30.GL_ARRAY_BUFFER_BINDING)
		val lastVertexArrayObject = if (useVertexArray) GL30.glGetInteger(GL30.GL_VERTEX_ARRAY_BINDING) else 0
		val lastPolygonMode = IntArray(2)
		if (usePolygonMode) GL30.glGetIntegerv(GL30.GL_POLYGON_MODE, lastPolygonMode)
		val lastViewport = IntArray(4); GL30.glGetIntegerv(GL30.GL_VIEWPORT, lastViewport)
		val lastScissorBox = IntArray(4); GL30.glGetIntegerv(GL30.GL_SCISSOR_BOX, lastScissorBox)
		val lastBlendSrcRGB = GL30.glGetInteger(GL30.GL_BLEND_SRC_RGB)
		val lastBlendDstRGB = GL30.glGetInteger(GL30.GL_BLEND_DST_RGB)
		val lastBlendSrcAlpha = GL30.glGetInteger(GL30.GL_BLEND_SRC_ALPHA)
		val lastBlendDstAlpha = GL30.glGetInteger(GL30.GL_BLEND_DST_ALPHA)
		val lastBlendEquationRGB = GL30.glGetInteger(GL30.GL_BLEND_EQUATION_RGB)
		val lastBlendEquationAlpha = GL30.glGetInteger(GL30.GL_BLEND_EQUATION_ALPHA)
		val lastEnableBlend = GL30.glIsEnabled(GL30.GL_BLEND)
		val lastEnableCullFace = GL30.glIsEnabled(GL30.GL_CULL_FACE)
		val lastEnableDepthTest = GL30.glIsEnabled(GL30.GL_DEPTH_TEST)
		val lastEnableScissorTest = GL30.glIsEnabled(GL30.GL_SCISSOR_TEST)
		val clipOriginLowerLeft = if (useClipOrigin) {
			val lastClipOrigin = GL30.glGetInteger(ARBClipControl.GL_CLIP_ORIGIN)
			lastClipOrigin != GL30.GL_UPPER_LEFT
		} else {
			true
		}

		// Setup desired GL state
		// Recreate the VAO every time (this is to easily allow multiple GL contexts to be rendered to. VAO are not shared among GL contexts)
		// The renderer would actually work without any VAO bound, but then our VertexAttrib calls would overwrite the default one currently bound.
		val vertexArrayObject = if (useVertexArray) {
			GL30.glGenVertexArrays()
		} else {
			0
		}
		setupRenderState(drawData, fbWidth, fbHeight, vertexArrayObject)

		// Will project scissor/clipping rectangles into framebuffer space
		val clipOff = drawData.displayPos         // (0,0) unless using multi-viewports
		val clipScale = drawData.framebufferScale // (1,1) unless using retina display which are often (2,2)

		// Render command lists
		for (n in 0 until drawData.cmdListsCount) {
			val cmdList = CImGui.pImDrawListArray_getitem(drawData.cmdLists, n)

			val sizeOfImDrawVert = 20L
			val sizeOfImDrawIdx = Short.SIZE_BYTES.toLong()

			// Upload buffer
			GL30.nglBufferData(GL30.GL_ARRAY_BUFFER, cmdList.vtxBuffer.size * sizeOfImDrawVert, ImDrawVert.getCPtr(cmdList.vtxBuffer.data), GL30.GL_STREAM_DRAW)
			GL30.nglBufferData(GL30.GL_ELEMENT_ARRAY_BUFFER, cmdList.idxBuffer.size * sizeOfImDrawIdx, SWIGTYPE_p_unsigned_short.getCPtr(cmdList.idxBuffer.data), GL30.GL_STREAM_DRAW)

			for (cmd_i in 0 until cmdList.cmdBuffer.size) {
				val pcmd = CImGui.ImDrawCmdArray_getitem(cmdList.cmdBuffer.data, cmd_i)
				if (pcmd.userCallback != null) {
					// User callback, registered via ImDrawList::AddCallback()
					// (ImDrawCallback_ResetRenderState is a special callback value used by the user to request the renderer to reset render state.)

					if (pcmd.userCallback == ImDrawCallback_ResetRenderState) {
						setupRenderState(drawData, fbWidth, fbHeight, vertexArrayObject)
					} else {
						// 	pcmd.userCallback!!(cmdList, pcmd)
						TODO()
					}
				} else {
					// Project scissor/clipping rectangles into framebuffer space
					val x = (pcmd.clipRect.x - clipOff.x) * clipScale.x
					val y = (pcmd.clipRect.y - clipOff.y) * clipScale.y
					val z = (pcmd.clipRect.z - clipOff.x) * clipScale.x
					val w = (pcmd.clipRect.w - clipOff.y) * clipScale.y

					if (x < fbWidth && y < fbHeight && z >= 0 && w >= 0.0f) {
						// Apply scissor/clipping rectangle
						if (clipOriginLowerLeft) {
							GL30.glScissor(x.toInt(), (fbHeight - w).toInt(), (z - x).toInt(), (w - y).toInt())
						} else {
							GL30.glScissor(x.toInt(), y.toInt(), z.toInt(), w.toInt()) // Support for GL 4.5 rarely used glClipControl(GL_UPPER_LEFT)
						}

						// Bind texture, Draw
						GL30.glBindTexture(GL30.GL_TEXTURE_2D, SWIGTYPE_p_void.getCPtr(pcmd.textureId).toInt())

						val indexType = if (sizeOfImDrawIdx == 2L) GL30.GL_UNSIGNED_SHORT else GL30.GL_UNSIGNED_INT
						val indexOffset = (pcmd.idxOffset * sizeOfImDrawIdx)
						if (useDrawWithBaseVertex) {
							GL32.glDrawElementsBaseVertex(GL30.GL_TRIANGLES, pcmd.elemCount.toInt(), indexType, indexOffset, pcmd.vtxOffset.toInt())
						} else {
							GL30.glDrawElements(GL30.GL_TRIANGLES, pcmd.elemCount.toInt(), indexType, indexOffset)
						}
					}
				}
			}
		}

		if (useVertexArray) {
			GL30.glDeleteVertexArrays(vertexArrayObject)
		}

		// Restore modified state
		GL30.glUseProgram(lastProgram)
		GL30.glBindTexture(GL30.GL_TEXTURE_2D, lastTexture)
		if (useSamplerBinding) GL33.glBindSampler(0, lastSampler)
		GL30.glActiveTexture(lastActiveTexture)
		GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, lastArrayBuffer)
		if (useVertexArray) GL30.glBindVertexArray(lastVertexArrayObject)
		GL30.glBlendEquationSeparate(lastBlendEquationRGB, lastBlendEquationAlpha)
		GL30.glBlendFuncSeparate(lastBlendSrcRGB, lastBlendDstRGB, lastBlendSrcAlpha, lastBlendDstAlpha)
		if (lastEnableBlend) GL30.glEnable(GL30.GL_BLEND) else GL30.glDisable(GL30.GL_BLEND)
		if (lastEnableCullFace) GL30.glEnable(GL30.GL_CULL_FACE) else GL30.glDisable(GL30.GL_CULL_FACE)
		if (lastEnableDepthTest) GL30.glEnable(GL30.GL_DEPTH_TEST) else GL30.glDisable(GL30.GL_DEPTH_TEST)
		if (lastEnableScissorTest) GL30.glEnable(GL30.GL_SCISSOR_TEST) else GL30.glDisable(GL30.GL_SCISSOR_TEST)
		if (usePolygonMode) GL30.glPolygonMode(GL30.GL_FRONT_AND_BACK, lastPolygonMode[0])
		if (lastEnableBlend) GL30.glEnable(GL30.GL_BLEND) else GL30.glDisable(GL30.GL_BLEND)
		GL30.glViewport(lastViewport[0], lastViewport[1], lastViewport[2], lastViewport[3])
		GL30.glScissor(lastScissorBox[0], lastScissorBox[1], lastScissorBox[2], lastScissorBox[3])
	}

	private fun createFontsTexture() {
		val io = CImGui.igGetIO()!!

		val lastTexture = GL30.glGetInteger(GL30.GL_TEXTURE_BINDING_2D)

		val pixels = CImGui.new_unsigned_charpp()
		val width = CImGui.new_intp()
		val height = CImGui.new_intp()
		try {
			// Load as RGBA 32-bits (75% of the memory is wasted, but default font is so small) because it is more likely to be compatible with user's existing shaders. If your ImTextureId represent a higher-level concept than just a GL texture id, consider calling GetTexDataAsAlpha8() instead to save on GPU memory.
			CImGui.ImFontAtlas_GetTexDataAsRGBA32(io.fonts, pixels, width, height, null)

			// Upload texture to graphics system
			GL30.glBindTexture(GL30.GL_TEXTURE_2D, fontTexture)
			GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_MIN_FILTER, GL30.GL_LINEAR)
			GL30.glTexParameteri(GL30.GL_TEXTURE_2D, GL30.GL_TEXTURE_MAG_FILTER, GL30.GL_LINEAR)
			if (unpackRowLength) GL30.glPixelStorei(GL30.GL_UNPACK_ROW_LENGTH, 0)
			GL30.glTexImage2D(GL30.GL_TEXTURE_2D, 0, GL30.GL_RGBA, CImGui.intp_value(width), CImGui.intp_value(height), 0, GL30.GL_RGBA, GL30.GL_UNSIGNED_BYTE, SWIGTYPE_p_unsigned_char.getCPtr(CImGui.unsigned_charpp_value(pixels)))
		} finally {
			CImGui.delete_unsigned_charpp(pixels)
			CImGui.delete_intp(width)
			CImGui.delete_intp(height)
		}

		// Store our identifier
		io.fonts!!.texID = SWIGTYPE_p_void(fontTexture.toLong(), false)

		// Restore state
		GL30.glBindTexture(GL30.GL_TEXTURE_2D, lastTexture)
	}

	private fun destroyFontsTexture() {
		val io = ImGui.getIO().ptr
		GL30.glDeleteTextures(fontTexture)
		io.fonts!!.texID = null
	}

	override fun close() {
		GL15.glDeleteBuffers(intArrayOf(vboHandle, elementsHandle))
		GL30.glDetachShader(shaderHandle, vertHandle)
		GL30.glDetachShader(shaderHandle, fragHandle)
		GL30.glDeleteShader(vertHandle)
		GL30.glDeleteShader(fragHandle)
		GL30.glDeleteProgram(shaderHandle)

		destroyFontsTexture()
	}

	companion object {
		private val ImDrawCallback_ResetRenderState = SWIGTYPE_p_f_p_q_const__ImDrawList_p_q_const__ImDrawCmd__void(-1L, false)
	}
}

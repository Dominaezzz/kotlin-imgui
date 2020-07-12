package com.imgui.impl

import com.imgui.ImDrawData
import io.ktor.utils.io.core.*

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

expect class ImGuiOpenGL3(
	glslVersionStr: String = "#version 130",
	useVertexArray: Boolean = true, // if !IMGUI_IMPL_OPENGL_ES2
	unpackRowLength: Boolean = true,
	usePolygonMode: Boolean = true,
	useSamplerBinding: Boolean = false,
	useClipOrigin: Boolean = true,
	useDrawWithBaseVertex: Boolean = true
) : Closeable {

	fun newFrame()

	// OpenGL3 Render function.
	// (this used to be set in io.RenderDrawListsFn and called by ImGui::Render(), but you can now call this directly from your main loop)
	// Note that this implementation is little overcomplicated because we are saving/setting up/restoring every OpenGL state explicitly, in order to be able to run within any OpenGL engine that doesn't do so.
	fun renderDrawData(drawData: ImDrawData)
}

internal object Shaders {
	// language=glsl
	val vertexShaderGLSL120 = """
			uniform mat4 ProjMtx;
			attribute vec2 Position;
			attribute vec2 UV;
			attribute vec4 Color;
			varying vec2 Frag_UV;
			varying vec4 Frag_Color;
			void main()
			{
			    Frag_UV = UV;
			    Frag_Color = Color;
			    gl_Position = ProjMtx * vec4(Position.xy,0,1);
			}
		""".trimIndent()

	// language=glsl
	val vertexShaderGLSL130 = """
			uniform mat4 ProjMtx;
			in vec2 Position;
			in vec2 UV;
			in vec4 Color;
			out vec2 Frag_UV;
			out vec4 Frag_Color;
			void main()
			{
			    Frag_UV = UV;
			    Frag_Color = Color;
			    gl_Position = ProjMtx * vec4(Position.xy,0,1);
			}
		""".trimIndent()

	// language=glsl
	val vertexShaderGLSL300ES = """
			precision mediump float;
			layout (location = 0) in vec2 Position;
			layout (location = 1) in vec2 UV;
			layout (location = 2) in vec4 Color;
			uniform mat4 ProjMtx;
			out vec2 Frag_UV;
			out vec4 Frag_Color;
			void main()
			{
			    Frag_UV = UV;
			    Frag_Color = Color;
			    gl_Position = ProjMtx * vec4(Position.xy,0,1);
			}
		""".trimIndent()

	// language=glsl
	val vertexShaderGLSL410Core = """
			layout (location = 0) in vec2 Position;
			layout (location = 1) in vec2 UV;
			layout (location = 2) in vec4 Color;
			uniform mat4 ProjMtx;
			out vec2 Frag_UV;
			out vec4 Frag_Color;
			void main()
			{
			    Frag_UV = UV;
			    Frag_Color = Color;
			    gl_Position = ProjMtx * vec4(Position.xy,0,1);
			}
		""".trimIndent()

	// language=glsl
	val fragmentShaderGLSL120 = """
			#ifdef GL_ES
			    precision mediump float;
			#endif
			uniform sampler2D Texture;
			varying vec2 Frag_UV;
			varying vec4 Frag_Color;
			void main()
			{
			    gl_FragColor = Frag_Color * texture2D(Texture, Frag_UV.st);
			}
		""".trimIndent()

	// language=glsl
	val fragmentShaderGLSL130 = """
			uniform sampler2D Texture;
			in vec2 Frag_UV;
			in vec4 Frag_Color;
			out vec4 Out_Color;
			void main()
			{
			    Out_Color = Frag_Color * texture(Texture, Frag_UV.st);
			}
		""".trimIndent()

	// language=glsl
	val fragmentShaderGLSL300ES = """
			precision mediump float;
			uniform sampler2D Texture;
			in vec2 Frag_UV;
			in vec4 Frag_Color;
			layout (location = 0) out vec4 Out_Color;
			void main()
			{
			    Out_Color = Frag_Color * texture(Texture, Frag_UV.st);
			}
		""".trimIndent()

	// language=glsl
	val fragmentShaderGLSL410Core = """
			in vec2 Frag_UV;
			in vec4 Frag_Color;
			uniform sampler2D Texture;
			layout (location = 0) out vec4 Out_Color;
			void main()
			{
			    Out_Color = Frag_Color * texture(Texture, Frag_UV.st);
			}
		""".trimIndent()
}

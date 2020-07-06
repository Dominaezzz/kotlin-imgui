package sample

import com.imgui.*
import com.imgui.impl.ImGuiGLFW
import com.imgui.impl.ImguiOpenGL3
import com.kgl.glfw.Glfw
import com.kgl.glfw.OpenGLProfile
import com.kgl.glfw.Window
import org.lwjgl.opengl.GL11

class Simple(private val window: Window) {
	private val glfw: ImGuiGLFW
	private val gl: ImguiOpenGL3

	// Our state
	private var showDemoWindow = false
	private var showAnotherWindow = false
	private var clearColor = floatArrayOf(0.45f, 0.55f, 0.60f, 1.00f)

	private var f = 0.0f
	private var counter = 0

	init {
		// Decide GL+GLSL versions

		// GL 3.0 + GLSL 130
		val glslVersion = "#version 130";

		// Setup Dear ImGui context
		// IMGUI_CHECKVERSION();
		ImGui.createContext()
		val io = ImGui.getIO()
		// io.ConfigFlags = io.ConfigFlags or ImGuiConfigFlags_NavEnableKeyboard.toInt() // Enable Keyboard Controls
		// io.ConfigFlags = io.ConfigFlags or ImGuiConfigFlags_NavEnableGamepad.toInt()  // Enable Gamepad Controls

		// Setup Dear ImGui style
		ImGui.styleColorsDark()
		// ImGui.styleColorsDark()

		// Setup Platform/Renderer bindings
		glfw = ImGuiGLFW(window, true)
		gl = ImguiOpenGL3(glslVersion)

		// Load Fonts
		// - If no fonts are loaded, dear imgui will use the default font. You can also load multiple fonts and use ImGui::PushFont()/PopFont() to select them.
		// - AddFontFromFileTTF() will return the ImFont* so you can store it if you need to select the font among multiple.
		// - If the file cannot be loaded, the function will return NULL. Please handle those errors in your application (e.g. use an assertion, or display an error and quit).
		// - The fonts will be rasterized at a given size (w/ oversampling) and stored into a texture when calling ImFontAtlas::Build()/GetTexDataAsXXXX(), which ImGui_ImplXXXX_NewFrame below will call.
		// - Read 'misc/fonts/README.txt' for more instructions and details.
		// - Remember that in C/C++ if you want to include a backslash \ in a string literal you need to write a double backslash \\ !
		//io.Fonts->AddFontDefault();
		//io.Fonts->AddFontFromFileTTF("../../misc/fonts/Roboto-Medium.ttf", 16.0f);
		//io.Fonts->AddFontFromFileTTF("../../misc/fonts/Cousine-Regular.ttf", 15.0f);
		//io.Fonts->AddFontFromFileTTF("../../misc/fonts/DroidSans.ttf", 16.0f);
		//io.Fonts->AddFontFromFileTTF("../../misc/fonts/ProggyTiny.ttf", 10.0f);
		//ImFont* font = io.Fonts->AddFontFromFileTTF("c:\\Windows\\Fonts\\ArialUni.ttf", 18.0f, NULL, io.Fonts->GetGlyphRangesJapanese());
		//IM_ASSERT(font != NULL);
	}

	fun run() {
		// Main loop
		while (!window.shouldClose) {
			// Poll and handle events (inputs, window resize, etc.)
			// You can read the io.WantCaptureMouse, io.WantCaptureKeyboard flags to tell if dear imgui wants to use your inputs.
			// - When io.WantCaptureMouse is true, do not dispatch mouse input data to your main application.
			// - When io.WantCaptureKeyboard is true, do not dispatch keyboard input data to your main application.
			// Generally you may always pass all inputs to dear imgui, and hide them from your application based on those two flags.
			Glfw.pollEvents()

			// Start the Dear ImGui frame
			gl.newFrame()
			glfw.newFrame()
			ImGui.newFrame()

			drawUI()

			// Rendering
			ImGui.render()
			val (display_w, display_h) = window.frameBufferSize
			GL11.glViewport(0, 0, display_w, display_h)
			GL11.glClearColor(clearColor[0], clearColor[1], clearColor[2], clearColor[3])
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT)
			gl.renderDrawData(ImGui.getDrawData())

			window.swapBuffers()
		}
	}

	fun drawUI() {
		val io = ImGui.getIO()

		// 1. Show the big demo window (Most of the sample code is in ImGui::ShowDemoWindow()! You can browse its code to learn more about Dear ImGui!).
		if (showDemoWindow) {
			ImGui.showDemoWindow(::showDemoWindow)
		}

		// 2. Show a simple window that we create ourselves. We use a Begin/End pair to created a named window.
		run {
			ImGui.begin("Hello, world!") // Create a window called "Hello, world!" and append into it.
			ImGui.text("This is some useful text.")              // Display some text (you can use a format strings too)
			ImGui.checkbox("Demo Window", ::showDemoWindow) // Edit bools storing our window open/close state

			ImGui.checkbox("Another Window", ::showAnotherWindow)

			ImGui.sliderFloat("float", ::f, 0.0f, 1.0f)  // Edit 1 float using a slider from 0.0f to 1.0f
			ImGui.colorEdit3("clear color", clearColor)

			if (ImGui.button("Button")) {     // Buttons return true when clicked (most widgets return true when edited/activated)
				counter++
			}
			ImGui.sameLine()
			ImGui.text("counter = $counter")

			ImGui.text("Application average ${round(1000.0f / io.framerate, 3)} ms/frame (${round(io.framerate, 1)} FPS)")
			ImGui.end()
		}

		// 3. Show another simple window.
		if (showAnotherWindow) {
			// Pass a pointer to our bool variable (the window will have a closing button that will clear the bool when clicked)
			ImGui.begin("Another Window", ::showAnotherWindow)
			ImGui.text("Hello from another window!")
			if (ImGui.button("Close Me")) {
				showAnotherWindow = false
			}
			ImGui.end()
		}
	}

	fun close() {
		// Cleanup
		gl.close()
		glfw.close()
		ImGui.destroyContext()
	}
}

fun main(args: Array<String>) {
	args.size

	// Setup window
	Glfw.setErrorCallback { error, description ->
		println("Glfw Error ${error}: $description");
	}

	check(Glfw.init())

	with(Glfw.windowHints) {
		contextVersionMajor = 3
		contextVersionMinor = 2
		openGLProfile = OpenGLProfile.Core  // 3.2+ only
		openGLForwardCompat = true          // Required on Mac
	}

	val window = Window(1280, 720, "Dear ImGui GLFW+OpenGL3 example")
	Glfw.currentContext = window
	Glfw.setSwapInterval(1) // Enable vsync

	val simple = Simple(window)
	try {
		simple.run()
	} finally {
		simple.close()
		window.close()
		Glfw.terminate()
	}
}

package com.imgui.impl

import com.imgui.*
import com.kgl.core.Flag
import com.kgl.glfw.*
import io.ktor.utils.io.core.*

private var _mainWindow: Window? = null
internal val mainWindow: Window get() = _mainWindow ?: error("ImGuiGLFW was not initialized")

private val mouseJustPressed = BooleanArray(5) { false }
private var wantUpdateMonitors: Boolean = true

private var prevUserCallbackMouseButton: MouseButtonCallback? = null
private var prevUserCallbackScroll: ScrollCallback? = null
private var prevUserCallbackKey: KeyCallback? = null
private var prevUserCallbackChar: CharCallback? = null
private var prevUserCallbackMonitor: MonitorCallback? = null

class ImGuiGlfw(window: Window, installCallbacks: Boolean) : Closeable {
	private var time: Double = 0.0
	private val mouseJustPressed = BooleanArray(5) { false }
	private val mouseCursors = Array<Cursor?>(ImGuiMouseCursor.values().size) { null }
	private val callbacksAreInstalled = installCallbacks

	init {
		_mainWindow = window

		val io = ImGui.getIO()
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasMouseCursors
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasSetMousePos
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.PlatformHasViewports
		// io.BackendPlatformName = "ImGuiGlfw".cstr

		// Keyboard mapping.
		fun mapKey(imGuiKey: ImGuiKey, key: KeyboardKey) {
			io.keyMap(imGuiKey.cValue, key.ordinal)
		}
		mapKey(ImGuiKey.Tab, KeyboardKey.TAB)
		mapKey(ImGuiKey.LeftArrow, KeyboardKey.LEFT)
		mapKey(ImGuiKey.RightArrow, KeyboardKey.RIGHT)
		mapKey(ImGuiKey.UpArrow, KeyboardKey.UP)
		mapKey(ImGuiKey.DownArrow, KeyboardKey.DOWN)
		mapKey(ImGuiKey.PageUp, KeyboardKey.PAGE_UP)
		mapKey(ImGuiKey.PageDown, KeyboardKey.PAGE_DOWN)
		mapKey(ImGuiKey.Home, KeyboardKey.HOME)
		mapKey(ImGuiKey.End, KeyboardKey.END)
		mapKey(ImGuiKey.Insert, KeyboardKey.INSERT)
		mapKey(ImGuiKey.Delete, KeyboardKey.DELETE)
		mapKey(ImGuiKey.Backspace, KeyboardKey.BACKSPACE)
		mapKey(ImGuiKey.Space, KeyboardKey.SPACE)
		mapKey(ImGuiKey.Enter, KeyboardKey.ENTER)
		mapKey(ImGuiKey.Escape, KeyboardKey.ESCAPE)
		mapKey(ImGuiKey.KeyPadEnter, KeyboardKey.KP_ENTER)
		mapKey(ImGuiKey.A, KeyboardKey.A)
		mapKey(ImGuiKey.C, KeyboardKey.C)
		mapKey(ImGuiKey.V, KeyboardKey.V)
		mapKey(ImGuiKey.X, KeyboardKey.X)
		mapKey(ImGuiKey.Y, KeyboardKey.Y)
		mapKey(ImGuiKey.Z, KeyboardKey.Z)

		setupClipboard(io, mainWindow)

		val prevErrorCallback = Glfw.setErrorCallback(null)
		mouseCursors[ImGuiMouseCursor.Arrow.cValue] = Cursor(Cursor.Standard.Arrow)
		mouseCursors[ImGuiMouseCursor.TextInput.cValue] = Cursor(Cursor.Standard.IBeam)
		// FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeAll.cValue] = Cursor(Cursor.Standard.Arrow)
		mouseCursors[ImGuiMouseCursor.ResizeNS.cValue] = Cursor(Cursor.Standard.VResize)
		mouseCursors[ImGuiMouseCursor.ResizeEW.cValue] = Cursor(Cursor.Standard.HResize)
		// FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNESW.cValue] = Cursor(Cursor.Standard.Arrow)
		// FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNWSE.cValue] = Cursor(Cursor.Standard.Arrow)
		mouseCursors[ImGuiMouseCursor.Hand.cValue] = Cursor(Cursor.Standard.Hand)
		Glfw.setErrorCallback(prevErrorCallback)

		prevUserCallbackMouseButton = null
		prevUserCallbackScroll = null
		prevUserCallbackKey = null
		prevUserCallbackChar = null
		prevUserCallbackMonitor = null
		if (installCallbacks) {
			prevUserCallbackMouseButton = mainWindow.setMouseButtonCallback(this::mouseButtonCallback)
			prevUserCallbackScroll = mainWindow.setScrollCallback(this::scrollCallback)
			prevUserCallbackKey = mainWindow.setKeyCallback(this::keyCallback)
			prevUserCallbackChar = mainWindow.setCharCallback(this::charCallback)
			prevUserCallbackMonitor = Glfw.setMonitorCallback(this::monitorCallback)
		}

		// Update monitors the first time (note: monitor callback are broken in GLFW 3.2 and earlier, see github.com/glfw/glfw/issues/784)
		updateMonitors()
		Glfw.setMonitorCallback(this::monitorCallback)

		// Our mouse update function expect PlatformHandle to be filled for the main viewport
		val mainViewport = ImGui.getMainViewport()
		// userPointer for a Window's ptr is the Window itself
		//FIXME codegen?
		mainViewport.glfwWindow = mainWindow

		if (ImGuiConfigFlags.ViewportsEnable in io.configFlags) {
			initPlatformInterface()
		}
	}

	fun mouseButtonCallback(window: Window, button: MouseButton, action: Action, mods: Flag<Mod>) =
		com.imgui.impl.mouseButtonCallback(window, button, action, mods)

	fun scrollCallback(window: Window, offsetX: Double, offsetY: Double) =
		com.imgui.impl.scrollCallback(window, offsetX, offsetY)

	fun keyCallback(window: Window, key: KeyboardKey, scancode: Int, action: Action, mods: Flag<Mod>) =
		com.imgui.impl.keyCallback(window, key, scancode, action, mods)

	fun charCallback(window: Window, codepoint: UInt) =
		com.imgui.impl.charCallback(window, codepoint)

	fun monitorCallback(monitor: Monitor, isConnected: Boolean) =
		com.imgui.impl.monitorCallback(monitor, isConnected)

	private fun updateMonitors() {
		val platformIO = ImGui.getPlatformIO()
		val glfwMonitors = Glfw.monitors
		platformIO.monitors.resize(0)
		for (n in glfwMonitors.indices) {
			val monitor = ImGuiPlatformMonitor()
			val (monitorX, monitorY) = glfwMonitors[n].position
			val vidMode = glfwMonitors[n].videoMode
			monitor.mainPos = Vec2(monitorX.toFloat(), monitorY.toFloat())
			monitor.mainSize = Vec2(vidMode.width.toFloat(), vidMode.height.toFloat())
			val (x, y, w, h) = glfwMonitors[n].workarea
			monitor.workPos = Vec2(x.toFloat(), y.toFloat())
			monitor.workSize = Vec2(w.toFloat(), h.toFloat())
			val (xScale, _) = glfwMonitors[n].contentScale
			monitor.dpiScale = xScale
			platformIO.monitors.pushBack(monitor)
		}
		wantUpdateMonitors = false
	}

	fun newFrame() {
		val io = ImGui.getIO()
		check(io.fonts!!.isBuilt()) {
			"Font atlas not built! It is generally built by the renderer back-end. Missing call to renderer _NewFrame() function? e.g. ImGui_ImplOpenGL3_NewFrame()."
		}

		// Setup display size (every frame to accommodate for window resizing)
		val (w, h) = mainWindow.size
		val (displayWidth, displayHeight) = mainWindow.frameBufferSize

		io.displaySize = Vec2(w.toFloat(), h.toFloat())
		if (w > 0 && h > 0) {
			io.displayFramebufferScale = Vec2(displayWidth / w.toFloat(), displayHeight / h.toFloat())
		}

		if (wantUpdateMonitors) {
			updateMonitors()
		}

		// Setup time step
		val currentTime = Glfw.time
		io.deltaTime = if (time > 0) (currentTime - time).toFloat() else 1 / 60f
		time = currentTime

		// Update mouse position and buttons.
		run {
			// Update buttons
			for (i in 0 until 5) {
				io.mouseDown(i, mouseJustPressed[i] || mainWindow.getMouseButton(MouseButton.values()[i]) != Action.Release)
				mouseJustPressed[i] = false
			}

			// Update position
			val mousePosBackup = io.mousePos
			io.mousePos = Vec2(-Float.MAX_VALUE, -Float.MAX_VALUE)
			val platformIO = ImGui.getPlatformIO()
			for (viewport in platformIO.viewports) {
				val window = viewport.glfwWindow!!
				if (window.isFocused) {
					if (io.wantSetMousePos) {
						window.cursorPosition = mousePosBackup.x.toDouble() to mousePosBackup.y.toDouble()
					} else {
						val (mouseX, mouseY) = window.cursorPosition
						if (ImGuiConfigFlags.ViewportsEnable in io.configFlags) {
							val (windowX, windowY) = window.position
							io.mousePos = Vec2(mouseX.toFloat() + windowX, mouseY.toFloat() + windowY)
						} else {
							io.mousePos = Vec2(mouseX.toFloat(), mouseY.toFloat())
						}
					}
				}
				for (i in 0 until 5) {
					//FIXME com.kgl.glfw.MouseButton.from for common
					io.mouseDown(i, io.mouseDown(i) || window.getMouseButton(MouseButton.values()[i]) != Action.Release)
				}
			}
		}

		// Update mouse cursor.
		run {
			val changeDisabled = ImGuiConfigFlags.NoMouseCursorChange in io.configFlags
			if (!changeDisabled && mainWindow.cursorMode != CursorMode.Disabled) {
				val imguiCursor = ImGui.getMouseCursor()
				val platformIO = ImGui.getPlatformIO()
				for (viewport in platformIO.viewports) {
					val window = viewport.glfwWindow!!
					if (imguiCursor == ImGuiMouseCursor.None || io.mouseDrawCursor) {
						// Hide OS mouse cursor if imgui is drawing it or if it wants no cursor
						window.cursorMode = CursorMode.Hidden
					} else {
						// Show OS mouse cursor
						// FIXME-PLATFORM: Unfocused windows seems to fail changing the mouse cursor with GLFW 3.2, but 3.3 works here.
						window.setCursor(mouseCursors[imguiCursor.cValue] ?: mouseCursors[ImGuiMouseCursor.Arrow.cValue])
						window.cursorMode = CursorMode.Normal
					}
				}
			}
		}

		// Update gamepads
		run {
			for (i in ImGuiNavInput.values().indices) {
				io.navInputs(i, 0.0f)
			}
			if (ImGuiConfigFlags.NavEnableGamepad in io.configFlags) {
				val axes = Joystick._1.axes!!
				val buttons = Joystick._1.buttons!!

				inline fun mapButton(navNo: ImGuiNavInput, buttonNo: Int) {
					if (buttons.size > buttonNo && buttons[buttonNo] == Action.Press) {
						io.navInputs(navNo.cValue, 1f)
					}
				}

				inline fun mapAnalog(navNo: ImGuiNavInput, axisNo: Int, v0: Float, v1: Float) {
					var v = if (axes.size > axisNo) axes[axes.size] else v0
					v = (v - v0) / (v1 - v0)
					v = v.coerceAtMost(1.0f)
					if (io.navInputs(navNo.cValue) < v) {
						io.navInputs(navNo.cValue, v)
					}
				}

				//@formatter:off
				mapButton(ImGuiNavInput.Activate,   0)     // Cross / A
				mapButton(ImGuiNavInput.Cancel,     1)     // Circle / B
				mapButton(ImGuiNavInput.Menu,       2)     // Square / X
				mapButton(ImGuiNavInput.Input,      3)     // Triangle / Y
				mapButton(ImGuiNavInput.DpadLeft,   13)    // D-Pad Left
				mapButton(ImGuiNavInput.DpadRight,  11)    // D-Pad Right
				mapButton(ImGuiNavInput.DpadUp,     10)    // D-Pad Up
				mapButton(ImGuiNavInput.DpadDown,   12)    // D-Pad Down
				mapButton(ImGuiNavInput.FocusPrev,  4)     // L1 / LB
				mapButton(ImGuiNavInput.FocusNext,  5)     // R1 / RB
				mapButton(ImGuiNavInput.TweakSlow,  4)     // L1 / LB
				mapButton(ImGuiNavInput.TweakFast,  5)     // R1 / RB
				mapAnalog(ImGuiNavInput.LStickLeft, 0,  -0.3f,  -0.9f)
				mapAnalog(ImGuiNavInput.LStickRight,0,  +0.3f,  +0.9f)
				mapAnalog(ImGuiNavInput.LStickUp,   1,  +0.3f,  +0.9f)
				mapAnalog(ImGuiNavInput.LStickDown, 1,  -0.3f,  -0.9f)
				//@formatter:on

				if (axes.isNotEmpty() && buttons.isNotEmpty()) {
					io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasGamepad
				} else {
					io.backendFlags = io.backendFlags - ImGuiBackendFlags.HasGamepad
				}
			}
		}
	}

	override fun close() {
		freeClipboard(ImGui.getIO())

		shutdownPlatformInterface()

		if (callbacksAreInstalled) {
			mainWindow.setMouseButtonCallback(prevUserCallbackMouseButton)
			mainWindow.setScrollCallback(prevUserCallbackScroll)
			mainWindow.setKeyCallback(prevUserCallbackKey)
			mainWindow.setCharCallback(prevUserCallbackChar)
		}

		mouseCursors.forEach { it?.close() }
	}

	//--------------------------------------------------------------------------------------------------------
	// MULTI-VIEWPORT / PLATFORM INTERFACE SUPPORT
	// This is an _advanced_ and _optional_ feature, allowing the back-end to create and handle multiple viewports simultaneously.
	// If you are new to dear imgui or creating a new binding for dear imgui, it is recommended that you completely ignore this section first..
	//--------------------------------------------------------------------------------------------------------

	class ViewportData {
		private var _window: Window? = null
		var window: Window
			get() = _window!!
			set(value) {
				_window = value
			}

		var isWindowOwned: Boolean = false
		var ignoreWindowPosEventFrame: Int = -1
		var ignoreWindowSizeEventFrame: Int = -1

		fun createWindow(viewport: ImGuiViewport) {
			with(Glfw.windowHints) {
				visible = false
				focused = false
				focusOnShow = false
				decorated = ImGuiViewportFlags.NoDecoration !in viewport.flags
				floating = ImGuiViewportFlags.TopMost in viewport.flags
			}
			val (width, height) = viewport.size
			_window = Window(width.toInt(), height.toInt(), "No Title Yet", null, mainWindow)
			isWindowOwned = true
			window.position = viewport.pos.run { x.toInt() to y.toInt() }

			window.setMouseButtonCallback(::mouseButtonCallback)
			window.setScrollCallback(::scrollCallback)
			window.setKeyCallback(::keyCallback)
			window.setCharCallback(::charCallback)
			window.setCloseCallback {
				viewport.platformRequestClose = true
			}
			window.setPosCallback { _, _, _ ->
				viewport.glfwViewportData?.let { data ->
					if (ImGui.getFrameCount() <= data.ignoreWindowPosEventFrame + 1) return@setPosCallback
				}
				viewport.platformRequestMove = true
			}
			window.setSizeCallback { _, _, _ ->
				viewport.glfwViewportData?.let { data ->
					if (ImGui.getFrameCount() <= data.ignoreWindowSizeEventFrame + 1) return@setSizeCallback
				}
				viewport.platformRequestResize = true
			}
		}

		fun destroyWindow() {
			if (isWindowOwned) {
				window.close()
			}
			_window = null
		}

		fun showWindow() {
			window.isVisible = true
		}

		fun getWindowPos(): Vec2 = window.position.let { (x, y) -> Vec2(x.toFloat(), y.toFloat()) }

		fun setWindowPos(pos: Vec2) {
			ignoreWindowPosEventFrame = ImGui.getFrameCount()
			window.position = pos.x.toInt() to pos.y.toInt()
		}

		fun getWindowSize(): Vec2 = window.size.let { (x, y) -> Vec2(x.toFloat(), y.toFloat()) }

		fun setWindowSize(size: Vec2) {
			ignoreWindowSizeEventFrame = ImGui.getFrameCount()
			window.size = size.x.toInt() to size.y.toInt()
		}

		fun getWindowFocus(): Boolean = window.isFocused

		fun setWindowFocus() {
			window.focus()
		}

		fun getWindowMinimized(): Boolean = window.isIconified

		fun setWindowTitle(title: String) {
			window.setTitle(title)
		}

		fun renderWindow() {
			Glfw.currentContext = window
		}

		fun swapBuffers() {
			Glfw.currentContext = window
			window.swapBuffers()
		}

		fun setWindowAlpha(alpha: Float) {
			window.opacity = alpha
		}
	}

	private fun shutdownPlatformInterface() {}
}

private fun mouseButtonCallback(window: Window, button: MouseButton, action: Action, mods: Flag<Mod>) {
	if (window == mainWindow) {
		prevUserCallbackMouseButton?.invoke(window, button, action, mods)
	}

	if (action == Action.Press) {
		mouseJustPressed[button.ordinal] = true
	}
}

private fun scrollCallback(window: Window, offsetX: Double, offsetY: Double) {
	if (window == mainWindow) {
		prevUserCallbackScroll?.invoke(window, offsetX, offsetY)
	}

	val io = ImGui.getIO()
	io.mouseWheelH += offsetX.toFloat()
	io.mouseWheel += offsetY.toFloat()
}

private fun keyCallback(window: Window, key: KeyboardKey, scancode: Int, action: Action, mods: Flag<Mod>) {
	if (window == mainWindow) {
		prevUserCallbackKey?.invoke(window, key, scancode, action, mods)
	}

	val io = ImGui.getIO()
	if (action == Action.Press) {
		io.keysDown(key.ordinal, true)
	}
	if (action == Action.Release) {
		io.keysDown(key.ordinal, false)
	}

	// Modifiers are not reliable across systems
	io.keyCtrl = io.keysDown(KeyboardKey.LEFT_CONTROL.ordinal) || io.keysDown(KeyboardKey.RIGHT_CONTROL.ordinal)
	io.keyShift = io.keysDown(KeyboardKey.LEFT_SHIFT.ordinal) || io.keysDown(KeyboardKey.RIGHT_SHIFT.ordinal)
	io.keyAlt = io.keysDown(KeyboardKey.LEFT_ALT.ordinal) || io.keysDown(KeyboardKey.RIGHT_ALT.ordinal)
	io.keySuper = if (isWin32) false else {
		io.keysDown(KeyboardKey.LEFT_SUPER.ordinal) || io.keysDown(KeyboardKey.RIGHT_SUPER.ordinal)
	}
}

private fun charCallback(window: Window, codepoint: UInt) {
	if (window == mainWindow) {
		prevUserCallbackChar?.invoke(window, codepoint)
	}

	val io = ImGui.getIO()
	io.addInputCharacter(codepoint)
}

private fun monitorCallback(monitor: Monitor, isConnected: Boolean) {
	wantUpdateMonitors = true
}

internal expect fun initPlatformInterface()

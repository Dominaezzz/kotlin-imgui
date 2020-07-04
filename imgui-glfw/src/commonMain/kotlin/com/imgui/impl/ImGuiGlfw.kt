package com.imgui.impl

import com.imgui.*
import com.kgl.core.Flag
import com.kgl.glfw.*
import io.ktor.utils.io.core.*

private var _mainWindow: Window? = null
private val mainWindow: Window get() = _mainWindow ?: error("ImGuiGLFW was not initialized")

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

		setupClipboard(io, window)

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
			prevUserCallbackMouseButton = window.setMouseButtonCallback(this::mouseButtonCallback)
			prevUserCallbackScroll = window.setScrollCallback(this::scrollCallback)
			prevUserCallbackKey = window.setKeyCallback(this::keyCallback)
			prevUserCallbackChar = window.setCharCallback(this::charCallback)
			prevUserCallbackMonitor = Glfw.setMonitorCallback(this::monitorCallback)
		}

		// Update monitors the first time (note: monitor callback are broken in GLFW 3.2 and earlier, see github.com/glfw/glfw/issues/784)
		updateMonitors()
		Glfw.setMonitorCallback(this::monitorCallback)

		// Our mouse update function expect PlatformHandle to be filled for the main viewport
		val mainViewport = ImGui.getMainViewport()
		// userPointer for a Window's ptr is the Window itself
		//FIXME common
		//mainViewport.platformHandle = glfwGetWindowUserPointer(mainWindow.ptr)

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
		//FIXME common
		//inline fun ImVector_ImGuiPlatformMonitor._grow_capacity(size: Int): Int {
		//	val newCapacity = if (Capacity > 0) (Capacity + Capacity / 2) else 8
		//	return if (newCapacity > size) newCapacity else size
		//}

		//inline fun ImVector_ImGuiPlatformMonitor.reserve(newCapacity: Int) {
		//	if (newCapacity <= Capacity) return
		//	val newData = igMemAlloc((newCapacity * sizeOf<ImGuiPlatformMonitor>()).toULong())?.reinterpret<ImGuiPlatformMonitor>()
		//	if (Data != null) {
		//		memcpy(newData, Data, (Size * sizeOf<ImGuiPlatformMonitor>()).toULong())
		//		igMemFree(Data)
		//	}
		//	Data = newData
		//	Capacity = newCapacity
		//}

		//inline fun ImVector_ImGuiPlatformMonitor.resize(newSize: Int) {
		//	if (newSize > Capacity) reserve(_grow_capacity(newSize))
		//	Size = newSize
		//}

		//inline fun ImVector_ImGuiPlatformMonitor.push_back(value: ImGuiPlatformMonitor) {
		//	if (Size == Capacity) reserve(_grow_capacity(Size + 1))
		//	memcpy(Data!![Size].ptr, value.ptr, sizeOf<ImGuiPlatformMonitor>().convert())
		//	Size++
		//}

		//val platformIO = ImGui.getPlatformIO()
		//val glfwMonitors = Glfw.monitors
		//platformIO.Monitors.resize(0)
		//for (n in glfwMonitors.indices) {
		//	memScoped {
		//		val monitor = alloc<ImGuiPlatformMonitor>()
		//		val (monitorX, monitorY) = glfwMonitors[n].position
		//		val vidMode = glfwMonitors[n].videoMode
		//		monitor.MainPos.x = monitorX.toFloat()
		//		monitor.MainPos.y = monitorY.toFloat()
		//		monitor.MainSize.x = vidMode.width.toFloat()
		//		monitor.MainSize.y = vidMode.height.toFloat()
		//		val (x, y, w, h) = glfwMonitors[n].workarea
		//		monitor.WorkPos.x = x.toFloat()
		//		monitor.WorkPos.y = y.toFloat()
		//		monitor.WorkSize.x = w.toFloat()
		//		monitor.WorkSize.y = h.toFloat()
		//		val (xScale, _) = glfwMonitors[n].contentScale
		//		monitor.DpiScale = xScale
		//		platformIO.Monitors.push_back(monitor)
		//	}
		//}
		//wantUpdateMonitors
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
			//FIXME common
			//for (n in 0 until platformIO.Viewports.Size) {
			//	val viewport = platformIO.Viewports.Data!![n]!!.pointed
			//	val window = glfwGetWindowUserPointer(viewport.PlatformHandle!!.reinterpret())!!.asStableRef<Window>().get()
			//	if (window.isFocused) {
			//		if (io.WantSetMousePos) {
			//			window.cursorPosition = mousePosBackup.useContents { x.toDouble() to y.toDouble() }
			//		} else {
			//			val (mouseX, mouseY) = window.cursorPosition
			//			if (io.ConfigFlags and ImGuiConfigFlags.ViewportsEnable.value != 0) {
			//				val (windowX, windowY) = window.position
			//				io.MousePos.x = mouseX.toFloat() + windowX
			//				io.MousePos.y = mouseY.toFloat() + windowY
			//			} else {
			//				io.MousePos.x = mouseX.toFloat()
			//				io.MousePos.y = mouseY.toFloat()
			//			}
			//		}
			//	}
			//	for (i in 0 until 5) {
			//		io.MouseDown[i].value = io.MouseDown[i].value || window.getMouseButton(MouseButton.from(i)) != Action.Release
			//	}
			//}
		}

		// Update mouse cursor.
		run {
			val changeDisabled = ImGuiConfigFlags.NoMouseCursorChange in io.configFlags
			if (!changeDisabled && mainWindow.cursorMode != CursorMode.Disabled) {
				val imguiCursor = ImGui.getMouseCursor()
				val platformIO = ImGui.getPlatformIO()
				//FIXME common
				//for (n in 0 until platformIO.Viewports.Size) {
				//	val window = with(platformIO.Viewports.Data!![n]!!.pointed) {
				//		glfwGetWindowUserPointer(PlatformHandle!!.reinterpret())!!.asStableRef<Window>().get()
				//	}
				//	if (imguiCursor == ImGuiMouseCursor.None || io.MouseDrawCursor) {
				//		// Hide OS mouse cursor if imgui is drawing it or if it wants no cursor
				//		window.cursorMode = CursorMode.Hidden
				//	} else {
				//		// Show OS mouse cursor
				//		// FIXME-PLATFORM: Unfocused windows seems to fail changing the mouse cursor with GLFW 3.2, but 3.3 works here.
				//		window.setCursor(mouseCursors[imguiCursor.value] ?: mouseCursors[ImGuiMouseCursor.Arrow.value])
				//		window.cursorMode = CursorMode.Normal
				//	}
				//}
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

	private class ImGuiViewportDataGlfw : Closeable {
		var _window: Window? = null
		val window: Window get() = _window!!
		var isWindowOwned: Boolean = false
		var ignoreWindowPosEventFrame: Int = -1
		var ignoreWindowSizeEventFrame: Int = -1

		fun createWindow(pos: Pair<Int, Int>, size: Pair<Int, Int>, makeDecorated: Boolean, makeFloating: Boolean) {
			_window = Window(size.first, size.second, "No Title Yet", null, mainWindow) {
				//FIXME this should be set by the user once (if at all).
				// If the user uses a different context version, bad things may happen.
				// A fix would require removing the glfwDefaultWindowHints call from the Window constructor
				if (isMacOS) {
					contextVersionMajor = 3
					contextVersionMinor = 2
					openGLForwardCompat = true
					openGLProfile = OpenGLProfile.Core
				}
				visible = false
				focused = false
				focusOnShow = false
				decorated = makeDecorated
				floating = makeFloating
			}
			isWindowOwned = true
			window.position = pos

			window.setMouseButtonCallback(::mouseButtonCallback)
			window.setScrollCallback(::scrollCallback)
			window.setKeyCallback(::keyCallback)
			window.setCharCallback(::charCallback)
			window.setCloseCallback { window ->
				//FIXME common
				//igFindViewportByPlatformHandle(window.ptr)?.pointed?.PlatformRequestClose = true
			}
			window.setPosCallback { window, _, _ ->
				//FIXME common
				//igFindViewportByPlatformHandle(window.ptr)?.pointed?.let { viewport ->
				//	viewport.PlatformUserData?.asStableRef<ImGuiViewportDataGlfw>()?.get()?.let { data ->
				//		if (ImGui.getFrameCount() <= data.ignoreWindowPosEventFrame + 1) return@setPosCallback
				//	}
				//	viewport.PlatformRequestMove = true
				//}
			}
			window.setSizeCallback { window, _, _ ->
				//FIXME common
				//igFindViewportByPlatformHandle(window.ptr)?.pointed?.let { viewport ->
				//	viewport.PlatformUserData?.asStableRef<ImGuiViewportDataGlfw>()?.get()?.let { data ->
				//		if (ImGui.getFrameCount() <= data.ignoreWindowSizeEventFrame + 1) return@setSizeCallback
				//	}
				//	viewport.PlatformRequestResize = true
				//}
			}
		}

		fun destroyWindow() {
			if (isWindowOwned) {
				//FIXME Workaround because currently, Window.close() also terminates Glfw
				//window.close()
				//FIXME common
				//glfwGetWindowUserPointer(window.ptr)!!.asStableRef<Window>().dispose()
				//glfwDestroyWindow(window.ptr)
			}
			_window = null
		}

		override fun close() {
			check(_window == null)
		}
	}

	private fun initPlatformInterface() {
		//FIXME common
		//val platformIO = ImGui.getPlatformIO().ptr.pointed
		//platformIO.Platform_CreateWindow = staticCFunction { viewport ->
		//	val data = ImGuiViewportDataGlfw()
		//	viewport!!.pointed.PlatformUserData = StableRef.create(data).asCPointer()
		//	data.createWindow(
		//		viewport.pointed.Pos.x.toInt() to viewport.pointed.Pos.y.toInt(),
		//		viewport.pointed.Size.x.toInt() to viewport.pointed.Size.y.toInt(),
		//		viewport.pointed.Flags and ImGuiViewportFlags.NoDecoration.value == 0,
		//		viewport.pointed.Flags and ImGuiViewportFlags.TopMost.value != 0
		//	)
		//	viewport.pointed.PlatformHandle = data.window.ptr
		//}
		//platformIO.Platform_DestroyWindow = staticCFunction { viewport ->
		//	viewport!!.pointed.PlatformUserData?.asStableRef<ImGuiViewportDataGlfw>()?.let { dataRef ->
		//		val data = dataRef.get()
		//		data.destroyWindow()
		//		dataRef.dispose()
		//		data.close()
		//	}
		//	viewport.pointed.PlatformUserData = null
		//	viewport.pointed.PlatformHandle = null
		//}
		//platformIO.Platform_ShowWindow = staticCFunction { viewport ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.isVisible = true
		//}
		//platformIO.Platform_SetWindowPos = staticCFunction { viewport, pos ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.position = pos.useContents { x.toInt() to y.toInt() }
		//}
		//platformIO.Platform_GetWindowPos = staticCFunction { viewport ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.ignoreWindowPosEventFrame = ImGui.getFrameCount()
		//	data.window.position.let {
		//		cValue {
		//			x = it.first.toFloat()
		//			y = it.second.toFloat()
		//		}
		//	}
		//}
		//platformIO.Platform_SetWindowSize = staticCFunction { viewport, size ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.size = size.useContents { x.toInt() to y.toInt() }
		//}
		//platformIO.Platform_GetWindowSize = staticCFunction { viewport ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.ignoreWindowSizeEventFrame = ImGui.getFrameCount()
		//	data.window.size.let {
		//		cValue {
		//			x = it.first.toFloat()
		//			y = it.second.toFloat()
		//		}
		//	}
		//}
		//platformIO.Platform_SetWindowFocus = staticCFunction { viewport ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.focus()
		//}
		//platformIO.Platform_GetWindowFocus = staticCFunction { viewport ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.isFocused
		//}
		//platformIO.Platform_GetWindowMinimized = staticCFunction { viewport ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.isIconified
		//}
		//platformIO.Platform_SetWindowTitle = staticCFunction { viewport, title ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.setTitle(title?.toKString() ?: "")
		//}
		//platformIO.Platform_RenderWindow = staticCFunction { viewport, _ ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	Glfw.currentContext = data.window
		//}
		//platformIO.Platform_SwapBuffers = staticCFunction { viewport, _ ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	Glfw.currentContext = data.window
		//	data.window.swapBuffers()
		//}
		//platformIO.Platform_SetWindowAlpha = staticCFunction { viewport, alpha ->
		//	val data = viewport!!.pointed.PlatformUserData!!.asStableRef<ImGuiViewportDataGlfw>().get()
		//	data.window.opacity = alpha
		//}

		//val mainViewport = ImGui.getMainViewport().ptr.pointed
		//val data = ImGuiViewportDataGlfw()
		//data._window = mainWindow
		//data.isWindowOwned = false
		//mainViewport.PlatformUserData = StableRef.create(data).asCPointer()
		//mainViewport.PlatformHandle = mainWindow.ptr
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

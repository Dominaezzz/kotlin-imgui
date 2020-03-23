package com.imgui.impl

import cglfw.glfwGetClipboardString
import cglfw.glfwSetClipboardString
import com.imgui.*
import com.kgl.core.Flag
import com.kgl.glfw.*
import io.ktor.utils.io.core.Closeable
import kotlinx.cinterop.*
import platform.posix.memset

actual class ImGuiGLFW actual constructor(private val window: Window, installCallbacks: Boolean): Closeable {
	private var time: Double = 0.0
	private val mouseJustPressed = BooleanArray(5) { false }
	private val mouseCursors = Array<Cursor?>(ImGuiMouseCursor.values().size) { null }

	private val prevUserCallbackMouseButton: MouseButtonCallback? = null
	private val prevUserCallbackScroll: ScrollCallback? = null
	private val prevUserCallbackKey: KeyCallback? = null
	private val prevUserCallbackChar: CharCallback? = null

	init {
		val io = ImGui.getIO().ptr.pointed
		io.BackendFlags = io.BackendFlags or ImGuiBackendFlags.HasMouseCursors.value
		io.BackendFlags = io.BackendFlags or ImGuiBackendFlags.HasSetMousePos.value
		// io.BackendPlatformName = "ImguiGlfw".cstr

		// Keyboard mapping.
		inline fun mapKey(imGuiKey: ImGuiKey, key: KeyboardKey) {
			io.KeyMap[imGuiKey.value] = key.ordinal
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

		io.ClipboardUserData = window.ptr
		io.SetClipboardTextFn = staticCFunction { userData, text ->
			glfwSetClipboardString(userData?.reinterpret(), text?.toKString())
		}
		io.GetClipboardTextFn = staticCFunction { userData ->
			glfwGetClipboardString(userData?.reinterpret())
		}

		mouseCursors[ImGuiMouseCursor.Arrow.value] = Cursor(Cursor.Standard.Arrow)
		mouseCursors[ImGuiMouseCursor.TextInput.value] = Cursor(Cursor.Standard.IBeam)
		mouseCursors[ImGuiMouseCursor.ResizeAll.value] = Cursor(Cursor.Standard.Arrow)   // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNS.value] = Cursor(Cursor.Standard.VResize)
		mouseCursors[ImGuiMouseCursor.ResizeEW.value] = Cursor(Cursor.Standard.HResize)
		mouseCursors[ImGuiMouseCursor.ResizeNESW.value] = Cursor(Cursor.Standard.Arrow)  // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNWSE.value] = Cursor(Cursor.Standard.Arrow)  // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.Hand.value] = Cursor(Cursor.Standard.Hand)

		// prevUserCallbackMouseButton = null
		// prevUserCallbackScroll = null
		// prevUserCallbackKey = null
		// prevUserCallbackChar = null
		if (installCallbacks) {
			window.setMouseButtonCallback(this::mouseButtonCallback)
			window.setScrollCallback(this::scrollCallback)
			window.setKeyCallback(this::keyCallback)
			window.setCharCallback(this::charCallback)
		}
	}

	actual fun mouseButtonCallback(window: Window, button: MouseButton, action: Action, mods: Flag<Mod>) {
		prevUserCallbackMouseButton?.invoke(window, button, action, mods)

		if (action == Action.Press) {
			mouseJustPressed[button.ordinal] = true
		}
	}

	actual fun scrollCallback(window: Window, offsetX: Double, offsetY: Double) {
		prevUserCallbackScroll?.invoke(window, offsetX, offsetY)

		val io = ImGui.getIO().ptr.pointed
		io.MouseWheelH += offsetX.toFloat()
		io.MouseWheel += offsetY.toFloat()
	}

	actual fun keyCallback(window: Window, key: KeyboardKey, scancode: Int, action: Action, mods: Flag<Mod>) {
		prevUserCallbackKey?.invoke(window, key, scancode, action, mods)

		val io = ImGui.getIO().ptr.pointed
		if (action == Action.Press) {
			io.KeysDown[key.ordinal].value = true
		}
		if (action == Action.Release) {
			io.KeysDown[key.ordinal].value = false
		}

		// Modifiers are not reliable across systems
		io.KeyCtrl = io.KeysDown[KeyboardKey.LEFT_CONTROL.ordinal].value || io.KeysDown[KeyboardKey.RIGHT_CONTROL.ordinal].value
		io.KeyShift = io.KeysDown[KeyboardKey.LEFT_SHIFT.ordinal].value || io.KeysDown[KeyboardKey.RIGHT_SHIFT.ordinal].value
		io.KeyAlt = io.KeysDown[KeyboardKey.LEFT_ALT.ordinal].value || io.KeysDown[KeyboardKey.RIGHT_ALT.ordinal].value
		io.KeySuper = io.KeysDown[KeyboardKey.LEFT_SUPER.ordinal].value || io.KeysDown[KeyboardKey.RIGHT_SUPER.ordinal].value
	}

	actual fun charCallback(window: Window, codepoint: UInt) {
		prevUserCallbackChar?.invoke(window, codepoint)

		val io = ImGui.getIO()
		io.addInputCharacter(codepoint)
	}

	actual fun newFrame() {
		val ioObj = ImGui.getIO()
		assert(ioObj.fonts!!.isBuilt()) {
			"Font atlas not built! It is generally built by the renderer back-end. Missing call to renderer _NewFrame() function? e.g. ImGui_ImplOpenGL3_NewFrame()."
		}
		val io = ioObj.ptr.pointed

		// Setup display size (every frame to accommodate for window resizing)
		val (w, h) = window.size
		val (displayWidth, displayHeight) = window.frameBufferSize

		io.DisplaySize.x = w.toFloat()
		io.DisplaySize.y = h.toFloat()
		if (w > 0 && h > 0) {
			io.DisplayFramebufferScale.x = displayWidth / w.toFloat()
			io.DisplayFramebufferScale.y = displayHeight / h.toFloat()
		}

		// Setup time step
		val currentTime = Glfw.time
		io.DeltaTime = (if (time > 0.0) (currentTime - time) else 1.0 / 60.0).toFloat()
		time = currentTime

		// Update mouse position and buttons.
		run {
			// Update buttons
			for (i in 0 until 5) {
				io.MouseDown[i].value = mouseJustPressed[i] || window.getMouseButton(MouseButton.values()[i]) != Action.Release
				mouseJustPressed[i] = false
			}

			// Update position
			val mousePosBackup = io.MousePos.readValue()
			io.MousePos.x = -Float.MAX_VALUE
			io.MousePos.y = -Float.MAX_VALUE
			if (window.isFocused) {
				if (io.WantSetMousePos) {
					window.cursorPosition = mousePosBackup.useContents { x.toDouble() to y.toDouble() }
				} else {
					val (mouseX, mouseY) = window.cursorPosition
					io.MousePos.x = mouseX.toFloat()
					io.MousePos.y = mouseY.toFloat()
				}
			}
		}

		// Update mouse cursor.
		run {
			val changeDisabled = io.ConfigFlags and ImGuiConfigFlags.NoMouseCursorChange.value != 0
			if (!changeDisabled && window.cursorMode != CursorMode.Disabled) {
				val imguiCursor = ImGui.getMouseCursor()
				if (imguiCursor == ImGuiMouseCursor.None || io.MouseDrawCursor) {
					// Hide OS mouse cursor if imgui is drawing it or if it wants no cursor
					window.cursorMode = CursorMode.Hidden
				} else {
					// Show OS mouse cursor
					// FIXME-PLATFORM: Unfocused windows seems to fail changing the mouse cursor with GLFW 3.2, but 3.3 works here.
					window.setCursor(mouseCursors[imguiCursor.value] ?: mouseCursors[ImGuiMouseCursor.Arrow.value])
					window.cursorMode = CursorMode.Normal
				}
			}
		}

		// Update gamepads
		run {
			memset(io.NavInputs, 0, sizeOf<FloatVar>().toULong() * ImGuiNavInput.values().size.toUInt())
			if (io.ConfigFlags and ImGuiConfigFlags.NavEnableGamepad.value != 0) {

				val axes = Joystick._1.axes!!
				val buttons = Joystick._1.buttons!!
				val axesCount = axes.size
				val buttonsCount = buttons.size

				inline fun mapButton(navNo: ImGuiNavInput, buttonNo: Int) {
					if (buttonsCount > buttonNo && buttons[buttonNo] == Action.Press) {
						io.NavInputs[navNo.value] = 1.0f
					}
				}
				inline fun mapAnalog(navNo: ImGuiNavInput, axisNo: Int, v0: Float, v1: Float) {
					var v = if (axesCount > axisNo) axes[axesCount] else v0
					v = (v - v0) / (v1 - v0)
					v = v.coerceAtMost(1.0f)
					if (io.NavInputs[navNo.value] < v) {
						io.NavInputs[navNo.value] = v
					}
				}

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

				if (axesCount > 0 && buttonsCount > 0) {
					io.BackendFlags = io.BackendFlags or ImGuiBackendFlags.HasGamepad.value
				} else {
					io.BackendFlags = io.BackendFlags and ImGuiBackendFlags.HasGamepad.value.inv()
				}
			}
		}
	}

	override fun close() {
		mouseCursors.forEach { it?.close() }
	}
}

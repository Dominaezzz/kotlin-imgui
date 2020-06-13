package com.imgui.impl

import com.imgui.*
import com.kgl.core.Flag
import com.kgl.glfw.*
import io.ktor.utils.io.core.Closeable

class ImGuiGLFW(private val window: Window, installCallbacks: Boolean) : Closeable {
	private var time: Double = 0.0
	private val mouseJustPressed = BooleanArray(5) { false }
	private val mouseCursors = Array<Cursor?>(ImGuiMouseCursor.values().size) { null }

	private val prevUserCallbackMouseButton: MouseButtonCallback?
	private val prevUserCallbackScroll: ScrollCallback?
	private val prevUserCallbackKey: KeyCallback?
	private val prevUserCallbackChar: CharCallback?

	init {
		val io = ImGui.getIO()
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasMouseCursors
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasSetMousePos
		// io.BackendPlatformName = "ImguiGlfw".cstr

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

		mouseCursors[ImGuiMouseCursor.Arrow.cValue] = Cursor(Cursor.Standard.Arrow)
		mouseCursors[ImGuiMouseCursor.TextInput.cValue] = Cursor(Cursor.Standard.IBeam)
		mouseCursors[ImGuiMouseCursor.ResizeAll.cValue] = Cursor(Cursor.Standard.Arrow)   // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNS.cValue] = Cursor(Cursor.Standard.VResize)
		mouseCursors[ImGuiMouseCursor.ResizeEW.cValue] = Cursor(Cursor.Standard.HResize)
		mouseCursors[ImGuiMouseCursor.ResizeNESW.cValue] = Cursor(Cursor.Standard.Arrow)  // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNWSE.cValue] = Cursor(Cursor.Standard.Arrow)  // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.Hand.cValue] = Cursor(Cursor.Standard.Hand)

		if (installCallbacks) {
			prevUserCallbackMouseButton = window.setMouseButtonCallback(this::mouseButtonCallback)
			prevUserCallbackScroll = window.setScrollCallback(this::scrollCallback)
			prevUserCallbackKey = window.setKeyCallback(this::keyCallback)
			prevUserCallbackChar = window.setCharCallback(this::charCallback)
		} else {
			prevUserCallbackMouseButton = null
			prevUserCallbackScroll = null
			prevUserCallbackKey = null
			prevUserCallbackChar = null
		}
	}

	fun mouseButtonCallback(window: Window, button: MouseButton, action: Action, mods: Flag<Mod>) {
		prevUserCallbackMouseButton?.invoke(window, button, action, mods)

		if (action == Action.Press) {
			mouseJustPressed[button.ordinal] = true
		}
	}

	fun scrollCallback(window: Window, offsetX: Double, offsetY: Double) {
		prevUserCallbackScroll?.invoke(window, offsetX, offsetY)

		val io = ImGui.getIO()
		io.mouseWheelH += offsetX.toFloat()
		io.mouseWheel += offsetY.toFloat()
	}

	fun keyCallback(window: Window, key: KeyboardKey, scancode: Int, action: Action, mods: Flag<Mod>) {
		prevUserCallbackKey?.invoke(window, key, scancode, action, mods)

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
		io.keySuper = io.keysDown(KeyboardKey.LEFT_SUPER.ordinal) || io.keysDown(KeyboardKey.RIGHT_SUPER.ordinal)
	}

	fun charCallback(window: Window, codepoint: UInt) {
		prevUserCallbackChar?.invoke(window, codepoint)

		val io = ImGui.getIO()
		io.addInputCharacter(codepoint)
	}

	fun newFrame() {
		val io = ImGui.getIO()
		check(io.fonts!!.isBuilt()) {
			"Font atlas not built! It is generally built by the renderer back-end. Missing call to renderer _NewFrame() function? e.g. ImGui_ImplOpenGL3_NewFrame()."
		}

		// Setup display size (every frame to accommodate for window resizing)
		val (w, h) = window.size
		val (displayWidth, displayHeight) = window.frameBufferSize

		io.displaySize = Vec2(w.toFloat(), h.toFloat())
		if (w > 0 && h > 0) {
			io.displayFramebufferScale = Vec2(displayWidth / w.toFloat(), displayHeight / h.toFloat())
		}

		// Setup time step
		val currentTime = Glfw.time
		io.deltaTime = (if (time > 0.0) (currentTime - time) else 1.0 / 60.0).toFloat()
		time = currentTime

		// Update mouse position and buttons.
		run {
			// Update buttons
			for (i in 0 until 5) {
				io.mouseDown(i, mouseJustPressed[i] || window.getMouseButton(MouseButton.values()[i]) != Action.Release)
				mouseJustPressed[i] = false
			}

			// Update position
			val mousePosBackup = io.mousePos
			io.mousePos = Vec2(-Float.MAX_VALUE, -Float.MAX_VALUE)
			if (window.isFocused) {
				if (io.wantSetMousePos) {
					window.cursorPosition = mousePosBackup.run { x.toDouble() to y.toDouble() }
				} else {
					val (mouseX, mouseY) = window.cursorPosition
					io.mousePos = Vec2(mouseX.toFloat(), mouseY.toFloat())
				}
			}
		}

		// Update mouse cursor.
		run {
			val changeDisabled = ImGuiConfigFlags.NoMouseCursorChange in io.configFlags
			if (!changeDisabled && window.cursorMode != CursorMode.Disabled) {
				val imguiCursor = ImGui.getMouseCursor()
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

		// Update gamepads
		run {
			for (i in 0..ImGuiNavInput.values().size) {
				io.navInputs(i, 0.0f)
			}
			if (ImGuiConfigFlags.NavEnableGamepad in io.configFlags) {
				val axes = Joystick._1.axes!!
				val buttons = Joystick._1.buttons!!
				val axesCount = axes.size
				val buttonsCount = buttons.size

				fun mapButton(navNo: ImGuiNavInput, buttonNo: Int) {
					if (buttonsCount > buttonNo && buttons[buttonNo] == Action.Press) {
						io.navInputs(navNo.cValue, 1.0f)
					}
				}

				fun mapAnalog(navNo: ImGuiNavInput, axisNo: Int, v0: Float, v1: Float) {
					var v = if (axesCount > axisNo) axes[axesCount] else v0
					v = (v - v0) / (v1 - v0)
					v = v.coerceAtMost(1.0f)
					if (io.navInputs(navNo.cValue) < v) {
						io.navInputs(navNo.cValue, v)
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
					io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasGamepad
				} else {
					io.backendFlags = io.backendFlags - ImGuiBackendFlags.HasGamepad
				}
			}
		}
	}

	override fun close() {
		freeClipboard(ImGui.getIO())
		mouseCursors.forEach { it?.close() }
	}
}

package com.imgui.impl

import cimgui.internal.*
import com.imgui.*
import com.kgl.core.Flag
import com.kgl.glfw.*
import io.ktor.utils.io.core.Closeable
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.system.Callback
import org.lwjgl.system.dyncall.DynCallback.dcbArgPointer

actual class ImGuiGLFW actual constructor(private val window: Window, installCallbacks: Boolean) : Closeable {
	private var time: Double = 0.0
	private val mouseJustPressed = BooleanArray(5) { false }
	private val mouseCursors = Array<Cursor?>(ImGuiMouseCursor.values().size) { null }

	private val prevUserCallbackMouseButton: MouseButtonCallback?
	private val prevUserCallbackScroll: ScrollCallback?
	private val prevUserCallbackKey: KeyCallback?
	private val prevUserCallbackChar: CharCallback?

	init {
		val io = ImGui.getIO().ptr
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasMouseCursors.value
		io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasSetMousePos.value
		// io.backendPlatformName = "ImguiGlfw".cstr

		// Keyboard mapping.
		fun mapKey(imGuiKey: ImGuiKey, key: KeyboardKey) {
			io.keyMap[imGuiKey.value] = key.ordinal
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

		val setClipboard = object : org.lwjgl.system.CallbackI.V {
			override fun getSignature(): String = "(pp)v"

			override fun callback(args: Long) {
				val userData = dcbArgPointer(args)
				val text = dcbArgPointer(args)

				nglfwSetClipboardString(userData, text)
			}
		}
		val getClipboard = object : org.lwjgl.system.CallbackI.P {
			override fun getSignature(): String = "(p)p"

			override fun callback(args: Long): Long {
				val userData = dcbArgPointer(args)

				return nglfwGetClipboardString(userData)
			}
		}

		io.clipboardUserData = SWIGTYPE_p_void(window.ptr, false)
		io.setClipboardTextFn = SWIGTYPE_p_f_p_void_p_q_const__char__void(setClipboard.address(), false)
		io.getClipboardTextFn = SWIGTYPE_p_f_p_void__p_char(getClipboard.address(), false)

		mouseCursors[ImGuiMouseCursor.Arrow.value] = Cursor(Cursor.Standard.Arrow)
		mouseCursors[ImGuiMouseCursor.TextInput.value] = Cursor(Cursor.Standard.IBeam)
		mouseCursors[ImGuiMouseCursor.ResizeAll.value] = Cursor(Cursor.Standard.Arrow)   // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNS.value] = Cursor(Cursor.Standard.VResize)
		mouseCursors[ImGuiMouseCursor.ResizeEW.value] = Cursor(Cursor.Standard.HResize)
		mouseCursors[ImGuiMouseCursor.ResizeNESW.value] = Cursor(Cursor.Standard.Arrow)  // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.ResizeNWSE.value] = Cursor(Cursor.Standard.Arrow)  // FIXME: GLFW doesn't have this.
		mouseCursors[ImGuiMouseCursor.Hand.value] = Cursor(Cursor.Standard.Hand)

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

	actual fun mouseButtonCallback(window: Window, button: MouseButton, action: Action, mods: Flag<Mod>) {
		prevUserCallbackMouseButton?.invoke(window, button, action, mods)

		if (action == Action.Press) {
			mouseJustPressed[button.ordinal] = true
		}
	}

	actual fun scrollCallback(window: Window, offsetX: Double, offsetY: Double) {
		prevUserCallbackScroll?.invoke(window, offsetX, offsetY)

		val io = ImGui.getIO().ptr
		io.mouseWheelH += offsetX.toFloat()
		io.mouseWheel += offsetY.toFloat()
	}

	actual fun keyCallback(window: Window, key: KeyboardKey, scancode: Int, action: Action, mods: Flag<Mod>) {
		prevUserCallbackKey?.invoke(window, key, scancode, action, mods)

		val io = ImGui.getIO().ptr
		if (action == Action.Press) {
			io.keysDown[key.ordinal] = true
		}
		if (action == Action.Release) {
			io.keysDown[key.ordinal] = false
		}

		// Modifiers are not reliable across systems
		io.keyCtrl = io.keysDown[KeyboardKey.LEFT_CONTROL.ordinal] || io.keysDown[KeyboardKey.RIGHT_CONTROL.ordinal]
		io.keyShift = io.keysDown[KeyboardKey.LEFT_SHIFT.ordinal] || io.keysDown[KeyboardKey.RIGHT_SHIFT.ordinal]
		io.keyAlt = io.keysDown[KeyboardKey.LEFT_ALT.ordinal] || io.keysDown[KeyboardKey.RIGHT_ALT.ordinal]
		io.keySuper = io.keysDown[KeyboardKey.LEFT_SUPER.ordinal] || io.keysDown[KeyboardKey.RIGHT_SUPER.ordinal]
	}

	actual fun charCallback(window: Window, codepoint: UInt) {
		prevUserCallbackChar?.invoke(window, codepoint)

		val io = ImGui.getIO()
		io.addInputCharacter(codepoint)
	}

	actual fun newFrame() {
		val io = ImGui.getIO().ptr
		assert(CImGui.ImFontAtlas_IsBuilt(io.fonts)) {
			"Font atlas not built! It is generally built by the renderer back-end. Missing call to renderer _NewFrame() function? e.g. ImGui_ImplOpenGL3_NewFrame()."
		}

		// Setup display size (every frame to accommodate for window resizing)
		val (w, h) = window.size
		val (displayWidth, displayHeight) = window.frameBufferSize

		io.displaySize.x = w.toFloat()
		io.displaySize.y = h.toFloat()
		if (w > 0 && h > 0) {
			io.displayFramebufferScale.x = displayWidth / w.toFloat()
			io.displayFramebufferScale.y = displayHeight / h.toFloat()
		}

		// Setup time step
		val currentTime = Glfw.time
		io.deltaTime = (if (time > 0.0) (currentTime - time) else 1.0 / 60.0).toFloat()
		time = currentTime

		// Update mouse position and buttons.
		run {
			// Update buttons
			for (i in 0 until 5) {
				io.mouseDown[i] = mouseJustPressed[i] || window.getMouseButton(MouseButton.values()[i]) != Action.Release
				mouseJustPressed[i] = false
			}

			// Update position
			val mousePosBackupX = io.mousePos.x
			val mousePosBackupY = io.mousePos.y
			io.mousePos.x = -Float.MAX_VALUE
			io.mousePos.y = -Float.MAX_VALUE
			if (window.isFocused) {
				if (io.wantSetMousePos) {
					window.cursorPosition = mousePosBackupX.toDouble() to mousePosBackupY.toDouble()
				} else {
					val (mouseX, mouseY) = window.cursorPosition
					io.mousePos.x = mouseX.toFloat()
					io.mousePos.y = mouseY.toFloat()
				}
			}
		}

		// Update mouse cursor.
		run {
			val changeDisabled = io.configFlags and ImGuiConfigFlags.NoMouseCursorChange.value != 0
			if (!changeDisabled && window.cursorMode != CursorMode.Disabled) {
				val imguiCursor = ImGui.getMouseCursor()
				if (imguiCursor == ImGuiMouseCursor.None || io.mouseDrawCursor) {
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
			repeat(ImGuiNavInput.values().size) { io.navInputs[it] = 0f }
			if (io.configFlags and ImGuiConfigFlags.NavEnableGamepad.ordinal != 0) {
				val axes = Joystick._1.axes!!
				val buttons = Joystick._1.buttons!!
				val axesCount = axes.size
				val buttonsCount = buttons.size

				fun mapButton(navNo: ImGuiNavInput, buttonNo: Int) {
					if (buttonsCount > buttonNo && buttons[buttonNo] == Action.Press) {
						io.navInputs[navNo.value] = 1.0f
					}
				}

				fun mapAnalog(navNo: ImGuiNavInput, axisNo: Int, v0: Float, v1: Float) {
					var v = if (axesCount > axisNo) axes[axesCount] else v0
					v = (v - v0) / (v1 - v0)
					v = v.coerceAtMost(1.0f)
					if (io.navInputs[navNo.value] < v) {
						io.navInputs[navNo.value] = v
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
					io.backendFlags = io.backendFlags or ImGuiBackendFlags.HasGamepad.value
				} else {
					io.backendFlags = io.backendFlags and -ImGuiBackendFlags.HasGamepad.value
				}
			}
		}
	}

	override fun close() {
		val io = ImGui.getIO().ptr
		io.clipboardUserData = null
		Callback.free(SWIGTYPE_p_f_p_void_p_q_const__char__void.getCPtr(io.setClipboardTextFn))
		io.setClipboardTextFn = null
		Callback.free(SWIGTYPE_p_f_p_void__p_char.getCPtr(io.getClipboardTextFn))
		io.getClipboardTextFn = null

		mouseCursors.forEach { it?.close() }
	}

	private operator fun SWIGTYPE_p_bool.set(index: Int, value: Boolean) {
		CImGui.boolArray_setitem(this, index, value)
	}

	private operator fun SWIGTYPE_p_bool.get(index: Int): Boolean {
		return CImGui.boolArray_getitem(this, index)
	}

	private operator fun SWIGTYPE_p_int.set(index: Int, value: Int) {
		CImGui.intArray_setitem(this, index, value)
	}

	private operator fun SWIGTYPE_p_int.get(index: Int): Int {
		return CImGui.intArray_getitem(this, index)
	}

	private operator fun SWIGTYPE_p_float.set(index: Int, value: Float) {
		CImGui.floatArray_setitem(this, index, value)
	}

	private operator fun SWIGTYPE_p_float.get(index: Int): Float {
		return CImGui.floatArray_getitem(this, index)
	}
}

package com.imgui.impl

import com.kgl.core.Flag
import com.kgl.glfw.*
import io.ktor.utils.io.core.Closeable

expect class ImGuiGLFW(window: Window, installCallbacks: Boolean): Closeable {
	fun mouseButtonCallback(window: Window, button: MouseButton, action: Action, mods: Flag<Mod>)

	fun scrollCallback(window: Window, offsetX: Double, offsetY: Double)

	fun keyCallback(window: Window, key: KeyboardKey, scancode: Int, action: Action, mods: Flag<Mod>)

	fun charCallback(window: Window, codepoint: UInt)

	fun newFrame()
}

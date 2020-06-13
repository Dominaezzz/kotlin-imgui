package com.imgui.impl

import cglfw.glfwGetClipboardString
import cglfw.glfwSetClipboardString
import com.imgui.ImGuiIO
import com.imgui.Vec2
import com.kgl.glfw.Window
import kotlinx.cinterop.pointed
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString


actual fun setupClipboard(ioObj: ImGuiIO, window: Window) {
	val io = ioObj.ptr.pointed
	io.ClipboardUserData = window.ptr
	io.SetClipboardTextFn = staticCFunction { userData, text ->
		glfwSetClipboardString(userData?.reinterpret(), text?.toKString())
	}
	io.GetClipboardTextFn = staticCFunction { userData ->
		glfwGetClipboardString(userData?.reinterpret())
	}
}

actual fun freeClipboard(ioObj: ImGuiIO) {
}

package com.imgui.impl

import cglfw.*
import com.imgui.*
import com.kgl.glfw.*
import kotlinx.cinterop.*

actual val isMacOS: Boolean = Platform.osFamily == OsFamily.MACOSX
actual val isWin32: Boolean = Platform.osFamily == OsFamily.WINDOWS

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

actual fun freeClipboard(ioObj: ImGuiIO) {}

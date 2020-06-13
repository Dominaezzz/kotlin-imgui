package com.imgui.impl

import cimgui.internal.SWIGTYPE_p_f_p_void__p_char
import cimgui.internal.SWIGTYPE_p_f_p_void_p_q_const__char__void
import cimgui.internal.SWIGTYPE_p_void
import com.imgui.ImGuiIO
import com.imgui.Vec2
import com.kgl.glfw.Window
import org.lwjgl.glfw.GLFW
import org.lwjgl.system.Callback
import org.lwjgl.system.dyncall.DynCallback


actual fun setupClipboard(ioObj: ImGuiIO, window: Window) {
	val io = ioObj.ptr

	val setClipboard = object : org.lwjgl.system.CallbackI.V {
		override fun getSignature(): String = "(pp)v"

		override fun callback(args: Long) {
			val userData = DynCallback.dcbArgPointer(args)
			val text = DynCallback.dcbArgPointer(args)

			GLFW.nglfwSetClipboardString(userData, text)
		}
	}
	val getClipboard = object : org.lwjgl.system.CallbackI.P {
		override fun getSignature(): String = "(p)p"

		override fun callback(args: Long): Long {
			val userData = DynCallback.dcbArgPointer(args)

			return GLFW.nglfwGetClipboardString(userData)
		}
	}

	io.clipboardUserData = SWIGTYPE_p_void(window.ptr, false)
	io.setClipboardTextFn = SWIGTYPE_p_f_p_void_p_q_const__char__void(setClipboard.address(), false)
	io.getClipboardTextFn = SWIGTYPE_p_f_p_void__p_char(getClipboard.address(), false)
}

actual fun freeClipboard(ioObj: ImGuiIO) {
	val io = ioObj.ptr

	Callback.free(SWIGTYPE_p_f_p_void_p_q_const__char__void.getCPtr(io.setClipboardTextFn))
	Callback.free(SWIGTYPE_p_f_p_void__p_char.getCPtr(io.getClipboardTextFn))

	io.clipboardUserData = null
	io.setClipboardTextFn = null
	io.getClipboardTextFn = null
}

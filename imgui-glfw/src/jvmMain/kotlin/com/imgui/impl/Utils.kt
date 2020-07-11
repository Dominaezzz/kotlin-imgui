package com.imgui.impl

import cimgui.internal.*
import cimgui.internal.ImVec2
import com.imgui.*
import com.imgui.ImGuiIO
import com.imgui.ImGuiPlatformIO
import com.imgui.ImGuiPlatformMonitor
import com.imgui.ImGuiViewport
import com.kgl.glfw.*
import org.lwjgl.glfw.*
import org.lwjgl.system.*
import org.lwjgl.system.dyncall.*
import org.lwjgl.system.jni.*

actual val isMacOS: Boolean = "mac" in System.getProperty("os.name").toLowerCase()
actual val isWin32: Boolean = "win" in System.getProperty("os.name").toLowerCase()

actual fun setupClipboard(ioObj: ImGuiIO, window: Window) {
	val io = ioObj.ptr

	val setClipboard = object : CallbackI.V {
		override fun getSignature(): String = "(pp)v"

		override fun callback(args: Long) {
			val userData = DynCallback.dcbArgPointer(args)
			val text = DynCallback.dcbArgPointer(args)

			GLFW.nglfwSetClipboardString(userData, text)
		}
	}
	val getClipboard = object : CallbackI.P {
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

internal actual fun ImGuiGlfw.initPlatformInterface() {
	val platformIO = ImGui.getPlatformIO().ptr
	platformIO.platform_CreateWindow = SWIGTYPE_p_f_p_ImGuiViewport__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(p)v"
			override fun callback(args: Long) {
				val imGuiGlfw = ImGui.getIO().imGuiGlfw!!
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				val data = ImGuiGlfw.ViewportData(imGuiGlfw, viewport)
				viewport.glfwViewportData = data
				viewport.glfwWindow = data.window
			}
		}.address(),
		false
	)
	platformIO.platform_DestroyWindow = SWIGTYPE_p_f_p_ImGuiViewport__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(p)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				viewport.glfwViewportData?.close()
				viewport.glfwViewportData = null
				viewport.glfwWindow = null
			}
		}.address(),
		false
	)
	platformIO.platform_ShowWindow = SWIGTYPE_p_f_p_ImGuiViewport__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(p)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				viewport.glfwViewportData!!.showWindow()
			}
		}.address(),
		false
	)
	platformIO.platform_SetWindowPos = SWIGTYPE_p_f_p_ImGuiViewport_ImVec2__void(
		object : CallbackI.V { //TODO is this the right type?
			override fun getSignature(): String = "(pp)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				val pos = ImVec2(DynCallback.dcbArgPointer(args), false)
				viewport.glfwViewportData!!.setWindowPos(Vec2(pos.x, pos.y))
			}
		}.address(),
		false
	)
	platformIO.platform_GetWindowPos = SWIGTYPE_p_f_p_ImGuiViewport__ImVec2(
		object : CallbackI.P { //TODO is this the right type?
			override fun getSignature(): String = "(p)p"
			override fun callback(args: Long): Long {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				return viewport.glfwViewportData!!.getWindowPos().let {
					ImVec2.getCPtr(ImVec2().apply { x = it.x; y = it.y })
				}
			}
		}.address(),
		false
	)
	platformIO.platform_SetWindowSize = SWIGTYPE_p_f_p_ImGuiViewport_ImVec2__void(
		object : CallbackI.V { //TODO is this the right type?
			override fun getSignature(): String = "(pp)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				val size = ImVec2(DynCallback.dcbArgPointer(args), false)
				viewport.glfwViewportData!!.setWindowSize(Vec2(size.x, size.y))
			}
		}.address(),
		false
	)
	platformIO.platform_GetWindowSize = SWIGTYPE_p_f_p_ImGuiViewport__ImVec2(
		object : CallbackI.P { //TODO is this the right type?
			override fun getSignature(): String = "(p)p"
			override fun callback(args: Long): Long {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				return viewport.glfwViewportData!!.getWindowSize().let {
					ImVec2.getCPtr(ImVec2().apply { x = it.x; y = it.y })
				}
			}
		}.address(),
		false
	)
	platformIO.platform_SetWindowFocus = SWIGTYPE_p_f_p_ImGuiViewport__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(p)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				viewport.glfwViewportData!!.setWindowFocus()
			}
		}.address(),
		false
	)
	platformIO.platform_GetWindowFocus = SWIGTYPE_p_f_p_ImGuiViewport__bool(
		object : CallbackI.Z {
			override fun getSignature(): String = "(p)B"
			override fun callback(args: Long): Boolean {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				return viewport.glfwViewportData!!.getWindowFocus()
			}
		}.address(),
		false
	)
	platformIO.platform_GetWindowMinimized = SWIGTYPE_p_f_p_ImGuiViewport__bool(
		object : CallbackI.Z {
			override fun getSignature(): String = "(p)B"
			override fun callback(args: Long): Boolean {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				return viewport.glfwViewportData!!.getWindowMinimized()
			}
		}.address(),
		false
	)
	platformIO.platform_SetWindowTitle = SWIGTYPE_p_f_p_ImGuiViewport_p_q_const__char__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(pp)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				val title = MemoryUtil.memUTF8(DynCallback.dcbArgPointer(args))
				viewport.glfwViewportData!!.setWindowTitle(title)
			}
		}.address(),
		false
	)
	platformIO.platform_RenderWindow = SWIGTYPE_p_f_p_ImGuiViewport_p_void__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(pp)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				viewport.glfwViewportData!!.renderWindow()
			}
		}.address(),
		false
	)
	platformIO.platform_SwapBuffers = SWIGTYPE_p_f_p_ImGuiViewport_p_void__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(pp)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				viewport.glfwViewportData!!.swapBuffers()
			}
		}.address(),
		false
	)
	platformIO.platform_SetWindowAlpha = SWIGTYPE_p_f_p_ImGuiViewport_float__void(
		object : CallbackI.V {
			override fun getSignature(): String = "(pf)v"
			override fun callback(args: Long) {
				val viewport = ImGuiViewport(cimgui.internal.ImGuiViewport(DynCallback.dcbArgPointer(args), false))
				val alpha = DynCallback.dcbArgFloat(args)
				viewport.glfwViewportData!!.setWindowAlpha(alpha)
			}
		}.address(),
		false
	)

	val mainViewport = ImGui.getMainViewport()
	val data = ImGuiGlfw.ViewportData(this)
	mainViewport.glfwViewportData = data
	mainViewport.glfwWindow = mainWindow
}

internal actual fun ImGuiGlfw.shutdownPlatformInterface() {
	val platformIO = ImGui.getPlatformIO().ptr
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__void.getCPtr(platformIO.platform_CreateWindow))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__void.getCPtr(platformIO.platform_DestroyWindow))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__void.getCPtr(platformIO.platform_ShowWindow))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport_ImVec2__void.getCPtr(platformIO.platform_SetWindowPos))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__ImVec2.getCPtr(platformIO.platform_GetWindowPos))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport_ImVec2__void.getCPtr(platformIO.platform_SetWindowSize))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__ImVec2.getCPtr(platformIO.platform_GetWindowSize))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__void.getCPtr(platformIO.platform_SetWindowFocus))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__bool.getCPtr(platformIO.platform_GetWindowFocus))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport__bool.getCPtr(platformIO.platform_GetWindowMinimized))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport_p_q_const__char__void.getCPtr(platformIO.platform_SetWindowTitle))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport_p_void__void.getCPtr(platformIO.platform_RenderWindow))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport_p_void__void.getCPtr(platformIO.platform_SwapBuffers))
	Callback.free(SWIGTYPE_p_f_p_ImGuiViewport_float__void.getCPtr(platformIO.platform_SetWindowAlpha))
}


actual var ImGuiIO.imGuiGlfw: ImGuiGlfw?
	get() = MemoryUtil.memGlobalRefToObject<ImGuiGlfw>(SWIGTYPE_p_void.getCPtr(ptr.backendPlatformUserData))
	set(value) {
		ptr.backendPlatformUserData?.let { JNINativeInterface.DeleteGlobalRef(SWIGTYPE_p_void.getCPtr(it)) }
		ptr.backendPlatformUserData = value?.let { SWIGTYPE_p_void(JNINativeInterface.NewGlobalRef(it), false) }
	}

actual var ImGuiViewport.glfwWindow: Window?
	get() = MemoryUtil.memGlobalRefToObject<Window>(GLFW.glfwGetWindowUserPointer(SWIGTYPE_p_void.getCPtr(ptr.platformHandle)))
	set(value) {
		ptr.platformHandle = value?.let { SWIGTYPE_p_void(it.ptr, false) }
	}

actual var ImGuiViewport.glfwViewportData: ImGuiGlfw.ViewportData?
	get() = MemoryUtil.memGlobalRefToObject<ImGuiGlfw.ViewportData>(SWIGTYPE_p_void.getCPtr(ptr.platformUserData))
	set(value) {
		ptr.platformUserData?.let { JNINativeInterface.DeleteGlobalRef(SWIGTYPE_p_void.getCPtr(it)) }
		ptr.platformUserData = value?.let { SWIGTYPE_p_void(JNINativeInterface.NewGlobalRef(it), false) }
	}

actual val ImGuiPlatformIO.monitors: ImVector<ImGuiPlatformMonitor>
	get() = object : ImVector<ImGuiPlatformMonitor>() {
		private val monitors = ptr.monitors

		override val capacity get() = monitors.capacity
		override val size get() = monitors.size

		override operator fun get(index: Int): ImGuiPlatformMonitor {
			val data = cimgui.internal.ImGuiPlatformMonitor.getCPtr(monitors.data)
			return ImGuiPlatformMonitor(cimgui.internal.ImGuiPlatformMonitor(data + CImGui.getPlatformMonitorSize() * index, false))
		}

		private fun growCapacity(size: Int): Int {
			val newCapacity = if (capacity > 0) (capacity + capacity / 2) else 8
			return if (newCapacity > size) newCapacity else size
		}

		override fun reserve(newCapacity: Int) {
			if (newCapacity <= capacity) return
			val data = cimgui.internal.ImGuiPlatformMonitor.getCPtr(monitors.data)
			val newData = SWIGTYPE_p_void.getCPtr(CImGui.igMemAlloc(newCapacity * CImGui.getPlatformMonitorSize()))
			if (data != 0L) {
				MemoryUtil.memCopy(data, newData, size * CImGui.getPlatformMonitorSize())
				CImGui.igMemFree(SWIGTYPE_p_void(data, false))
			}
			monitors.data = cimgui.internal.ImGuiPlatformMonitor(newData, false)
			monitors.capacity = newCapacity
		}

		override fun resize(newSize: Int) {
			if (newSize > capacity) reserve(growCapacity(newSize))
			monitors.size = newSize
		}

		override fun pushBack(element: ImGuiPlatformMonitor) {
			if (size == capacity) reserve(growCapacity(size + 1))
			val data = cimgui.internal.ImGuiPlatformMonitor.getCPtr(monitors.data)
			MemoryUtil.memCopy(
				cimgui.internal.ImGuiPlatformMonitor.getCPtr(element.ptr),
				data + size * CImGui.getPlatformMonitorSize(),
				CImGui.getPlatformMonitorSize()
			)
			monitors.size += 1
		}
	}

actual val ImGuiPlatformIO.viewports: ImVector<ImGuiViewport>
	get() = object : ImVector<ImGuiViewport>() {
		private val viewports = ptr.viewports

		override val capacity get() = viewports.capacity
		override val size get() = viewports.size

		override operator fun get(index: Int): ImGuiViewport {
			return ImGuiViewport(CImGui.pImGuiViewportArray_getitem(viewports.data, index))
		}

		private fun growCapacity(size: Int): Int {
			val newCapacity = if (capacity > 0) (capacity + capacity / 2) else 8
			return if (newCapacity > size) newCapacity else size
		}

		override fun reserve(newCapacity: Int) {
			if (newCapacity <= capacity) return
			val data = SWIGTYPE_p_p_ImGuiViewport.getCPtr(viewports.data)
			val newData = SWIGTYPE_p_void.getCPtr(CImGui.igMemAlloc(newCapacity * CImGui.getPointerSize()))
			if (data != 0L) {
				MemoryUtil.memCopy(newData, data, size * CImGui.getPointerSize())
				CImGui.igMemFree(SWIGTYPE_p_void(data, false))
			}
			viewports.data = SWIGTYPE_p_p_ImGuiViewport(newData, false)
			viewports.capacity = newCapacity
		}

		override fun resize(newSize: Int) {
			if (newSize > capacity) reserve(growCapacity(newSize))
			viewports.size = newSize
		}

		override fun pushBack(element: ImGuiViewport) {
			if (size == capacity) reserve(growCapacity(size + 1))
			val data = SWIGTYPE_p_p_ImGuiViewport.getCPtr(viewports.data)
			val newData = CImGui.new_pImGuiViewportArray(1)
			CImGui.pImGuiViewportArray_setitem(newData, 0, element.ptr)
			MemoryUtil.memCopy(
				data + size * CImGui.getPointerSize(),
				SWIGTYPE_p_p_ImGuiViewport.getCPtr(newData),
				CImGui.getPointerSize()
			)
			viewports.size += 1
		}
	}

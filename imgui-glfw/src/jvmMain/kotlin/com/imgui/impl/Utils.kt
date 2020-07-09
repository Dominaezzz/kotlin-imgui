package com.imgui.impl

import cimgui.internal.*
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
	//FIXME what's the SWIG equivalent of a staticCFunction???
	//val platformIO = ImGui.getPlatformIO().ptr.pointed
	//platformIO.Platform_CreateWindow = staticCFunction { viewportPtr ->
	//	val viewport = ImGuiViewport(viewportPtr!!)
	//	val data = ImGuiGlfw.ViewportData()
	//	viewport.glfwViewportData = data
	//	data.createWindow(viewport)
	//	viewport.glfwWindow = data.window
	//}
	//platformIO.Platform_DestroyWindow = staticCFunction { viewportPtr ->
	//	val viewport = ImGuiViewport(viewportPtr!!)
	//	viewport.glfwViewportData?.destroyWindow()
	//	viewport.glfwViewportData = null
	//	viewport.glfwWindow = null
	//}
	//platformIO.Platform_ShowWindow = staticCFunction { viewport ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.showWindow()
	//}
	//platformIO.Platform_SetWindowPos = staticCFunction { viewport, pos ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.setWindowPos(pos.useContents { Vec2(x, y) })
	//}
	//platformIO.Platform_GetWindowPos = staticCFunction { viewport ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.getWindowPos().let {
	//		cValue { x = it.x; y = it.y }
	//	}
	//}
	//platformIO.Platform_SetWindowSize = staticCFunction { viewport, size ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.setWindowSize(size.useContents { Vec2(x, y) })
	//}
	//platformIO.Platform_GetWindowSize = staticCFunction { viewport ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.getWindowSize().let {
	//		cValue { x = it.x; y = it.y }
	//	}
	//}
	//platformIO.Platform_SetWindowFocus = staticCFunction { viewport ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.setWindowFocus()
	//}
	//platformIO.Platform_GetWindowFocus = staticCFunction { viewport ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.getWindowFocus()
	//}
	//platformIO.Platform_GetWindowMinimized = staticCFunction { viewport ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.getWindowMinimized()
	//}
	//platformIO.Platform_SetWindowTitle = staticCFunction { viewport, title ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.setWindowTitle(title?.toKString() ?: "")
	//}
	//platformIO.Platform_RenderWindow = staticCFunction { viewport, _ ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.renderWindow()
	//}
	//platformIO.Platform_SwapBuffers = staticCFunction { viewport, _ ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.swapBuffers()
	//}
	//platformIO.Platform_SetWindowAlpha = staticCFunction { viewport, alpha ->
	//	ImGuiViewport(viewport!!).glfwViewportData!!.setWindowAlpha(alpha)
	//}

	//val mainViewport = ImGui.getMainViewport()
	//val data = ImGuiGlfw.ViewportData()
	//data.window = mainWindow
	//data.isWindowOwned = false
	//mainViewport.glfwViewportData = data
	//mainViewport.glfwWindow = mainWindow
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
		ptr.platformHandle?.let { JNINativeInterface.DeleteGlobalRef(SWIGTYPE_p_void.getCPtr(it)) }
		ptr.platformHandle = value?.let { SWIGTYPE_p_void(JNINativeInterface.NewGlobalRef(it), false) }
	}

actual val ImGuiPlatformIO.monitors: ImVector<ImGuiPlatformMonitor>
	get() = object : ImVector<ImGuiPlatformMonitor>() {
		private val monitors = ptr.monitors

		override val capacity get() = monitors.capacity
		override val size get() = monitors.size

		override operator fun get(index: Int): ImGuiPlatformMonitor {
			val data = cimgui.internal.ImGuiPlatformMonitor.getCPtr(monitors.data)
			return ImGuiPlatformMonitor(ImGuiPlatformMonitor(data + CImGui.getPlatformMonitorSize() * index, false))
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
				MemoryUtil.memCopy(newData, data, size * CImGui.getPlatformMonitorSize())
				CImGui.igMemFree(SWIGTYPE_p_void(data, false))
			}
			monitors.data = ImGuiPlatformMonitor(newData, false)
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
				data + size * CImGui.getPlatformMonitorSize(),
				cimgui.internal.ImGuiPlatformMonitor.getCPtr(element.ptr),
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

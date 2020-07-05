package com.imgui.impl

import cglfw.*
import cimgui.internal.*
import com.imgui.*
import com.imgui.ImGuiIO
import com.imgui.ImGuiPlatformIO
import com.imgui.ImGuiPlatformMonitor
import com.imgui.ImGuiViewport
import com.kgl.glfw.*
import kotlinx.cinterop.*
import platform.posix.*

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

internal actual fun initPlatformInterface() {
	val platformIO = ImGui.getPlatformIO().ptr.pointed
	platformIO.Platform_CreateWindow = staticCFunction { viewport ->
		val data = ImGuiGlfw.ViewportData()
		viewport!!.pointed.PlatformUserData = StableRef.create(data).asCPointer()
		data.createWindow(ImGuiViewport(viewport))
		viewport.pointed.PlatformHandle = data.window.ptr
	}
	platformIO.Platform_DestroyWindow = staticCFunction { viewportPtr ->
		val viewport = ImGuiViewport(viewportPtr!!)
		viewportPtr.pointed.PlatformUserData?.asStableRef<ImGuiGlfw.ViewportData>()?.let { dataRef ->
			val data = dataRef.get()
			data.destroyWindow()
			dataRef.dispose()
		}
		viewport.glfwViewportData = null
		viewport.glfwWindow = null
	}
	platformIO.Platform_ShowWindow = staticCFunction { viewport ->
		ImGuiViewport(viewport!!).glfwViewportData!!.showWindow()
	}
	platformIO.Platform_SetWindowPos = staticCFunction { viewport, pos ->
		ImGuiViewport(viewport!!).glfwViewportData!!.setWindowPos(pos.useContents { Vec2(x, y) })
	}
	platformIO.Platform_GetWindowPos = staticCFunction { viewport ->
		ImGuiViewport(viewport!!).glfwViewportData!!.getWindowPos().let {
			cValue { x = it.x; y = it.y }
		}
	}
	platformIO.Platform_SetWindowSize = staticCFunction { viewport, size ->
		ImGuiViewport(viewport!!).glfwViewportData!!.setWindowSize(size.useContents { Vec2(x, y) })
	}
	platformIO.Platform_GetWindowSize = staticCFunction { viewport ->
		ImGuiViewport(viewport!!).glfwViewportData!!.getWindowSize().let {
			cValue { x = it.x; y = it.y }
		}
	}
	platformIO.Platform_SetWindowFocus = staticCFunction { viewport ->
		ImGuiViewport(viewport!!).glfwViewportData!!.setWindowFocus()
	}
	platformIO.Platform_GetWindowFocus = staticCFunction { viewport ->
		ImGuiViewport(viewport!!).glfwViewportData!!.getWindowFocus()
	}
	platformIO.Platform_GetWindowMinimized = staticCFunction { viewport ->
		ImGuiViewport(viewport!!).glfwViewportData!!.getWindowMinimized()
	}
	platformIO.Platform_SetWindowTitle = staticCFunction { viewport, title ->
		ImGuiViewport(viewport!!).glfwViewportData!!.setWindowTitle(title?.toKString() ?: "")
	}
	platformIO.Platform_RenderWindow = staticCFunction { viewport, _ ->
		ImGuiViewport(viewport!!).glfwViewportData!!.renderWindow()
	}
	platformIO.Platform_SwapBuffers = staticCFunction { viewport, _ ->
		ImGuiViewport(viewport!!).glfwViewportData!!.swapBuffers()
	}
	platformIO.Platform_SetWindowAlpha = staticCFunction { viewport, alpha ->
		ImGuiViewport(viewport!!).glfwViewportData!!.setWindowAlpha(alpha)
	}

	val mainViewport = ImGui.getMainViewport()
	val data = ImGuiGlfw.ViewportData()
	data.window = mainWindow
	data.isWindowOwned = false
	mainViewport.glfwViewportData = data
	mainViewport.glfwWindow = mainWindow
}

actual var ImGuiViewport.glfwWindow: Window?
	get() = glfwGetWindowUserPointer(ptr.pointed.PlatformHandle?.reinterpret())?.asStableRef<Window>()?.get()
	set(value) {
		ptr.pointed.PlatformHandle = value?.ptr
	}

actual var ImGuiViewport.glfwViewportData: ImGuiGlfw.ViewportData?
	get() = ptr.pointed.PlatformUserData?.asStableRef<ImGuiGlfw.ViewportData>()?.get()
	set(value) {
		ptr.pointed.PlatformUserData?.asStableRef<ImGuiGlfw.ViewportData>()?.dispose()
		ptr.pointed.PlatformUserData = value?.let { StableRef.create(value).asCPointer() }
	}

actual val ImGuiPlatformIO.monitors: ImVector<ImGuiPlatformMonitor>
	get() = object : ImVector<ImGuiPlatformMonitor>() {
		private val monitors = ptr.pointed.Monitors

		override val capacity get() = monitors.Capacity
		override val size get() = monitors.Size

		override operator fun get(index: Int): ImGuiPlatformMonitor {
			return ImGuiPlatformMonitor(monitors.Data!![index].ptr)
		}

		private fun growCapacity(size: Int): Int {
			val newCapacity = if (capacity > 0) (capacity + capacity / 2) else 8
			return if (newCapacity > size) newCapacity else size
		}

		override fun reserve(newCapacity: Int) {
			if (newCapacity <= capacity) return
			val newData = igMemAlloc((newCapacity * sizeOf<cimgui.internal.ImGuiPlatformMonitor>()).toULong())
				?.reinterpret<cimgui.internal.ImGuiPlatformMonitor>()
			if (monitors.Data != null) {
				memcpy(newData, monitors.Data, (monitors.Size * sizeOf<cimgui.internal.ImGuiPlatformMonitor>()).toULong())
				igMemFree(monitors.Data)
			}
			monitors.Data = newData
			monitors.Capacity = newCapacity
		}

		override fun resize(newSize: Int) {
			if (newSize > capacity) reserve(growCapacity(newSize))
			monitors.Size = newSize
		}

		override fun pushBack(element: ImGuiPlatformMonitor) {
			if (monitors.Size == monitors.Capacity) reserve(growCapacity(monitors.Size + 1))
			memcpy(monitors.Data!![monitors.Size].ptr, element.ptr, sizeOf<cimgui.internal.ImGuiPlatformMonitor>().toULong())
			monitors.Size += 1
		}
	}

actual val ImGuiPlatformIO.viewports: ImVector<ImGuiViewport>
	get() = object : ImVector<ImGuiViewport>() {
		private val viewports = ptr.pointed.Viewports

		override val capacity get() = viewports.Capacity
		override val size get() = viewports.Size

		override operator fun get(index: Int): ImGuiViewport {
			return ImGuiViewport(viewports.Data!![index]!!)
		}

		private fun growCapacity(size: Int): Int {
			val newCapacity = if (capacity > 0) (capacity + capacity / 2) else 8
			return if (newCapacity > size) newCapacity else size
		}

		override fun reserve(newCapacity: Int) {
			if (newCapacity <= capacity) return
			val newData = igMemAlloc((newCapacity * sizeOf<CPointerVar<cimgui.internal.ImGuiViewport>>()).toULong())
				?.reinterpret<CPointerVar<cimgui.internal.ImGuiViewport>>()
			if (viewports.Data != null) {
				memcpy(newData, viewports.Data, (viewports.Size * sizeOf<CPointerVar<cimgui.internal.ImGuiViewport>>()).toULong())
				igMemFree(viewports.Data)
			}
			viewports.Data = newData
			viewports.Capacity = newCapacity
		}

		override fun resize(newSize: Int) {
			if (newSize > capacity) reserve(growCapacity(newSize))
			viewports.Size = newSize
		}

		override fun pushBack(element: ImGuiViewport) {
			if (viewports.Size == viewports.Capacity) reserve(growCapacity(viewports.Size + 1))
			memcpy(viewports.Data!![viewports.Size]!!, element.ptr, sizeOf<CPointerVar<cimgui.internal.ImGuiViewport>>().toULong())
			viewports.Size += 1
		}
	}

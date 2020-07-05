package com.imgui.impl

import com.imgui.*
import com.kgl.glfw.*

expect val isMacOS: Boolean
expect val isWin32: Boolean

expect fun setupClipboard(ioObj: ImGuiIO, window: Window)

expect fun freeClipboard(ioObj: ImGuiIO)

expect var ImGuiViewport.glfwWindow: Window?
expect var ImGuiViewport.glfwViewportData: ImGuiGlfw.ViewportData?

abstract class ImVector<T> : Iterable<T> {
	abstract val capacity: Int
	abstract val size: Int

	abstract operator fun get(index: Int): T

	abstract fun reserve(newCapacity: Int)
	abstract fun resize(newSize: Int)
	abstract fun pushBack(element: T)

	override operator fun iterator(): Iterator<T> = IteratorImpl()

	private open inner class IteratorImpl : Iterator<T> {
		/** the index of the item that will be returned on the next call to [next]`()` */
		protected var index = 0

		override fun hasNext(): Boolean = index < size

		override fun next(): T {
			if (!hasNext()) throw NoSuchElementException()
			return get(index++)
		}
	}
}

expect val ImGuiPlatformIO.monitors: ImVector<ImGuiPlatformMonitor>
expect val ImGuiPlatformIO.viewports: ImVector<ImGuiViewport>

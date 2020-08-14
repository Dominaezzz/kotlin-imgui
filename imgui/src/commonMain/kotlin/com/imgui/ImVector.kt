package com.imgui

abstract class ImVector<T> : AbstractList<T>() {
	abstract val capacity: Int
	abstract override val size: Int

	abstract override operator fun get(index: Int): T

	protected fun growCapacity(size: Int): Int {
		val newCapacity = if (capacity > 0) (capacity + capacity / 2) else 8
		return if (newCapacity > size) newCapacity else size
	}

	abstract fun reserve(newCapacity: Int)
	abstract fun resize(newSize: Int)
	abstract fun pushBack(element: T)
}

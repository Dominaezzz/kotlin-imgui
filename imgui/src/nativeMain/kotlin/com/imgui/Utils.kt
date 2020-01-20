package com.imgui

import cimgui.internal.ImVec2
import cimgui.internal.ImVec4
import kotlinx.cinterop.*
import platform.posix.size_tVar
import kotlin.native.concurrent.ThreadLocal
import kotlin.reflect.KMutableProperty0

@ThreadLocal
internal object ImGuiTemps {
	val blob = LongArray(6)
	var offset = 0
}

internal inline fun <reified Var : CPrimitiveVar, T> usingVar(block: (Var) -> T): T {
	check(sizeOf<Var>() <= sizeOf<LongVar>())

	return ImGuiTemps.blob.usePinned {
		val value = it.addressOf(ImGuiTemps.offset).reinterpret<Var>()
		ImGuiTemps.offset++
		try {
			block(value.pointed)
		} finally {
			ImGuiTemps.offset--
		}
	}
}

internal inline fun <T> usingVec2(block: (ImVec2) -> T): T {
	check(sizeOf<ImVec2>() == sizeOf<LongVar>()) // The same size as Long.

	return ImGuiTemps.blob.usePinned {
		val value = it.addressOf(ImGuiTemps.offset).reinterpret<ImVec2>()
		ImGuiTemps.offset++
		try {
			block(value.pointed)
		} finally {
			ImGuiTemps.offset--
		}
	}
}

internal inline fun <T> usingVec4(block: (ImVec4) -> T): T {
	check(sizeOf<ImVec2>() == sizeOf<LongVar>() * 2) // The same size as 2 Longs.

	return ImGuiTemps.blob.usePinned {
		val value = it.addressOf(ImGuiTemps.offset).reinterpret<ImVec4>()
		ImGuiTemps.offset += 2
		try {
			block(value.pointed)
		} finally {
			ImGuiTemps.offset -= 2
		}
	}
}

internal inline fun <T, TProp, reified TVar : CPrimitiveVar> usingGeneralProperty(
		prop: KMutableProperty0<TProp>,
		getValue: (TVar) -> TProp,
		setValue: (TVar, TProp) -> Unit,
		block: (CPointer<TVar>) -> T
): T {
	return usingVar<TVar, T> { nativeValue ->
		val propValue = prop.get()
		setValue(nativeValue, propValue)
		try {
			block(nativeValue.ptr)
		} finally {
			val newValue = getValue(nativeValue)
			if (propValue != newValue) prop.set(newValue)
		}
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<Boolean>, block: (CPointer<BooleanVar>) -> T): T {
	return usingGeneralProperty(prop, { it.value }, { ptr, value -> ptr.value = value }, block)
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Boolean>?, block: (CPointer<BooleanVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<UInt>, block: (CPointer<UIntVar>) -> T): T {
	return usingGeneralProperty(prop, { it.value }, { ptr, value -> ptr.value = value }, block)
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<UInt>?, block: (CPointer<UIntVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<Int>, block: (CPointer<IntVar>) -> T): T {
	return usingGeneralProperty(prop, { it.value }, { ptr, value -> ptr.value = value }, block)
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Int>?, block: (CPointer<IntVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<ULong>, block: (CPointer<size_tVar>) -> T): T {
	return usingGeneralProperty(prop, { it.value.convert() }, { ptr, value -> ptr.value = value.convert() }, block)
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<ULong>?, block: (CPointer<size_tVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<Float>, block: (CPointer<FloatVar>) -> T): T {
	return usingGeneralProperty(prop, { it.value }, { ptr, value -> ptr.value = value }, block)
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Float>?, block: (CPointer<FloatVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<Double>, block: (CPointer<DoubleVar>) -> T): T {
	return usingGeneralProperty(prop, { it.value }, { ptr, value -> ptr.value = value }, block)
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Double>?, block: (CPointer<DoubleVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}


internal fun Vec2.toCValue() = cValue<ImVec2> {
	val vec = this@toCValue
	x = vec.x
	y = vec.y
}

internal fun Vec4.toCValue() = cValue<ImVec4> {
	val vec = this@toCValue
	x = vec.x
	y = vec.y
	z = vec.z
	w = vec.w
}

internal fun CValue<ImVec2>.fromCValue(): Vec2 {
	return usingVec2 {
		place(it.ptr)
		it.fromCValue()
	}
}

internal fun CValue<ImVec4>.fromCValue(): Vec4 {
	return usingVec4 {
		place(it.ptr)
		it.fromCValue()
	}
}

internal fun ImVec2.fromCValue(): Vec2 {
	return Vec2(x, y)
}

internal fun ImVec4.fromCValue(): Vec4 {
	return Vec4(x, y, z, w)
}

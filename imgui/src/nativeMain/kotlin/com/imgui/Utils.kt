package com.imgui

import cimgui.internal.ImVec2
import cimgui.internal.ImVec4
import kotlinx.cinterop.*
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

internal inline fun <T> usingProperty(prop: KMutableProperty0<Boolean>, block: (CPointer<BooleanVar>) -> T): T {
	return usingVar<BooleanVar, T> { nativeValue ->
		val propValue = prop.get()
		nativeValue.value = propValue
		try {
			block(nativeValue.ptr)
		} finally {
			if (propValue != nativeValue.value) prop.set(nativeValue.value)
		}
	}
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Boolean>?, block: (CPointer<BooleanVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<Int>, block: (CPointer<IntVar>) -> T): T {
	return usingVar<IntVar, T> { nativeValue ->
		val propValue = prop.get()
		nativeValue.value = propValue
		try {
			block(nativeValue.ptr)
		} finally {
			if (propValue != nativeValue.value) prop.set(nativeValue.value)
		}
	}
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Int>?, block: (CPointer<IntVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<ULong>, block: (CPointer<ULongVar>) -> T): T {
	return usingVar<ULongVar, T> { nativeValue ->
		val propValue = prop.get()
		nativeValue.value = propValue
		try {
			block(nativeValue.ptr)
		} finally {
			if (propValue != nativeValue.value) prop.set(nativeValue.value)
		}
	}
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<ULong>?, block: (CPointer<ULongVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<Float>, block: (CPointer<FloatVar>) -> T): T {
	return usingVar<FloatVar, T> { nativeValue ->
		val propValue = prop.get()
		nativeValue.value = propValue
		try {
			block(nativeValue.ptr)
		} finally {
			if (propValue != nativeValue.value) prop.set(nativeValue.value)
		}
	}
}

internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Float>?, block: (CPointer<FloatVar>?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> usingProperty(prop: KMutableProperty0<Double>, block: (CPointer<DoubleVar>) -> T): T {
	return usingVar<DoubleVar, T> { nativeValue ->
		val propValue = prop.get()
		nativeValue.value = propValue
		try {
			block(nativeValue.ptr)
		} finally {
			if (propValue != nativeValue.value) prop.set(nativeValue.value)
		}
	}
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
		Vec2(it.x, it.y)
	}
}

internal fun CValue<ImVec4>.fromCValue(): Vec4 {
	return usingVec4 {
		place(it.ptr)
		Vec4(it.x, it.y, it.z, it.w)
	}
}

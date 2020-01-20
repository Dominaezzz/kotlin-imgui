package com.imgui

import cimgui.internal.*
import cimgui.internal.ImVec2
import cimgui.internal.ImVec4
import java.io.File
import java.util.*
import kotlin.reflect.KMutableProperty0
import kotlin.jvm.JvmName

// Use this for temp values.
internal object ImGuiTemps {
	val imVec2Stack: Stack<ImVec2> = Stack()
	val imVec4Stack: Stack<ImVec4> = Stack()
}

internal fun loadCImGuiNativeLibs() {
	val osName = System.getProperty("os.name")
	val osArch = System.getProperty("os.arch")

	val simpleOsName: String
	val extName: String
	when {
		osName == "Mac OS X" -> {
			simpleOsName = "osx"
			extName = "dylib"
		}
		osName == "Linux" -> {
			simpleOsName = "linux"
			extName = "so"
		}
		osName.startsWith("Windows") -> {
			simpleOsName = "windows"
			extName = "dll"
		}
		else -> TODO("OS '$osName' not support by cimgui")
	}
	val simpleOsArch = when (osArch) {
		"amd64" -> "x64"
		else -> osArch
	}

	val tempFile = File.createTempFile("libcimgui", ".$extName")
	tempFile.deleteOnExit()

	val libraryPath = "$simpleOsName/$simpleOsArch/libcimgui.$extName"

	val loader = ClassLoader.getSystemClassLoader()
	val stream = checkNotNull(loader.getResourceAsStream(libraryPath)) {
		"Could not find native library for cimgui"
	}

	stream.use { binary ->
		tempFile.outputStream().use { file ->
			binary.copyTo(file)
		}
	}

	System.load(tempFile.absolutePath)
}

internal inline fun <TReturn, TProp, TNative> usingGeneralProperty(
		prop: KMutableProperty0<TProp>,
		newP: () -> TNative,
		deleteP: (TNative) -> Unit,
		getP: (TNative) -> TProp,
		setP: (TNative, TProp) -> Unit,
		block: (TNative) -> TReturn
): TReturn {
	val ptr = newP()
	return try {
		val propValue = prop.get()
		setP(ptr, propValue)
		try {
			block(ptr)
		} finally {
			val newValue = getP(ptr)
			if (propValue != newValue) prop.set(newValue)
		}
	} finally {
		// This is in a separate `finally` in case user's property setter/getter throws.
		deleteP(ptr)
	}
}

@JvmName("usingBoolProperty")
internal inline fun <T> usingProperty(prop: KMutableProperty0<Boolean>, block: (SWIGTYPE_p_bool) -> T): T {
	return usingGeneralProperty(prop, CImGui::new_boolp, CImGui::delete_boolp, CImGui::boolp_value, CImGui::boolp_assign, block)
}

@JvmName("usingBoolPropertyN")
internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Boolean>?, block: (SWIGTYPE_p_bool?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

@JvmName("usingUIntProperty")
internal inline fun <T> usingProperty(prop: KMutableProperty0<UInt>, block: (SWIGTYPE_p_unsigned_int) -> T): T {
	return usingGeneralProperty(
			prop,
			CImGui::new_uintp,
			CImGui::delete_uintp,
			{ ptr -> CImGui.uintp_value(ptr).toUInt() },
			{ ptr, value -> CImGui.uintp_assign(ptr, value.toLong()) },
			block
	)
}

@JvmName("usingUIntPropertyN")
internal inline fun <T> usingPropertyN(prop: KMutableProperty0<UInt>?, block: (SWIGTYPE_p_unsigned_int?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

@JvmName("usingIntProperty")
internal inline fun <T> usingProperty(prop: KMutableProperty0<Int>, block: (SWIGTYPE_p_int) -> T): T {
	return usingGeneralProperty(prop, CImGui::new_intp, CImGui::delete_intp, CImGui::intp_value, CImGui::intp_assign, block)
}

@JvmName("usingIntPropertyN")
internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Int>?, block: (SWIGTYPE_p_int?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

@JvmName("usingULongProperty")
internal inline fun <T> usingProperty(prop: KMutableProperty0<ULong>, block: (SWIGTYPE_p_size_t) -> T): T {
	return usingGeneralProperty(
			prop,
			CImGui::new_size_tp,
			CImGui::delete_size_tp,
			{ ptr -> CImGui.size_tp_value(ptr).toULong() },
			{ ptr, value -> CImGui.size_tp_assign(ptr, value.toLong()) },
			block
	)
}

@JvmName("usingULongPropertyN")
internal inline fun <T> usingPropertyN(prop: KMutableProperty0<ULong>?, block: (SWIGTYPE_p_size_t?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

@JvmName("usingFloatProperty")
internal inline fun <T> usingProperty(prop: KMutableProperty0<Float>, block: (SWIGTYPE_p_float) -> T): T {
	return usingGeneralProperty(prop, CImGui::new_floatp, CImGui::delete_floatp, CImGui::floatp_value, CImGui::floatp_assign, block)
}

@JvmName("usingFloatPropertyN")
internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Float>?, block: (SWIGTYPE_p_float?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

@JvmName("usingDoubleProperty")
internal inline fun <T> usingProperty(prop: KMutableProperty0<Double>, block: (SWIGTYPE_p_double) -> T): T {
	return usingGeneralProperty(prop, CImGui::new_doublep, CImGui::delete_doublep, CImGui::doublep_value, CImGui::doublep_assign, block)
}

@JvmName("usingDoublePropertyN")
internal inline fun <T> usingPropertyN(prop: KMutableProperty0<Double>?, block: (SWIGTYPE_p_double?) -> T): T {
	return if (prop != null) {
		usingProperty(prop, block)
	} else {
		block(null)
	}
}

internal inline fun <T> IntArray.nativeCopy(block: (SWIGTYPE_p_int) -> T): T {
	val native = CImGui.new_intArray(size)
	return try {
		forEachIndexed { index, value -> CImGui.intArray_setitem(native, index, value) }
		block(native)
	} finally {
		CImGui.delete_intArray(native)
	}
}

internal inline fun <T> FloatArray.nativeCopy(block: (SWIGTYPE_p_float) -> T): T {
	val native = CImGui.new_floatArray(size)
	return try {
		forEachIndexed { index, value -> CImGui.floatArray_setitem(native, index, value) }
		block(native)
	} finally {
		CImGui.delete_floatArray(native)
	}
}


internal inline fun <T> usingVec4(block: (ImVec4) -> T): T {
	val temp = ImGuiTemps.imVec4Stack.let {
		if (it.isEmpty()) ImVec4() else it.pop()
	}
	return try {
		block(temp)
	} finally {
		ImGuiTemps.imVec4Stack.push(temp)
	}
}

internal inline fun <T> usingVec2(block: (ImVec2) -> T): T {
	val temp = ImGuiTemps.imVec2Stack.let {
		if (it.isEmpty()) ImVec2() else it.pop()
	}
	return try {
		block(temp)
	} finally {
		ImGuiTemps.imVec2Stack.push(temp)
	}
}

internal inline fun <T> usingVec4(init: Vec4, block: (ImVec4) -> T): T {
	return usingVec4 {
		it.x = init.x
		it.y = init.y
		it.z = init.z
		it.w = init.w
		block(it)
	}
}

internal inline fun <T> usingVec2(init: Vec2, block: (ImVec2) -> T): T {
	return usingVec2 {
		it.x = init.x
		it.y = init.y
		block(it)
	}
}

internal inline fun returnVec4(block: (ImVec4) -> Unit): Vec4 {
	return usingVec4 {
		block(it)
		Vec4(it.x, it.y, it.z, it.w)
	}
}

internal inline fun returnVec2(block: (ImVec2) -> Unit): Vec2 {
	return usingVec2 {
		block(it)
		Vec2(it.x, it.y)
	}
}


internal fun ImVec2.fromCValue(): Vec2 {
	return Vec2(x, y)
}

internal fun ImVec4.fromCValue(): Vec4 {
	return Vec4(x, y, z, w)
}


internal fun SWIGTYPE_p_unsigned_short.toUTF16String(): String {
	var length = 0
	while (CImGui.ushortArray_getitem(this, length) != 0) {
		length++
	}

	val charBuf = CharArray(length) { CImGui.ushortArray_getitem(this, it).toChar() }
	return String(charBuf)
}

internal fun <T> String?.usingUTF16String(block: (SWIGTYPE_p_unsigned_short?) -> T): T {
	return if (this != null) {
		val nativeStr = CImGui.new_ushortArray(length + 1)
		try {
			forEachIndexed { index, c -> CImGui.ushortArray_setitem(nativeStr, index, c.toInt()) }
			CImGui.ushortArray_setitem(nativeStr, length, 0) // Null terminator.
			block(nativeStr)
		} finally {
			CImGui.delete_ushortArray(nativeStr)
		}
	} else {
		block(null)
	}
}

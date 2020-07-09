package com.imgui

import cimgui.internal.*
import kotlinx.cinterop.*
import kotlin.reflect.*


actual fun <T> ImGui.checkboxFlags(
	label: String,
	flags: KMutableProperty0<Flag<T>?>,
	flagsValue: Flag<T>
): Boolean where T : Enum<T>, T : Flag<T> {
	return usingGeneralProperty<Boolean, Flag<T>?, UIntVar>(
		flags,
		{ Flag.invoke(it.value.toInt(), flagsValue.info) },
		{ ptr, value -> ptr.value = (value?.value ?: 0).toUInt() }
	) {
		igCheckboxFlags(label, it, flagsValue.value.toUInt())
	}
}

package com.imgui

import cimgui.internal.*
import kotlin.reflect.*


actual fun <T> ImGui.checkboxFlags(
	label: String,
	flags: KMutableProperty0<Flag<T>?>,
	flagsValue: Flag<T>
): Boolean where T : Enum<T>, T : Flag<T> {
	return usingGeneralProperty<Boolean, Flag<T>?, SWIGTYPE_p_unsigned_int>(
		flags,
		CImGui::new_uintp,
		CImGui::delete_uintp,
		{ Flag.invoke(CImGui.uintp_value(it).toInt(), flagsValue.info) },
		{ ptr, value -> CImGui.uintp_assign(ptr, (value?.value ?: 0).toLong()) }
	) {
		CImGui.igCheckboxFlags(label, it, flagsValue.value.toLong())
	}
}

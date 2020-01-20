package com.imgui

import cimgui.internal.CImGui.ImGuiStorage_BuildSortByKey
import cimgui.internal.CImGui.ImGuiStorage_Clear
import cimgui.internal.CImGui.ImGuiStorage_GetBool
import cimgui.internal.CImGui.ImGuiStorage_GetFloat
import cimgui.internal.CImGui.ImGuiStorage_GetInt
import cimgui.internal.CImGui.ImGuiStorage_SetAllInt
import cimgui.internal.CImGui.ImGuiStorage_SetBool
import cimgui.internal.CImGui.ImGuiStorage_SetFloat
import cimgui.internal.CImGui.ImGuiStorage_SetInt
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiStorage(
  val ptr: cimgui.internal.ImGuiStorage
) {
  actual fun buildSortByKey() {
    ImGuiStorage_BuildSortByKey(ptr)
  }

  actual fun clear() {
    ImGuiStorage_Clear(ptr)
  }

  actual fun getBool(key: ImGuiID, defaultVal: Boolean): Boolean = ImGuiStorage_GetBool(ptr,
      key.value, defaultVal)

  actual fun getFloat(key: ImGuiID, defaultVal: Float): Float = ImGuiStorage_GetFloat(ptr,
      key.value, defaultVal)

  actual fun getInt(key: ImGuiID, defaultVal: Int): Int = ImGuiStorage_GetInt(ptr, key.value,
      defaultVal)

  actual fun setAllInt(`val`: Int) {
    ImGuiStorage_SetAllInt(ptr, `val`)
  }

  actual fun setBool(key: ImGuiID, `val`: Boolean) {
    ImGuiStorage_SetBool(ptr, key.value, `val`)
  }

  actual fun setFloat(key: ImGuiID, `val`: Float) {
    ImGuiStorage_SetFloat(ptr, key.value, `val`)
  }

  actual fun setInt(key: ImGuiID, `val`: Int) {
    ImGuiStorage_SetInt(ptr, key.value, `val`)
  }
}

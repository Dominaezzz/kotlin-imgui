package com.imgui

import cimgui.internal.ImGuiStorage_BuildSortByKey
import cimgui.internal.ImGuiStorage_Clear
import cimgui.internal.ImGuiStorage_GetBool
import cimgui.internal.ImGuiStorage_GetFloat
import cimgui.internal.ImGuiStorage_GetInt
import cimgui.internal.ImGuiStorage_SetAllInt
import cimgui.internal.ImGuiStorage_SetBool
import cimgui.internal.ImGuiStorage_SetFloat
import cimgui.internal.ImGuiStorage_SetInt
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlinx.cinterop.CPointer

inline class ImGuiStorage(
  val ptr: CPointer<cimgui.internal.ImGuiStorage>
) {
  fun buildSortByKey() {
    ImGuiStorage_BuildSortByKey(ptr)
  }

  fun clear() {
    ImGuiStorage_Clear(ptr)
  }

  fun getBool(key: ImGuiID, defaultVal: Boolean = false): Boolean = ImGuiStorage_GetBool(ptr,
      key.value, defaultVal)

  fun getFloat(key: ImGuiID, defaultVal: Float = 0.0f): Float = ImGuiStorage_GetFloat(ptr,
      key.value, defaultVal)

  fun getInt(key: ImGuiID, defaultVal: Int = 0): Int = ImGuiStorage_GetInt(ptr, key.value,
      defaultVal)

  fun setAllInt(`val`: Int) {
    ImGuiStorage_SetAllInt(ptr, `val`)
  }

  fun setBool(key: ImGuiID, `val`: Boolean) {
    ImGuiStorage_SetBool(ptr, key.value, `val`)
  }

  fun setFloat(key: ImGuiID, `val`: Float) {
    ImGuiStorage_SetFloat(ptr, key.value, `val`)
  }

  fun setInt(key: ImGuiID, `val`: Int) {
    ImGuiStorage_SetInt(ptr, key.value, `val`)
  }
}

package com.imgui

import cimgui.internal.CImGui.ImDrawDataBuilder_Clear
import cimgui.internal.CImGui.ImDrawDataBuilder_ClearFreeMemory
import cimgui.internal.CImGui.ImDrawDataBuilder_FlattenIntoSingleLayer
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawDataBuilder(
  val ptr: cimgui.internal.ImDrawDataBuilder
) {
  actual fun clear() {
    ImDrawDataBuilder_Clear(ptr)
  }

  actual fun clearFreeMemory() {
    ImDrawDataBuilder_ClearFreeMemory(ptr)
  }

  actual fun flattenIntoSingleLayer() {
    ImDrawDataBuilder_FlattenIntoSingleLayer(ptr)
  }
}

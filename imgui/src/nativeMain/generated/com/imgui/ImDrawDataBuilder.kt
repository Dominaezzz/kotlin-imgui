package com.imgui

import cimgui.internal.ImDrawDataBuilder_Clear
import cimgui.internal.ImDrawDataBuilder_ClearFreeMemory
import cimgui.internal.ImDrawDataBuilder_FlattenIntoSingleLayer
import kotlin.Suppress
import kotlinx.cinterop.CPointer

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawDataBuilder(
  val ptr: CPointer<cimgui.internal.ImDrawDataBuilder>
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

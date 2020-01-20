package com.imgui

import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiSizeCallbackData(
  val ptr: CPointer<cimgui.internal.ImGuiSizeCallbackData>
) {
  actual val pos: Vec2
    get() = ptr.pointed.Pos.fromCValue()

  actual val currentSize: Vec2
    get() = ptr.pointed.CurrentSize.fromCValue()

  actual val desiredSize: Vec2
    get() = ptr.pointed.DesiredSize.fromCValue()
}

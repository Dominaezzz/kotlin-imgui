package com.imgui

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiSizeCallbackData(
  val ptr: CPointer<cimgui.internal.ImGuiSizeCallbackData>
) {
  val pos: Vec2
    get() = ptr.pointed.Pos.fromCValue()

  val currentSize: Vec2
    get() = ptr.pointed.CurrentSize.fromCValue()

  val desiredSize: Vec2
    get() = ptr.pointed.DesiredSize.fromCValue()
}

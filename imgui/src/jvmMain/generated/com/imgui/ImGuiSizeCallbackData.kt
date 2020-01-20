package com.imgui

import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiSizeCallbackData(
  val ptr: cimgui.internal.ImGuiSizeCallbackData
) {
  actual val pos: Vec2
    get() = ptr.pos.fromCValue()

  actual val currentSize: Vec2
    get() = ptr.currentSize.fromCValue()

  actual val desiredSize: Vec2
    get() = ptr.desiredSize.fromCValue()
}

package com.imgui

import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiShrinkWidthItem(
  val ptr: cimgui.internal.ImGuiShrinkWidthItem
) {
  actual val index: Int
    get() = ptr.index

  actual val width: Float
    get() = ptr.width
}

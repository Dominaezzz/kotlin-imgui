package com.imgui

import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiShrinkWidthItem(
  val ptr: CPointer<cimgui.internal.ImGuiShrinkWidthItem>
) {
  actual val index: Int
    get() = ptr.pointed.Index

  actual val width: Float
    get() = ptr.pointed.Width
}

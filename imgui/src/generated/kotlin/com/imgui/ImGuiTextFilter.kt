package com.imgui

import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiTextFilter(
  val ptr: CPointer<cimgui.internal.ImGuiTextFilter>
) {
  val countGrep: Int
    get() = ptr.pointed.CountGrep
}

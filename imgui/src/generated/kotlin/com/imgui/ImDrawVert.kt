package com.imgui

import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawVert(
  val ptr: CPointer<cimgui.internal.ImDrawVert>
) {
  val col: UInt
    get() = ptr.pointed.col
}

package com.imgui

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImColor(
  val ptr: CPointer<cimgui.internal.ImColor>
) {
  val value: Vec4
    get() = ptr.pointed.Value.fromCValue()
}

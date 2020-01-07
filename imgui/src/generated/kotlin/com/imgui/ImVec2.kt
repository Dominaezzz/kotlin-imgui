package com.imgui

import kotlin.Float
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImVec2(
  val ptr: CPointer<cimgui.internal.ImVec2>
) {
  val x: Float
    get() = ptr.pointed.x

  val y: Float
    get() = ptr.pointed.y
}

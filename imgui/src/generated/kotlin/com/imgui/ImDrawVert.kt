package com.imgui

import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawVert(
  val ptr: CPointer<cimgui.internal.ImDrawVert>
) {
  val pos: Vec2
    get() = ptr.pointed.pos.fromCValue()

  val uv: Vec2
    get() = ptr.pointed.uv.fromCValue()

  val col: UInt
    get() = ptr.pointed.col
}

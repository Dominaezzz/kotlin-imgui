package com.imgui

import kotlin.Suppress
import kotlin.UInt

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawVert(
  val ptr: cimgui.internal.ImDrawVert
) {
  actual val pos: Vec2
    get() = ptr.pos.fromCValue()

  actual val uv: Vec2
    get() = ptr.uv.fromCValue()

  actual val col: UInt
    get() = ptr.col.toUInt()
}

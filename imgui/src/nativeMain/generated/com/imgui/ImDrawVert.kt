package com.imgui

import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawVert(
  val ptr: CPointer<cimgui.internal.ImDrawVert>
) {
  actual val pos: Vec2
    get() = ptr.pointed.pos.fromCValue()

  actual val uv: Vec2
    get() = ptr.pointed.uv.fromCValue()

  actual val col: UInt
    get() = ptr.pointed.col.toUInt()
}

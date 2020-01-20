package com.imgui

import kotlin.Char
import kotlin.Float
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontGlyph(
  val ptr: cimgui.internal.ImFontGlyph
) {
  actual val codepoint: Char
    get() = ptr.codepoint.toShort().toChar()

  actual val advanceX: Float
    get() = ptr.advanceX

  actual val x0: Float
    get() = ptr.x0

  actual val y0: Float
    get() = ptr.y0

  actual val x1: Float
    get() = ptr.x1

  actual val y1: Float
    get() = ptr.y1

  actual val u0: Float
    get() = ptr.u0

  actual val v0: Float
    get() = ptr.v0

  actual val u1: Float
    get() = ptr.u1

  actual val v1: Float
    get() = ptr.v1
}

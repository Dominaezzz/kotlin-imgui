package com.imgui

import kotlin.Char
import kotlin.Float
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImFontGlyph(
  val ptr: CPointer<cimgui.internal.ImFontGlyph>
) {
  val codepoint: Char
    get() = ptr.pointed.Codepoint.toShort().toChar()

  val advanceX: Float
    get() = ptr.pointed.AdvanceX

  val x0: Float
    get() = ptr.pointed.X0

  val y0: Float
    get() = ptr.pointed.Y0

  val x1: Float
    get() = ptr.pointed.X1

  val y1: Float
    get() = ptr.pointed.Y1

  val u0: Float
    get() = ptr.pointed.U0

  val v0: Float
    get() = ptr.pointed.V0

  val u1: Float
    get() = ptr.pointed.U1

  val v1: Float
    get() = ptr.pointed.V1
}

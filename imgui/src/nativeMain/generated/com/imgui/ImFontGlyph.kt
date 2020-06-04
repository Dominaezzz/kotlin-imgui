package com.imgui

import kotlin.Float
import kotlin.Suppress
import kotlin.UInt
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontGlyph(
  val ptr: CPointer<cimgui.internal.ImFontGlyph>
) {
  actual val codepoint: UInt
    get() = ptr.pointed.Codepoint.toUInt()

  actual val visible: UInt
    get() = ptr.pointed.Visible.toUInt()

  actual val advanceX: Float
    get() = ptr.pointed.AdvanceX

  actual val x0: Float
    get() = ptr.pointed.X0

  actual val y0: Float
    get() = ptr.pointed.Y0

  actual val x1: Float
    get() = ptr.pointed.X1

  actual val y1: Float
    get() = ptr.pointed.Y1

  actual val u0: Float
    get() = ptr.pointed.U0

  actual val v0: Float
    get() = ptr.pointed.V0

  actual val u1: Float
    get() = ptr.pointed.U1

  actual val v1: Float
    get() = ptr.pointed.V1
}

package com.imgui

import kotlin.Float
import kotlin.UInt
import kotlin.UShort
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImFontAtlasCustomRect(
  val ptr: CPointer<cimgui.internal.ImFontAtlasCustomRect>
) {
  val iD: UInt
    get() = ptr.pointed.ID

  val width: UShort
    get() = ptr.pointed.Width

  val height: UShort
    get() = ptr.pointed.Height

  val x: UShort
    get() = ptr.pointed.X

  val y: UShort
    get() = ptr.pointed.Y

  val glyphAdvanceX: Float
    get() = ptr.pointed.GlyphAdvanceX
}

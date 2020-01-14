package com.imgui

import cimgui.internal.ImFontAtlasCustomRect_ImFontAtlasCustomRect
import cimgui.internal.ImFontAtlasCustomRect_IsPacked
import cimgui.internal.ImFontAtlasCustomRect_destroy
import kotlin.Boolean
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

  val glyphOffset: Vec2
    get() = ptr.pointed.GlyphOffset.fromCValue()

  val font: ImFont?
    get() = ptr.pointed.Font?.let(::ImFont)

  constructor() : this(ImFontAtlasCustomRect_ImFontAtlasCustomRect()!!)

  fun isPacked(): Boolean = ImFontAtlasCustomRect_IsPacked(ptr)

  fun destroy() {
    ImFontAtlasCustomRect_destroy(ptr)
  }
}

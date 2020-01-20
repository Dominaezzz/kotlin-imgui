package com.imgui

import cimgui.internal.ImFontAtlasCustomRect_ImFontAtlasCustomRect
import cimgui.internal.ImFontAtlasCustomRect_IsPacked
import cimgui.internal.ImFontAtlasCustomRect_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.UInt
import kotlin.UShort
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontAtlasCustomRect(
  val ptr: CPointer<cimgui.internal.ImFontAtlasCustomRect>
) {
  actual val id: UInt
    get() = ptr.pointed.ID.toUInt()

  actual val width: UShort
    get() = ptr.pointed.Width.toUShort()

  actual val height: UShort
    get() = ptr.pointed.Height.toUShort()

  actual val x: UShort
    get() = ptr.pointed.X.toUShort()

  actual val y: UShort
    get() = ptr.pointed.Y.toUShort()

  actual val glyphAdvanceX: Float
    get() = ptr.pointed.GlyphAdvanceX

  actual val glyphOffset: Vec2
    get() = ptr.pointed.GlyphOffset.fromCValue()

  actual val font: ImFont?
    get() = ptr.pointed.Font?.let(::ImFont)

  actual constructor() : this(ImFontAtlasCustomRect_ImFontAtlasCustomRect()!!)

  actual fun isPacked(): Boolean = ImFontAtlasCustomRect_IsPacked(ptr)

  actual fun destroy() {
    ImFontAtlasCustomRect_destroy(ptr)
  }
}

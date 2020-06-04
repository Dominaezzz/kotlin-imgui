package com.imgui

import cimgui.internal.ImFontGlyphRangesBuilder_AddChar
import cimgui.internal.ImFontGlyphRangesBuilder_AddRanges
import cimgui.internal.ImFontGlyphRangesBuilder_AddText
import cimgui.internal.ImFontGlyphRangesBuilder_Clear
import cimgui.internal.ImFontGlyphRangesBuilder_GetBit
import cimgui.internal.ImFontGlyphRangesBuilder_ImFontGlyphRangesBuilder
import cimgui.internal.ImFontGlyphRangesBuilder_SetBit
import cimgui.internal.ImFontGlyphRangesBuilder_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.String
import kotlin.Suppress
import kotlin.ULong
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.convert
import kotlinx.cinterop.wcstr

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontGlyphRangesBuilder(
  val ptr: CPointer<cimgui.internal.ImFontGlyphRangesBuilder>
) {
  actual constructor() : this(ImFontGlyphRangesBuilder_ImFontGlyphRangesBuilder()!!)

  actual fun addChar(c: Char) {
    ImFontGlyphRangesBuilder_AddChar(ptr, c.toShort().toUShort())
  }

  actual fun addRanges(ranges: String) {
    ImFontGlyphRangesBuilder_AddRanges(ptr, ranges.wcstr)
  }

  actual fun addText(text: String, textEnd: String?) {
    ImFontGlyphRangesBuilder_AddText(ptr, text, textEnd)
  }

  actual fun clear() {
    ImFontGlyphRangesBuilder_Clear(ptr)
  }

  actual fun getBit(n: ULong): Boolean = ImFontGlyphRangesBuilder_GetBit(ptr, n.convert())

  actual fun setBit(n: ULong) {
    ImFontGlyphRangesBuilder_SetBit(ptr, n.convert())
  }

  actual fun destroy() {
    ImFontGlyphRangesBuilder_destroy(ptr)
  }
}

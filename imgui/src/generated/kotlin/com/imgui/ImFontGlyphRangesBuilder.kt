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
import kotlin.Int
import kotlin.String
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.wcstr

inline class ImFontGlyphRangesBuilder(
  val ptr: CPointer<cimgui.internal.ImFontGlyphRangesBuilder>
) {
  constructor() : this(ImFontGlyphRangesBuilder_ImFontGlyphRangesBuilder()!!)

  fun addChar(c: Char) {
    ImFontGlyphRangesBuilder_AddChar(ptr, c.toShort().toUShort())
  }

  fun addRanges(ranges: String) {
    ImFontGlyphRangesBuilder_AddRanges(ptr, ranges.wcstr)
  }

  fun addText(text: String, textEnd: String? = null) {
    ImFontGlyphRangesBuilder_AddText(ptr, text, textEnd)
  }

  fun clear() {
    ImFontGlyphRangesBuilder_Clear(ptr)
  }

  fun getBit(n: Int): Boolean = ImFontGlyphRangesBuilder_GetBit(ptr, n)

  fun setBit(n: Int) {
    ImFontGlyphRangesBuilder_SetBit(ptr, n)
  }

  fun destroy() {
    ImFontGlyphRangesBuilder_destroy(ptr)
  }
}

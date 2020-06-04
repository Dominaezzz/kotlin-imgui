package com.imgui

import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_AddChar
import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_AddRanges
import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_AddText
import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_Clear
import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_GetBit
import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_ImFontGlyphRangesBuilder
import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_SetBit
import cimgui.internal.CImGui.ImFontGlyphRangesBuilder_destroy
import kotlin.Boolean
import kotlin.Char
import kotlin.String
import kotlin.Suppress
import kotlin.ULong

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImFontGlyphRangesBuilder(
  val ptr: cimgui.internal.ImFontGlyphRangesBuilder
) {
  actual constructor() : this(ImFontGlyphRangesBuilder_ImFontGlyphRangesBuilder()!!)

  actual fun addChar(c: Char) {
    ImFontGlyphRangesBuilder_AddChar(ptr, c.toInt())
  }

  actual fun addRanges(ranges: String) {
    ranges.usingUTF16String { ptrRanges -> 
      ImFontGlyphRangesBuilder_AddRanges(ptr, ptrRanges)
    }
  }

  actual fun addText(text: String, textEnd: String?) {
    ImFontGlyphRangesBuilder_AddText(ptr, text, textEnd)
  }

  actual fun clear() {
    ImFontGlyphRangesBuilder_Clear(ptr)
  }

  actual fun getBit(n: ULong): Boolean = ImFontGlyphRangesBuilder_GetBit(ptr, n.toLong())

  actual fun setBit(n: ULong) {
    ImFontGlyphRangesBuilder_SetBit(ptr, n.toLong())
  }

  actual fun destroy() {
    ImFontGlyphRangesBuilder_destroy(ptr)
  }
}

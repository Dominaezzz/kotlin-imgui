package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.String
import kotlin.ULong

expect class ImFontGlyphRangesBuilder {
  constructor()

  fun addChar(c: Char)

  fun addRanges(ranges: String)

  fun addText(text: String, textEnd: String? = null)

  fun clear()

  fun getBit(n: ULong): Boolean

  fun setBit(n: ULong)

  fun destroy()
}

package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.Int
import kotlin.String

expect class ImFontGlyphRangesBuilder {
  constructor()

  fun addChar(c: Char)

  fun addRanges(ranges: String)

  fun addText(text: String, textEnd: String? = null)

  fun clear()

  fun getBit(n: Int): Boolean

  fun setBit(n: Int)

  fun destroy()
}

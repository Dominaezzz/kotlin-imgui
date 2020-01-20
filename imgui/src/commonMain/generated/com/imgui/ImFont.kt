package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.UInt

expect class ImFont {
  val fallbackAdvanceX: Float

  val fontSize: Float

  val fallbackGlyph: ImFontGlyph?

  val displayOffset: Vec2

  val containerAtlas: ImFontAtlas?

  val configData: ImFontConfig?

  val configDataCount: Short

  val fallbackChar: Char

  val ellipsisChar: Char

  val scale: Float

  val ascent: Float

  val descent: Float

  val metricsTotalSurface: Int

  val dirtyLookupTables: Boolean

  constructor()

  fun addGlyph(
    c: Char,
    x0: Float,
    y0: Float,
    x1: Float,
    y1: Float,
    u0: Float,
    v0: Float,
    u1: Float,
    v1: Float,
    advanceX: Float
  )

  fun addRemapChar(
    dst: Char,
    src: Char,
    overwriteDst: Boolean = true
  )

  fun buildLookupTable()

  fun calcTextSizeA(
    size: Float,
    maxWidth: Float,
    wrapWidth: Float,
    textBegin: String,
    textEnd: String? = null
  ): Vec2

  fun calcWordWrapPositionA(
    scale: Float,
    text: String,
    textEnd: String,
    wrapWidth: Float
  ): String?

  fun clearOutputData()

  fun findGlyph(c: Char): ImFontGlyph

  fun findGlyphNoFallback(c: Char): ImFontGlyph

  fun getCharAdvance(c: Char): Float

  fun getDebugName(): String?

  fun growIndex(newSize: Int)

  fun isLoaded(): Boolean

  fun renderChar(
    drawList: ImDrawList,
    size: Float,
    pos: Vec2,
    col: UInt,
    c: Char
  )

  fun renderText(
    drawList: ImDrawList,
    size: Float,
    pos: Vec2,
    col: UInt,
    clipRect: Vec4,
    textBegin: String,
    textEnd: String,
    wrapWidth: Float = 0.0f,
    cpuFineClip: Boolean = false
  )

  fun setFallbackChar(c: Char)

  fun destroy()
}

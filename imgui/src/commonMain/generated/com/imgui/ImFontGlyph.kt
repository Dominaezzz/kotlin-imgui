package com.imgui

import kotlin.Char
import kotlin.Float

expect class ImFontGlyph {
  val codepoint: Char

  val advanceX: Float

  val x0: Float

  val y0: Float

  val x1: Float

  val y1: Float

  val u0: Float

  val v0: Float

  val u1: Float

  val v1: Float
}

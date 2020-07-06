package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.UInt
import kotlin.UShort

expect class ImFontAtlasCustomRect {
  val width: UShort

  val height: UShort

  val x: UShort

  val y: UShort

  val glyphID: UInt

  val glyphAdvanceX: Float

  val glyphOffset: Vec2

  val font: ImFont?

  constructor()

  fun isPacked(): Boolean

  fun destroy()
}

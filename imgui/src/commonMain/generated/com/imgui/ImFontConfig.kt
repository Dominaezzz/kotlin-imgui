package com.imgui

import kotlin.Boolean
import kotlin.Char
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt

expect class ImFontConfig {
  val fontDataSize: Int

  val fontDataOwnedByAtlas: Boolean

  val fontNo: Int

  val sizePixels: Float

  val oversampleH: Int

  val oversampleV: Int

  val pixelSnapH: Boolean

  val glyphExtraSpacing: Vec2

  val glyphOffset: Vec2

  val glyphRanges: String?

  val glyphMinAdvanceX: Float

  val glyphMaxAdvanceX: Float

  val mergeMode: Boolean

  val rasterizerFlags: UInt

  val rasterizerMultiply: Float

  val ellipsisChar: Char

  val dstFont: ImFont?

  constructor()

  fun destroy()
}

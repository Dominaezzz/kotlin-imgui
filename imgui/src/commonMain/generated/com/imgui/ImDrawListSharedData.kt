package com.imgui

import kotlin.Float
import kotlin.Int

expect class ImDrawListSharedData {
  val texUvWhitePixel: Vec2

  val font: ImFont?

  val fontSize: Float

  val curveTessellationTol: Float

  val circleSegmentMaxError: Float

  val clipRectFullscreen: Vec4

  val initialFlags: Flag<ImDrawListFlags>

  constructor()

  fun arcFastVtx(index: Int): Vec2

  fun setCircleSegmentMaxError(maxError: Float)

  fun destroy()
}

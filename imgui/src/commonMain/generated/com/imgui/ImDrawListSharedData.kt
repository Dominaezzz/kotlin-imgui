package com.imgui

import kotlin.Float

expect class ImDrawListSharedData {
  val texUvWhitePixel: Vec2

  val font: ImFont?

  val fontSize: Float

  val curveTessellationTol: Float

  val circleSegmentMaxError: Float

  val clipRectFullscreen: Vec4

  val initialFlags: Flag<ImDrawListFlags>

  constructor()

  fun setCircleSegmentMaxError(maxError: Float)

  fun destroy()
}

package com.imgui

import kotlin.UInt

expect class ImDrawVert {
  val pos: Vec2

  val uv: Vec2

  val col: UInt
}

package com.imgui

import kotlin.Float

expect class ImVec2 {
  val x: Float

  val y: Float

  constructor()

  constructor(x: Float, y: Float)

  fun destroy()
}

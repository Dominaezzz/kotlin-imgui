package com.imgui

import kotlin.Float

expect class ImVec4 {
  val x: Float

  val y: Float

  val z: Float

  val w: Float

  constructor()

  constructor(
    x: Float,
    y: Float,
    z: Float,
    w: Float
  )

  fun destroy()
}

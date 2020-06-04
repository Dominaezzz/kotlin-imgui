package com.imgui

import kotlin.Float

expect class ImVec1 {
  val x: Float

  constructor()

  constructor(x: Float)

  fun destroy()
}

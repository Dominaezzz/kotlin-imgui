package com.imgui

import kotlin.Short

expect class ImVec2ih {
  val x: Short

  val y: Short

  constructor()

  constructor(x: Short, y: Short)

  fun destroy()
}

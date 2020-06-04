package com.imgui

import kotlin.Float
import kotlin.Int

expect class ImGuiStyleMod {
  val varIdx: ImGuiStyleVar

  constructor(idx: ImGuiStyleVar, v: Int)

  constructor(idx: ImGuiStyleVar, v: Float)

  constructor(idx: ImGuiStyleVar, v: Vec2)

  fun destroy()
}

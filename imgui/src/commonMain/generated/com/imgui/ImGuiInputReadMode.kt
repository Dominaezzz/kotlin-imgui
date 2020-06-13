package com.imgui

import kotlin.Int

expect enum class ImGuiInputReadMode {
  Down,

  Pressed,

  Released,

  Repeat,

  RepeatSlow,

  RepeatFast;

  val cValue: Int

  companion object
}

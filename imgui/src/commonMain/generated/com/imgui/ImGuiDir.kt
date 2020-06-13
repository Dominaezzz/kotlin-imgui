package com.imgui

import kotlin.Int

expect enum class ImGuiDir {
  None,

  Left,

  Right,

  Up,

  Down;

  val cValue: Int

  companion object
}

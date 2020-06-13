package com.imgui

import kotlin.Int

expect enum class ImGuiMouseButton {
  Left,

  Right,

  Middle;

  val cValue: Int

  companion object
}

package com.imgui

import kotlin.Int

expect enum class ImGuiInputSource {
  None,

  Mouse,

  Nav,

  NavKeyboard,

  NavGamepad;

  val cValue: Int

  companion object
}

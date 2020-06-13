package com.imgui

import kotlin.Int

expect enum class ImGuiKeyModFlags : Flag<ImGuiKeyModFlags> {
  Ctrl,

  Shift,

  Alt,

  Super;

  val cValue: Int

  companion object
}

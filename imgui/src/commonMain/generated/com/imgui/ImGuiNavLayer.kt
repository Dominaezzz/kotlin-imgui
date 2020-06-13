package com.imgui

import kotlin.Int

expect enum class ImGuiNavLayer {
  Main,

  Menu;

  val cValue: Int

  companion object
}

package com.imgui

import kotlin.Int

expect enum class ImGuiAxis {
  None,

  X,

  Y;

  val cValue: Int

  companion object
}

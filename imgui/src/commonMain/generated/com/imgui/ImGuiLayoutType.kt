package com.imgui

import kotlin.Int

expect enum class ImGuiLayoutType {
  Horizontal,

  Vertical;

  val cValue: Int

  companion object
}

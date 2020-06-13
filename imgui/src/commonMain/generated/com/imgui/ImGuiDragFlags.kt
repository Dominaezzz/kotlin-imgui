package com.imgui

import kotlin.Int

expect enum class ImGuiDragFlags : Flag<ImGuiDragFlags> {
  Vertical;

  val cValue: Int

  companion object
}

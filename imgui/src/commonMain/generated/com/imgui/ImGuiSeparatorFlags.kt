package com.imgui

import kotlin.Int

expect enum class ImGuiSeparatorFlags : Flag<ImGuiSeparatorFlags> {
  Horizontal,

  Vertical,

  SpanAllColumns;

  val cValue: Int

  companion object
}

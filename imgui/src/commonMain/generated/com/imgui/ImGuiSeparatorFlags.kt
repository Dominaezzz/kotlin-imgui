package com.imgui

expect enum class ImGuiSeparatorFlags : Flag<ImGuiSeparatorFlags> {
  Horizontal,

  Vertical,

  SpanAllColumns;

  companion object
}

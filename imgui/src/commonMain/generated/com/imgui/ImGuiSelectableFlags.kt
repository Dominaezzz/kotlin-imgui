package com.imgui

expect enum class ImGuiSelectableFlags : Flag<ImGuiSelectableFlags> {
  DontClosePopups,

  SpanAllColumns,

  AllowDoubleClick,

  Disabled,

  AllowItemOverlap;

  companion object
}

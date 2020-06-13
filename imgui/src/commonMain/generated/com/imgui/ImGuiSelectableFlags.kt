package com.imgui

import kotlin.Int

expect enum class ImGuiSelectableFlags : Flag<ImGuiSelectableFlags> {
  DontClosePopups,

  SpanAllColumns,

  AllowDoubleClick,

  Disabled,

  AllowItemOverlap;

  val cValue: Int

  companion object
}

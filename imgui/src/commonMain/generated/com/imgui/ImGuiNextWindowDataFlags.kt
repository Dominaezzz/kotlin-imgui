package com.imgui

import kotlin.Int

expect enum class ImGuiNextWindowDataFlags : Flag<ImGuiNextWindowDataFlags> {
  HasPos,

  HasSize,

  HasContentSize,

  HasCollapsed,

  HasSizeConstraint,

  HasFocus,

  HasBgAlpha;

  val cValue: Int

  companion object
}

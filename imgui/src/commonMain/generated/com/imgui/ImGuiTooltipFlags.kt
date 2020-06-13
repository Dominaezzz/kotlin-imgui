package com.imgui

import kotlin.Int

expect enum class ImGuiTooltipFlags : Flag<ImGuiTooltipFlags> {
  OverridePreviousTooltip;

  val cValue: Int

  companion object
}

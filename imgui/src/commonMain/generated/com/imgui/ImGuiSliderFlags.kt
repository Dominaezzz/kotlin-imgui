package com.imgui

import kotlin.Int

expect enum class ImGuiSliderFlags : Flag<ImGuiSliderFlags> {
  Vertical;

  val cValue: Int

  companion object
}

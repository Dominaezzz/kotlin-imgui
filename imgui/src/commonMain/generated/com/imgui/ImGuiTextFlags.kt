package com.imgui

import kotlin.Int

expect enum class ImGuiTextFlags : Flag<ImGuiTextFlags> {
  NoWidthForLargeClippedText;

  val cValue: Int

  companion object
}

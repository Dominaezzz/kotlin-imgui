package com.imgui

import kotlin.Int

expect enum class ImGuiNextItemDataFlags : Flag<ImGuiNextItemDataFlags> {
  HasWidth,

  HasOpen;

  val cValue: Int

  companion object
}

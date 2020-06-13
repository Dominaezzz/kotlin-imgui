package com.imgui

import kotlin.Int

expect enum class ImGuiNavHighlightFlags : Flag<ImGuiNavHighlightFlags> {
  TypeDefault,

  TypeThin,

  AlwaysDraw,

  NoRounding;

  val cValue: Int

  companion object
}

package com.imgui

expect enum class ImGuiNavHighlightFlags : Flag<ImGuiNavHighlightFlags> {
  TypeDefault,

  TypeThin,

  AlwaysDraw,

  NoRounding;

  companion object
}

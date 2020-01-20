package com.imgui

expect enum class ImFontAtlasFlags : Flag<ImFontAtlasFlags> {
  NoPowerOfTwoHeight,

  NoMouseCursors;

  companion object
}

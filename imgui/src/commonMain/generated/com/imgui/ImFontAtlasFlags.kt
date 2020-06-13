package com.imgui

import kotlin.Int

expect enum class ImFontAtlasFlags : Flag<ImFontAtlasFlags> {
  NoPowerOfTwoHeight,

  NoMouseCursors;

  val cValue: Int

  companion object
}

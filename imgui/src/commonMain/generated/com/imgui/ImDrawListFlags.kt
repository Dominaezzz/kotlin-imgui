package com.imgui

import kotlin.Int

expect enum class ImDrawListFlags : Flag<ImDrawListFlags> {
  AntiAliasedLines,

  AntiAliasedFill,

  AllowVtxOffset;

  val cValue: Int

  companion object
}

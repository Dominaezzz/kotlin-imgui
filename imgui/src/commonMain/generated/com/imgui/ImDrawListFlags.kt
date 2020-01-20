package com.imgui

expect enum class ImDrawListFlags : Flag<ImDrawListFlags> {
  AntiAliasedLines,

  AntiAliasedFill,

  AllowVtxOffset;

  companion object
}

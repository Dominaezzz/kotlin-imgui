package com.imgui

expect enum class ImDrawCornerFlags : Flag<ImDrawCornerFlags> {
  TopLeft,

  TopRight,

  BotLeft,

  BotRight;

  companion object {
    val Top: Flag<ImDrawCornerFlags>

    val Bot: Flag<ImDrawCornerFlags>

    val Left: Flag<ImDrawCornerFlags>

    val Right: Flag<ImDrawCornerFlags>

    val All: Flag<ImDrawCornerFlags>
  }
}

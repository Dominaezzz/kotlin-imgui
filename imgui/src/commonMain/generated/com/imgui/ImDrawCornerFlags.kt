package com.imgui

import kotlin.Int

expect enum class ImDrawCornerFlags : Flag<ImDrawCornerFlags> {
  TopLeft,

  TopRight,

  BotLeft,

  BotRight;

  val cValue: Int

  companion object {
    val Top: Flag<ImDrawCornerFlags>

    val Bot: Flag<ImDrawCornerFlags>

    val Left: Flag<ImDrawCornerFlags>

    val Right: Flag<ImDrawCornerFlags>

    val All: Flag<ImDrawCornerFlags>
  }
}

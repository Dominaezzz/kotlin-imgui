package com.imgui

import kotlin.Int

expect enum class ImGuiHoveredFlags : Flag<ImGuiHoveredFlags> {
  ChildWindows,

  RootWindow,

  AnyWindow,

  AllowWhenBlockedByPopup,

  AllowWhenBlockedByActiveItem,

  AllowWhenOverlapped,

  AllowWhenDisabled;

  val cValue: Int

  companion object {
    val RectOnly: Flag<ImGuiHoveredFlags>

    val RootAndChildWindows: Flag<ImGuiHoveredFlags>
  }
}

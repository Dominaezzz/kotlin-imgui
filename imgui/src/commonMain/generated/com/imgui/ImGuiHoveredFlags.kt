package com.imgui

expect enum class ImGuiHoveredFlags : Flag<ImGuiHoveredFlags> {
  ChildWindows,

  RootWindow,

  AnyWindow,

  AllowWhenBlockedByPopup,

  AllowWhenBlockedByActiveItem,

  AllowWhenOverlapped,

  AllowWhenDisabled;

  companion object {
    val RectOnly: Flag<ImGuiHoveredFlags>

    val RootAndChildWindows: Flag<ImGuiHoveredFlags>
  }
}

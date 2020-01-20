package com.imgui

expect enum class ImGuiFocusedFlags : Flag<ImGuiFocusedFlags> {
  ChildWindows,

  RootWindow,

  AnyWindow;

  companion object {
    val RootAndChildWindows: Flag<ImGuiFocusedFlags>
  }
}

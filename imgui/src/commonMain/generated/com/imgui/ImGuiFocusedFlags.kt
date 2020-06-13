package com.imgui

import kotlin.Int

expect enum class ImGuiFocusedFlags : Flag<ImGuiFocusedFlags> {
  ChildWindows,

  RootWindow,

  AnyWindow;

  val cValue: Int

  companion object {
    val RootAndChildWindows: Flag<ImGuiFocusedFlags>
  }
}

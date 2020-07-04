package com.imgui

import kotlin.Int

expect enum class ImGuiViewportFlags : Flag<ImGuiViewportFlags> {
  NoDecoration,

  NoTaskBarIcon,

  NoFocusOnAppearing,

  NoFocusOnClick,

  NoInputs,

  NoRendererClear,

  TopMost,

  Minimized,

  NoAutoMerge,

  CanHostOtherWindows;

  val cValue: Int

  companion object
}

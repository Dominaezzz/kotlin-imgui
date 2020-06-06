package com.imgui

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

  companion object
}

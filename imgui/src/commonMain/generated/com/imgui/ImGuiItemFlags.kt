package com.imgui

expect enum class ImGuiItemFlags : Flag<ImGuiItemFlags> {
  NoTabStop,

  ButtonRepeat,

  Disabled,

  NoNav,

  NoNavDefaultFocus,

  SelectableDontClosePopup,

  MixedValue,

  Default_;

  companion object
}

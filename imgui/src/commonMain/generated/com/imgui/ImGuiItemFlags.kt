package com.imgui

import kotlin.Int

expect enum class ImGuiItemFlags : Flag<ImGuiItemFlags> {
  NoTabStop,

  ButtonRepeat,

  Disabled,

  NoNav,

  NoNavDefaultFocus,

  SelectableDontClosePopup,

  MixedValue,

  Default_;

  val cValue: Int

  companion object
}

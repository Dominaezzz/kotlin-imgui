package com.imgui

import kotlin.Int

expect enum class ImGuiKey {
  Tab,

  LeftArrow,

  RightArrow,

  UpArrow,

  DownArrow,

  PageUp,

  PageDown,

  Home,

  End,

  Insert,

  Delete,

  Backspace,

  Space,

  Enter,

  Escape,

  KeyPadEnter,

  A,

  C,

  V,

  X,

  Y,

  Z;

  val cValue: Int

  companion object
}

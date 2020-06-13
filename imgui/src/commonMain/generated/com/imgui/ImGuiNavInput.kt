package com.imgui

import kotlin.Int

expect enum class ImGuiNavInput {
  Activate,

  Cancel,

  Input,

  Menu,

  DpadLeft,

  DpadRight,

  DpadUp,

  DpadDown,

  LStickLeft,

  LStickRight,

  LStickUp,

  LStickDown,

  FocusPrev,

  FocusNext,

  TweakSlow,

  TweakFast,

  KeyMenu_,

  KeyLeft_,

  KeyRight_,

  KeyUp_,

  KeyDown_,

  InternalStart_;

  val cValue: Int

  companion object
}

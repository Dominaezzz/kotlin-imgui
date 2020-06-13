package com.imgui

import kotlin.Int

expect enum class ImGuiInputTextFlags : Flag<ImGuiInputTextFlags> {
  CharsDecimal,

  CharsHexadecimal,

  CharsUppercase,

  CharsNoBlank,

  AutoSelectAll,

  EnterReturnsTrue,

  CallbackCompletion,

  CallbackHistory,

  CallbackAlways,

  CallbackCharFilter,

  AllowTabInput,

  CtrlEnterForNewLine,

  NoHorizontalScroll,

  AlwaysInsertMode,

  ReadOnly,

  Password,

  NoUndoRedo,

  CharsScientific,

  CallbackResize,

  Multiline,

  NoMarkEdited;

  val cValue: Int

  companion object
}

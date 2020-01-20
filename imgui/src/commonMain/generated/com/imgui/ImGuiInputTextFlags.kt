package com.imgui

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

  companion object
}

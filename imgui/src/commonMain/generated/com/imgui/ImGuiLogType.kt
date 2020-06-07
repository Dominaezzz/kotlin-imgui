package com.imgui

expect enum class ImGuiLogType {
  None,

  TTY,

  File,

  Buffer,

  Clipboard;

  companion object
}

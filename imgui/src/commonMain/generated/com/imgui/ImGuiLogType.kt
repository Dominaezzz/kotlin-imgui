package com.imgui

expect enum class ImGuiLogType {
  _None,

  _TTY,

  _File,

  _Buffer,

  _Clipboard;

  companion object
}

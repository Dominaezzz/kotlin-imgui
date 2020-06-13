package com.imgui

import kotlin.Int

expect enum class ImGuiLogType {
  None,

  TTY,

  File,

  Buffer,

  Clipboard;

  val cValue: Int

  companion object
}

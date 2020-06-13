package com.imgui

import cimgui.internal.ImGuiLogType.ImGuiLogType_Buffer
import cimgui.internal.ImGuiLogType.ImGuiLogType_Clipboard
import cimgui.internal.ImGuiLogType.ImGuiLogType_File
import cimgui.internal.ImGuiLogType.ImGuiLogType_None
import cimgui.internal.ImGuiLogType.ImGuiLogType_TTY
import kotlin.Int

actual enum class ImGuiLogType(
  val value: Int
) {
  None(ImGuiLogType_None),

  TTY(ImGuiLogType_TTY),

  File(ImGuiLogType_File),

  Buffer(ImGuiLogType_Buffer),

  Clipboard(ImGuiLogType_Clipboard);

  actual val cValue: Int
    get() = value

  actual companion object {
    fun from(value: Int): ImGuiLogType = when (value) {
      ImGuiLogType_None -> None
      ImGuiLogType_TTY -> TTY
      ImGuiLogType_File -> File
      ImGuiLogType_Buffer -> Buffer
      ImGuiLogType_Clipboard -> Clipboard
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

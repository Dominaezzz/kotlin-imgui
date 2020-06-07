package com.imgui

import cimgui.internal.ImGuiLogType_Buffer
import cimgui.internal.ImGuiLogType_Clipboard
import cimgui.internal.ImGuiLogType_File
import cimgui.internal.ImGuiLogType_None
import cimgui.internal.ImGuiLogType_TTY
import kotlinx.cinterop.convert

actual enum class ImGuiLogType(
  val value: cimgui.internal.ImGuiLogType
) {
  None(ImGuiLogType_None.convert()),

  TTY(ImGuiLogType_TTY.convert()),

  File(ImGuiLogType_File.convert()),

  Buffer(ImGuiLogType_Buffer.convert()),

  Clipboard(ImGuiLogType_Clipboard.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiLogType): ImGuiLogType = when
        (value.convert<cimgui.internal.ImGuiLogType>()) {
      ImGuiLogType_None -> None
      ImGuiLogType_TTY -> TTY
      ImGuiLogType_File -> File
      ImGuiLogType_Buffer -> Buffer
      ImGuiLogType_Clipboard -> Clipboard
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

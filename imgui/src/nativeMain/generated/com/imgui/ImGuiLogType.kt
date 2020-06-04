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
  _None(ImGuiLogType_None.convert()),

  _TTY(ImGuiLogType_TTY.convert()),

  _File(ImGuiLogType_File.convert()),

  _Buffer(ImGuiLogType_Buffer.convert()),

  _Clipboard(ImGuiLogType_Clipboard.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiLogType): ImGuiLogType = when
        (value.convert<cimgui.internal.ImGuiLogType>()) {
      ImGuiLogType_None -> _None
      ImGuiLogType_TTY -> _TTY
      ImGuiLogType_File -> _File
      ImGuiLogType_Buffer -> _Buffer
      ImGuiLogType_Clipboard -> _Clipboard
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

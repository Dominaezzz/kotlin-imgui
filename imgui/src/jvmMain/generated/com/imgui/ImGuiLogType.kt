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
  _None(ImGuiLogType_None),

  _TTY(ImGuiLogType_TTY),

  _File(ImGuiLogType_File),

  _Buffer(ImGuiLogType_Buffer),

  _Clipboard(ImGuiLogType_Clipboard);

  actual companion object {
    fun from(value: Int): ImGuiLogType = when (value) {
      ImGuiLogType_None -> _None
      ImGuiLogType_TTY -> _TTY
      ImGuiLogType_File -> _File
      ImGuiLogType_Buffer -> _Buffer
      ImGuiLogType_Clipboard -> _Clipboard
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

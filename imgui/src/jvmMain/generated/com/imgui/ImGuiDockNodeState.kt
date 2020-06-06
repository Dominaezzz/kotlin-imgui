package com.imgui

import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow
import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing
import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_HostWindowVisible
import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_Unknown
import kotlin.Int

actual enum class ImGuiDockNodeState(
  val value: Int
) {
  _Unknown(ImGuiDockNodeState_Unknown),

  _HostWindowHiddenBecauseSingleWindow(ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow),

  _HostWindowHiddenBecauseWindowsAreResizing(ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing),

  _HostWindowVisible(ImGuiDockNodeState_HostWindowVisible);

  actual companion object {
    fun from(value: Int): ImGuiDockNodeState = when (value) {
      ImGuiDockNodeState_Unknown -> _Unknown
      ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow -> _HostWindowHiddenBecauseSingleWindow
      ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing ->
          _HostWindowHiddenBecauseWindowsAreResizing
      ImGuiDockNodeState_HostWindowVisible -> _HostWindowVisible
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

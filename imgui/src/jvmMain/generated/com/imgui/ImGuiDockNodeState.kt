package com.imgui

import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow
import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing
import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_HostWindowVisible
import cimgui.internal.ImGuiDockNodeState.ImGuiDockNodeState_Unknown
import kotlin.Int

actual enum class ImGuiDockNodeState(
  val value: Int
) {
  Unknown(ImGuiDockNodeState_Unknown),

  HostWindowHiddenBecauseSingleWindow(ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow),

  HostWindowHiddenBecauseWindowsAreResizing(ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing),

  HostWindowVisible(ImGuiDockNodeState_HostWindowVisible);

  actual companion object {
    fun from(value: Int): ImGuiDockNodeState = when (value) {
      ImGuiDockNodeState_Unknown -> Unknown
      ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow -> HostWindowHiddenBecauseSingleWindow
      ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing ->
          HostWindowHiddenBecauseWindowsAreResizing
      ImGuiDockNodeState_HostWindowVisible -> HostWindowVisible
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

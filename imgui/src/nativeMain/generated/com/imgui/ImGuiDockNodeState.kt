package com.imgui

import cimgui.internal.ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow
import cimgui.internal.ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing
import cimgui.internal.ImGuiDockNodeState_HostWindowVisible
import cimgui.internal.ImGuiDockNodeState_Unknown
import kotlinx.cinterop.convert

actual enum class ImGuiDockNodeState(
  val value: cimgui.internal.ImGuiDockNodeState
) {
  Unknown(ImGuiDockNodeState_Unknown.convert()),

  HostWindowHiddenBecauseSingleWindow(ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow.convert()),

  HostWindowHiddenBecauseWindowsAreResizing(ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing.convert()),

  HostWindowVisible(ImGuiDockNodeState_HostWindowVisible.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiDockNodeState): ImGuiDockNodeState = when
        (value.convert<cimgui.internal.ImGuiDockNodeState>()) {
      ImGuiDockNodeState_Unknown -> Unknown
      ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow -> HostWindowHiddenBecauseSingleWindow
      ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing ->
          HostWindowHiddenBecauseWindowsAreResizing
      ImGuiDockNodeState_HostWindowVisible -> HostWindowVisible
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

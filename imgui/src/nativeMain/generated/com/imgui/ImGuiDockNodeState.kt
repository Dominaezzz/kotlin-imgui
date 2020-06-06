package com.imgui

import cimgui.internal.ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow
import cimgui.internal.ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing
import cimgui.internal.ImGuiDockNodeState_HostWindowVisible
import cimgui.internal.ImGuiDockNodeState_Unknown
import kotlinx.cinterop.convert

actual enum class ImGuiDockNodeState(
  val value: cimgui.internal.ImGuiDockNodeState
) {
  _Unknown(ImGuiDockNodeState_Unknown.convert()),

  _HostWindowHiddenBecauseSingleWindow(ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow.convert()),

  _HostWindowHiddenBecauseWindowsAreResizing(ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing.convert()),

  _HostWindowVisible(ImGuiDockNodeState_HostWindowVisible.convert());

  actual companion object {
    fun from(value: cimgui.internal.ImGuiDockNodeState): ImGuiDockNodeState = when
        (value.convert<cimgui.internal.ImGuiDockNodeState>()) {
      ImGuiDockNodeState_Unknown -> _Unknown
      ImGuiDockNodeState_HostWindowHiddenBecauseSingleWindow -> _HostWindowHiddenBecauseSingleWindow
      ImGuiDockNodeState_HostWindowHiddenBecauseWindowsAreResizing ->
          _HostWindowHiddenBecauseWindowsAreResizing
      ImGuiDockNodeState_HostWindowVisible -> _HostWindowVisible
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }
  }
}

package com.imgui

expect enum class ImGuiDockNodeState {
  _Unknown,

  _HostWindowHiddenBecauseSingleWindow,

  _HostWindowHiddenBecauseWindowsAreResizing,

  _HostWindowVisible;

  companion object
}

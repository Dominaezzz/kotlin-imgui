package com.imgui

expect enum class ImGuiDockNodeState {
  Unknown,

  HostWindowHiddenBecauseSingleWindow,

  HostWindowHiddenBecauseWindowsAreResizing,

  HostWindowVisible;

  companion object
}

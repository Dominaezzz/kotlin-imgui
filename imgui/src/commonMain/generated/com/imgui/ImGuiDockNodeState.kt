package com.imgui

import kotlin.Int

expect enum class ImGuiDockNodeState {
  Unknown,

  HostWindowHiddenBecauseSingleWindow,

  HostWindowHiddenBecauseWindowsAreResizing,

  HostWindowVisible;

  val cValue: Int

  companion object
}

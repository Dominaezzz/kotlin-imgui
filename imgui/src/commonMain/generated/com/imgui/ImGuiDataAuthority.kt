package com.imgui

import kotlin.Int

expect enum class ImGuiDataAuthority {
  Auto,

  DockNode,

  Window;

  val cValue: Int

  companion object
}

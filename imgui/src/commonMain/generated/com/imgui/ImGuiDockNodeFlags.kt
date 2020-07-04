package com.imgui

import kotlin.Int

expect enum class ImGuiDockNodeFlags : Flag<ImGuiDockNodeFlags> {
  KeepAliveOnly,

  NoDockingInCentralNode,

  PassthruCentralNode,

  NoSplit,

  NoResize,

  AutoHideTabBar;

  val cValue: Int

  companion object
}

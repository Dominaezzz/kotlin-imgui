package com.imgui

expect enum class ImGuiDockNodeFlags : Flag<ImGuiDockNodeFlags> {
  KeepAliveOnly,

  NoDockingInCentralNode,

  PassthruCentralNode,

  NoSplit,

  NoResize,

  AutoHideTabBar;

  companion object
}

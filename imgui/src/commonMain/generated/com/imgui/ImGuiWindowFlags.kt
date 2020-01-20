package com.imgui

expect enum class ImGuiWindowFlags : Flag<ImGuiWindowFlags> {
  NoTitleBar,

  NoResize,

  NoMove,

  NoScrollbar,

  NoScrollWithMouse,

  NoCollapse,

  AlwaysAutoResize,

  NoBackground,

  NoSavedSettings,

  NoMouseInputs,

  MenuBar,

  HorizontalScrollbar,

  NoFocusOnAppearing,

  NoBringToFrontOnFocus,

  AlwaysVerticalScrollbar,

  AlwaysHorizontalScrollbar,

  AlwaysUseWindowPadding,

  NoNavInputs,

  NoNavFocus,

  UnsavedDocument,

  NavFlattened,

  ChildWindow,

  Tooltip,

  Popup,

  Modal,

  ChildMenu;

  companion object {
    val NoNav: Flag<ImGuiWindowFlags>

    val NoDecoration: Flag<ImGuiWindowFlags>

    val NoInputs: Flag<ImGuiWindowFlags>
  }
}

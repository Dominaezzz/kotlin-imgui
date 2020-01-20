package com.imgui

expect enum class ImGuiTabItemFlags : Flag<ImGuiTabItemFlags> {
  UnsavedDocument,

  SetSelected,

  NoCloseWithMiddleMouseButton,

  NoPushId;

  companion object
}

package com.imgui

expect enum class ImGuiItemStatusFlags : Flag<ImGuiItemStatusFlags> {
  HoveredRect,

  HasDisplayRect,

  Edited,

  ToggledSelection,

  ToggledOpen,

  HasDeactivated,

  Deactivated;

  companion object
}

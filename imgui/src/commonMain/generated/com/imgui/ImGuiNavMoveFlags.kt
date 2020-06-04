package com.imgui

expect enum class ImGuiNavMoveFlags : Flag<ImGuiNavMoveFlags> {
  LoopX,

  LoopY,

  WrapX,

  WrapY,

  AllowCurrentNavId,

  AlsoScoreVisibleSet,

  ScrollToEdge;

  companion object
}

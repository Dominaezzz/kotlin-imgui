package com.imgui

import kotlin.Int

expect enum class ImGuiNavMoveFlags : Flag<ImGuiNavMoveFlags> {
  LoopX,

  LoopY,

  WrapX,

  WrapY,

  AllowCurrentNavId,

  AlsoScoreVisibleSet,

  ScrollToEdge;

  val cValue: Int

  companion object
}

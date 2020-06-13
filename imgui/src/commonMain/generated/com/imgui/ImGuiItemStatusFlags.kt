package com.imgui

import kotlin.Int

expect enum class ImGuiItemStatusFlags : Flag<ImGuiItemStatusFlags> {
  HoveredRect,

  HasDisplayRect,

  Edited,

  ToggledSelection,

  ToggledOpen,

  HasDeactivated,

  Deactivated;

  val cValue: Int

  companion object
}

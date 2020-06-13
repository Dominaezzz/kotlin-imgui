package com.imgui

import kotlin.Int

expect enum class ImGuiColumnsFlags : Flag<ImGuiColumnsFlags> {
  NoBorder,

  NoResize,

  NoPreserveWidths,

  NoForceWithinWindow,

  GrowParentContentsSize;

  val cValue: Int

  companion object
}

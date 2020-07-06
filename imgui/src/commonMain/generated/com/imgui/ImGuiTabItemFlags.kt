package com.imgui

import kotlin.Int

expect enum class ImGuiTabItemFlags : Flag<ImGuiTabItemFlags> {
  UnsavedDocument,

  SetSelected,

  NoCloseWithMiddleMouseButton,

  NoPushId,

  NoTooltip;

  val cValue: Int

  companion object
}

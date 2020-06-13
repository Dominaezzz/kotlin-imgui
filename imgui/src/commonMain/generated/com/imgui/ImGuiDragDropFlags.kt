package com.imgui

import kotlin.Int

expect enum class ImGuiDragDropFlags : Flag<ImGuiDragDropFlags> {
  SourceNoPreviewTooltip,

  SourceNoDisableHover,

  SourceNoHoldToOpenOthers,

  SourceAllowNullID,

  SourceExtern,

  SourceAutoExpirePayload,

  AcceptBeforeDelivery,

  AcceptNoDrawDefaultRect,

  AcceptNoPreviewTooltip;

  val cValue: Int

  companion object {
    val AcceptPeekOnly: Flag<ImGuiDragDropFlags>
  }
}

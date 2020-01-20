package com.imgui

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

  companion object {
    val AcceptPeekOnly: Flag<ImGuiDragDropFlags>
  }
}

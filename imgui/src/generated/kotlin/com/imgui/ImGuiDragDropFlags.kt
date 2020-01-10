package com.imgui

import cimgui.internal.ImGuiDragDropFlags_AcceptBeforeDelivery
import cimgui.internal.ImGuiDragDropFlags_AcceptNoDrawDefaultRect
import cimgui.internal.ImGuiDragDropFlags_AcceptNoPreviewTooltip
import cimgui.internal.ImGuiDragDropFlags_AcceptPeekOnly
import cimgui.internal.ImGuiDragDropFlags_SourceAllowNullID
import cimgui.internal.ImGuiDragDropFlags_SourceAutoExpirePayload
import cimgui.internal.ImGuiDragDropFlags_SourceExtern
import cimgui.internal.ImGuiDragDropFlags_SourceNoDisableHover
import cimgui.internal.ImGuiDragDropFlags_SourceNoHoldToOpenOthers
import cimgui.internal.ImGuiDragDropFlags_SourceNoPreviewTooltip
import kotlin.Int

enum class ImGuiDragDropFlags(
  override val value: Int
) : Flag<ImGuiDragDropFlags> {
  SourceNoPreviewTooltip(ImGuiDragDropFlags_SourceNoPreviewTooltip.toInt()),

  SourceNoDisableHover(ImGuiDragDropFlags_SourceNoDisableHover.toInt()),

  SourceNoHoldToOpenOthers(ImGuiDragDropFlags_SourceNoHoldToOpenOthers.toInt()),

  SourceAllowNullID(ImGuiDragDropFlags_SourceAllowNullID.toInt()),

  SourceExtern(ImGuiDragDropFlags_SourceExtern.toInt()),

  SourceAutoExpirePayload(ImGuiDragDropFlags_SourceAutoExpirePayload.toInt()),

  AcceptBeforeDelivery(ImGuiDragDropFlags_AcceptBeforeDelivery.toInt()),

  AcceptNoDrawDefaultRect(ImGuiDragDropFlags_AcceptNoDrawDefaultRect.toInt()),

  AcceptNoPreviewTooltip(ImGuiDragDropFlags_AcceptNoPreviewTooltip.toInt());

  override val info: Flag.EnumInfo<ImGuiDragDropFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiDragDropFlags> = Flag.enumInfo()

    val AcceptPeekOnly: Flag<ImGuiDragDropFlags> = Flag(ImGuiDragDropFlags_AcceptPeekOnly.toInt(),
        cachedInfo)
  }
}

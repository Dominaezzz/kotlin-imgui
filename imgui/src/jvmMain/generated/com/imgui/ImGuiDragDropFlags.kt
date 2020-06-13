package com.imgui

import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_AcceptBeforeDelivery
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_AcceptNoDrawDefaultRect
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_AcceptNoPreviewTooltip
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_AcceptPeekOnly
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_SourceAllowNullID
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_SourceAutoExpirePayload
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_SourceExtern
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_SourceNoDisableHover
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_SourceNoHoldToOpenOthers
import cimgui.internal.ImGuiDragDropFlags_.ImGuiDragDropFlags_SourceNoPreviewTooltip
import kotlin.Int

actual enum class ImGuiDragDropFlags(
  override val value: Int
) : Flag<ImGuiDragDropFlags> {
  SourceNoPreviewTooltip(ImGuiDragDropFlags_SourceNoPreviewTooltip),

  SourceNoDisableHover(ImGuiDragDropFlags_SourceNoDisableHover),

  SourceNoHoldToOpenOthers(ImGuiDragDropFlags_SourceNoHoldToOpenOthers),

  SourceAllowNullID(ImGuiDragDropFlags_SourceAllowNullID),

  SourceExtern(ImGuiDragDropFlags_SourceExtern),

  SourceAutoExpirePayload(ImGuiDragDropFlags_SourceAutoExpirePayload),

  AcceptBeforeDelivery(ImGuiDragDropFlags_AcceptBeforeDelivery),

  AcceptNoDrawDefaultRect(ImGuiDragDropFlags_AcceptNoDrawDefaultRect),

  AcceptNoPreviewTooltip(ImGuiDragDropFlags_AcceptNoPreviewTooltip);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiDragDropFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiDragDropFlags> = Flag.enumInfo()

    actual val AcceptPeekOnly: Flag<ImGuiDragDropFlags> = Flag(ImGuiDragDropFlags_AcceptPeekOnly,
        cachedInfo)

    fun from(value: Int): ImGuiDragDropFlags = when (value) {
      ImGuiDragDropFlags_SourceNoPreviewTooltip -> SourceNoPreviewTooltip
      ImGuiDragDropFlags_SourceNoDisableHover -> SourceNoDisableHover
      ImGuiDragDropFlags_SourceNoHoldToOpenOthers -> SourceNoHoldToOpenOthers
      ImGuiDragDropFlags_SourceAllowNullID -> SourceAllowNullID
      ImGuiDragDropFlags_SourceExtern -> SourceExtern
      ImGuiDragDropFlags_SourceAutoExpirePayload -> SourceAutoExpirePayload
      ImGuiDragDropFlags_AcceptBeforeDelivery -> AcceptBeforeDelivery
      ImGuiDragDropFlags_AcceptNoDrawDefaultRect -> AcceptNoDrawDefaultRect
      ImGuiDragDropFlags_AcceptNoPreviewTooltip -> AcceptNoPreviewTooltip
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiDragDropFlags> = Flag(value, cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiDragDropFlags_
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
import kotlinx.cinterop.convert

enum class ImGuiDragDropFlags(
  override val value: cimgui.internal.ImGuiDragDropFlags
) : Flag<ImGuiDragDropFlags> {
  SourceNoPreviewTooltip(ImGuiDragDropFlags_SourceNoPreviewTooltip.convert()),

  SourceNoDisableHover(ImGuiDragDropFlags_SourceNoDisableHover.convert()),

  SourceNoHoldToOpenOthers(ImGuiDragDropFlags_SourceNoHoldToOpenOthers.convert()),

  SourceAllowNullID(ImGuiDragDropFlags_SourceAllowNullID.convert()),

  SourceExtern(ImGuiDragDropFlags_SourceExtern.convert()),

  SourceAutoExpirePayload(ImGuiDragDropFlags_SourceAutoExpirePayload.convert()),

  AcceptBeforeDelivery(ImGuiDragDropFlags_AcceptBeforeDelivery.convert()),

  AcceptNoDrawDefaultRect(ImGuiDragDropFlags_AcceptNoDrawDefaultRect.convert()),

  AcceptNoPreviewTooltip(ImGuiDragDropFlags_AcceptNoPreviewTooltip.convert());

  override val info: Flag.EnumInfo<ImGuiDragDropFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiDragDropFlags> = Flag.enumInfo()

    val AcceptPeekOnly: Flag<ImGuiDragDropFlags> = Flag(ImGuiDragDropFlags_AcceptPeekOnly.toInt(),
        cachedInfo)

    fun from(value: cimgui.internal.ImGuiDragDropFlags): ImGuiDragDropFlags = when
        (value.convert<ImGuiDragDropFlags_>()) {
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


    fun fromMultiple(value: cimgui.internal.ImGuiDragDropFlags): Flag<ImGuiDragDropFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

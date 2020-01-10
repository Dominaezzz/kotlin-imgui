package com.imgui

import cimgui.internal.ImGuiComboFlags_HeightLarge
import cimgui.internal.ImGuiComboFlags_HeightLargest
import cimgui.internal.ImGuiComboFlags_HeightMask_
import cimgui.internal.ImGuiComboFlags_HeightRegular
import cimgui.internal.ImGuiComboFlags_HeightSmall
import cimgui.internal.ImGuiComboFlags_NoArrowButton
import cimgui.internal.ImGuiComboFlags_NoPreview
import cimgui.internal.ImGuiComboFlags_PopupAlignLeft
import kotlin.Int

enum class ImGuiComboFlags(
  override val value: Int
) : Flag<ImGuiComboFlags> {
  PopupAlignLeft(ImGuiComboFlags_PopupAlignLeft.toInt()),

  HeightSmall(ImGuiComboFlags_HeightSmall.toInt()),

  HeightRegular(ImGuiComboFlags_HeightRegular.toInt()),

  HeightLarge(ImGuiComboFlags_HeightLarge.toInt()),

  HeightLargest(ImGuiComboFlags_HeightLargest.toInt()),

  NoArrowButton(ImGuiComboFlags_NoArrowButton.toInt()),

  NoPreview(ImGuiComboFlags_NoPreview.toInt());

  override val info: Flag.EnumInfo<ImGuiComboFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiComboFlags> = Flag.enumInfo()

    val HeightMask_: Flag<ImGuiComboFlags> = Flag(ImGuiComboFlags_HeightMask_.toInt(), cachedInfo)
  }
}

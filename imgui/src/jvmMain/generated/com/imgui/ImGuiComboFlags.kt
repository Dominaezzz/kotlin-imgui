package com.imgui

import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_HeightLarge
import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_HeightLargest
import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_HeightMask_
import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_HeightRegular
import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_HeightSmall
import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_NoArrowButton
import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_NoPreview
import cimgui.internal.ImGuiComboFlags_.ImGuiComboFlags_PopupAlignLeft
import kotlin.Int

actual enum class ImGuiComboFlags(
  override val value: Int
) : Flag<ImGuiComboFlags> {
  PopupAlignLeft(ImGuiComboFlags_PopupAlignLeft),

  HeightSmall(ImGuiComboFlags_HeightSmall),

  HeightRegular(ImGuiComboFlags_HeightRegular),

  HeightLarge(ImGuiComboFlags_HeightLarge),

  HeightLargest(ImGuiComboFlags_HeightLargest),

  NoArrowButton(ImGuiComboFlags_NoArrowButton),

  NoPreview(ImGuiComboFlags_NoPreview);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiComboFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiComboFlags> = Flag.enumInfo()

    actual val HeightMask_: Flag<ImGuiComboFlags> = Flag(ImGuiComboFlags_HeightMask_, cachedInfo)

    fun from(value: Int): ImGuiComboFlags = when (value) {
      ImGuiComboFlags_PopupAlignLeft -> PopupAlignLeft
      ImGuiComboFlags_HeightSmall -> HeightSmall
      ImGuiComboFlags_HeightRegular -> HeightRegular
      ImGuiComboFlags_HeightLarge -> HeightLarge
      ImGuiComboFlags_HeightLargest -> HeightLargest
      ImGuiComboFlags_NoArrowButton -> NoArrowButton
      ImGuiComboFlags_NoPreview -> NoPreview
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiComboFlags> = Flag(value, cachedInfo)
  }
}

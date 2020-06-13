package com.imgui

import cimgui.internal.ImGuiComboFlags_
import cimgui.internal.ImGuiComboFlags_HeightLarge
import cimgui.internal.ImGuiComboFlags_HeightLargest
import cimgui.internal.ImGuiComboFlags_HeightMask_
import cimgui.internal.ImGuiComboFlags_HeightRegular
import cimgui.internal.ImGuiComboFlags_HeightSmall
import cimgui.internal.ImGuiComboFlags_NoArrowButton
import cimgui.internal.ImGuiComboFlags_NoPreview
import cimgui.internal.ImGuiComboFlags_PopupAlignLeft
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiComboFlags(
  override val value: cimgui.internal.ImGuiComboFlags
) : Flag<ImGuiComboFlags> {
  PopupAlignLeft(ImGuiComboFlags_PopupAlignLeft.convert()),

  HeightSmall(ImGuiComboFlags_HeightSmall.convert()),

  HeightRegular(ImGuiComboFlags_HeightRegular.convert()),

  HeightLarge(ImGuiComboFlags_HeightLarge.convert()),

  HeightLargest(ImGuiComboFlags_HeightLargest.convert()),

  NoArrowButton(ImGuiComboFlags_NoArrowButton.convert()),

  NoPreview(ImGuiComboFlags_NoPreview.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiComboFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiComboFlags> = Flag.enumInfo()

    actual val HeightMask_: Flag<ImGuiComboFlags> = Flag(ImGuiComboFlags_HeightMask_.toInt(),
        cachedInfo)

    fun from(value: cimgui.internal.ImGuiComboFlags): ImGuiComboFlags = when
        (value.convert<ImGuiComboFlags_>()) {
      ImGuiComboFlags_PopupAlignLeft -> PopupAlignLeft
      ImGuiComboFlags_HeightSmall -> HeightSmall
      ImGuiComboFlags_HeightRegular -> HeightRegular
      ImGuiComboFlags_HeightLarge -> HeightLarge
      ImGuiComboFlags_HeightLargest -> HeightLargest
      ImGuiComboFlags_NoArrowButton -> NoArrowButton
      ImGuiComboFlags_NoPreview -> NoPreview
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiComboFlags): Flag<ImGuiComboFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

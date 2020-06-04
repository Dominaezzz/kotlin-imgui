package com.imgui

import cimgui.internal.ImGuiSliderFlags_
import cimgui.internal.ImGuiSliderFlags_Vertical
import kotlinx.cinterop.convert

actual enum class ImGuiSliderFlags(
  override val value: cimgui.internal.ImGuiSliderFlags
) : Flag<ImGuiSliderFlags> {
  Vertical(ImGuiSliderFlags_Vertical.convert());

  override val info: Flag.EnumInfo<ImGuiSliderFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiSliderFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiSliderFlags): ImGuiSliderFlags = when
        (value.convert<ImGuiSliderFlags_>()) {
      ImGuiSliderFlags_Vertical -> Vertical
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiSliderFlags): Flag<ImGuiSliderFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

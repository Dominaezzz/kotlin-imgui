package com.imgui

import cimgui.internal.ImGuiSliderFlags_.ImGuiSliderFlags_Vertical
import kotlin.Int

actual enum class ImGuiSliderFlags(
  override val value: Int
) : Flag<ImGuiSliderFlags> {
  Vertical(ImGuiSliderFlags_Vertical);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiSliderFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiSliderFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiSliderFlags = when (value) {
      ImGuiSliderFlags_Vertical -> Vertical
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiSliderFlags> = Flag(value, cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiTooltipFlags_.ImGuiTooltipFlags_OverridePreviousTooltip
import kotlin.Int

actual enum class ImGuiTooltipFlags(
  override val value: Int
) : Flag<ImGuiTooltipFlags> {
  OverridePreviousTooltip(ImGuiTooltipFlags_OverridePreviousTooltip);

  override val info: Flag.EnumInfo<ImGuiTooltipFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTooltipFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiTooltipFlags = when (value) {
      ImGuiTooltipFlags_OverridePreviousTooltip -> OverridePreviousTooltip
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiTooltipFlags> = Flag(value, cachedInfo)
  }
}

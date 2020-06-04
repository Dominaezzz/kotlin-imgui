package com.imgui

import cimgui.internal.ImGuiTooltipFlags_
import cimgui.internal.ImGuiTooltipFlags_OverridePreviousTooltip
import kotlinx.cinterop.convert

actual enum class ImGuiTooltipFlags(
  override val value: cimgui.internal.ImGuiTooltipFlags
) : Flag<ImGuiTooltipFlags> {
  OverridePreviousTooltip(ImGuiTooltipFlags_OverridePreviousTooltip.convert());

  override val info: Flag.EnumInfo<ImGuiTooltipFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTooltipFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiTooltipFlags): ImGuiTooltipFlags = when
        (value.convert<ImGuiTooltipFlags_>()) {
      ImGuiTooltipFlags_OverridePreviousTooltip -> OverridePreviousTooltip
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiTooltipFlags): Flag<ImGuiTooltipFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

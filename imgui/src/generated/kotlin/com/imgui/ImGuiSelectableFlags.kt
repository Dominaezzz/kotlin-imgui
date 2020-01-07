package com.imgui

import cimgui.internal.ImGuiSelectableFlags_AllowDoubleClick
import cimgui.internal.ImGuiSelectableFlags_AllowItemOverlap
import cimgui.internal.ImGuiSelectableFlags_Disabled
import cimgui.internal.ImGuiSelectableFlags_DontClosePopups
import cimgui.internal.ImGuiSelectableFlags_SpanAllColumns
import kotlin.Int

enum class ImGuiSelectableFlags(
  override val value: Int
) : Flag<ImGuiSelectableFlags> {
  DontClosePopups(ImGuiSelectableFlags_DontClosePopups.toInt()),

  SpanAllColumns(ImGuiSelectableFlags_SpanAllColumns.toInt()),

  AllowDoubleClick(ImGuiSelectableFlags_AllowDoubleClick.toInt()),

  Disabled(ImGuiSelectableFlags_Disabled.toInt()),

  AllowItemOverlap(ImGuiSelectableFlags_AllowItemOverlap.toInt());

  override val info: Flag.EnumInfo<ImGuiSelectableFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiSelectableFlags> = Flag.enumInfo()
  }
}

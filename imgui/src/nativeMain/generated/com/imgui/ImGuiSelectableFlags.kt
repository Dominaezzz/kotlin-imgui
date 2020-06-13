package com.imgui

import cimgui.internal.ImGuiSelectableFlags_
import cimgui.internal.ImGuiSelectableFlags_AllowDoubleClick
import cimgui.internal.ImGuiSelectableFlags_AllowItemOverlap
import cimgui.internal.ImGuiSelectableFlags_Disabled
import cimgui.internal.ImGuiSelectableFlags_DontClosePopups
import cimgui.internal.ImGuiSelectableFlags_SpanAllColumns
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiSelectableFlags(
  override val value: cimgui.internal.ImGuiSelectableFlags
) : Flag<ImGuiSelectableFlags> {
  DontClosePopups(ImGuiSelectableFlags_DontClosePopups.convert()),

  SpanAllColumns(ImGuiSelectableFlags_SpanAllColumns.convert()),

  AllowDoubleClick(ImGuiSelectableFlags_AllowDoubleClick.convert()),

  Disabled(ImGuiSelectableFlags_Disabled.convert()),

  AllowItemOverlap(ImGuiSelectableFlags_AllowItemOverlap.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiSelectableFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiSelectableFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiSelectableFlags): ImGuiSelectableFlags = when
        (value.convert<ImGuiSelectableFlags_>()) {
      ImGuiSelectableFlags_DontClosePopups -> DontClosePopups
      ImGuiSelectableFlags_SpanAllColumns -> SpanAllColumns
      ImGuiSelectableFlags_AllowDoubleClick -> AllowDoubleClick
      ImGuiSelectableFlags_Disabled -> Disabled
      ImGuiSelectableFlags_AllowItemOverlap -> AllowItemOverlap
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiSelectableFlags): Flag<ImGuiSelectableFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

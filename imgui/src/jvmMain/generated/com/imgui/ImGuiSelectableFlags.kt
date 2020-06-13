package com.imgui

import cimgui.internal.ImGuiSelectableFlags_.ImGuiSelectableFlags_AllowDoubleClick
import cimgui.internal.ImGuiSelectableFlags_.ImGuiSelectableFlags_AllowItemOverlap
import cimgui.internal.ImGuiSelectableFlags_.ImGuiSelectableFlags_Disabled
import cimgui.internal.ImGuiSelectableFlags_.ImGuiSelectableFlags_DontClosePopups
import cimgui.internal.ImGuiSelectableFlags_.ImGuiSelectableFlags_SpanAllColumns
import kotlin.Int

actual enum class ImGuiSelectableFlags(
  override val value: Int
) : Flag<ImGuiSelectableFlags> {
  DontClosePopups(ImGuiSelectableFlags_DontClosePopups),

  SpanAllColumns(ImGuiSelectableFlags_SpanAllColumns),

  AllowDoubleClick(ImGuiSelectableFlags_AllowDoubleClick),

  Disabled(ImGuiSelectableFlags_Disabled),

  AllowItemOverlap(ImGuiSelectableFlags_AllowItemOverlap);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiSelectableFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiSelectableFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiSelectableFlags = when (value) {
      ImGuiSelectableFlags_DontClosePopups -> DontClosePopups
      ImGuiSelectableFlags_SpanAllColumns -> SpanAllColumns
      ImGuiSelectableFlags_AllowDoubleClick -> AllowDoubleClick
      ImGuiSelectableFlags_Disabled -> Disabled
      ImGuiSelectableFlags_AllowItemOverlap -> AllowItemOverlap
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiSelectableFlags> = Flag(value, cachedInfo)
  }
}

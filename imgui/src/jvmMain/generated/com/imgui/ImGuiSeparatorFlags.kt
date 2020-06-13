package com.imgui

import cimgui.internal.ImGuiSeparatorFlags_.ImGuiSeparatorFlags_Horizontal
import cimgui.internal.ImGuiSeparatorFlags_.ImGuiSeparatorFlags_SpanAllColumns
import cimgui.internal.ImGuiSeparatorFlags_.ImGuiSeparatorFlags_Vertical
import kotlin.Int

actual enum class ImGuiSeparatorFlags(
  override val value: Int
) : Flag<ImGuiSeparatorFlags> {
  Horizontal(ImGuiSeparatorFlags_Horizontal),

  Vertical(ImGuiSeparatorFlags_Vertical),

  SpanAllColumns(ImGuiSeparatorFlags_SpanAllColumns);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiSeparatorFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiSeparatorFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiSeparatorFlags = when (value) {
      ImGuiSeparatorFlags_Horizontal -> Horizontal
      ImGuiSeparatorFlags_Vertical -> Vertical
      ImGuiSeparatorFlags_SpanAllColumns -> SpanAllColumns
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiSeparatorFlags> = Flag(value, cachedInfo)
  }
}

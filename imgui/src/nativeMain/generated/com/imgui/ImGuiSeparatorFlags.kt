package com.imgui

import cimgui.internal.ImGuiSeparatorFlags_
import cimgui.internal.ImGuiSeparatorFlags_Horizontal
import cimgui.internal.ImGuiSeparatorFlags_SpanAllColumns
import cimgui.internal.ImGuiSeparatorFlags_Vertical
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiSeparatorFlags(
  override val value: cimgui.internal.ImGuiSeparatorFlags
) : Flag<ImGuiSeparatorFlags> {
  Horizontal(ImGuiSeparatorFlags_Horizontal.convert()),

  Vertical(ImGuiSeparatorFlags_Vertical.convert()),

  SpanAllColumns(ImGuiSeparatorFlags_SpanAllColumns.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiSeparatorFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiSeparatorFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiSeparatorFlags): ImGuiSeparatorFlags = when
        (value.convert<ImGuiSeparatorFlags_>()) {
      ImGuiSeparatorFlags_Horizontal -> Horizontal
      ImGuiSeparatorFlags_Vertical -> Vertical
      ImGuiSeparatorFlags_SpanAllColumns -> SpanAllColumns
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiSeparatorFlags): Flag<ImGuiSeparatorFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

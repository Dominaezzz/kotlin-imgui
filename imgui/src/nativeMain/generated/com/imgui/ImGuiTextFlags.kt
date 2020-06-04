package com.imgui

import cimgui.internal.ImGuiTextFlags_
import cimgui.internal.ImGuiTextFlags_NoWidthForLargeClippedText
import kotlinx.cinterop.convert

actual enum class ImGuiTextFlags(
  override val value: cimgui.internal.ImGuiTextFlags
) : Flag<ImGuiTextFlags> {
  NoWidthForLargeClippedText(ImGuiTextFlags_NoWidthForLargeClippedText.convert());

  override val info: Flag.EnumInfo<ImGuiTextFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTextFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiTextFlags): ImGuiTextFlags = when
        (value.convert<ImGuiTextFlags_>()) {
      ImGuiTextFlags_NoWidthForLargeClippedText -> NoWidthForLargeClippedText
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiTextFlags): Flag<ImGuiTextFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

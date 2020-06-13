package com.imgui

import cimgui.internal.ImGuiTextFlags_.ImGuiTextFlags_NoWidthForLargeClippedText
import kotlin.Int

actual enum class ImGuiTextFlags(
  override val value: Int
) : Flag<ImGuiTextFlags> {
  NoWidthForLargeClippedText(ImGuiTextFlags_NoWidthForLargeClippedText);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiTextFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTextFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiTextFlags = when (value) {
      ImGuiTextFlags_NoWidthForLargeClippedText -> NoWidthForLargeClippedText
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiTextFlags> = Flag(value, cachedInfo)
  }
}

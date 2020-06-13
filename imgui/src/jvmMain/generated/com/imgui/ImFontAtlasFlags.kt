package com.imgui

import cimgui.internal.ImFontAtlasFlags_.ImFontAtlasFlags_NoMouseCursors
import cimgui.internal.ImFontAtlasFlags_.ImFontAtlasFlags_NoPowerOfTwoHeight
import kotlin.Int

actual enum class ImFontAtlasFlags(
  override val value: Int
) : Flag<ImFontAtlasFlags> {
  NoPowerOfTwoHeight(ImFontAtlasFlags_NoPowerOfTwoHeight),

  NoMouseCursors(ImFontAtlasFlags_NoMouseCursors);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImFontAtlasFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImFontAtlasFlags> = Flag.enumInfo()

    fun from(value: Int): ImFontAtlasFlags = when (value) {
      ImFontAtlasFlags_NoPowerOfTwoHeight -> NoPowerOfTwoHeight
      ImFontAtlasFlags_NoMouseCursors -> NoMouseCursors
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImFontAtlasFlags> = Flag(value, cachedInfo)
  }
}

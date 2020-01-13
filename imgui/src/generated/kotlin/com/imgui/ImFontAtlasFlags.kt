package com.imgui

import cimgui.internal.ImFontAtlasFlags_
import cimgui.internal.ImFontAtlasFlags_NoMouseCursors
import cimgui.internal.ImFontAtlasFlags_NoPowerOfTwoHeight
import kotlinx.cinterop.convert

enum class ImFontAtlasFlags(
  override val value: cimgui.internal.ImFontAtlasFlags
) : Flag<ImFontAtlasFlags> {
  NoPowerOfTwoHeight(ImFontAtlasFlags_NoPowerOfTwoHeight.convert()),

  NoMouseCursors(ImFontAtlasFlags_NoMouseCursors.convert());

  override val info: Flag.EnumInfo<ImFontAtlasFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImFontAtlasFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImFontAtlasFlags): ImFontAtlasFlags = when
        (value.convert<ImFontAtlasFlags_>()) {
      ImFontAtlasFlags_NoPowerOfTwoHeight -> NoPowerOfTwoHeight
      ImFontAtlasFlags_NoMouseCursors -> NoMouseCursors
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }


    fun fromMultiple(value: cimgui.internal.ImFontAtlasFlags): Flag<ImFontAtlasFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

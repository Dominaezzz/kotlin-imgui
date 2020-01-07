package com.imgui

import cimgui.internal.ImFontAtlasFlags_NoMouseCursors
import cimgui.internal.ImFontAtlasFlags_NoPowerOfTwoHeight
import kotlin.Int

enum class ImFontAtlasFlags(
  override val value: Int
) : Flag<ImFontAtlasFlags> {
  NoPowerOfTwoHeight(ImFontAtlasFlags_NoPowerOfTwoHeight.toInt()),

  NoMouseCursors(ImFontAtlasFlags_NoMouseCursors.toInt());

  override val info: Flag.EnumInfo<ImFontAtlasFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImFontAtlasFlags> = Flag.enumInfo()
  }
}

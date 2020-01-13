package com.imgui

import cimgui.internal.ImDrawListFlags_
import cimgui.internal.ImDrawListFlags_AllowVtxOffset
import cimgui.internal.ImDrawListFlags_AntiAliasedFill
import cimgui.internal.ImDrawListFlags_AntiAliasedLines
import kotlinx.cinterop.convert

enum class ImDrawListFlags(
  override val value: cimgui.internal.ImDrawListFlags
) : Flag<ImDrawListFlags> {
  AntiAliasedLines(ImDrawListFlags_AntiAliasedLines.convert()),

  AntiAliasedFill(ImDrawListFlags_AntiAliasedFill.convert()),

  AllowVtxOffset(ImDrawListFlags_AllowVtxOffset.convert());

  override val info: Flag.EnumInfo<ImDrawListFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImDrawListFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImDrawListFlags): ImDrawListFlags = when
        (value.convert<ImDrawListFlags_>()) {
      ImDrawListFlags_AntiAliasedLines -> AntiAliasedLines
      ImDrawListFlags_AntiAliasedFill -> AntiAliasedFill
      ImDrawListFlags_AllowVtxOffset -> AllowVtxOffset
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }


    fun fromMultiple(value: cimgui.internal.ImDrawListFlags): Flag<ImDrawListFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

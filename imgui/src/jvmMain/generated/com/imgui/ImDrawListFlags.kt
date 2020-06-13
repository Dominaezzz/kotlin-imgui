package com.imgui

import cimgui.internal.ImDrawListFlags_.ImDrawListFlags_AllowVtxOffset
import cimgui.internal.ImDrawListFlags_.ImDrawListFlags_AntiAliasedFill
import cimgui.internal.ImDrawListFlags_.ImDrawListFlags_AntiAliasedLines
import kotlin.Int

actual enum class ImDrawListFlags(
  override val value: Int
) : Flag<ImDrawListFlags> {
  AntiAliasedLines(ImDrawListFlags_AntiAliasedLines),

  AntiAliasedFill(ImDrawListFlags_AntiAliasedFill),

  AllowVtxOffset(ImDrawListFlags_AllowVtxOffset);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImDrawListFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImDrawListFlags> = Flag.enumInfo()

    fun from(value: Int): ImDrawListFlags = when (value) {
      ImDrawListFlags_AntiAliasedLines -> AntiAliasedLines
      ImDrawListFlags_AntiAliasedFill -> AntiAliasedFill
      ImDrawListFlags_AllowVtxOffset -> AllowVtxOffset
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImDrawListFlags> = Flag(value, cachedInfo)
  }
}

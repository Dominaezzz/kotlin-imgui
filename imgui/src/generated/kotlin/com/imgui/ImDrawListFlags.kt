package com.imgui

import cimgui.internal.ImDrawListFlags_AllowVtxOffset
import cimgui.internal.ImDrawListFlags_AntiAliasedFill
import cimgui.internal.ImDrawListFlags_AntiAliasedLines
import kotlin.Int

enum class ImDrawListFlags(
  override val value: Int
) : Flag<ImDrawListFlags> {
  AntiAliasedLines(ImDrawListFlags_AntiAliasedLines.toInt()),

  AntiAliasedFill(ImDrawListFlags_AntiAliasedFill.toInt()),

  AllowVtxOffset(ImDrawListFlags_AllowVtxOffset.toInt());

  override val info: Flag.EnumInfo<ImDrawListFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImDrawListFlags> = Flag.enumInfo()
  }
}

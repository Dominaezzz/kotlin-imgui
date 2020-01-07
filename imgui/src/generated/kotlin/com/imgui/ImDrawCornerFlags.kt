package com.imgui

import cimgui.internal.ImDrawCornerFlags_BotLeft
import cimgui.internal.ImDrawCornerFlags_BotRight
import cimgui.internal.ImDrawCornerFlags_TopLeft
import cimgui.internal.ImDrawCornerFlags_TopRight
import kotlin.Int

enum class ImDrawCornerFlags(
  override val value: Int
) : Flag<ImDrawCornerFlags> {
  TopLeft(ImDrawCornerFlags_TopLeft.toInt()),

  TopRight(ImDrawCornerFlags_TopRight.toInt()),

  BotLeft(ImDrawCornerFlags_BotLeft.toInt()),

  BotRight(ImDrawCornerFlags_BotRight.toInt());

  override val info: Flag.EnumInfo<ImDrawCornerFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImDrawCornerFlags> = Flag.enumInfo()
  }
}

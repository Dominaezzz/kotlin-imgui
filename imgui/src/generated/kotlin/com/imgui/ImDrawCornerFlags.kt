package com.imgui

import cimgui.internal.ImDrawCornerFlags_All
import cimgui.internal.ImDrawCornerFlags_Bot
import cimgui.internal.ImDrawCornerFlags_BotLeft
import cimgui.internal.ImDrawCornerFlags_BotRight
import cimgui.internal.ImDrawCornerFlags_Left
import cimgui.internal.ImDrawCornerFlags_Right
import cimgui.internal.ImDrawCornerFlags_Top
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

    val Top: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Top.toInt(), cachedInfo)

    val Bot: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Bot.toInt(), cachedInfo)

    val Left: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Left.toInt(), cachedInfo)

    val Right: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Right.toInt(), cachedInfo)

    val All: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_All.toInt(), cachedInfo)
  }
}

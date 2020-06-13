package com.imgui

import cimgui.internal.ImDrawCornerFlags_
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
import kotlinx.cinterop.convert

actual enum class ImDrawCornerFlags(
  override val value: cimgui.internal.ImDrawCornerFlags
) : Flag<ImDrawCornerFlags> {
  TopLeft(ImDrawCornerFlags_TopLeft.convert()),

  TopRight(ImDrawCornerFlags_TopRight.convert()),

  BotLeft(ImDrawCornerFlags_BotLeft.convert()),

  BotRight(ImDrawCornerFlags_BotRight.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImDrawCornerFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImDrawCornerFlags> = Flag.enumInfo()

    actual val Top: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Top.toInt(), cachedInfo)

    actual val Bot: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Bot.toInt(), cachedInfo)

    actual val Left: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Left.toInt(), cachedInfo)

    actual val Right: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Right.toInt(), cachedInfo)

    actual val All: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_All.toInt(), cachedInfo)

    fun from(value: cimgui.internal.ImDrawCornerFlags): ImDrawCornerFlags = when
        (value.convert<ImDrawCornerFlags_>()) {
      ImDrawCornerFlags_TopLeft -> TopLeft
      ImDrawCornerFlags_TopRight -> TopRight
      ImDrawCornerFlags_BotLeft -> BotLeft
      ImDrawCornerFlags_BotRight -> BotRight
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImDrawCornerFlags): Flag<ImDrawCornerFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

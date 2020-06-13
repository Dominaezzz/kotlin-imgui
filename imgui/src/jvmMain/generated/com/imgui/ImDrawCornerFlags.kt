package com.imgui

import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_All
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_Bot
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_BotLeft
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_BotRight
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_Left
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_Right
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_Top
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_TopLeft
import cimgui.internal.ImDrawCornerFlags_.ImDrawCornerFlags_TopRight
import kotlin.Int

actual enum class ImDrawCornerFlags(
  override val value: Int
) : Flag<ImDrawCornerFlags> {
  TopLeft(ImDrawCornerFlags_TopLeft),

  TopRight(ImDrawCornerFlags_TopRight),

  BotLeft(ImDrawCornerFlags_BotLeft),

  BotRight(ImDrawCornerFlags_BotRight);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImDrawCornerFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImDrawCornerFlags> = Flag.enumInfo()

    actual val Top: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Top, cachedInfo)

    actual val Bot: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Bot, cachedInfo)

    actual val Left: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Left, cachedInfo)

    actual val Right: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_Right, cachedInfo)

    actual val All: Flag<ImDrawCornerFlags> = Flag(ImDrawCornerFlags_All, cachedInfo)

    fun from(value: Int): ImDrawCornerFlags = when (value) {
      ImDrawCornerFlags_TopLeft -> TopLeft
      ImDrawCornerFlags_TopRight -> TopRight
      ImDrawCornerFlags_BotLeft -> BotLeft
      ImDrawCornerFlags_BotRight -> BotRight
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImDrawCornerFlags> = Flag(value, cachedInfo)
  }
}

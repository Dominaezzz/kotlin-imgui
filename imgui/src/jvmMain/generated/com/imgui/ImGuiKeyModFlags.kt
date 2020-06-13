package com.imgui

import cimgui.internal.ImGuiKeyModFlags_.ImGuiKeyModFlags_Alt
import cimgui.internal.ImGuiKeyModFlags_.ImGuiKeyModFlags_Ctrl
import cimgui.internal.ImGuiKeyModFlags_.ImGuiKeyModFlags_Shift
import cimgui.internal.ImGuiKeyModFlags_.ImGuiKeyModFlags_Super
import kotlin.Int

actual enum class ImGuiKeyModFlags(
  override val value: Int
) : Flag<ImGuiKeyModFlags> {
  Ctrl(ImGuiKeyModFlags_Ctrl),

  Shift(ImGuiKeyModFlags_Shift),

  Alt(ImGuiKeyModFlags_Alt),

  Super(ImGuiKeyModFlags_Super);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiKeyModFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiKeyModFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiKeyModFlags = when (value) {
      ImGuiKeyModFlags_Ctrl -> Ctrl
      ImGuiKeyModFlags_Shift -> Shift
      ImGuiKeyModFlags_Alt -> Alt
      ImGuiKeyModFlags_Super -> Super
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiKeyModFlags> = Flag(value, cachedInfo)
  }
}

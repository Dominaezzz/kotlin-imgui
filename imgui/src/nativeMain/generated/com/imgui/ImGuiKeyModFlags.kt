package com.imgui

import cimgui.internal.ImGuiKeyModFlags_
import cimgui.internal.ImGuiKeyModFlags_Alt
import cimgui.internal.ImGuiKeyModFlags_Ctrl
import cimgui.internal.ImGuiKeyModFlags_Shift
import cimgui.internal.ImGuiKeyModFlags_Super
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiKeyModFlags(
  override val value: cimgui.internal.ImGuiKeyModFlags
) : Flag<ImGuiKeyModFlags> {
  Ctrl(ImGuiKeyModFlags_Ctrl.convert()),

  Shift(ImGuiKeyModFlags_Shift.convert()),

  Alt(ImGuiKeyModFlags_Alt.convert()),

  Super(ImGuiKeyModFlags_Super.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiKeyModFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiKeyModFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiKeyModFlags): ImGuiKeyModFlags = when
        (value.convert<ImGuiKeyModFlags_>()) {
      ImGuiKeyModFlags_Ctrl -> Ctrl
      ImGuiKeyModFlags_Shift -> Shift
      ImGuiKeyModFlags_Alt -> Alt
      ImGuiKeyModFlags_Super -> Super
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiKeyModFlags): Flag<ImGuiKeyModFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

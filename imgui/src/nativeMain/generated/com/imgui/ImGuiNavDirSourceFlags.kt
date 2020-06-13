package com.imgui

import cimgui.internal.ImGuiNavDirSourceFlags_
import cimgui.internal.ImGuiNavDirSourceFlags_Keyboard
import cimgui.internal.ImGuiNavDirSourceFlags_PadDPad
import cimgui.internal.ImGuiNavDirSourceFlags_PadLStick
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiNavDirSourceFlags(
  override val value: cimgui.internal.ImGuiNavDirSourceFlags
) : Flag<ImGuiNavDirSourceFlags> {
  Keyboard(ImGuiNavDirSourceFlags_Keyboard.convert()),

  PadDPad(ImGuiNavDirSourceFlags_PadDPad.convert()),

  PadLStick(ImGuiNavDirSourceFlags_PadLStick.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiNavDirSourceFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNavDirSourceFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiNavDirSourceFlags): ImGuiNavDirSourceFlags = when
        (value.convert<ImGuiNavDirSourceFlags_>()) {
      ImGuiNavDirSourceFlags_Keyboard -> Keyboard
      ImGuiNavDirSourceFlags_PadDPad -> PadDPad
      ImGuiNavDirSourceFlags_PadLStick -> PadLStick
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiNavDirSourceFlags): Flag<ImGuiNavDirSourceFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

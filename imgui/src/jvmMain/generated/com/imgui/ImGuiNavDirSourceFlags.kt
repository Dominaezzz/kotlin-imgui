package com.imgui

import cimgui.internal.ImGuiNavDirSourceFlags_.ImGuiNavDirSourceFlags_Keyboard
import cimgui.internal.ImGuiNavDirSourceFlags_.ImGuiNavDirSourceFlags_PadDPad
import cimgui.internal.ImGuiNavDirSourceFlags_.ImGuiNavDirSourceFlags_PadLStick
import kotlin.Int

actual enum class ImGuiNavDirSourceFlags(
  override val value: Int
) : Flag<ImGuiNavDirSourceFlags> {
  Keyboard(ImGuiNavDirSourceFlags_Keyboard),

  PadDPad(ImGuiNavDirSourceFlags_PadDPad),

  PadLStick(ImGuiNavDirSourceFlags_PadLStick);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiNavDirSourceFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNavDirSourceFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiNavDirSourceFlags = when (value) {
      ImGuiNavDirSourceFlags_Keyboard -> Keyboard
      ImGuiNavDirSourceFlags_PadDPad -> PadDPad
      ImGuiNavDirSourceFlags_PadLStick -> PadLStick
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiNavDirSourceFlags> = Flag(value, cachedInfo)
  }
}

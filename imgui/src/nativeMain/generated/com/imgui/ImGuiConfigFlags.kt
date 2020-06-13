package com.imgui

import cimgui.internal.ImGuiConfigFlags_
import cimgui.internal.ImGuiConfigFlags_IsSRGB
import cimgui.internal.ImGuiConfigFlags_IsTouchScreen
import cimgui.internal.ImGuiConfigFlags_NavEnableGamepad
import cimgui.internal.ImGuiConfigFlags_NavEnableKeyboard
import cimgui.internal.ImGuiConfigFlags_NavEnableSetMousePos
import cimgui.internal.ImGuiConfigFlags_NavNoCaptureKeyboard
import cimgui.internal.ImGuiConfigFlags_NoMouse
import cimgui.internal.ImGuiConfigFlags_NoMouseCursorChange
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiConfigFlags(
  override val value: cimgui.internal.ImGuiConfigFlags
) : Flag<ImGuiConfigFlags> {
  NavEnableKeyboard(ImGuiConfigFlags_NavEnableKeyboard.convert()),

  NavEnableGamepad(ImGuiConfigFlags_NavEnableGamepad.convert()),

  NavEnableSetMousePos(ImGuiConfigFlags_NavEnableSetMousePos.convert()),

  NavNoCaptureKeyboard(ImGuiConfigFlags_NavNoCaptureKeyboard.convert()),

  NoMouse(ImGuiConfigFlags_NoMouse.convert()),

  NoMouseCursorChange(ImGuiConfigFlags_NoMouseCursorChange.convert()),

  IsSRGB(ImGuiConfigFlags_IsSRGB.convert()),

  IsTouchScreen(ImGuiConfigFlags_IsTouchScreen.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiConfigFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiConfigFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiConfigFlags): ImGuiConfigFlags = when
        (value.convert<ImGuiConfigFlags_>()) {
      ImGuiConfigFlags_NavEnableKeyboard -> NavEnableKeyboard
      ImGuiConfigFlags_NavEnableGamepad -> NavEnableGamepad
      ImGuiConfigFlags_NavEnableSetMousePos -> NavEnableSetMousePos
      ImGuiConfigFlags_NavNoCaptureKeyboard -> NavNoCaptureKeyboard
      ImGuiConfigFlags_NoMouse -> NoMouse
      ImGuiConfigFlags_NoMouseCursorChange -> NoMouseCursorChange
      ImGuiConfigFlags_IsSRGB -> IsSRGB
      ImGuiConfigFlags_IsTouchScreen -> IsTouchScreen
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiConfigFlags): Flag<ImGuiConfigFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

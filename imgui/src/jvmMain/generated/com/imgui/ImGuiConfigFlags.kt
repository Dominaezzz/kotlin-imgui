package com.imgui

import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_DockingEnable
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_DpiEnableScaleFonts
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_DpiEnableScaleViewports
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_IsSRGB
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_IsTouchScreen
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_NavEnableGamepad
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_NavEnableKeyboard
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_NavEnableSetMousePos
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_NavNoCaptureKeyboard
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_NoMouse
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_NoMouseCursorChange
import cimgui.internal.ImGuiConfigFlags_.ImGuiConfigFlags_ViewportsEnable
import kotlin.Int

actual enum class ImGuiConfigFlags(
  override val value: Int
) : Flag<ImGuiConfigFlags> {
  NavEnableKeyboard(ImGuiConfigFlags_NavEnableKeyboard),

  NavEnableGamepad(ImGuiConfigFlags_NavEnableGamepad),

  NavEnableSetMousePos(ImGuiConfigFlags_NavEnableSetMousePos),

  NavNoCaptureKeyboard(ImGuiConfigFlags_NavNoCaptureKeyboard),

  NoMouse(ImGuiConfigFlags_NoMouse),

  NoMouseCursorChange(ImGuiConfigFlags_NoMouseCursorChange),

  DockingEnable(ImGuiConfigFlags_DockingEnable),

  ViewportsEnable(ImGuiConfigFlags_ViewportsEnable),

  DpiEnableScaleViewports(ImGuiConfigFlags_DpiEnableScaleViewports),

  DpiEnableScaleFonts(ImGuiConfigFlags_DpiEnableScaleFonts),

  IsSRGB(ImGuiConfigFlags_IsSRGB),

  IsTouchScreen(ImGuiConfigFlags_IsTouchScreen);

  override val info: Flag.EnumInfo<ImGuiConfigFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiConfigFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiConfigFlags = when (value) {
      ImGuiConfigFlags_NavEnableKeyboard -> NavEnableKeyboard
      ImGuiConfigFlags_NavEnableGamepad -> NavEnableGamepad
      ImGuiConfigFlags_NavEnableSetMousePos -> NavEnableSetMousePos
      ImGuiConfigFlags_NavNoCaptureKeyboard -> NavNoCaptureKeyboard
      ImGuiConfigFlags_NoMouse -> NoMouse
      ImGuiConfigFlags_NoMouseCursorChange -> NoMouseCursorChange
      ImGuiConfigFlags_DockingEnable -> DockingEnable
      ImGuiConfigFlags_ViewportsEnable -> ViewportsEnable
      ImGuiConfigFlags_DpiEnableScaleViewports -> DpiEnableScaleViewports
      ImGuiConfigFlags_DpiEnableScaleFonts -> DpiEnableScaleFonts
      ImGuiConfigFlags_IsSRGB -> IsSRGB
      ImGuiConfigFlags_IsTouchScreen -> IsTouchScreen
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiConfigFlags> = Flag(value, cachedInfo)
  }
}

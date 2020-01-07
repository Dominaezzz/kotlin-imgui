package com.imgui

import cimgui.internal.ImGuiConfigFlags_IsSRGB
import cimgui.internal.ImGuiConfigFlags_IsTouchScreen
import cimgui.internal.ImGuiConfigFlags_NavEnableGamepad
import cimgui.internal.ImGuiConfigFlags_NavEnableKeyboard
import cimgui.internal.ImGuiConfigFlags_NavEnableSetMousePos
import cimgui.internal.ImGuiConfigFlags_NavNoCaptureKeyboard
import cimgui.internal.ImGuiConfigFlags_NoMouse
import cimgui.internal.ImGuiConfigFlags_NoMouseCursorChange
import kotlin.Int

enum class ImGuiConfigFlags(
  override val value: Int
) : Flag<ImGuiConfigFlags> {
  NavEnableKeyboard(ImGuiConfigFlags_NavEnableKeyboard.toInt()),

  NavEnableGamepad(ImGuiConfigFlags_NavEnableGamepad.toInt()),

  NavEnableSetMousePos(ImGuiConfigFlags_NavEnableSetMousePos.toInt()),

  NavNoCaptureKeyboard(ImGuiConfigFlags_NavNoCaptureKeyboard.toInt()),

  NoMouse(ImGuiConfigFlags_NoMouse.toInt()),

  NoMouseCursorChange(ImGuiConfigFlags_NoMouseCursorChange.toInt()),

  IsSRGB(ImGuiConfigFlags_IsSRGB.toInt()),

  IsTouchScreen(ImGuiConfigFlags_IsTouchScreen.toInt());

  override val info: Flag.EnumInfo<ImGuiConfigFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiConfigFlags> = Flag.enumInfo()
  }
}

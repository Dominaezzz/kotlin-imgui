package com.imgui

import cimgui.internal.ImGuiColorEditFlags_AlphaBar
import cimgui.internal.ImGuiColorEditFlags_AlphaPreview
import cimgui.internal.ImGuiColorEditFlags_AlphaPreviewHalf
import cimgui.internal.ImGuiColorEditFlags_DisplayHSV
import cimgui.internal.ImGuiColorEditFlags_DisplayHex
import cimgui.internal.ImGuiColorEditFlags_DisplayRGB
import cimgui.internal.ImGuiColorEditFlags_Float
import cimgui.internal.ImGuiColorEditFlags_HDR
import cimgui.internal.ImGuiColorEditFlags_InputHSV
import cimgui.internal.ImGuiColorEditFlags_InputRGB
import cimgui.internal.ImGuiColorEditFlags_NoAlpha
import cimgui.internal.ImGuiColorEditFlags_NoDragDrop
import cimgui.internal.ImGuiColorEditFlags_NoInputs
import cimgui.internal.ImGuiColorEditFlags_NoLabel
import cimgui.internal.ImGuiColorEditFlags_NoOptions
import cimgui.internal.ImGuiColorEditFlags_NoPicker
import cimgui.internal.ImGuiColorEditFlags_NoSidePreview
import cimgui.internal.ImGuiColorEditFlags_NoSmallPreview
import cimgui.internal.ImGuiColorEditFlags_NoTooltip
import cimgui.internal.ImGuiColorEditFlags_PickerHueBar
import cimgui.internal.ImGuiColorEditFlags_PickerHueWheel
import cimgui.internal.ImGuiColorEditFlags_Uint8
import kotlin.Int

enum class ImGuiColorEditFlags(
  override val value: Int
) : Flag<ImGuiColorEditFlags> {
  NoAlpha(ImGuiColorEditFlags_NoAlpha.toInt()),

  NoPicker(ImGuiColorEditFlags_NoPicker.toInt()),

  NoOptions(ImGuiColorEditFlags_NoOptions.toInt()),

  NoSmallPreview(ImGuiColorEditFlags_NoSmallPreview.toInt()),

  NoInputs(ImGuiColorEditFlags_NoInputs.toInt()),

  NoTooltip(ImGuiColorEditFlags_NoTooltip.toInt()),

  NoLabel(ImGuiColorEditFlags_NoLabel.toInt()),

  NoSidePreview(ImGuiColorEditFlags_NoSidePreview.toInt()),

  NoDragDrop(ImGuiColorEditFlags_NoDragDrop.toInt()),

  AlphaBar(ImGuiColorEditFlags_AlphaBar.toInt()),

  AlphaPreview(ImGuiColorEditFlags_AlphaPreview.toInt()),

  AlphaPreviewHalf(ImGuiColorEditFlags_AlphaPreviewHalf.toInt()),

  HDR(ImGuiColorEditFlags_HDR.toInt()),

  DisplayRGB(ImGuiColorEditFlags_DisplayRGB.toInt()),

  DisplayHSV(ImGuiColorEditFlags_DisplayHSV.toInt()),

  DisplayHex(ImGuiColorEditFlags_DisplayHex.toInt()),

  Uint8(ImGuiColorEditFlags_Uint8.toInt()),

  Float(ImGuiColorEditFlags_Float.toInt()),

  PickerHueBar(ImGuiColorEditFlags_PickerHueBar.toInt()),

  PickerHueWheel(ImGuiColorEditFlags_PickerHueWheel.toInt()),

  InputRGB(ImGuiColorEditFlags_InputRGB.toInt()),

  InputHSV(ImGuiColorEditFlags_InputHSV.toInt());

  override val info: Flag.EnumInfo<ImGuiColorEditFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiColorEditFlags> = Flag.enumInfo()
  }
}

package com.imgui

import cimgui.internal.ImGuiColorEditFlags_
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
import kotlinx.cinterop.convert

enum class ImGuiColorEditFlags(
  override val value: cimgui.internal.ImGuiColorEditFlags
) : Flag<ImGuiColorEditFlags> {
  NoAlpha(ImGuiColorEditFlags_NoAlpha.convert()),

  NoPicker(ImGuiColorEditFlags_NoPicker.convert()),

  NoOptions(ImGuiColorEditFlags_NoOptions.convert()),

  NoSmallPreview(ImGuiColorEditFlags_NoSmallPreview.convert()),

  NoInputs(ImGuiColorEditFlags_NoInputs.convert()),

  NoTooltip(ImGuiColorEditFlags_NoTooltip.convert()),

  NoLabel(ImGuiColorEditFlags_NoLabel.convert()),

  NoSidePreview(ImGuiColorEditFlags_NoSidePreview.convert()),

  NoDragDrop(ImGuiColorEditFlags_NoDragDrop.convert()),

  AlphaBar(ImGuiColorEditFlags_AlphaBar.convert()),

  AlphaPreview(ImGuiColorEditFlags_AlphaPreview.convert()),

  AlphaPreviewHalf(ImGuiColorEditFlags_AlphaPreviewHalf.convert()),

  HDR(ImGuiColorEditFlags_HDR.convert()),

  DisplayRGB(ImGuiColorEditFlags_DisplayRGB.convert()),

  DisplayHSV(ImGuiColorEditFlags_DisplayHSV.convert()),

  DisplayHex(ImGuiColorEditFlags_DisplayHex.convert()),

  Uint8(ImGuiColorEditFlags_Uint8.convert()),

  Float(ImGuiColorEditFlags_Float.convert()),

  PickerHueBar(ImGuiColorEditFlags_PickerHueBar.convert()),

  PickerHueWheel(ImGuiColorEditFlags_PickerHueWheel.convert()),

  InputRGB(ImGuiColorEditFlags_InputRGB.convert()),

  InputHSV(ImGuiColorEditFlags_InputHSV.convert());

  override val info: Flag.EnumInfo<ImGuiColorEditFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiColorEditFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiColorEditFlags): ImGuiColorEditFlags = when
        (value.convert<ImGuiColorEditFlags_>()) {
      ImGuiColorEditFlags_NoAlpha -> NoAlpha
      ImGuiColorEditFlags_NoPicker -> NoPicker
      ImGuiColorEditFlags_NoOptions -> NoOptions
      ImGuiColorEditFlags_NoSmallPreview -> NoSmallPreview
      ImGuiColorEditFlags_NoInputs -> NoInputs
      ImGuiColorEditFlags_NoTooltip -> NoTooltip
      ImGuiColorEditFlags_NoLabel -> NoLabel
      ImGuiColorEditFlags_NoSidePreview -> NoSidePreview
      ImGuiColorEditFlags_NoDragDrop -> NoDragDrop
      ImGuiColorEditFlags_AlphaBar -> AlphaBar
      ImGuiColorEditFlags_AlphaPreview -> AlphaPreview
      ImGuiColorEditFlags_AlphaPreviewHalf -> AlphaPreviewHalf
      ImGuiColorEditFlags_HDR -> HDR
      ImGuiColorEditFlags_DisplayRGB -> DisplayRGB
      ImGuiColorEditFlags_DisplayHSV -> DisplayHSV
      ImGuiColorEditFlags_DisplayHex -> DisplayHex
      ImGuiColorEditFlags_Uint8 -> Uint8
      ImGuiColorEditFlags_Float -> Float
      ImGuiColorEditFlags_PickerHueBar -> PickerHueBar
      ImGuiColorEditFlags_PickerHueWheel -> PickerHueWheel
      ImGuiColorEditFlags_InputRGB -> InputRGB
      ImGuiColorEditFlags_InputHSV -> InputHSV
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }


    fun fromMultiple(value: cimgui.internal.ImGuiColorEditFlags): Flag<ImGuiColorEditFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

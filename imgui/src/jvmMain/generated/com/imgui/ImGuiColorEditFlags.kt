package com.imgui

import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_AlphaBar
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_AlphaPreview
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_AlphaPreviewHalf
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_DisplayHSV
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_DisplayHex
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_DisplayRGB
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_Float
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_HDR
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_InputHSV
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_InputRGB
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoAlpha
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoDragDrop
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoInputs
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoLabel
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoOptions
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoPicker
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoSidePreview
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoSmallPreview
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_NoTooltip
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_PickerHueBar
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_PickerHueWheel
import cimgui.internal.ImGuiColorEditFlags_.ImGuiColorEditFlags_Uint8
import kotlin.Int

actual enum class ImGuiColorEditFlags(
  override val value: Int
) : Flag<ImGuiColorEditFlags> {
  NoAlpha(ImGuiColorEditFlags_NoAlpha),

  NoPicker(ImGuiColorEditFlags_NoPicker),

  NoOptions(ImGuiColorEditFlags_NoOptions),

  NoSmallPreview(ImGuiColorEditFlags_NoSmallPreview),

  NoInputs(ImGuiColorEditFlags_NoInputs),

  NoTooltip(ImGuiColorEditFlags_NoTooltip),

  NoLabel(ImGuiColorEditFlags_NoLabel),

  NoSidePreview(ImGuiColorEditFlags_NoSidePreview),

  NoDragDrop(ImGuiColorEditFlags_NoDragDrop),

  AlphaBar(ImGuiColorEditFlags_AlphaBar),

  AlphaPreview(ImGuiColorEditFlags_AlphaPreview),

  AlphaPreviewHalf(ImGuiColorEditFlags_AlphaPreviewHalf),

  HDR(ImGuiColorEditFlags_HDR),

  DisplayRGB(ImGuiColorEditFlags_DisplayRGB),

  DisplayHSV(ImGuiColorEditFlags_DisplayHSV),

  DisplayHex(ImGuiColorEditFlags_DisplayHex),

  Uint8(ImGuiColorEditFlags_Uint8),

  Float(ImGuiColorEditFlags_Float),

  PickerHueBar(ImGuiColorEditFlags_PickerHueBar),

  PickerHueWheel(ImGuiColorEditFlags_PickerHueWheel),

  InputRGB(ImGuiColorEditFlags_InputRGB),

  InputHSV(ImGuiColorEditFlags_InputHSV);

  override val info: Flag.EnumInfo<ImGuiColorEditFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiColorEditFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiColorEditFlags = when (value) {
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

    fun fromMultiple(value: Int): Flag<ImGuiColorEditFlags> = Flag(value, cachedInfo)
  }
}

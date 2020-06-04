package com.imgui

expect enum class ImGuiColorEditFlags : Flag<ImGuiColorEditFlags> {
  NoAlpha,

  NoPicker,

  NoOptions,

  NoSmallPreview,

  NoInputs,

  NoTooltip,

  NoLabel,

  NoSidePreview,

  NoDragDrop,

  NoBorder,

  AlphaBar,

  AlphaPreview,

  AlphaPreviewHalf,

  HDR,

  DisplayRGB,

  DisplayHSV,

  DisplayHex,

  Uint8,

  Float,

  PickerHueBar,

  PickerHueWheel,

  InputRGB,

  InputHSV;

  companion object
}

package com.imgui

expect enum class ImGuiComboFlags : Flag<ImGuiComboFlags> {
  PopupAlignLeft,

  HeightSmall,

  HeightRegular,

  HeightLarge,

  HeightLargest,

  NoArrowButton,

  NoPreview;

  companion object {
    val HeightMask_: Flag<ImGuiComboFlags>
  }
}

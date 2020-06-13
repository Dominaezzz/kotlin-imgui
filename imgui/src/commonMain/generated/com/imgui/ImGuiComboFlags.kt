package com.imgui

import kotlin.Int

expect enum class ImGuiComboFlags : Flag<ImGuiComboFlags> {
  PopupAlignLeft,

  HeightSmall,

  HeightRegular,

  HeightLarge,

  HeightLargest,

  NoArrowButton,

  NoPreview;

  val cValue: Int

  companion object {
    val HeightMask_: Flag<ImGuiComboFlags>
  }
}

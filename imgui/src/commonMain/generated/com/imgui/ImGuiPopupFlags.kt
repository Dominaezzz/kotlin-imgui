package com.imgui

expect enum class ImGuiPopupFlags : Flag<ImGuiPopupFlags> {
  MouseButtonLeft,

  NoOpenOverExistingPopup,

  NoOpenOverItems,

  AnyPopupId,

  AnyPopupLevel;

  companion object {
    val MouseButtonRight: Flag<ImGuiPopupFlags>

    val MouseButtonMiddle: Flag<ImGuiPopupFlags>

    val MouseButtonMask_: Flag<ImGuiPopupFlags>

    val MouseButtonDefault_: Flag<ImGuiPopupFlags>

    val AnyPopup: Flag<ImGuiPopupFlags>
  }
}

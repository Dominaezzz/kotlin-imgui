package com.imgui

import kotlin.Int

expect enum class ImGuiButtonFlags : Flag<ImGuiButtonFlags> {
  Repeat,

  PressedOnClick,

  PressedOnClickRelease,

  PressedOnClickReleaseAnywhere,

  PressedOnRelease,

  PressedOnDoubleClick,

  PressedOnDragDropHold,

  FlattenChildren,

  AllowItemOverlap,

  DontClosePopups,

  Disabled,

  AlignTextBaseLine,

  NoKeyModifiers,

  NoHoldingActiveId,

  NoNavFocus,

  NoHoveredOnFocus,

  MouseButtonLeft,

  MouseButtonRight,

  MouseButtonMiddle;

  val cValue: Int

  companion object {
    val MouseButtonMask_: Flag<ImGuiButtonFlags>

    val MouseButtonShift_: Flag<ImGuiButtonFlags>

    val MouseButtonDefault_: Flag<ImGuiButtonFlags>

    val PressedOnMask_: Flag<ImGuiButtonFlags>

    val PressedOnDefault_: Flag<ImGuiButtonFlags>
  }
}

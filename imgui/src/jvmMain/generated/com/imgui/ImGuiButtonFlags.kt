package com.imgui

import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_AlignTextBaseLine
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_AllowItemOverlap
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_Disabled
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_DontClosePopups
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_FlattenChildren
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_MouseButtonDefault_
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_MouseButtonLeft
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_MouseButtonMask_
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_MouseButtonMiddle
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_MouseButtonRight
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_MouseButtonShift_
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_NoHoldingActiveId
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_NoHoveredOnFocus
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_NoKeyModifiers
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_NoNavFocus
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnClick
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnClickRelease
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnClickReleaseAnywhere
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnDefault_
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnDoubleClick
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnDragDropHold
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnMask_
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_PressedOnRelease
import cimgui.internal.ImGuiButtonFlags_.ImGuiButtonFlags_Repeat
import kotlin.Int

actual enum class ImGuiButtonFlags(
  override val value: Int
) : Flag<ImGuiButtonFlags> {
  Repeat(ImGuiButtonFlags_Repeat),

  PressedOnClick(ImGuiButtonFlags_PressedOnClick),

  PressedOnClickRelease(ImGuiButtonFlags_PressedOnClickRelease),

  PressedOnClickReleaseAnywhere(ImGuiButtonFlags_PressedOnClickReleaseAnywhere),

  PressedOnRelease(ImGuiButtonFlags_PressedOnRelease),

  PressedOnDoubleClick(ImGuiButtonFlags_PressedOnDoubleClick),

  PressedOnDragDropHold(ImGuiButtonFlags_PressedOnDragDropHold),

  FlattenChildren(ImGuiButtonFlags_FlattenChildren),

  AllowItemOverlap(ImGuiButtonFlags_AllowItemOverlap),

  DontClosePopups(ImGuiButtonFlags_DontClosePopups),

  Disabled(ImGuiButtonFlags_Disabled),

  AlignTextBaseLine(ImGuiButtonFlags_AlignTextBaseLine),

  NoKeyModifiers(ImGuiButtonFlags_NoKeyModifiers),

  NoHoldingActiveId(ImGuiButtonFlags_NoHoldingActiveId),

  NoNavFocus(ImGuiButtonFlags_NoNavFocus),

  NoHoveredOnFocus(ImGuiButtonFlags_NoHoveredOnFocus),

  MouseButtonLeft(ImGuiButtonFlags_MouseButtonLeft),

  MouseButtonRight(ImGuiButtonFlags_MouseButtonRight),

  MouseButtonMiddle(ImGuiButtonFlags_MouseButtonMiddle);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiButtonFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiButtonFlags> = Flag.enumInfo()

    actual val MouseButtonMask_: Flag<ImGuiButtonFlags> = Flag(ImGuiButtonFlags_MouseButtonMask_,
        cachedInfo)

    actual val MouseButtonShift_: Flag<ImGuiButtonFlags> = Flag(ImGuiButtonFlags_MouseButtonShift_,
        cachedInfo)

    actual val MouseButtonDefault_: Flag<ImGuiButtonFlags> =
        Flag(ImGuiButtonFlags_MouseButtonDefault_, cachedInfo)

    actual val PressedOnMask_: Flag<ImGuiButtonFlags> = Flag(ImGuiButtonFlags_PressedOnMask_,
        cachedInfo)

    actual val PressedOnDefault_: Flag<ImGuiButtonFlags> = Flag(ImGuiButtonFlags_PressedOnDefault_,
        cachedInfo)

    fun from(value: Int): ImGuiButtonFlags = when (value) {
      ImGuiButtonFlags_Repeat -> Repeat
      ImGuiButtonFlags_PressedOnClick -> PressedOnClick
      ImGuiButtonFlags_PressedOnClickRelease -> PressedOnClickRelease
      ImGuiButtonFlags_PressedOnClickReleaseAnywhere -> PressedOnClickReleaseAnywhere
      ImGuiButtonFlags_PressedOnRelease -> PressedOnRelease
      ImGuiButtonFlags_PressedOnDoubleClick -> PressedOnDoubleClick
      ImGuiButtonFlags_PressedOnDragDropHold -> PressedOnDragDropHold
      ImGuiButtonFlags_FlattenChildren -> FlattenChildren
      ImGuiButtonFlags_AllowItemOverlap -> AllowItemOverlap
      ImGuiButtonFlags_DontClosePopups -> DontClosePopups
      ImGuiButtonFlags_Disabled -> Disabled
      ImGuiButtonFlags_AlignTextBaseLine -> AlignTextBaseLine
      ImGuiButtonFlags_NoKeyModifiers -> NoKeyModifiers
      ImGuiButtonFlags_NoHoldingActiveId -> NoHoldingActiveId
      ImGuiButtonFlags_NoNavFocus -> NoNavFocus
      ImGuiButtonFlags_NoHoveredOnFocus -> NoHoveredOnFocus
      ImGuiButtonFlags_MouseButtonLeft -> MouseButtonLeft
      ImGuiButtonFlags_MouseButtonRight -> MouseButtonRight
      ImGuiButtonFlags_MouseButtonMiddle -> MouseButtonMiddle
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiButtonFlags> = Flag(value, cachedInfo)
  }
}

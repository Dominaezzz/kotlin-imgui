package com.imgui

import cimgui.internal.ImGuiButtonFlags_
import cimgui.internal.ImGuiButtonFlags_AlignTextBaseLine
import cimgui.internal.ImGuiButtonFlags_AllowItemOverlap
import cimgui.internal.ImGuiButtonFlags_Disabled
import cimgui.internal.ImGuiButtonFlags_DontClosePopups
import cimgui.internal.ImGuiButtonFlags_FlattenChildren
import cimgui.internal.ImGuiButtonFlags_MouseButtonDefault_
import cimgui.internal.ImGuiButtonFlags_MouseButtonLeft
import cimgui.internal.ImGuiButtonFlags_MouseButtonMask_
import cimgui.internal.ImGuiButtonFlags_MouseButtonMiddle
import cimgui.internal.ImGuiButtonFlags_MouseButtonRight
import cimgui.internal.ImGuiButtonFlags_MouseButtonShift_
import cimgui.internal.ImGuiButtonFlags_NoHoldingActiveId
import cimgui.internal.ImGuiButtonFlags_NoHoveredOnFocus
import cimgui.internal.ImGuiButtonFlags_NoKeyModifiers
import cimgui.internal.ImGuiButtonFlags_NoNavFocus
import cimgui.internal.ImGuiButtonFlags_PressedOnClick
import cimgui.internal.ImGuiButtonFlags_PressedOnClickRelease
import cimgui.internal.ImGuiButtonFlags_PressedOnClickReleaseAnywhere
import cimgui.internal.ImGuiButtonFlags_PressedOnDefault_
import cimgui.internal.ImGuiButtonFlags_PressedOnDoubleClick
import cimgui.internal.ImGuiButtonFlags_PressedOnDragDropHold
import cimgui.internal.ImGuiButtonFlags_PressedOnMask_
import cimgui.internal.ImGuiButtonFlags_PressedOnRelease
import cimgui.internal.ImGuiButtonFlags_Repeat
import kotlinx.cinterop.convert

actual enum class ImGuiButtonFlags(
  override val value: cimgui.internal.ImGuiButtonFlags
) : Flag<ImGuiButtonFlags> {
  Repeat(ImGuiButtonFlags_Repeat.convert()),

  PressedOnClick(ImGuiButtonFlags_PressedOnClick.convert()),

  PressedOnClickRelease(ImGuiButtonFlags_PressedOnClickRelease.convert()),

  PressedOnClickReleaseAnywhere(ImGuiButtonFlags_PressedOnClickReleaseAnywhere.convert()),

  PressedOnRelease(ImGuiButtonFlags_PressedOnRelease.convert()),

  PressedOnDoubleClick(ImGuiButtonFlags_PressedOnDoubleClick.convert()),

  PressedOnDragDropHold(ImGuiButtonFlags_PressedOnDragDropHold.convert()),

  FlattenChildren(ImGuiButtonFlags_FlattenChildren.convert()),

  AllowItemOverlap(ImGuiButtonFlags_AllowItemOverlap.convert()),

  DontClosePopups(ImGuiButtonFlags_DontClosePopups.convert()),

  Disabled(ImGuiButtonFlags_Disabled.convert()),

  AlignTextBaseLine(ImGuiButtonFlags_AlignTextBaseLine.convert()),

  NoKeyModifiers(ImGuiButtonFlags_NoKeyModifiers.convert()),

  NoHoldingActiveId(ImGuiButtonFlags_NoHoldingActiveId.convert()),

  NoNavFocus(ImGuiButtonFlags_NoNavFocus.convert()),

  NoHoveredOnFocus(ImGuiButtonFlags_NoHoveredOnFocus.convert()),

  MouseButtonLeft(ImGuiButtonFlags_MouseButtonLeft.convert()),

  MouseButtonRight(ImGuiButtonFlags_MouseButtonRight.convert()),

  MouseButtonMiddle(ImGuiButtonFlags_MouseButtonMiddle.convert());

  override val info: Flag.EnumInfo<ImGuiButtonFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiButtonFlags> = Flag.enumInfo()

    actual val MouseButtonMask_: Flag<ImGuiButtonFlags> =
        Flag(ImGuiButtonFlags_MouseButtonMask_.toInt(), cachedInfo)

    actual val MouseButtonShift_: Flag<ImGuiButtonFlags> =
        Flag(ImGuiButtonFlags_MouseButtonShift_.toInt(), cachedInfo)

    actual val MouseButtonDefault_: Flag<ImGuiButtonFlags> =
        Flag(ImGuiButtonFlags_MouseButtonDefault_.toInt(), cachedInfo)

    actual val PressedOnMask_: Flag<ImGuiButtonFlags> =
        Flag(ImGuiButtonFlags_PressedOnMask_.toInt(), cachedInfo)

    actual val PressedOnDefault_: Flag<ImGuiButtonFlags> =
        Flag(ImGuiButtonFlags_PressedOnDefault_.toInt(), cachedInfo)

    fun from(value: cimgui.internal.ImGuiButtonFlags): ImGuiButtonFlags = when
        (value.convert<ImGuiButtonFlags_>()) {
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

    fun fromMultiple(value: cimgui.internal.ImGuiButtonFlags): Flag<ImGuiButtonFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

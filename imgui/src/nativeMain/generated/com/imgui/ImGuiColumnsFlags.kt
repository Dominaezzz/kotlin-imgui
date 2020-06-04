package com.imgui

import cimgui.internal.ImGuiColumnsFlags_
import cimgui.internal.ImGuiColumnsFlags_GrowParentContentsSize
import cimgui.internal.ImGuiColumnsFlags_NoBorder
import cimgui.internal.ImGuiColumnsFlags_NoForceWithinWindow
import cimgui.internal.ImGuiColumnsFlags_NoPreserveWidths
import cimgui.internal.ImGuiColumnsFlags_NoResize
import kotlinx.cinterop.convert

actual enum class ImGuiColumnsFlags(
  override val value: cimgui.internal.ImGuiColumnsFlags
) : Flag<ImGuiColumnsFlags> {
  NoBorder(ImGuiColumnsFlags_NoBorder.convert()),

  NoResize(ImGuiColumnsFlags_NoResize.convert()),

  NoPreserveWidths(ImGuiColumnsFlags_NoPreserveWidths.convert()),

  NoForceWithinWindow(ImGuiColumnsFlags_NoForceWithinWindow.convert()),

  GrowParentContentsSize(ImGuiColumnsFlags_GrowParentContentsSize.convert());

  override val info: Flag.EnumInfo<ImGuiColumnsFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiColumnsFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiColumnsFlags): ImGuiColumnsFlags = when
        (value.convert<ImGuiColumnsFlags_>()) {
      ImGuiColumnsFlags_NoBorder -> NoBorder
      ImGuiColumnsFlags_NoResize -> NoResize
      ImGuiColumnsFlags_NoPreserveWidths -> NoPreserveWidths
      ImGuiColumnsFlags_NoForceWithinWindow -> NoForceWithinWindow
      ImGuiColumnsFlags_GrowParentContentsSize -> GrowParentContentsSize
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiColumnsFlags): Flag<ImGuiColumnsFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

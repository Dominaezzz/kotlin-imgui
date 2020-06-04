package com.imgui

import cimgui.internal.ImGuiColumnsFlags_.ImGuiColumnsFlags_GrowParentContentsSize
import cimgui.internal.ImGuiColumnsFlags_.ImGuiColumnsFlags_NoBorder
import cimgui.internal.ImGuiColumnsFlags_.ImGuiColumnsFlags_NoForceWithinWindow
import cimgui.internal.ImGuiColumnsFlags_.ImGuiColumnsFlags_NoPreserveWidths
import cimgui.internal.ImGuiColumnsFlags_.ImGuiColumnsFlags_NoResize
import kotlin.Int

actual enum class ImGuiColumnsFlags(
  override val value: Int
) : Flag<ImGuiColumnsFlags> {
  NoBorder(ImGuiColumnsFlags_NoBorder),

  NoResize(ImGuiColumnsFlags_NoResize),

  NoPreserveWidths(ImGuiColumnsFlags_NoPreserveWidths),

  NoForceWithinWindow(ImGuiColumnsFlags_NoForceWithinWindow),

  GrowParentContentsSize(ImGuiColumnsFlags_GrowParentContentsSize);

  override val info: Flag.EnumInfo<ImGuiColumnsFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiColumnsFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiColumnsFlags = when (value) {
      ImGuiColumnsFlags_NoBorder -> NoBorder
      ImGuiColumnsFlags_NoResize -> NoResize
      ImGuiColumnsFlags_NoPreserveWidths -> NoPreserveWidths
      ImGuiColumnsFlags_NoForceWithinWindow -> NoForceWithinWindow
      ImGuiColumnsFlags_GrowParentContentsSize -> GrowParentContentsSize
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiColumnsFlags> = Flag(value, cachedInfo)
  }
}

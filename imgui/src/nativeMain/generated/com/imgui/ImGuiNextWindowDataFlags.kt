package com.imgui

import cimgui.internal.ImGuiNextWindowDataFlags_
import cimgui.internal.ImGuiNextWindowDataFlags_HasBgAlpha
import cimgui.internal.ImGuiNextWindowDataFlags_HasCollapsed
import cimgui.internal.ImGuiNextWindowDataFlags_HasContentSize
import cimgui.internal.ImGuiNextWindowDataFlags_HasFocus
import cimgui.internal.ImGuiNextWindowDataFlags_HasPos
import cimgui.internal.ImGuiNextWindowDataFlags_HasSize
import cimgui.internal.ImGuiNextWindowDataFlags_HasSizeConstraint
import kotlinx.cinterop.convert

actual enum class ImGuiNextWindowDataFlags(
  override val value: cimgui.internal.ImGuiNextWindowDataFlags
) : Flag<ImGuiNextWindowDataFlags> {
  HasPos(ImGuiNextWindowDataFlags_HasPos.convert()),

  HasSize(ImGuiNextWindowDataFlags_HasSize.convert()),

  HasContentSize(ImGuiNextWindowDataFlags_HasContentSize.convert()),

  HasCollapsed(ImGuiNextWindowDataFlags_HasCollapsed.convert()),

  HasSizeConstraint(ImGuiNextWindowDataFlags_HasSizeConstraint.convert()),

  HasFocus(ImGuiNextWindowDataFlags_HasFocus.convert()),

  HasBgAlpha(ImGuiNextWindowDataFlags_HasBgAlpha.convert());

  override val info: Flag.EnumInfo<ImGuiNextWindowDataFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNextWindowDataFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiNextWindowDataFlags): ImGuiNextWindowDataFlags = when
        (value.convert<ImGuiNextWindowDataFlags_>()) {
      ImGuiNextWindowDataFlags_HasPos -> HasPos
      ImGuiNextWindowDataFlags_HasSize -> HasSize
      ImGuiNextWindowDataFlags_HasContentSize -> HasContentSize
      ImGuiNextWindowDataFlags_HasCollapsed -> HasCollapsed
      ImGuiNextWindowDataFlags_HasSizeConstraint -> HasSizeConstraint
      ImGuiNextWindowDataFlags_HasFocus -> HasFocus
      ImGuiNextWindowDataFlags_HasBgAlpha -> HasBgAlpha
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiNextWindowDataFlags):
        Flag<ImGuiNextWindowDataFlags> = Flag(value.convert(), cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiNextWindowDataFlags_.ImGuiNextWindowDataFlags_HasBgAlpha
import cimgui.internal.ImGuiNextWindowDataFlags_.ImGuiNextWindowDataFlags_HasCollapsed
import cimgui.internal.ImGuiNextWindowDataFlags_.ImGuiNextWindowDataFlags_HasContentSize
import cimgui.internal.ImGuiNextWindowDataFlags_.ImGuiNextWindowDataFlags_HasFocus
import cimgui.internal.ImGuiNextWindowDataFlags_.ImGuiNextWindowDataFlags_HasPos
import cimgui.internal.ImGuiNextWindowDataFlags_.ImGuiNextWindowDataFlags_HasSize
import cimgui.internal.ImGuiNextWindowDataFlags_.ImGuiNextWindowDataFlags_HasSizeConstraint
import kotlin.Int

actual enum class ImGuiNextWindowDataFlags(
  override val value: Int
) : Flag<ImGuiNextWindowDataFlags> {
  HasPos(ImGuiNextWindowDataFlags_HasPos),

  HasSize(ImGuiNextWindowDataFlags_HasSize),

  HasContentSize(ImGuiNextWindowDataFlags_HasContentSize),

  HasCollapsed(ImGuiNextWindowDataFlags_HasCollapsed),

  HasSizeConstraint(ImGuiNextWindowDataFlags_HasSizeConstraint),

  HasFocus(ImGuiNextWindowDataFlags_HasFocus),

  HasBgAlpha(ImGuiNextWindowDataFlags_HasBgAlpha);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiNextWindowDataFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNextWindowDataFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiNextWindowDataFlags = when (value) {
      ImGuiNextWindowDataFlags_HasPos -> HasPos
      ImGuiNextWindowDataFlags_HasSize -> HasSize
      ImGuiNextWindowDataFlags_HasContentSize -> HasContentSize
      ImGuiNextWindowDataFlags_HasCollapsed -> HasCollapsed
      ImGuiNextWindowDataFlags_HasSizeConstraint -> HasSizeConstraint
      ImGuiNextWindowDataFlags_HasFocus -> HasFocus
      ImGuiNextWindowDataFlags_HasBgAlpha -> HasBgAlpha
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiNextWindowDataFlags> = Flag(value, cachedInfo)
  }
}
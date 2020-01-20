package com.imgui

import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_AllowWhenBlockedByActiveItem
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_AllowWhenBlockedByPopup
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_AllowWhenDisabled
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_AllowWhenOverlapped
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_AnyWindow
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_ChildWindows
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_RectOnly
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_RootAndChildWindows
import cimgui.internal.ImGuiHoveredFlags_.ImGuiHoveredFlags_RootWindow
import kotlin.Int

actual enum class ImGuiHoveredFlags(
  override val value: Int
) : Flag<ImGuiHoveredFlags> {
  ChildWindows(ImGuiHoveredFlags_ChildWindows),

  RootWindow(ImGuiHoveredFlags_RootWindow),

  AnyWindow(ImGuiHoveredFlags_AnyWindow),

  AllowWhenBlockedByPopup(ImGuiHoveredFlags_AllowWhenBlockedByPopup),

  AllowWhenBlockedByActiveItem(ImGuiHoveredFlags_AllowWhenBlockedByActiveItem),

  AllowWhenOverlapped(ImGuiHoveredFlags_AllowWhenOverlapped),

  AllowWhenDisabled(ImGuiHoveredFlags_AllowWhenDisabled);

  override val info: Flag.EnumInfo<ImGuiHoveredFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiHoveredFlags> = Flag.enumInfo()

    actual val RectOnly: Flag<ImGuiHoveredFlags> = Flag(ImGuiHoveredFlags_RectOnly, cachedInfo)

    actual val RootAndChildWindows: Flag<ImGuiHoveredFlags> =
        Flag(ImGuiHoveredFlags_RootAndChildWindows, cachedInfo)

    fun from(value: Int): ImGuiHoveredFlags = when (value) {
      ImGuiHoveredFlags_ChildWindows -> ChildWindows
      ImGuiHoveredFlags_RootWindow -> RootWindow
      ImGuiHoveredFlags_AnyWindow -> AnyWindow
      ImGuiHoveredFlags_AllowWhenBlockedByPopup -> AllowWhenBlockedByPopup
      ImGuiHoveredFlags_AllowWhenBlockedByActiveItem -> AllowWhenBlockedByActiveItem
      ImGuiHoveredFlags_AllowWhenOverlapped -> AllowWhenOverlapped
      ImGuiHoveredFlags_AllowWhenDisabled -> AllowWhenDisabled
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiHoveredFlags> = Flag(value, cachedInfo)
  }
}

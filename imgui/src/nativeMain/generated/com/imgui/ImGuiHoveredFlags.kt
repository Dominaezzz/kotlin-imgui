package com.imgui

import cimgui.internal.ImGuiHoveredFlags_
import cimgui.internal.ImGuiHoveredFlags_AllowWhenBlockedByActiveItem
import cimgui.internal.ImGuiHoveredFlags_AllowWhenBlockedByPopup
import cimgui.internal.ImGuiHoveredFlags_AllowWhenDisabled
import cimgui.internal.ImGuiHoveredFlags_AllowWhenOverlapped
import cimgui.internal.ImGuiHoveredFlags_AnyWindow
import cimgui.internal.ImGuiHoveredFlags_ChildWindows
import cimgui.internal.ImGuiHoveredFlags_RectOnly
import cimgui.internal.ImGuiHoveredFlags_RootAndChildWindows
import cimgui.internal.ImGuiHoveredFlags_RootWindow
import kotlinx.cinterop.convert

actual enum class ImGuiHoveredFlags(
  override val value: cimgui.internal.ImGuiHoveredFlags
) : Flag<ImGuiHoveredFlags> {
  ChildWindows(ImGuiHoveredFlags_ChildWindows.convert()),

  RootWindow(ImGuiHoveredFlags_RootWindow.convert()),

  AnyWindow(ImGuiHoveredFlags_AnyWindow.convert()),

  AllowWhenBlockedByPopup(ImGuiHoveredFlags_AllowWhenBlockedByPopup.convert()),

  AllowWhenBlockedByActiveItem(ImGuiHoveredFlags_AllowWhenBlockedByActiveItem.convert()),

  AllowWhenOverlapped(ImGuiHoveredFlags_AllowWhenOverlapped.convert()),

  AllowWhenDisabled(ImGuiHoveredFlags_AllowWhenDisabled.convert());

  override val info: Flag.EnumInfo<ImGuiHoveredFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiHoveredFlags> = Flag.enumInfo()

    actual val RectOnly: Flag<ImGuiHoveredFlags> = Flag(ImGuiHoveredFlags_RectOnly.toInt(),
        cachedInfo)

    actual val RootAndChildWindows: Flag<ImGuiHoveredFlags> =
        Flag(ImGuiHoveredFlags_RootAndChildWindows.toInt(), cachedInfo)

    fun from(value: cimgui.internal.ImGuiHoveredFlags): ImGuiHoveredFlags = when
        (value.convert<ImGuiHoveredFlags_>()) {
      ImGuiHoveredFlags_ChildWindows -> ChildWindows
      ImGuiHoveredFlags_RootWindow -> RootWindow
      ImGuiHoveredFlags_AnyWindow -> AnyWindow
      ImGuiHoveredFlags_AllowWhenBlockedByPopup -> AllowWhenBlockedByPopup
      ImGuiHoveredFlags_AllowWhenBlockedByActiveItem -> AllowWhenBlockedByActiveItem
      ImGuiHoveredFlags_AllowWhenOverlapped -> AllowWhenOverlapped
      ImGuiHoveredFlags_AllowWhenDisabled -> AllowWhenDisabled
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiHoveredFlags): Flag<ImGuiHoveredFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

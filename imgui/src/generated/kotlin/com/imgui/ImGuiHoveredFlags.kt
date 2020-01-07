package com.imgui

import cimgui.internal.ImGuiHoveredFlags_AllowWhenBlockedByActiveItem
import cimgui.internal.ImGuiHoveredFlags_AllowWhenBlockedByPopup
import cimgui.internal.ImGuiHoveredFlags_AllowWhenDisabled
import cimgui.internal.ImGuiHoveredFlags_AllowWhenOverlapped
import cimgui.internal.ImGuiHoveredFlags_AnyWindow
import cimgui.internal.ImGuiHoveredFlags_ChildWindows
import cimgui.internal.ImGuiHoveredFlags_RootWindow
import kotlin.Int

enum class ImGuiHoveredFlags(
  override val value: Int
) : Flag<ImGuiHoveredFlags> {
  ChildWindows(ImGuiHoveredFlags_ChildWindows.toInt()),

  RootWindow(ImGuiHoveredFlags_RootWindow.toInt()),

  AnyWindow(ImGuiHoveredFlags_AnyWindow.toInt()),

  AllowWhenBlockedByPopup(ImGuiHoveredFlags_AllowWhenBlockedByPopup.toInt()),

  AllowWhenBlockedByActiveItem(ImGuiHoveredFlags_AllowWhenBlockedByActiveItem.toInt()),

  AllowWhenOverlapped(ImGuiHoveredFlags_AllowWhenOverlapped.toInt()),

  AllowWhenDisabled(ImGuiHoveredFlags_AllowWhenDisabled.toInt());

  override val info: Flag.EnumInfo<ImGuiHoveredFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiHoveredFlags> = Flag.enumInfo()
  }
}

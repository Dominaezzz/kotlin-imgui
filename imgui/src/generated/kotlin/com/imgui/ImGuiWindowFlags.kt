package com.imgui

import cimgui.internal.ImGuiWindowFlags_AlwaysAutoResize
import cimgui.internal.ImGuiWindowFlags_AlwaysHorizontalScrollbar
import cimgui.internal.ImGuiWindowFlags_AlwaysUseWindowPadding
import cimgui.internal.ImGuiWindowFlags_AlwaysVerticalScrollbar
import cimgui.internal.ImGuiWindowFlags_ChildMenu
import cimgui.internal.ImGuiWindowFlags_ChildWindow
import cimgui.internal.ImGuiWindowFlags_HorizontalScrollbar
import cimgui.internal.ImGuiWindowFlags_MenuBar
import cimgui.internal.ImGuiWindowFlags_Modal
import cimgui.internal.ImGuiWindowFlags_NavFlattened
import cimgui.internal.ImGuiWindowFlags_NoBackground
import cimgui.internal.ImGuiWindowFlags_NoBringToFrontOnFocus
import cimgui.internal.ImGuiWindowFlags_NoCollapse
import cimgui.internal.ImGuiWindowFlags_NoFocusOnAppearing
import cimgui.internal.ImGuiWindowFlags_NoMouseInputs
import cimgui.internal.ImGuiWindowFlags_NoMove
import cimgui.internal.ImGuiWindowFlags_NoNavFocus
import cimgui.internal.ImGuiWindowFlags_NoNavInputs
import cimgui.internal.ImGuiWindowFlags_NoResize
import cimgui.internal.ImGuiWindowFlags_NoSavedSettings
import cimgui.internal.ImGuiWindowFlags_NoScrollWithMouse
import cimgui.internal.ImGuiWindowFlags_NoScrollbar
import cimgui.internal.ImGuiWindowFlags_NoTitleBar
import cimgui.internal.ImGuiWindowFlags_Popup
import cimgui.internal.ImGuiWindowFlags_Tooltip
import cimgui.internal.ImGuiWindowFlags_UnsavedDocument
import kotlin.Int

enum class ImGuiWindowFlags(
  override val value: Int
) : Flag<ImGuiWindowFlags> {
  NoTitleBar(ImGuiWindowFlags_NoTitleBar.toInt()),

  NoResize(ImGuiWindowFlags_NoResize.toInt()),

  NoMove(ImGuiWindowFlags_NoMove.toInt()),

  NoScrollbar(ImGuiWindowFlags_NoScrollbar.toInt()),

  NoScrollWithMouse(ImGuiWindowFlags_NoScrollWithMouse.toInt()),

  NoCollapse(ImGuiWindowFlags_NoCollapse.toInt()),

  AlwaysAutoResize(ImGuiWindowFlags_AlwaysAutoResize.toInt()),

  NoBackground(ImGuiWindowFlags_NoBackground.toInt()),

  NoSavedSettings(ImGuiWindowFlags_NoSavedSettings.toInt()),

  NoMouseInputs(ImGuiWindowFlags_NoMouseInputs.toInt()),

  MenuBar(ImGuiWindowFlags_MenuBar.toInt()),

  HorizontalScrollbar(ImGuiWindowFlags_HorizontalScrollbar.toInt()),

  NoFocusOnAppearing(ImGuiWindowFlags_NoFocusOnAppearing.toInt()),

  NoBringToFrontOnFocus(ImGuiWindowFlags_NoBringToFrontOnFocus.toInt()),

  AlwaysVerticalScrollbar(ImGuiWindowFlags_AlwaysVerticalScrollbar.toInt()),

  AlwaysHorizontalScrollbar(ImGuiWindowFlags_AlwaysHorizontalScrollbar.toInt()),

  AlwaysUseWindowPadding(ImGuiWindowFlags_AlwaysUseWindowPadding.toInt()),

  NoNavInputs(ImGuiWindowFlags_NoNavInputs.toInt()),

  NoNavFocus(ImGuiWindowFlags_NoNavFocus.toInt()),

  UnsavedDocument(ImGuiWindowFlags_UnsavedDocument.toInt()),

  NavFlattened(ImGuiWindowFlags_NavFlattened.toInt()),

  ChildWindow(ImGuiWindowFlags_ChildWindow.toInt()),

  Tooltip(ImGuiWindowFlags_Tooltip.toInt()),

  Popup(ImGuiWindowFlags_Popup.toInt()),

  Modal(ImGuiWindowFlags_Modal.toInt()),

  ChildMenu(ImGuiWindowFlags_ChildMenu.toInt());

  override val info: Flag.EnumInfo<ImGuiWindowFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiWindowFlags> = Flag.enumInfo()
  }
}

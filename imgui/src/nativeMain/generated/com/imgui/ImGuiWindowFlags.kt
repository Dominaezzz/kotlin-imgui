package com.imgui

import cimgui.internal.ImGuiWindowFlags_
import cimgui.internal.ImGuiWindowFlags_AlwaysAutoResize
import cimgui.internal.ImGuiWindowFlags_AlwaysHorizontalScrollbar
import cimgui.internal.ImGuiWindowFlags_AlwaysUseWindowPadding
import cimgui.internal.ImGuiWindowFlags_AlwaysVerticalScrollbar
import cimgui.internal.ImGuiWindowFlags_ChildMenu
import cimgui.internal.ImGuiWindowFlags_ChildWindow
import cimgui.internal.ImGuiWindowFlags_DockNodeHost
import cimgui.internal.ImGuiWindowFlags_HorizontalScrollbar
import cimgui.internal.ImGuiWindowFlags_MenuBar
import cimgui.internal.ImGuiWindowFlags_Modal
import cimgui.internal.ImGuiWindowFlags_NavFlattened
import cimgui.internal.ImGuiWindowFlags_NoBackground
import cimgui.internal.ImGuiWindowFlags_NoBringToFrontOnFocus
import cimgui.internal.ImGuiWindowFlags_NoCollapse
import cimgui.internal.ImGuiWindowFlags_NoDecoration
import cimgui.internal.ImGuiWindowFlags_NoDocking
import cimgui.internal.ImGuiWindowFlags_NoFocusOnAppearing
import cimgui.internal.ImGuiWindowFlags_NoInputs
import cimgui.internal.ImGuiWindowFlags_NoMouseInputs
import cimgui.internal.ImGuiWindowFlags_NoMove
import cimgui.internal.ImGuiWindowFlags_NoNav
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
import kotlinx.cinterop.convert

actual enum class ImGuiWindowFlags(
  override val value: cimgui.internal.ImGuiWindowFlags
) : Flag<ImGuiWindowFlags> {
  NoTitleBar(ImGuiWindowFlags_NoTitleBar.convert()),

  NoResize(ImGuiWindowFlags_NoResize.convert()),

  NoMove(ImGuiWindowFlags_NoMove.convert()),

  NoScrollbar(ImGuiWindowFlags_NoScrollbar.convert()),

  NoScrollWithMouse(ImGuiWindowFlags_NoScrollWithMouse.convert()),

  NoCollapse(ImGuiWindowFlags_NoCollapse.convert()),

  AlwaysAutoResize(ImGuiWindowFlags_AlwaysAutoResize.convert()),

  NoBackground(ImGuiWindowFlags_NoBackground.convert()),

  NoSavedSettings(ImGuiWindowFlags_NoSavedSettings.convert()),

  NoMouseInputs(ImGuiWindowFlags_NoMouseInputs.convert()),

  MenuBar(ImGuiWindowFlags_MenuBar.convert()),

  HorizontalScrollbar(ImGuiWindowFlags_HorizontalScrollbar.convert()),

  NoFocusOnAppearing(ImGuiWindowFlags_NoFocusOnAppearing.convert()),

  NoBringToFrontOnFocus(ImGuiWindowFlags_NoBringToFrontOnFocus.convert()),

  AlwaysVerticalScrollbar(ImGuiWindowFlags_AlwaysVerticalScrollbar.convert()),

  AlwaysHorizontalScrollbar(ImGuiWindowFlags_AlwaysHorizontalScrollbar.convert()),

  AlwaysUseWindowPadding(ImGuiWindowFlags_AlwaysUseWindowPadding.convert()),

  NoNavInputs(ImGuiWindowFlags_NoNavInputs.convert()),

  NoNavFocus(ImGuiWindowFlags_NoNavFocus.convert()),

  UnsavedDocument(ImGuiWindowFlags_UnsavedDocument.convert()),

  NoDocking(ImGuiWindowFlags_NoDocking.convert()),

  NavFlattened(ImGuiWindowFlags_NavFlattened.convert()),

  ChildWindow(ImGuiWindowFlags_ChildWindow.convert()),

  Tooltip(ImGuiWindowFlags_Tooltip.convert()),

  Popup(ImGuiWindowFlags_Popup.convert()),

  Modal(ImGuiWindowFlags_Modal.convert()),

  ChildMenu(ImGuiWindowFlags_ChildMenu.convert()),

  DockNodeHost(ImGuiWindowFlags_DockNodeHost.convert());

  override val info: Flag.EnumInfo<ImGuiWindowFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiWindowFlags> = Flag.enumInfo()

    actual val NoNav: Flag<ImGuiWindowFlags> = Flag(ImGuiWindowFlags_NoNav.toInt(), cachedInfo)

    actual val NoDecoration: Flag<ImGuiWindowFlags> = Flag(ImGuiWindowFlags_NoDecoration.toInt(),
        cachedInfo)

    actual val NoInputs: Flag<ImGuiWindowFlags> = Flag(ImGuiWindowFlags_NoInputs.toInt(),
        cachedInfo)

    fun from(value: cimgui.internal.ImGuiWindowFlags): ImGuiWindowFlags = when
        (value.convert<ImGuiWindowFlags_>()) {
      ImGuiWindowFlags_NoTitleBar -> NoTitleBar
      ImGuiWindowFlags_NoResize -> NoResize
      ImGuiWindowFlags_NoMove -> NoMove
      ImGuiWindowFlags_NoScrollbar -> NoScrollbar
      ImGuiWindowFlags_NoScrollWithMouse -> NoScrollWithMouse
      ImGuiWindowFlags_NoCollapse -> NoCollapse
      ImGuiWindowFlags_AlwaysAutoResize -> AlwaysAutoResize
      ImGuiWindowFlags_NoBackground -> NoBackground
      ImGuiWindowFlags_NoSavedSettings -> NoSavedSettings
      ImGuiWindowFlags_NoMouseInputs -> NoMouseInputs
      ImGuiWindowFlags_MenuBar -> MenuBar
      ImGuiWindowFlags_HorizontalScrollbar -> HorizontalScrollbar
      ImGuiWindowFlags_NoFocusOnAppearing -> NoFocusOnAppearing
      ImGuiWindowFlags_NoBringToFrontOnFocus -> NoBringToFrontOnFocus
      ImGuiWindowFlags_AlwaysVerticalScrollbar -> AlwaysVerticalScrollbar
      ImGuiWindowFlags_AlwaysHorizontalScrollbar -> AlwaysHorizontalScrollbar
      ImGuiWindowFlags_AlwaysUseWindowPadding -> AlwaysUseWindowPadding
      ImGuiWindowFlags_NoNavInputs -> NoNavInputs
      ImGuiWindowFlags_NoNavFocus -> NoNavFocus
      ImGuiWindowFlags_UnsavedDocument -> UnsavedDocument
      ImGuiWindowFlags_NoDocking -> NoDocking
      ImGuiWindowFlags_NavFlattened -> NavFlattened
      ImGuiWindowFlags_ChildWindow -> ChildWindow
      ImGuiWindowFlags_Tooltip -> Tooltip
      ImGuiWindowFlags_Popup -> Popup
      ImGuiWindowFlags_Modal -> Modal
      ImGuiWindowFlags_ChildMenu -> ChildMenu
      ImGuiWindowFlags_DockNodeHost -> DockNodeHost
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiWindowFlags): Flag<ImGuiWindowFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

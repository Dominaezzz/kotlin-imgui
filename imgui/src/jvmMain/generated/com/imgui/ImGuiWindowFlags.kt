package com.imgui

import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_AlwaysAutoResize
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_AlwaysHorizontalScrollbar
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_AlwaysUseWindowPadding
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_AlwaysVerticalScrollbar
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_ChildMenu
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_ChildWindow
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_DockNodeHost
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_HorizontalScrollbar
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_MenuBar
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_Modal
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NavFlattened
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoBackground
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoBringToFrontOnFocus
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoCollapse
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoDecoration
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoDocking
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoFocusOnAppearing
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoInputs
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoMouseInputs
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoMove
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoNav
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoNavFocus
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoNavInputs
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoResize
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoSavedSettings
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoScrollWithMouse
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoScrollbar
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_NoTitleBar
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_Popup
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_Tooltip
import cimgui.internal.ImGuiWindowFlags_.ImGuiWindowFlags_UnsavedDocument
import kotlin.Int

actual enum class ImGuiWindowFlags(
  override val value: Int
) : Flag<ImGuiWindowFlags> {
  NoTitleBar(ImGuiWindowFlags_NoTitleBar),

  NoResize(ImGuiWindowFlags_NoResize),

  NoMove(ImGuiWindowFlags_NoMove),

  NoScrollbar(ImGuiWindowFlags_NoScrollbar),

  NoScrollWithMouse(ImGuiWindowFlags_NoScrollWithMouse),

  NoCollapse(ImGuiWindowFlags_NoCollapse),

  AlwaysAutoResize(ImGuiWindowFlags_AlwaysAutoResize),

  NoBackground(ImGuiWindowFlags_NoBackground),

  NoSavedSettings(ImGuiWindowFlags_NoSavedSettings),

  NoMouseInputs(ImGuiWindowFlags_NoMouseInputs),

  MenuBar(ImGuiWindowFlags_MenuBar),

  HorizontalScrollbar(ImGuiWindowFlags_HorizontalScrollbar),

  NoFocusOnAppearing(ImGuiWindowFlags_NoFocusOnAppearing),

  NoBringToFrontOnFocus(ImGuiWindowFlags_NoBringToFrontOnFocus),

  AlwaysVerticalScrollbar(ImGuiWindowFlags_AlwaysVerticalScrollbar),

  AlwaysHorizontalScrollbar(ImGuiWindowFlags_AlwaysHorizontalScrollbar),

  AlwaysUseWindowPadding(ImGuiWindowFlags_AlwaysUseWindowPadding),

  NoNavInputs(ImGuiWindowFlags_NoNavInputs),

  NoNavFocus(ImGuiWindowFlags_NoNavFocus),

  UnsavedDocument(ImGuiWindowFlags_UnsavedDocument),

  NoDocking(ImGuiWindowFlags_NoDocking),

  NavFlattened(ImGuiWindowFlags_NavFlattened),

  ChildWindow(ImGuiWindowFlags_ChildWindow),

  Tooltip(ImGuiWindowFlags_Tooltip),

  Popup(ImGuiWindowFlags_Popup),

  Modal(ImGuiWindowFlags_Modal),

  ChildMenu(ImGuiWindowFlags_ChildMenu),

  DockNodeHost(ImGuiWindowFlags_DockNodeHost);

  override val info: Flag.EnumInfo<ImGuiWindowFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiWindowFlags> = Flag.enumInfo()

    actual val NoNav: Flag<ImGuiWindowFlags> = Flag(ImGuiWindowFlags_NoNav, cachedInfo)

    actual val NoDecoration: Flag<ImGuiWindowFlags> = Flag(ImGuiWindowFlags_NoDecoration,
        cachedInfo)

    actual val NoInputs: Flag<ImGuiWindowFlags> = Flag(ImGuiWindowFlags_NoInputs, cachedInfo)

    fun from(value: Int): ImGuiWindowFlags = when (value) {
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

    fun fromMultiple(value: Int): Flag<ImGuiWindowFlags> = Flag(value, cachedInfo)
  }
}

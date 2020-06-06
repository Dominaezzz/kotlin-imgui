package com.imgui

import cimgui.internal.ImGuiViewportFlags_
import cimgui.internal.ImGuiViewportFlags_CanHostOtherWindows
import cimgui.internal.ImGuiViewportFlags_Minimized
import cimgui.internal.ImGuiViewportFlags_NoAutoMerge
import cimgui.internal.ImGuiViewportFlags_NoDecoration
import cimgui.internal.ImGuiViewportFlags_NoFocusOnAppearing
import cimgui.internal.ImGuiViewportFlags_NoFocusOnClick
import cimgui.internal.ImGuiViewportFlags_NoInputs
import cimgui.internal.ImGuiViewportFlags_NoRendererClear
import cimgui.internal.ImGuiViewportFlags_NoTaskBarIcon
import cimgui.internal.ImGuiViewportFlags_TopMost
import kotlinx.cinterop.convert

actual enum class ImGuiViewportFlags(
  override val value: cimgui.internal.ImGuiViewportFlags
) : Flag<ImGuiViewportFlags> {
  NoDecoration(ImGuiViewportFlags_NoDecoration.convert()),

  NoTaskBarIcon(ImGuiViewportFlags_NoTaskBarIcon.convert()),

  NoFocusOnAppearing(ImGuiViewportFlags_NoFocusOnAppearing.convert()),

  NoFocusOnClick(ImGuiViewportFlags_NoFocusOnClick.convert()),

  NoInputs(ImGuiViewportFlags_NoInputs.convert()),

  NoRendererClear(ImGuiViewportFlags_NoRendererClear.convert()),

  TopMost(ImGuiViewportFlags_TopMost.convert()),

  Minimized(ImGuiViewportFlags_Minimized.convert()),

  NoAutoMerge(ImGuiViewportFlags_NoAutoMerge.convert()),

  CanHostOtherWindows(ImGuiViewportFlags_CanHostOtherWindows.convert());

  override val info: Flag.EnumInfo<ImGuiViewportFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiViewportFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiViewportFlags): ImGuiViewportFlags = when
        (value.convert<ImGuiViewportFlags_>()) {
      ImGuiViewportFlags_NoDecoration -> NoDecoration
      ImGuiViewportFlags_NoTaskBarIcon -> NoTaskBarIcon
      ImGuiViewportFlags_NoFocusOnAppearing -> NoFocusOnAppearing
      ImGuiViewportFlags_NoFocusOnClick -> NoFocusOnClick
      ImGuiViewportFlags_NoInputs -> NoInputs
      ImGuiViewportFlags_NoRendererClear -> NoRendererClear
      ImGuiViewportFlags_TopMost -> TopMost
      ImGuiViewportFlags_Minimized -> Minimized
      ImGuiViewportFlags_NoAutoMerge -> NoAutoMerge
      ImGuiViewportFlags_CanHostOtherWindows -> CanHostOtherWindows
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiViewportFlags): Flag<ImGuiViewportFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

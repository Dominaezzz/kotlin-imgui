package com.imgui

import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_CanHostOtherWindows
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_Minimized
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_NoAutoMerge
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_NoDecoration
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_NoFocusOnAppearing
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_NoFocusOnClick
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_NoInputs
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_NoRendererClear
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_NoTaskBarIcon
import cimgui.internal.ImGuiViewportFlags_.ImGuiViewportFlags_TopMost
import kotlin.Int

actual enum class ImGuiViewportFlags(
  override val value: Int
) : Flag<ImGuiViewportFlags> {
  NoDecoration(ImGuiViewportFlags_NoDecoration),

  NoTaskBarIcon(ImGuiViewportFlags_NoTaskBarIcon),

  NoFocusOnAppearing(ImGuiViewportFlags_NoFocusOnAppearing),

  NoFocusOnClick(ImGuiViewportFlags_NoFocusOnClick),

  NoInputs(ImGuiViewportFlags_NoInputs),

  NoRendererClear(ImGuiViewportFlags_NoRendererClear),

  TopMost(ImGuiViewportFlags_TopMost),

  Minimized(ImGuiViewportFlags_Minimized),

  NoAutoMerge(ImGuiViewportFlags_NoAutoMerge),

  CanHostOtherWindows(ImGuiViewportFlags_CanHostOtherWindows);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiViewportFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiViewportFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiViewportFlags = when (value) {
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

    fun fromMultiple(value: Int): Flag<ImGuiViewportFlags> = Flag(value, cachedInfo)
  }
}

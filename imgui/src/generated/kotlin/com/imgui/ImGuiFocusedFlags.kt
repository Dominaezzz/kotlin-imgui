package com.imgui

import cimgui.internal.ImGuiFocusedFlags_
import cimgui.internal.ImGuiFocusedFlags_AnyWindow
import cimgui.internal.ImGuiFocusedFlags_ChildWindows
import cimgui.internal.ImGuiFocusedFlags_RootAndChildWindows
import cimgui.internal.ImGuiFocusedFlags_RootWindow
import kotlinx.cinterop.convert

enum class ImGuiFocusedFlags(
  override val value: cimgui.internal.ImGuiFocusedFlags
) : Flag<ImGuiFocusedFlags> {
  ChildWindows(ImGuiFocusedFlags_ChildWindows.convert()),

  RootWindow(ImGuiFocusedFlags_RootWindow.convert()),

  AnyWindow(ImGuiFocusedFlags_AnyWindow.convert());

  override val info: Flag.EnumInfo<ImGuiFocusedFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiFocusedFlags> = Flag.enumInfo()

    val RootAndChildWindows: Flag<ImGuiFocusedFlags> =
        Flag(ImGuiFocusedFlags_RootAndChildWindows.toInt(), cachedInfo)

    fun from(value: cimgui.internal.ImGuiFocusedFlags): ImGuiFocusedFlags = when
        (value.convert<ImGuiFocusedFlags_>()) {
      ImGuiFocusedFlags_ChildWindows -> ChildWindows
      ImGuiFocusedFlags_RootWindow -> RootWindow
      ImGuiFocusedFlags_AnyWindow -> AnyWindow
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }


    fun fromMultiple(value: cimgui.internal.ImGuiFocusedFlags): Flag<ImGuiFocusedFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

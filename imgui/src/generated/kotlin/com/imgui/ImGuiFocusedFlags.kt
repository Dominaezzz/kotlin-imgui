package com.imgui

import cimgui.internal.ImGuiFocusedFlags_AnyWindow
import cimgui.internal.ImGuiFocusedFlags_ChildWindows
import cimgui.internal.ImGuiFocusedFlags_RootAndChildWindows
import cimgui.internal.ImGuiFocusedFlags_RootWindow
import kotlin.Int

enum class ImGuiFocusedFlags(
  override val value: Int
) : Flag<ImGuiFocusedFlags> {
  ChildWindows(ImGuiFocusedFlags_ChildWindows.toInt()),

  RootWindow(ImGuiFocusedFlags_RootWindow.toInt()),

  AnyWindow(ImGuiFocusedFlags_AnyWindow.toInt());

  override val info: Flag.EnumInfo<ImGuiFocusedFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiFocusedFlags> = Flag.enumInfo()

    val RootAndChildWindows: Flag<ImGuiFocusedFlags> =
        Flag(ImGuiFocusedFlags_RootAndChildWindows.toInt(), cachedInfo)
  }
}

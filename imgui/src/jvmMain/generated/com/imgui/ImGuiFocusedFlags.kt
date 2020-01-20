package com.imgui

import cimgui.internal.ImGuiFocusedFlags_.ImGuiFocusedFlags_AnyWindow
import cimgui.internal.ImGuiFocusedFlags_.ImGuiFocusedFlags_ChildWindows
import cimgui.internal.ImGuiFocusedFlags_.ImGuiFocusedFlags_RootAndChildWindows
import cimgui.internal.ImGuiFocusedFlags_.ImGuiFocusedFlags_RootWindow
import kotlin.Int

actual enum class ImGuiFocusedFlags(
  override val value: Int
) : Flag<ImGuiFocusedFlags> {
  ChildWindows(ImGuiFocusedFlags_ChildWindows),

  RootWindow(ImGuiFocusedFlags_RootWindow),

  AnyWindow(ImGuiFocusedFlags_AnyWindow);

  override val info: Flag.EnumInfo<ImGuiFocusedFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiFocusedFlags> = Flag.enumInfo()

    actual val RootAndChildWindows: Flag<ImGuiFocusedFlags> =
        Flag(ImGuiFocusedFlags_RootAndChildWindows, cachedInfo)

    fun from(value: Int): ImGuiFocusedFlags = when (value) {
      ImGuiFocusedFlags_ChildWindows -> ChildWindows
      ImGuiFocusedFlags_RootWindow -> RootWindow
      ImGuiFocusedFlags_AnyWindow -> AnyWindow
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiFocusedFlags> = Flag(value, cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiDragFlags_
import cimgui.internal.ImGuiDragFlags_Vertical
import kotlinx.cinterop.convert

actual enum class ImGuiDragFlags(
  override val value: cimgui.internal.ImGuiDragFlags
) : Flag<ImGuiDragFlags> {
  Vertical(ImGuiDragFlags_Vertical.convert());

  override val info: Flag.EnumInfo<ImGuiDragFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiDragFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiDragFlags): ImGuiDragFlags = when
        (value.convert<ImGuiDragFlags_>()) {
      ImGuiDragFlags_Vertical -> Vertical
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiDragFlags): Flag<ImGuiDragFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

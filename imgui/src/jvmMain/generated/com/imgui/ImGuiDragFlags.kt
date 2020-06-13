package com.imgui

import cimgui.internal.ImGuiDragFlags_.ImGuiDragFlags_Vertical
import kotlin.Int

actual enum class ImGuiDragFlags(
  override val value: Int
) : Flag<ImGuiDragFlags> {
  Vertical(ImGuiDragFlags_Vertical);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiDragFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiDragFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiDragFlags = when (value) {
      ImGuiDragFlags_Vertical -> Vertical
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiDragFlags> = Flag(value, cachedInfo)
  }
}

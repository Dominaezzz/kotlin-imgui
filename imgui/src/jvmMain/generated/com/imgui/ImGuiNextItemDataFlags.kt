package com.imgui

import cimgui.internal.ImGuiNextItemDataFlags_.ImGuiNextItemDataFlags_HasOpen
import cimgui.internal.ImGuiNextItemDataFlags_.ImGuiNextItemDataFlags_HasWidth
import kotlin.Int

actual enum class ImGuiNextItemDataFlags(
  override val value: Int
) : Flag<ImGuiNextItemDataFlags> {
  HasWidth(ImGuiNextItemDataFlags_HasWidth),

  HasOpen(ImGuiNextItemDataFlags_HasOpen);

  override val info: Flag.EnumInfo<ImGuiNextItemDataFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNextItemDataFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiNextItemDataFlags = when (value) {
      ImGuiNextItemDataFlags_HasWidth -> HasWidth
      ImGuiNextItemDataFlags_HasOpen -> HasOpen
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiNextItemDataFlags> = Flag(value, cachedInfo)
  }
}

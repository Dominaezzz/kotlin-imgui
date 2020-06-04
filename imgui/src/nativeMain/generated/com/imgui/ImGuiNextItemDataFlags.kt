package com.imgui

import cimgui.internal.ImGuiNextItemDataFlags_
import cimgui.internal.ImGuiNextItemDataFlags_HasOpen
import cimgui.internal.ImGuiNextItemDataFlags_HasWidth
import kotlinx.cinterop.convert

actual enum class ImGuiNextItemDataFlags(
  override val value: cimgui.internal.ImGuiNextItemDataFlags
) : Flag<ImGuiNextItemDataFlags> {
  HasWidth(ImGuiNextItemDataFlags_HasWidth.convert()),

  HasOpen(ImGuiNextItemDataFlags_HasOpen.convert());

  override val info: Flag.EnumInfo<ImGuiNextItemDataFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiNextItemDataFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiNextItemDataFlags): ImGuiNextItemDataFlags = when
        (value.convert<ImGuiNextItemDataFlags_>()) {
      ImGuiNextItemDataFlags_HasWidth -> HasWidth
      ImGuiNextItemDataFlags_HasOpen -> HasOpen
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiNextItemDataFlags): Flag<ImGuiNextItemDataFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

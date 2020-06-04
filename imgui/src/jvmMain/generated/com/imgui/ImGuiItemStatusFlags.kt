package com.imgui

import cimgui.internal.ImGuiItemStatusFlags_.ImGuiItemStatusFlags_Deactivated
import cimgui.internal.ImGuiItemStatusFlags_.ImGuiItemStatusFlags_Edited
import cimgui.internal.ImGuiItemStatusFlags_.ImGuiItemStatusFlags_HasDeactivated
import cimgui.internal.ImGuiItemStatusFlags_.ImGuiItemStatusFlags_HasDisplayRect
import cimgui.internal.ImGuiItemStatusFlags_.ImGuiItemStatusFlags_HoveredRect
import cimgui.internal.ImGuiItemStatusFlags_.ImGuiItemStatusFlags_ToggledOpen
import cimgui.internal.ImGuiItemStatusFlags_.ImGuiItemStatusFlags_ToggledSelection
import kotlin.Int

actual enum class ImGuiItemStatusFlags(
  override val value: Int
) : Flag<ImGuiItemStatusFlags> {
  HoveredRect(ImGuiItemStatusFlags_HoveredRect),

  HasDisplayRect(ImGuiItemStatusFlags_HasDisplayRect),

  Edited(ImGuiItemStatusFlags_Edited),

  ToggledSelection(ImGuiItemStatusFlags_ToggledSelection),

  ToggledOpen(ImGuiItemStatusFlags_ToggledOpen),

  HasDeactivated(ImGuiItemStatusFlags_HasDeactivated),

  Deactivated(ImGuiItemStatusFlags_Deactivated);

  override val info: Flag.EnumInfo<ImGuiItemStatusFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiItemStatusFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiItemStatusFlags = when (value) {
      ImGuiItemStatusFlags_HoveredRect -> HoveredRect
      ImGuiItemStatusFlags_HasDisplayRect -> HasDisplayRect
      ImGuiItemStatusFlags_Edited -> Edited
      ImGuiItemStatusFlags_ToggledSelection -> ToggledSelection
      ImGuiItemStatusFlags_ToggledOpen -> ToggledOpen
      ImGuiItemStatusFlags_HasDeactivated -> HasDeactivated
      ImGuiItemStatusFlags_Deactivated -> Deactivated
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiItemStatusFlags> = Flag(value, cachedInfo)
  }
}

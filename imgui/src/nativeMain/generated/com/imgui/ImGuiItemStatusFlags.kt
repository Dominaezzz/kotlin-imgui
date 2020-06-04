package com.imgui

import cimgui.internal.ImGuiItemStatusFlags_
import cimgui.internal.ImGuiItemStatusFlags_Deactivated
import cimgui.internal.ImGuiItemStatusFlags_Edited
import cimgui.internal.ImGuiItemStatusFlags_HasDeactivated
import cimgui.internal.ImGuiItemStatusFlags_HasDisplayRect
import cimgui.internal.ImGuiItemStatusFlags_HoveredRect
import cimgui.internal.ImGuiItemStatusFlags_ToggledOpen
import cimgui.internal.ImGuiItemStatusFlags_ToggledSelection
import kotlinx.cinterop.convert

actual enum class ImGuiItemStatusFlags(
  override val value: cimgui.internal.ImGuiItemStatusFlags
) : Flag<ImGuiItemStatusFlags> {
  HoveredRect(ImGuiItemStatusFlags_HoveredRect.convert()),

  HasDisplayRect(ImGuiItemStatusFlags_HasDisplayRect.convert()),

  Edited(ImGuiItemStatusFlags_Edited.convert()),

  ToggledSelection(ImGuiItemStatusFlags_ToggledSelection.convert()),

  ToggledOpen(ImGuiItemStatusFlags_ToggledOpen.convert()),

  HasDeactivated(ImGuiItemStatusFlags_HasDeactivated.convert()),

  Deactivated(ImGuiItemStatusFlags_Deactivated.convert());

  override val info: Flag.EnumInfo<ImGuiItemStatusFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiItemStatusFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiItemStatusFlags): ImGuiItemStatusFlags = when
        (value.convert<ImGuiItemStatusFlags_>()) {
      ImGuiItemStatusFlags_HoveredRect -> HoveredRect
      ImGuiItemStatusFlags_HasDisplayRect -> HasDisplayRect
      ImGuiItemStatusFlags_Edited -> Edited
      ImGuiItemStatusFlags_ToggledSelection -> ToggledSelection
      ImGuiItemStatusFlags_ToggledOpen -> ToggledOpen
      ImGuiItemStatusFlags_HasDeactivated -> HasDeactivated
      ImGuiItemStatusFlags_Deactivated -> Deactivated
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiItemStatusFlags): Flag<ImGuiItemStatusFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiItemFlags_
import cimgui.internal.ImGuiItemFlags_ButtonRepeat
import cimgui.internal.ImGuiItemFlags_Default_
import cimgui.internal.ImGuiItemFlags_Disabled
import cimgui.internal.ImGuiItemFlags_MixedValue
import cimgui.internal.ImGuiItemFlags_NoNav
import cimgui.internal.ImGuiItemFlags_NoNavDefaultFocus
import cimgui.internal.ImGuiItemFlags_NoTabStop
import cimgui.internal.ImGuiItemFlags_SelectableDontClosePopup
import kotlinx.cinterop.convert

actual enum class ImGuiItemFlags(
  override val value: cimgui.internal.ImGuiItemFlags
) : Flag<ImGuiItemFlags> {
  NoTabStop(ImGuiItemFlags_NoTabStop.convert()),

  ButtonRepeat(ImGuiItemFlags_ButtonRepeat.convert()),

  Disabled(ImGuiItemFlags_Disabled.convert()),

  NoNav(ImGuiItemFlags_NoNav.convert()),

  NoNavDefaultFocus(ImGuiItemFlags_NoNavDefaultFocus.convert()),

  SelectableDontClosePopup(ImGuiItemFlags_SelectableDontClosePopup.convert()),

  MixedValue(ImGuiItemFlags_MixedValue.convert()),

  Default_(ImGuiItemFlags_Default_.convert());

  override val info: Flag.EnumInfo<ImGuiItemFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiItemFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiItemFlags): ImGuiItemFlags = when
        (value.convert<ImGuiItemFlags_>()) {
      ImGuiItemFlags_NoTabStop -> NoTabStop
      ImGuiItemFlags_ButtonRepeat -> ButtonRepeat
      ImGuiItemFlags_Disabled -> Disabled
      ImGuiItemFlags_NoNav -> NoNav
      ImGuiItemFlags_NoNavDefaultFocus -> NoNavDefaultFocus
      ImGuiItemFlags_SelectableDontClosePopup -> SelectableDontClosePopup
      ImGuiItemFlags_MixedValue -> MixedValue
      ImGuiItemFlags_Default_ -> Default_
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiItemFlags): Flag<ImGuiItemFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

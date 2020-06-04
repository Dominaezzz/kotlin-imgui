package com.imgui

import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_ButtonRepeat
import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_Default_
import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_Disabled
import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_MixedValue
import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_NoNav
import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_NoNavDefaultFocus
import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_NoTabStop
import cimgui.internal.ImGuiItemFlags_.ImGuiItemFlags_SelectableDontClosePopup
import kotlin.Int

actual enum class ImGuiItemFlags(
  override val value: Int
) : Flag<ImGuiItemFlags> {
  NoTabStop(ImGuiItemFlags_NoTabStop),

  ButtonRepeat(ImGuiItemFlags_ButtonRepeat),

  Disabled(ImGuiItemFlags_Disabled),

  NoNav(ImGuiItemFlags_NoNav),

  NoNavDefaultFocus(ImGuiItemFlags_NoNavDefaultFocus),

  SelectableDontClosePopup(ImGuiItemFlags_SelectableDontClosePopup),

  MixedValue(ImGuiItemFlags_MixedValue),

  Default_(ImGuiItemFlags_Default_);

  override val info: Flag.EnumInfo<ImGuiItemFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiItemFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiItemFlags = when (value) {
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

    fun fromMultiple(value: Int): Flag<ImGuiItemFlags> = Flag(value, cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_AnyPopup
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_AnyPopupId
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_AnyPopupLevel
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_MouseButtonDefault_
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_MouseButtonLeft
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_MouseButtonMask_
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_MouseButtonMiddle
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_MouseButtonRight
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_NoOpenOverExistingPopup
import cimgui.internal.ImGuiPopupFlags_.ImGuiPopupFlags_NoOpenOverItems
import kotlin.Int

actual enum class ImGuiPopupFlags(
  override val value: Int
) : Flag<ImGuiPopupFlags> {
  MouseButtonLeft(ImGuiPopupFlags_MouseButtonLeft),

  NoOpenOverExistingPopup(ImGuiPopupFlags_NoOpenOverExistingPopup),

  NoOpenOverItems(ImGuiPopupFlags_NoOpenOverItems),

  AnyPopupId(ImGuiPopupFlags_AnyPopupId),

  AnyPopupLevel(ImGuiPopupFlags_AnyPopupLevel);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiPopupFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiPopupFlags> = Flag.enumInfo()

    actual val MouseButtonRight: Flag<ImGuiPopupFlags> = Flag(ImGuiPopupFlags_MouseButtonRight,
        cachedInfo)

    actual val MouseButtonMiddle: Flag<ImGuiPopupFlags> = Flag(ImGuiPopupFlags_MouseButtonMiddle,
        cachedInfo)

    actual val MouseButtonMask_: Flag<ImGuiPopupFlags> = Flag(ImGuiPopupFlags_MouseButtonMask_,
        cachedInfo)

    actual val MouseButtonDefault_: Flag<ImGuiPopupFlags> =
        Flag(ImGuiPopupFlags_MouseButtonDefault_, cachedInfo)

    actual val AnyPopup: Flag<ImGuiPopupFlags> = Flag(ImGuiPopupFlags_AnyPopup, cachedInfo)

    fun from(value: Int): ImGuiPopupFlags = when (value) {
      ImGuiPopupFlags_MouseButtonLeft -> MouseButtonLeft
      ImGuiPopupFlags_NoOpenOverExistingPopup -> NoOpenOverExistingPopup
      ImGuiPopupFlags_NoOpenOverItems -> NoOpenOverItems
      ImGuiPopupFlags_AnyPopupId -> AnyPopupId
      ImGuiPopupFlags_AnyPopupLevel -> AnyPopupLevel
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiPopupFlags> = Flag(value, cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiPopupFlags_
import cimgui.internal.ImGuiPopupFlags_AnyPopup
import cimgui.internal.ImGuiPopupFlags_AnyPopupId
import cimgui.internal.ImGuiPopupFlags_AnyPopupLevel
import cimgui.internal.ImGuiPopupFlags_MouseButtonDefault_
import cimgui.internal.ImGuiPopupFlags_MouseButtonLeft
import cimgui.internal.ImGuiPopupFlags_MouseButtonMask_
import cimgui.internal.ImGuiPopupFlags_MouseButtonMiddle
import cimgui.internal.ImGuiPopupFlags_MouseButtonRight
import cimgui.internal.ImGuiPopupFlags_NoOpenOverExistingPopup
import cimgui.internal.ImGuiPopupFlags_NoOpenOverItems
import kotlinx.cinterop.convert

actual enum class ImGuiPopupFlags(
  override val value: cimgui.internal.ImGuiPopupFlags
) : Flag<ImGuiPopupFlags> {
  MouseButtonLeft(ImGuiPopupFlags_MouseButtonLeft.convert()),

  NoOpenOverExistingPopup(ImGuiPopupFlags_NoOpenOverExistingPopup.convert()),

  NoOpenOverItems(ImGuiPopupFlags_NoOpenOverItems.convert()),

  AnyPopupId(ImGuiPopupFlags_AnyPopupId.convert()),

  AnyPopupLevel(ImGuiPopupFlags_AnyPopupLevel.convert());

  override val info: Flag.EnumInfo<ImGuiPopupFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiPopupFlags> = Flag.enumInfo()

    actual val MouseButtonRight: Flag<ImGuiPopupFlags> =
        Flag(ImGuiPopupFlags_MouseButtonRight.toInt(), cachedInfo)

    actual val MouseButtonMiddle: Flag<ImGuiPopupFlags> =
        Flag(ImGuiPopupFlags_MouseButtonMiddle.toInt(), cachedInfo)

    actual val MouseButtonMask_: Flag<ImGuiPopupFlags> =
        Flag(ImGuiPopupFlags_MouseButtonMask_.toInt(), cachedInfo)

    actual val MouseButtonDefault_: Flag<ImGuiPopupFlags> =
        Flag(ImGuiPopupFlags_MouseButtonDefault_.toInt(), cachedInfo)

    actual val AnyPopup: Flag<ImGuiPopupFlags> = Flag(ImGuiPopupFlags_AnyPopup.toInt(), cachedInfo)

    fun from(value: cimgui.internal.ImGuiPopupFlags): ImGuiPopupFlags = when
        (value.convert<ImGuiPopupFlags_>()) {
      ImGuiPopupFlags_MouseButtonLeft -> MouseButtonLeft
      ImGuiPopupFlags_NoOpenOverExistingPopup -> NoOpenOverExistingPopup
      ImGuiPopupFlags_NoOpenOverItems -> NoOpenOverItems
      ImGuiPopupFlags_AnyPopupId -> AnyPopupId
      ImGuiPopupFlags_AnyPopupLevel -> AnyPopupLevel
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiPopupFlags): Flag<ImGuiPopupFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiTabItemFlags_
import cimgui.internal.ImGuiTabItemFlags_NoCloseWithMiddleMouseButton
import cimgui.internal.ImGuiTabItemFlags_NoPushId
import cimgui.internal.ImGuiTabItemFlags_SetSelected
import cimgui.internal.ImGuiTabItemFlags_UnsavedDocument
import kotlin.Int
import kotlinx.cinterop.convert

actual enum class ImGuiTabItemFlags(
  override val value: cimgui.internal.ImGuiTabItemFlags
) : Flag<ImGuiTabItemFlags> {
  UnsavedDocument(ImGuiTabItemFlags_UnsavedDocument.convert()),

  SetSelected(ImGuiTabItemFlags_SetSelected.convert()),

  NoCloseWithMiddleMouseButton(ImGuiTabItemFlags_NoCloseWithMiddleMouseButton.convert()),

  NoPushId(ImGuiTabItemFlags_NoPushId.convert());

  actual val cValue: Int
    get() = value.convert()

  override val info: Flag.EnumInfo<ImGuiTabItemFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTabItemFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiTabItemFlags): ImGuiTabItemFlags = when
        (value.convert<ImGuiTabItemFlags_>()) {
      ImGuiTabItemFlags_UnsavedDocument -> UnsavedDocument
      ImGuiTabItemFlags_SetSelected -> SetSelected
      ImGuiTabItemFlags_NoCloseWithMiddleMouseButton -> NoCloseWithMiddleMouseButton
      ImGuiTabItemFlags_NoPushId -> NoPushId
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiTabItemFlags): Flag<ImGuiTabItemFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

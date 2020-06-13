package com.imgui

import cimgui.internal.ImGuiTabItemFlags_.ImGuiTabItemFlags_NoCloseWithMiddleMouseButton
import cimgui.internal.ImGuiTabItemFlags_.ImGuiTabItemFlags_NoPushId
import cimgui.internal.ImGuiTabItemFlags_.ImGuiTabItemFlags_SetSelected
import cimgui.internal.ImGuiTabItemFlags_.ImGuiTabItemFlags_UnsavedDocument
import kotlin.Int

actual enum class ImGuiTabItemFlags(
  override val value: Int
) : Flag<ImGuiTabItemFlags> {
  UnsavedDocument(ImGuiTabItemFlags_UnsavedDocument),

  SetSelected(ImGuiTabItemFlags_SetSelected),

  NoCloseWithMiddleMouseButton(ImGuiTabItemFlags_NoCloseWithMiddleMouseButton),

  NoPushId(ImGuiTabItemFlags_NoPushId);

  actual val cValue: Int
    get() = value

  override val info: Flag.EnumInfo<ImGuiTabItemFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTabItemFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiTabItemFlags = when (value) {
      ImGuiTabItemFlags_UnsavedDocument -> UnsavedDocument
      ImGuiTabItemFlags_SetSelected -> SetSelected
      ImGuiTabItemFlags_NoCloseWithMiddleMouseButton -> NoCloseWithMiddleMouseButton
      ImGuiTabItemFlags_NoPushId -> NoPushId
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiTabItemFlags> = Flag(value, cachedInfo)
  }
}

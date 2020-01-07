package com.imgui

import cimgui.internal.ImGuiTabItemFlags_NoCloseWithMiddleMouseButton
import cimgui.internal.ImGuiTabItemFlags_NoPushId
import cimgui.internal.ImGuiTabItemFlags_SetSelected
import cimgui.internal.ImGuiTabItemFlags_UnsavedDocument
import kotlin.Int

enum class ImGuiTabItemFlags(
  override val value: Int
) : Flag<ImGuiTabItemFlags> {
  UnsavedDocument(ImGuiTabItemFlags_UnsavedDocument.toInt()),

  SetSelected(ImGuiTabItemFlags_SetSelected.toInt()),

  NoCloseWithMiddleMouseButton(ImGuiTabItemFlags_NoCloseWithMiddleMouseButton.toInt()),

  NoPushId(ImGuiTabItemFlags_NoPushId.toInt());

  override val info: Flag.EnumInfo<ImGuiTabItemFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiTabItemFlags> = Flag.enumInfo()
  }
}

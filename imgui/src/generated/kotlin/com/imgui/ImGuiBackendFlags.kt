package com.imgui

import cimgui.internal.ImGuiBackendFlags_HasGamepad
import cimgui.internal.ImGuiBackendFlags_HasMouseCursors
import cimgui.internal.ImGuiBackendFlags_HasSetMousePos
import cimgui.internal.ImGuiBackendFlags_RendererHasVtxOffset
import kotlin.Int

enum class ImGuiBackendFlags(
  override val value: Int
) : Flag<ImGuiBackendFlags> {
  HasGamepad(ImGuiBackendFlags_HasGamepad.toInt()),

  HasMouseCursors(ImGuiBackendFlags_HasMouseCursors.toInt()),

  HasSetMousePos(ImGuiBackendFlags_HasSetMousePos.toInt()),

  RendererHasVtxOffset(ImGuiBackendFlags_RendererHasVtxOffset.toInt());

  override val info: Flag.EnumInfo<ImGuiBackendFlags>
    get() = cachedInfo
  companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiBackendFlags> = Flag.enumInfo()
  }
}

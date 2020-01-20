package com.imgui

import cimgui.internal.ImGuiBackendFlags_
import cimgui.internal.ImGuiBackendFlags_HasGamepad
import cimgui.internal.ImGuiBackendFlags_HasMouseCursors
import cimgui.internal.ImGuiBackendFlags_HasSetMousePos
import cimgui.internal.ImGuiBackendFlags_RendererHasVtxOffset
import kotlinx.cinterop.convert

actual enum class ImGuiBackendFlags(
  override val value: cimgui.internal.ImGuiBackendFlags
) : Flag<ImGuiBackendFlags> {
  HasGamepad(ImGuiBackendFlags_HasGamepad.convert()),

  HasMouseCursors(ImGuiBackendFlags_HasMouseCursors.convert()),

  HasSetMousePos(ImGuiBackendFlags_HasSetMousePos.convert()),

  RendererHasVtxOffset(ImGuiBackendFlags_RendererHasVtxOffset.convert());

  override val info: Flag.EnumInfo<ImGuiBackendFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiBackendFlags> = Flag.enumInfo()

    fun from(value: cimgui.internal.ImGuiBackendFlags): ImGuiBackendFlags = when
        (value.convert<ImGuiBackendFlags_>()) {
      ImGuiBackendFlags_HasGamepad -> HasGamepad
      ImGuiBackendFlags_HasMouseCursors -> HasMouseCursors
      ImGuiBackendFlags_HasSetMousePos -> HasSetMousePos
      ImGuiBackendFlags_RendererHasVtxOffset -> RendererHasVtxOffset
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiBackendFlags): Flag<ImGuiBackendFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

package com.imgui

import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_HasGamepad
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_HasMouseCursors
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_HasSetMousePos
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_RendererHasVtxOffset
import kotlin.Int

actual enum class ImGuiBackendFlags(
  override val value: Int
) : Flag<ImGuiBackendFlags> {
  HasGamepad(ImGuiBackendFlags_HasGamepad),

  HasMouseCursors(ImGuiBackendFlags_HasMouseCursors),

  HasSetMousePos(ImGuiBackendFlags_HasSetMousePos),

  RendererHasVtxOffset(ImGuiBackendFlags_RendererHasVtxOffset);

  override val info: Flag.EnumInfo<ImGuiBackendFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiBackendFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiBackendFlags = when (value) {
      ImGuiBackendFlags_HasGamepad -> HasGamepad
      ImGuiBackendFlags_HasMouseCursors -> HasMouseCursors
      ImGuiBackendFlags_HasSetMousePos -> HasSetMousePos
      ImGuiBackendFlags_RendererHasVtxOffset -> RendererHasVtxOffset
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiBackendFlags> = Flag(value, cachedInfo)
  }
}

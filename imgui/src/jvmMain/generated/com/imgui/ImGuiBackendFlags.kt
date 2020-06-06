package com.imgui

import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_HasGamepad
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_HasMouseCursors
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_HasMouseHoveredViewport
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_HasSetMousePos
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_PlatformHasViewports
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_RendererHasViewports
import cimgui.internal.ImGuiBackendFlags_.ImGuiBackendFlags_RendererHasVtxOffset
import kotlin.Int

actual enum class ImGuiBackendFlags(
  override val value: Int
) : Flag<ImGuiBackendFlags> {
  HasGamepad(ImGuiBackendFlags_HasGamepad),

  HasMouseCursors(ImGuiBackendFlags_HasMouseCursors),

  HasSetMousePos(ImGuiBackendFlags_HasSetMousePos),

  RendererHasVtxOffset(ImGuiBackendFlags_RendererHasVtxOffset),

  PlatformHasViewports(ImGuiBackendFlags_PlatformHasViewports),

  HasMouseHoveredViewport(ImGuiBackendFlags_HasMouseHoveredViewport),

  RendererHasViewports(ImGuiBackendFlags_RendererHasViewports);

  override val info: Flag.EnumInfo<ImGuiBackendFlags>
    get() = cachedInfo
  actual companion object {
    private val cachedInfo: Flag.EnumInfo<ImGuiBackendFlags> = Flag.enumInfo()

    fun from(value: Int): ImGuiBackendFlags = when (value) {
      ImGuiBackendFlags_HasGamepad -> HasGamepad
      ImGuiBackendFlags_HasMouseCursors -> HasMouseCursors
      ImGuiBackendFlags_HasSetMousePos -> HasSetMousePos
      ImGuiBackendFlags_RendererHasVtxOffset -> RendererHasVtxOffset
      ImGuiBackendFlags_PlatformHasViewports -> PlatformHasViewports
      ImGuiBackendFlags_HasMouseHoveredViewport -> HasMouseHoveredViewport
      ImGuiBackendFlags_RendererHasViewports -> RendererHasViewports
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: Int): Flag<ImGuiBackendFlags> = Flag(value, cachedInfo)
  }
}

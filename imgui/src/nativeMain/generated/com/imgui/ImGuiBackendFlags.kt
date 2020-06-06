package com.imgui

import cimgui.internal.ImGuiBackendFlags_
import cimgui.internal.ImGuiBackendFlags_HasGamepad
import cimgui.internal.ImGuiBackendFlags_HasMouseCursors
import cimgui.internal.ImGuiBackendFlags_HasMouseHoveredViewport
import cimgui.internal.ImGuiBackendFlags_HasSetMousePos
import cimgui.internal.ImGuiBackendFlags_PlatformHasViewports
import cimgui.internal.ImGuiBackendFlags_RendererHasViewports
import cimgui.internal.ImGuiBackendFlags_RendererHasVtxOffset
import kotlinx.cinterop.convert

actual enum class ImGuiBackendFlags(
  override val value: cimgui.internal.ImGuiBackendFlags
) : Flag<ImGuiBackendFlags> {
  HasGamepad(ImGuiBackendFlags_HasGamepad.convert()),

  HasMouseCursors(ImGuiBackendFlags_HasMouseCursors.convert()),

  HasSetMousePos(ImGuiBackendFlags_HasSetMousePos.convert()),

  RendererHasVtxOffset(ImGuiBackendFlags_RendererHasVtxOffset.convert()),

  PlatformHasViewports(ImGuiBackendFlags_PlatformHasViewports.convert()),

  HasMouseHoveredViewport(ImGuiBackendFlags_HasMouseHoveredViewport.convert()),

  RendererHasViewports(ImGuiBackendFlags_RendererHasViewports.convert());

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
      ImGuiBackendFlags_PlatformHasViewports -> PlatformHasViewports
      ImGuiBackendFlags_HasMouseHoveredViewport -> HasMouseHoveredViewport
      ImGuiBackendFlags_RendererHasViewports -> RendererHasViewports
      else -> throw NoSuchElementException("""Unknown enum constant $value""")
    }

    fun fromMultiple(value: cimgui.internal.ImGuiBackendFlags): Flag<ImGuiBackendFlags> =
        Flag(value.convert(), cachedInfo)
  }
}

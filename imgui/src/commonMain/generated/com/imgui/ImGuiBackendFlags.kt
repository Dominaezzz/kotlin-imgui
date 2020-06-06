package com.imgui

expect enum class ImGuiBackendFlags : Flag<ImGuiBackendFlags> {
  HasGamepad,

  HasMouseCursors,

  HasSetMousePos,

  RendererHasVtxOffset,

  PlatformHasViewports,

  HasMouseHoveredViewport,

  RendererHasViewports;

  companion object
}

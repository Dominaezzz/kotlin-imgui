package com.imgui

expect enum class ImGuiBackendFlags : Flag<ImGuiBackendFlags> {
  HasGamepad,

  HasMouseCursors,

  HasSetMousePos,

  RendererHasVtxOffset;

  companion object
}

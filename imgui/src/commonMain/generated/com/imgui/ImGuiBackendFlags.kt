package com.imgui

import kotlin.Int

expect enum class ImGuiBackendFlags : Flag<ImGuiBackendFlags> {
  HasGamepad,

  HasMouseCursors,

  HasSetMousePos,

  RendererHasVtxOffset;

  val cValue: Int

  companion object
}

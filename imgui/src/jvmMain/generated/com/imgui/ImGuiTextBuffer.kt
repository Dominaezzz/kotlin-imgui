package com.imgui

import cimgui.internal.CImGui.ImGuiTextBuffer_ImGuiTextBuffer
import cimgui.internal.CImGui.ImGuiTextBuffer_append
import cimgui.internal.CImGui.ImGuiTextBuffer_appendf
import cimgui.internal.CImGui.ImGuiTextBuffer_begin
import cimgui.internal.CImGui.ImGuiTextBuffer_c_str
import cimgui.internal.CImGui.ImGuiTextBuffer_clear
import cimgui.internal.CImGui.ImGuiTextBuffer_destroy
import cimgui.internal.CImGui.ImGuiTextBuffer_empty
import cimgui.internal.CImGui.ImGuiTextBuffer_end
import cimgui.internal.CImGui.ImGuiTextBuffer_reserve
import cimgui.internal.CImGui.ImGuiTextBuffer_size
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTextBuffer(
  val ptr: cimgui.internal.ImGuiTextBuffer
) {
  actual constructor() : this(ImGuiTextBuffer_ImGuiTextBuffer()!!)

  actual fun append(str: String, strEnd: String?) {
    ImGuiTextBuffer_append(ptr, str, strEnd)
  }

  actual fun appendf(fmt: String) {
    ImGuiTextBuffer_appendf(ptr, fmt)
  }

  actual fun begin(): String? = ImGuiTextBuffer_begin(ptr)

  actual fun c_str(): String? = ImGuiTextBuffer_c_str(ptr)

  actual fun clear() {
    ImGuiTextBuffer_clear(ptr)
  }

  actual fun destroy() {
    ImGuiTextBuffer_destroy(ptr)
  }

  actual fun empty(): Boolean = ImGuiTextBuffer_empty(ptr)

  actual fun end(): String? = ImGuiTextBuffer_end(ptr)

  actual fun reserve(capacity: Int) {
    ImGuiTextBuffer_reserve(ptr, capacity)
  }

  actual fun size(): Int = ImGuiTextBuffer_size(ptr)
}

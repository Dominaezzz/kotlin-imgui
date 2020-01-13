package com.imgui

import cimgui.internal.ImGuiTextBuffer_ImGuiTextBuffer
import cimgui.internal.ImGuiTextBuffer_append
import cimgui.internal.ImGuiTextBuffer_appendf
import cimgui.internal.ImGuiTextBuffer_begin
import cimgui.internal.ImGuiTextBuffer_c_str
import cimgui.internal.ImGuiTextBuffer_clear
import cimgui.internal.ImGuiTextBuffer_destroy
import cimgui.internal.ImGuiTextBuffer_empty
import cimgui.internal.ImGuiTextBuffer_end
import cimgui.internal.ImGuiTextBuffer_reserve
import cimgui.internal.ImGuiTextBuffer_size
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.toKString

inline class ImGuiTextBuffer(
  val ptr: CPointer<cimgui.internal.ImGuiTextBuffer>
) {
  constructor() : this(ImGuiTextBuffer_ImGuiTextBuffer()!!)

  fun append(str: String, strEnd: String? = null) {
    ImGuiTextBuffer_append(ptr, str, strEnd)
  }

  fun appendf(fmt: String) {
    ImGuiTextBuffer_appendf(ptr, fmt)
  }

  fun begin(): String? = ImGuiTextBuffer_begin(ptr)?.toKString()

  fun c_str(): String? = ImGuiTextBuffer_c_str(ptr)?.toKString()

  fun clear() {
    ImGuiTextBuffer_clear(ptr)
  }

  fun destroy() {
    ImGuiTextBuffer_destroy(ptr)
  }

  fun empty(): Boolean = ImGuiTextBuffer_empty(ptr)

  fun end(): String? = ImGuiTextBuffer_end(ptr)?.toKString()

  fun reserve(capacity: Int) {
    ImGuiTextBuffer_reserve(ptr, capacity)
  }

  fun size(): Int = ImGuiTextBuffer_size(ptr)
}

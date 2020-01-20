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
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.toKString

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTextBuffer(
  val ptr: CPointer<cimgui.internal.ImGuiTextBuffer>
) {
  actual constructor() : this(ImGuiTextBuffer_ImGuiTextBuffer()!!)

  actual fun append(str: String, strEnd: String?) {
    ImGuiTextBuffer_append(ptr, str, strEnd)
  }

  actual fun appendf(fmt: String) {
    ImGuiTextBuffer_appendf(ptr, fmt)
  }

  actual fun begin(): String? = ImGuiTextBuffer_begin(ptr)?.toKString()

  actual fun c_str(): String? = ImGuiTextBuffer_c_str(ptr)?.toKString()

  actual fun clear() {
    ImGuiTextBuffer_clear(ptr)
  }

  actual fun destroy() {
    ImGuiTextBuffer_destroy(ptr)
  }

  actual fun empty(): Boolean = ImGuiTextBuffer_empty(ptr)

  actual fun end(): String? = ImGuiTextBuffer_end(ptr)?.toKString()

  actual fun reserve(capacity: Int) {
    ImGuiTextBuffer_reserve(ptr, capacity)
  }

  actual fun size(): Int = ImGuiTextBuffer_size(ptr)
}

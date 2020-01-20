package com.imgui

import cimgui.internal.ImGuiTextFilter_Build
import cimgui.internal.ImGuiTextFilter_Clear
import cimgui.internal.ImGuiTextFilter_Draw
import cimgui.internal.ImGuiTextFilter_ImGuiTextFilter
import cimgui.internal.ImGuiTextFilter_IsActive
import cimgui.internal.ImGuiTextFilter_PassFilter
import cimgui.internal.ImGuiTextFilter_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTextFilter(
  val ptr: CPointer<cimgui.internal.ImGuiTextFilter>
) {
  actual val countGrep: Int
    get() = ptr.pointed.CountGrep

  actual constructor(defaultFilter: String) : this(ImGuiTextFilter_ImGuiTextFilter(defaultFilter)!!)

  actual fun build() {
    ImGuiTextFilter_Build(ptr)
  }

  actual fun clear() {
    ImGuiTextFilter_Clear(ptr)
  }

  actual fun draw(label: String, width: Float): Boolean = ImGuiTextFilter_Draw(ptr, label, width)

  actual fun isActive(): Boolean = ImGuiTextFilter_IsActive(ptr)

  actual fun passFilter(text: String, textEnd: String?): Boolean = ImGuiTextFilter_PassFilter(ptr,
      text, textEnd)

  actual fun destroy() {
    ImGuiTextFilter_destroy(ptr)
  }
}

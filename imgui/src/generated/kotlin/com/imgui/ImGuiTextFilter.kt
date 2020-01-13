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
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiTextFilter(
  val ptr: CPointer<cimgui.internal.ImGuiTextFilter>
) {
  val countGrep: Int
    get() = ptr.pointed.CountGrep

  constructor(defaultFilter: String = "") : this(ImGuiTextFilter_ImGuiTextFilter(defaultFilter)!!)

  fun build() {
    ImGuiTextFilter_Build(ptr)
  }

  fun clear() {
    ImGuiTextFilter_Clear(ptr)
  }

  fun draw(label: String = "Filter(inc,-exc)", width: Float = 0.0f): Boolean =
      ImGuiTextFilter_Draw(ptr, label, width)

  fun isActive(): Boolean = ImGuiTextFilter_IsActive(ptr)

  fun passFilter(text: String, textEnd: String? = null): Boolean = ImGuiTextFilter_PassFilter(ptr,
      text, textEnd)

  fun destroy() {
    ImGuiTextFilter_destroy(ptr)
  }
}

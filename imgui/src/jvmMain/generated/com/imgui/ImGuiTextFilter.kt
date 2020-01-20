package com.imgui

import cimgui.internal.CImGui.ImGuiTextFilter_Build
import cimgui.internal.CImGui.ImGuiTextFilter_Clear
import cimgui.internal.CImGui.ImGuiTextFilter_Draw
import cimgui.internal.CImGui.ImGuiTextFilter_ImGuiTextFilter
import cimgui.internal.CImGui.ImGuiTextFilter_IsActive
import cimgui.internal.CImGui.ImGuiTextFilter_PassFilter
import cimgui.internal.CImGui.ImGuiTextFilter_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTextFilter(
  val ptr: cimgui.internal.ImGuiTextFilter
) {
  actual val countGrep: Int
    get() = ptr.countGrep

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

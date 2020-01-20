package com.imgui

import cimgui.internal.CImGui.ImGuiTextRange_ImGuiTextRange
import cimgui.internal.CImGui.ImGuiTextRange_ImGuiTextRangeStr
import cimgui.internal.CImGui.ImGuiTextRange_destroy
import cimgui.internal.CImGui.ImGuiTextRange_empty
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTextRange(
  val ptr: cimgui.internal.ImGuiTextRange
) {
  actual val b: String
    get() = ptr.b!!

  actual val e: String
    get() = ptr.e!!

  actual constructor() : this(ImGuiTextRange_ImGuiTextRange()!!)

  actual constructor(b: String, e: String) : this(ImGuiTextRange_ImGuiTextRangeStr(b, e)!!)

  actual fun destroy() {
    ImGuiTextRange_destroy(ptr)
  }

  actual fun empty(): Boolean = ImGuiTextRange_empty(ptr)
}

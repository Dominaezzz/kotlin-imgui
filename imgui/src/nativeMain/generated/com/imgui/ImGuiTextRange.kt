package com.imgui

import cimgui.internal.ImGuiTextRange_ImGuiTextRange
import cimgui.internal.ImGuiTextRange_ImGuiTextRangeStr
import cimgui.internal.ImGuiTextRange_destroy
import cimgui.internal.ImGuiTextRange_empty
import kotlin.Boolean
import kotlin.String
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

inline class ImGuiTextRange(
  val ptr: CPointer<cimgui.internal.ImGuiTextRange>
) {
  val b: String
    get() = ptr.pointed.b!!.toKString()

  val e: String
    get() = ptr.pointed.e!!.toKString()

  constructor() : this(ImGuiTextRange_ImGuiTextRange()!!)

  constructor(b: String, e: String) : this(ImGuiTextRange_ImGuiTextRangeStr(b, e)!!)

  fun destroy() {
    ImGuiTextRange_destroy(ptr)
  }

  fun empty(): Boolean = ImGuiTextRange_empty(ptr)
}

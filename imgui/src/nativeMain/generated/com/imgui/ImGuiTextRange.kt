package com.imgui

import cimgui.internal.ImGuiTextRange_ImGuiTextRangeNil
import cimgui.internal.ImGuiTextRange_ImGuiTextRangeStr
import cimgui.internal.ImGuiTextRange_destroy
import cimgui.internal.ImGuiTextRange_empty
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed
import kotlinx.cinterop.toKString

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiTextRange(
  val ptr: CPointer<cimgui.internal.ImGuiTextRange>
) {
  actual val b: String
    get() = ptr.pointed.b!!.toKString()

  actual val e: String
    get() = ptr.pointed.e!!.toKString()

  actual constructor() : this(ImGuiTextRange_ImGuiTextRangeNil()!!)

  actual constructor(b: String, e: String) : this(ImGuiTextRange_ImGuiTextRangeStr(b, e)!!)

  actual fun destroy() {
    ImGuiTextRange_destroy(ptr)
  }

  actual fun empty(): Boolean = ImGuiTextRange_empty(ptr)
}

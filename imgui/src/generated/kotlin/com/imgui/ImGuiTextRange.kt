package com.imgui

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
}

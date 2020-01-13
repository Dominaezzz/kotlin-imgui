package com.imgui

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImDrawList(
  val ptr: CPointer<cimgui.internal.ImDrawList>
) {
  val flags: Flag<ImDrawListFlags>
    get() = ptr.pointed.Flags.let { ImDrawListFlags.fromMultiple(it) }
}

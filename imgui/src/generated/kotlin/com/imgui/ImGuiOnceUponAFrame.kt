package com.imgui

import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiOnceUponAFrame(
  val ptr: CPointer<cimgui.internal.ImGuiOnceUponAFrame>
) {
  val refFrame: Int
    get() = ptr.pointed.RefFrame
}

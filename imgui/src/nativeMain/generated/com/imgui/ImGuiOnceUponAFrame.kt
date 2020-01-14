package com.imgui

import cimgui.internal.ImGuiOnceUponAFrame_ImGuiOnceUponAFrame
import cimgui.internal.ImGuiOnceUponAFrame_destroy
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiOnceUponAFrame(
  val ptr: CPointer<cimgui.internal.ImGuiOnceUponAFrame>
) {
  val refFrame: Int
    get() = ptr.pointed.RefFrame

  constructor() : this(ImGuiOnceUponAFrame_ImGuiOnceUponAFrame()!!)

  fun destroy() {
    ImGuiOnceUponAFrame_destroy(ptr)
  }
}

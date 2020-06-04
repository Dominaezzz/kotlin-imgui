package com.imgui

import cimgui.internal.ImGuiPtrOrIndex_ImGuiPtrOrIndexInt
import cimgui.internal.ImGuiPtrOrIndex_destroy
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiPtrOrIndex(
  val ptr: CPointer<cimgui.internal.ImGuiPtrOrIndex>
) {
  actual val index: Int
    get() = ptr.pointed.Index

  actual constructor(index: Int) : this(ImGuiPtrOrIndex_ImGuiPtrOrIndexInt(index)!!)

  actual fun destroy() {
    ImGuiPtrOrIndex_destroy(ptr)
  }
}

package com.imgui

import cimgui.internal.ImVec2ih_ImVec2ihNil
import cimgui.internal.ImVec2ih_ImVec2ihshort
import cimgui.internal.ImVec2ih_destroy
import kotlin.Short
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImVec2ih(
  val ptr: CPointer<cimgui.internal.ImVec2ih>
) {
  actual val x: Short
    get() = ptr.pointed.x

  actual val y: Short
    get() = ptr.pointed.y

  actual constructor() : this(ImVec2ih_ImVec2ihNil()!!)

  actual constructor(x: Short, y: Short) : this(ImVec2ih_ImVec2ihshort(x, y)!!)

  actual fun destroy() {
    ImVec2ih_destroy(ptr)
  }
}

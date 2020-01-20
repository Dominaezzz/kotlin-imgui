package com.imgui

import cimgui.internal.ImGuiListClipper_Begin
import cimgui.internal.ImGuiListClipper_End
import cimgui.internal.ImGuiListClipper_ImGuiListClipper
import cimgui.internal.ImGuiListClipper_Step
import cimgui.internal.ImGuiListClipper_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiListClipper(
  val ptr: CPointer<cimgui.internal.ImGuiListClipper>
) {
  actual val startPosY: Float
    get() = ptr.pointed.StartPosY

  actual val itemsHeight: Float
    get() = ptr.pointed.ItemsHeight

  actual val itemsCount: Int
    get() = ptr.pointed.ItemsCount

  actual val stepNo: Int
    get() = ptr.pointed.StepNo

  actual val displayStart: Int
    get() = ptr.pointed.DisplayStart

  actual val displayEnd: Int
    get() = ptr.pointed.DisplayEnd

  actual constructor(itemsCount: Int, itemsHeight: Float) :
      this(ImGuiListClipper_ImGuiListClipper(itemsCount, itemsHeight)!!)

  actual fun begin(itemsCount: Int, itemsHeight: Float) {
    ImGuiListClipper_Begin(ptr, itemsCount, itemsHeight)
  }

  actual fun end() {
    ImGuiListClipper_End(ptr)
  }

  actual fun step(): Boolean = ImGuiListClipper_Step(ptr)

  actual fun destroy() {
    ImGuiListClipper_destroy(ptr)
  }
}

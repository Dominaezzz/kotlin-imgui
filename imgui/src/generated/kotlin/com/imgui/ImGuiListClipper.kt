package com.imgui

import cimgui.internal.ImGuiListClipper_Begin
import cimgui.internal.ImGuiListClipper_End
import cimgui.internal.ImGuiListClipper_ImGuiListClipper
import cimgui.internal.ImGuiListClipper_Step
import cimgui.internal.ImGuiListClipper_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.pointed

inline class ImGuiListClipper(
  val ptr: CPointer<cimgui.internal.ImGuiListClipper>
) {
  val startPosY: Float
    get() = ptr.pointed.StartPosY

  val itemsHeight: Float
    get() = ptr.pointed.ItemsHeight

  val itemsCount: Int
    get() = ptr.pointed.ItemsCount

  val stepNo: Int
    get() = ptr.pointed.StepNo

  val displayStart: Int
    get() = ptr.pointed.DisplayStart

  val displayEnd: Int
    get() = ptr.pointed.DisplayEnd

  constructor(itemsCount: Int = -1, itemsHeight: Float = -1.0f) :
      this(ImGuiListClipper_ImGuiListClipper(itemsCount, itemsHeight)!!)

  fun begin(itemsCount: Int, itemsHeight: Float = -1.0f) {
    ImGuiListClipper_Begin(ptr, itemsCount, itemsHeight)
  }

  fun end() {
    ImGuiListClipper_End(ptr)
  }

  fun step(): Boolean = ImGuiListClipper_Step(ptr)

  fun destroy() {
    ImGuiListClipper_destroy(ptr)
  }
}

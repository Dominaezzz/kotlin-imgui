package com.imgui

import cimgui.internal.CImGui.ImGuiListClipper_Begin
import cimgui.internal.CImGui.ImGuiListClipper_End
import cimgui.internal.CImGui.ImGuiListClipper_ImGuiListClipper
import cimgui.internal.CImGui.ImGuiListClipper_Step
import cimgui.internal.CImGui.ImGuiListClipper_destroy
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImGuiListClipper(
  val ptr: cimgui.internal.ImGuiListClipper
) {
  actual val displayStart: Int
    get() = ptr.displayStart

  actual val displayEnd: Int
    get() = ptr.displayEnd

  actual val itemsCount: Int
    get() = ptr.itemsCount

  actual val stepNo: Int
    get() = ptr.stepNo

  actual val itemsHeight: Float
    get() = ptr.itemsHeight

  actual val startPosY: Float
    get() = ptr.startPosY

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

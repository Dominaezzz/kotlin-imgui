package com.imgui

import cimgui.internal.CImGui.ImDrawListSplitter_Clear
import cimgui.internal.CImGui.ImDrawListSplitter_ClearFreeMemory
import cimgui.internal.CImGui.ImDrawListSplitter_ImDrawListSplitter
import cimgui.internal.CImGui.ImDrawListSplitter_Merge
import cimgui.internal.CImGui.ImDrawListSplitter_SetCurrentChannel
import cimgui.internal.CImGui.ImDrawListSplitter_Split
import cimgui.internal.CImGui.ImDrawListSplitter_destroy
import kotlin.Int
import kotlin.Suppress

@Suppress("ACTUAL_WITHOUT_EXPECT")
actual inline class ImDrawListSplitter(
  val ptr: cimgui.internal.ImDrawListSplitter
) {
  actual constructor() : this(ImDrawListSplitter_ImDrawListSplitter()!!)

  actual fun clear() {
    ImDrawListSplitter_Clear(ptr)
  }

  actual fun clearFreeMemory() {
    ImDrawListSplitter_ClearFreeMemory(ptr)
  }

  actual fun merge(drawList: ImDrawList) {
    ImDrawListSplitter_Merge(ptr, drawList.ptr)
  }

  actual fun setCurrentChannel(drawList: ImDrawList, channelIdx: Int) {
    ImDrawListSplitter_SetCurrentChannel(ptr, drawList.ptr, channelIdx)
  }

  actual fun split(drawList: ImDrawList, count: Int) {
    ImDrawListSplitter_Split(ptr, drawList.ptr, count)
  }

  actual fun destroy() {
    ImDrawListSplitter_destroy(ptr)
  }
}

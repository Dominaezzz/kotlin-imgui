package com.imgui

import cimgui.internal.ImDrawListSplitter_Clear
import cimgui.internal.ImDrawListSplitter_ClearFreeMemory
import cimgui.internal.ImDrawListSplitter_ImDrawListSplitter
import cimgui.internal.ImDrawListSplitter_Merge
import cimgui.internal.ImDrawListSplitter_SetCurrentChannel
import cimgui.internal.ImDrawListSplitter_Split
import cimgui.internal.ImDrawListSplitter_destroy
import kotlin.Int
import kotlinx.cinterop.CPointer

inline class ImDrawListSplitter(
  val ptr: CPointer<cimgui.internal.ImDrawListSplitter>
) {
  constructor() : this(ImDrawListSplitter_ImDrawListSplitter()!!)

  fun clear() {
    ImDrawListSplitter_Clear(ptr)
  }

  fun clearFreeMemory() {
    ImDrawListSplitter_ClearFreeMemory(ptr)
  }

  fun merge(drawList: ImDrawList) {
    ImDrawListSplitter_Merge(ptr, drawList.ptr)
  }

  fun setCurrentChannel(drawList: ImDrawList, channelIdx: Int) {
    ImDrawListSplitter_SetCurrentChannel(ptr, drawList.ptr, channelIdx)
  }

  fun split(drawList: ImDrawList, count: Int) {
    ImDrawListSplitter_Split(ptr, drawList.ptr, count)
  }

  fun destroy() {
    ImDrawListSplitter_destroy(ptr)
  }
}

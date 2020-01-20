package com.imgui

import kotlin.Int

expect class ImDrawListSplitter {
  constructor()

  fun clear()

  fun clearFreeMemory()

  fun merge(drawList: ImDrawList)

  fun setCurrentChannel(drawList: ImDrawList, channelIdx: Int)

  fun split(drawList: ImDrawList, count: Int)

  fun destroy()
}

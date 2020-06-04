package com.imgui

expect class ImDrawDataBuilder {
  fun clear()

  fun clearFreeMemory()

  fun flattenIntoSingleLayer()
}

package com.imgui

import kotlin.Boolean
import kotlin.Float
import kotlin.Int

expect class ImGuiStorage {
  fun buildSortByKey()

  fun clear()

  fun getBool(key: ImGuiID, defaultVal: Boolean = false): Boolean

  fun getFloat(key: ImGuiID, defaultVal: Float = 0.0f): Float

  fun getInt(key: ImGuiID, defaultVal: Int = 0): Int

  fun setAllInt(`val`: Int)

  fun setBool(key: ImGuiID, `val`: Boolean)

  fun setFloat(key: ImGuiID, `val`: Float)

  fun setInt(key: ImGuiID, `val`: Int)
}

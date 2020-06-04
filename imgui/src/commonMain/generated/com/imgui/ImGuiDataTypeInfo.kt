package com.imgui

import kotlin.String
import kotlin.ULong

expect class ImGuiDataTypeInfo {
  val size: ULong

  val printFmt: String

  val scanFmt: String
}

package com.imgui

import kotlin.Boolean

expect class ImGuiDockContext {
  val wantFullRebuild: Boolean

  fun destroy()
}

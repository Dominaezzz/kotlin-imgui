package com.imgui.impl

import com.imgui.*
import com.kgl.glfw.*

expect val isMacOS: Boolean
expect val isWin32: Boolean

expect fun setupClipboard(ioObj: ImGuiIO, window: Window)

expect fun freeClipboard(ioObj: ImGuiIO)

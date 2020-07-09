package com.imgui.impl

import com.imgui.*
import com.kgl.glfw.*


expect fun setupClipboard(ioObj: ImGuiIO, window: Window)

expect fun freeClipboard(ioObj: ImGuiIO)

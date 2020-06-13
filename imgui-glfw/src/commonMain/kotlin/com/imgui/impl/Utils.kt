package com.imgui.impl

import com.imgui.ImGuiIO
import com.kgl.glfw.Window


expect fun setupClipboard(ioObj: ImGuiIO, window: Window)

expect fun freeClipboard(ioObj: ImGuiIO)

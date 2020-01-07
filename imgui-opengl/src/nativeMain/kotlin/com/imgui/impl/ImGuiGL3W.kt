package com.imgui.impl

import cgl3w.gl3wInit
import cimgui.internal.impl.ImGui_ImplOpenGL3_Init
import cimgui.internal.impl.ImGui_ImplOpenGL3_NewFrame
import cimgui.internal.impl.ImGui_ImplOpenGL3_RenderDrawData
import cimgui.internal.impl.ImGui_ImplOpenGL3_Shutdown
import com.imgui.ImDrawData

object ImGuiGL3W {

	fun init(glslVersion: String? = null) {
		check(gl3wInit() == 0) { "Failed to initialize OpenGL loader!" }
		ImGui_ImplOpenGL3_Init(glslVersion)
	}

	fun newFrame() {
		ImGui_ImplOpenGL3_NewFrame()
	}

	fun renderDrawData(drawData: ImDrawData) {
		ImGui_ImplOpenGL3_RenderDrawData(drawData.ptr)
	}

	fun shutDown() {
		ImGui_ImplOpenGL3_Shutdown()
	}
}

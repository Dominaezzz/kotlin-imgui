package cimgui.internal

interface InputTextCallback {
	operator fun invoke(data: Long /* ImGuiInputTextCallbackData */): Int
}

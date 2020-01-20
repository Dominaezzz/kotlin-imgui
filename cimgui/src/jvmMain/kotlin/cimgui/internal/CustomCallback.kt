package cimgui.internal

interface CustomCallback {
	operator fun invoke(data: Long /* ImGuiSizeCallbackData */)
}

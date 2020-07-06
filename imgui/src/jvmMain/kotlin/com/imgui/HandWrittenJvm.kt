package com.imgui

import cimgui.internal.*
import kotlin.reflect.KMutableProperty0


internal inline fun <T> withCallback(noinline callback: ImGuiInputTextCallback? = null, block: (actualCallback: InputTextCallback?) -> T): T {
	return if (callback != null) {
		val jvmCallback = object : InputTextCallback {
			override fun invoke(data: Long): Int {
				val swigData = ImGuiInputTextCallbackData(data, false)
				val actualData = ImGuiInputTextCallbackData(swigData)
				return callback(actualData)
			}
		}
		block(jvmCallback)
	} else {
		block(null)
	}
}

actual fun ImGui.inputText(label: String, buf: ByteArray, flags: Flag<ImGuiInputTextFlags>?, callback: ImGuiInputTextCallback?): Boolean {
	return withCallback(callback) {
		CImGui.igInputText(label, buf, buf.size.toLong(), flags?.value ?: 0, it)
	}
}

actual fun ImGui.inputTextMultiline(label: String, buf: ByteArray, size: Vec2, flags: Flag<ImGuiInputTextFlags>?, callback: ImGuiInputTextCallback?): Boolean {
	return usingVec2(size) { sizePtr ->
		withCallback(callback) {
			CImGui.igInputTextMultiline(label, buf, buf.size.toLong(), sizePtr, flags?.value ?: 0, it)
		}
	}
}

actual fun ImGui.inputTextWithHint(label: String, hint: String, buf: ByteArray, flags: Flag<ImGuiInputTextFlags>?, callback: ImGuiInputTextCallback?): Boolean {
	return withCallback(callback) {
		CImGui.igInputTextWithHint(label, hint, buf, buf.size.toLong(), flags?.value ?: 0, it)
	}
}


actual fun ImGui.setNextWindowSizeConstraints(sizeMin: Vec2, sizeMax: Vec2, customCallback: ImGuiSizeCallback?) {
	usingVec2(sizeMin) { sizeMinPtr ->
		usingVec2(sizeMax) { sizeMaxPtr ->
			if (customCallback != null) {
				val callback = object : CustomCallback {
					override fun invoke(data: Long) {
						val swigData = ImGuiSizeCallbackData(data, false)
						val actualData = ImGuiSizeCallbackData(swigData)
						customCallback(actualData)
					}
				}
				CImGui.igSetNextWindowSizeConstraints(sizeMinPtr, sizeMaxPtr, callback)
			} else {
				CImGui.igSetNextWindowSizeConstraints(sizeMinPtr, sizeMaxPtr, null)
			}
		}
	}
}


actual fun ImGui.combo(label: String, currentItem: KMutableProperty0<Int>, items: Array<String>, popupMaxHeightInItems: Int): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		CImGui.igComboStr_arr(label, currentItemPtr, items, popupMaxHeightInItems)
	}
}

actual fun ImGui.combo(label: String, currentItem: KMutableProperty0<Int>, itemsGetter: (idx: Int) -> String?, itemsCount: Int, popupMaxHeightInItems: Int): Boolean {
	val getter = object : ItemsGetter {
		override fun getItem(idx: Int): String? {
			return itemsGetter(idx)
		}
	}
	return usingProperty(currentItem) { currentItemPtr ->
		CImGui.igComboFnBoolPtr(label, currentItemPtr, getter, itemsCount, popupMaxHeightInItems)
	}
}


actual fun ImGui.listBox(label: String, currentItem: KMutableProperty0<Int>, items: Array<String>, heightInItems: Int): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		CImGui.igListBoxStr_arr(label, currentItemPtr, items, heightInItems)
	}
}

actual fun ImGui.listBox(label: String, currentItem: KMutableProperty0<Int>, itemsGetter: (idx: Int) -> String?, itemsCount: Int, heightInItems: Int): Boolean {
	val getter = object : ItemsGetter {
		override fun getItem(idx: Int): String? {
			return itemsGetter(idx)
		}
	}
	return usingProperty(currentItem) { currentItemPtr ->
		CImGui.igListBoxFnBoolPtr(label, currentItemPtr, getter, itemsCount, heightInItems)
	}
}


actual fun ImGui.plotHistogram(label: String, values: FloatArray, valuesOffset: Int, overlayText: String?, scaleMin: Float, scaleMax: Float, graphSize: Vec2, stride: Int) {
	values.nativeCopy { valuesPinned ->
		usingVec2(graphSize) { graphSizePtr ->
			CImGui.igPlotHistogramFloatPtr(label, valuesPinned, values.size, valuesOffset, overlayText, scaleMin, scaleMax, graphSizePtr, stride)
		}
	}
}

actual fun ImGui.plotHistogram(label: String, valuesGetter: (Int) -> Float, valuesCount: Int, valuesOffset: Int, overlayText: String?, scaleMin: Float, scaleMax: Float, graphSize: Vec2) {
	val getter = object : ValuesGetter {
		override fun getValue(idx: Int): Float {
			return valuesGetter(idx)
		}
	}
	return usingVec2(graphSize) { graphSizePtr ->
		CImGui.igPlotHistogramFnFloatPtr(label, getter, valuesCount, valuesOffset, overlayText, scaleMin, scaleMax, graphSizePtr)
	}
}


actual fun ImGui.plotLines(label: String, values: FloatArray, valuesOffset: Int, overlayText: String?, scaleMin: Float, scaleMax: Float, graphSize: Vec2, stride: Int) {
	values.nativeCopy { valuesPinned ->
		usingVec2(graphSize) { graphSizePtr ->
			CImGui.igPlotLinesFloatPtr(label, valuesPinned, values.size, valuesOffset, overlayText, scaleMin, scaleMax, graphSizePtr, stride)
		}
	}
}

actual fun ImGui.plotLines(label: String, valuesGetter: (Int) -> Float, valuesCount: Int, valuesOffset: Int, overlayText: String?, scaleMin: Float, scaleMax: Float, graphSize: Vec2) {
	val getter = object : ValuesGetter {
		override fun getValue(idx: Int): Float {
			return valuesGetter(idx)
		}
	}
	return usingVec2(graphSize) { graphSizePtr ->
		CImGui.igPlotLinesFnFloatPtr(label, getter, valuesCount, valuesOffset, overlayText, scaleMin, scaleMax, graphSizePtr)
	}
}

package com.imgui

import cimgui.internal.*
import kotlinx.cinterop.*
import kotlin.reflect.KMutableProperty0


typealias ImGuiInputTextCallback = (data: ImGuiInputTextCallbackData) -> Int

private inline fun <T> withCallback(noinline callback: ImGuiInputTextCallback? = null, block: (actualCallback: cimgui.internal.ImGuiInputTextCallback?, userData: CValuesRef<*>?) -> T): T {
	return if (callback != null) {
		val userData = StableRef.create(callback)
		try {
			block(staticCFunction { data ->
				val passedCallback = data!!.pointed.UserData!!.asStableRef<ImGuiInputTextCallback>().get()
				passedCallback(ImGuiInputTextCallbackData(data))
			}, userData.asCPointer())
		} finally {
			userData.dispose()
		}
	} else {
		block(null, null)
	}
}

fun ImGui.inputText(label: String, buf: ByteArray, flags: Flag<ImGuiInputTextFlags>? = null, callback: ImGuiInputTextCallback ? = null): Boolean {
	return withCallback(callback) { actualCallback, userData ->
		igInputText(label, buf.refTo(0), buf.size.convert(), flags?.value ?: 0, actualCallback, userData)
	}
}

fun ImGui.inputTextMultiline(label: String, buf: ByteArray, size: Vec2 = Vec2.Zero, flags: Flag<ImGuiInputTextFlags>? = null, callback: ImGuiInputTextCallback ? = null): Boolean {
	return withCallback(callback) { actualCallback, userData ->
		igInputTextMultiline(label, buf.refTo(0), buf.size.convert(), size.toCValue(), flags?.value ?: 0, actualCallback, userData)
	}
}

fun ImGui.inputTextWithHint(label: String, hint: String, buf: ByteArray, flags: Flag<ImGuiInputTextFlags>? = null, callback: ImGuiInputTextCallback ? = null): Boolean {
	return withCallback(callback) { actualCallback, userData ->
		igInputTextWithHint(label, hint, buf.refTo(0), buf.size.convert(), flags?.value ?: 0, actualCallback, userData)
	}
}


typealias ImGuiSizeCallback = (ImGuiSizeCallbackData) -> Unit

fun ImGui.setNextWindowSizeConstraints(sizeMin: Vec2, sizeMax: Vec2, customCallback: ImGuiSizeCallback? = null) {
	if (customCallback != null) {
		igSetNextWindowSizeConstraints(sizeMin.toCValue(), sizeMax.toCValue(),
				staticCFunction { data ->
					val ref = data!!.pointed.UserData!!.asStableRef<ImGuiSizeCallback>()
					val callback = ref.get()
					// FIXME: What if callback is not called. i.e user does not call `ImGui.begin(...)`.
					ref.dispose()
					callback(ImGuiSizeCallbackData(data))
				},
				StableRef.create(customCallback).asCPointer()
		)
	} else {
		igSetNextWindowSizeConstraints(sizeMin.toCValue(), sizeMax.toCValue(), null, null)
	}
}


private typealias ItemsGetter = CPointer<CFunction<(COpaquePointer?, Int, CPointer<CPointerVar<ByteVar>>?) -> Boolean>>?
private class Helper(val memScope: MemScope, val getter: (idx: Int) -> String?)
private inline fun <T> withItemsGetter(noinline itemsGetter: (idx: Int) -> String?, block: (getter: ItemsGetter, userData: CValuesRef<*>) -> T): T {
	return memScoped {
		val stableRef = StableRef.create(Helper(memScope, itemsGetter))
		try {
			val getter: ItemsGetter = staticCFunction { data, idx, outText ->
				val helper = data!!.asStableRef<Helper>().get()
				val str = helper.getter(idx)
				if (str != null) {
					outText!!.pointed.value = str.cstr.getPointer(helper.memScope)
					true
				} else {
					false
				}
			}
			block(getter, stableRef.asCPointer())
		} finally {
			stableRef.dispose()
		}
	}
}

fun ImGui.combo(label: String, currentItem: KMutableProperty0<Int>, items: List<String>, popupMaxHeightInItems: Int = -1): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		memScoped {
			igCombo(label, currentItemPtr, items.toCStringArray(memScope), items.size, popupMaxHeightInItems)
		}
	}
}

fun ImGui.combo(label: String, currentItem: KMutableProperty0<Int>, itemsGetter: (idx: Int) -> String?, itemsCount: Int, popupMaxHeightInItems: Int = -1): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		withItemsGetter(itemsGetter) { getter, data ->
			igComboFnPtr(label, currentItemPtr, getter, data, itemsCount, popupMaxHeightInItems)
		}
	}
}


fun ImGui.listBox(label: String, currentItem: KMutableProperty0<Int>, items: List<String>, heightInItems: Int = -1): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		memScoped {
			igListBoxStr_arr(label, currentItemPtr, items.toCStringArray(memScope), items.size, heightInItems)
		}
	}
}

fun ImGui.listBox(label: String, currentItem: KMutableProperty0<Int>, itemsGetter: (idx: Int) -> String?, itemsCount: Int, heightInItems: Int = -1): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		withItemsGetter(itemsGetter) { getter, data ->
			igListBoxFnPtr(label, currentItemPtr, getter, data, itemsCount, heightInItems)
		}
	}
}


fun ImGui.plotHistogram(label: String, values: FloatArray, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero, stride: Int = sizeOf<FloatVar>().toInt()) {
	values.usePinned { valuesPinned ->
		igPlotHistogramFloatPtr(label, valuesPinned.addressOf(0), values.size, valuesOffset, overlayText, scaleMin, scaleMax, graphSize.toCValue(), stride)
	}
}

fun ImGui.plotHistogram(label: String, valuesGetter: (Int) -> Float, valuesCount: Int, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero) {
	val stableRef = StableRef.create(valuesGetter)
	try {
		return igPlotHistogramFnPtr(label,
				staticCFunction { data, idx ->
					val getter = data!!.asStableRef<(Int) -> Float>().get()
					getter(idx)
				},
				stableRef.asCPointer(),
				valuesCount, valuesOffset, overlayText, scaleMin, scaleMax, graphSize.toCValue())
	} finally {
		stableRef.dispose()
	}
}


fun ImGui.plotLines(label: String, values: FloatArray, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero, stride: Int = sizeOf<FloatVar>().toInt()) {
	values.usePinned { valuesPinned ->
		igPlotLines(label, valuesPinned.addressOf(0), values.size, valuesOffset, overlayText, scaleMin, scaleMax, graphSize.toCValue(), stride)
	}
}

fun ImGui.plotLines(label: String, valuesGetter: (Int) -> Float, valuesCount: Int, valuesOffset: Int = 0, overlayText: String? = null, scaleMin: Float = Float.MAX_VALUE, scaleMax: Float = Float.MAX_VALUE, graphSize: Vec2 = Vec2.Zero) {
	val stableRef = StableRef.create(valuesGetter)
	try {
		return igPlotLinesFnPtr(label,
				staticCFunction { data, idx ->
					val getter = data!!.asStableRef<(Int) -> Float>().get()
					getter(idx)
				},
				stableRef.asCPointer(),
				valuesCount, valuesOffset, overlayText, scaleMin, scaleMax, graphSize.toCValue())
	} finally {
		stableRef.dispose()
	}
}

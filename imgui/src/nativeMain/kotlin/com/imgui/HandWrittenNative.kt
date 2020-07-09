package com.imgui

import cimgui.internal.*
import kotlinx.cinterop.*
import kotlin.reflect.*


private inline fun <T> withCallback(
	noinline callback: ImGuiInputTextCallback? = null,
	block: (actualCallback: cimgui.internal.ImGuiInputTextCallback?, userData: CValuesRef<*>?) -> T
): T {
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

actual fun ImGui.inputText(
	label: String,
	buf: ByteArray,
	flags: Flag<ImGuiInputTextFlags>?,
	callback: ImGuiInputTextCallback?
): Boolean {
	return withCallback(callback) { actualCallback, userData ->
		igInputText(label, buf.refTo(0), buf.size.convert(), flags?.value ?: 0, actualCallback, userData)
	}
}

actual fun ImGui.inputTextMultiline(
	label: String,
	buf: ByteArray,
	size: Vec2,
	flags: Flag<ImGuiInputTextFlags>?,
	callback: ImGuiInputTextCallback?
): Boolean {
	return withCallback(callback) { actualCallback, userData ->
		igInputTextMultiline(
			label,
			buf.refTo(0),
			buf.size.convert(),
			size.toCValue(),
			flags?.value ?: 0,
			actualCallback,
			userData
		)
	}
}

actual fun ImGui.inputTextWithHint(
	label: String,
	hint: String,
	buf: ByteArray,
	flags: Flag<ImGuiInputTextFlags>?,
	callback: ImGuiInputTextCallback?
): Boolean {
	return withCallback(callback) { actualCallback, userData ->
		igInputTextWithHint(label, hint, buf.refTo(0), buf.size.convert(), flags?.value ?: 0, actualCallback, userData)
	}
}


actual fun ImGui.setNextWindowSizeConstraints(
	sizeMin: Vec2, sizeMax: Vec2,
	customCallback: ImGuiSizeCallback?
) {
	if (customCallback != null) {
		igSetNextWindowSizeConstraints(
			sizeMin.toCValue(), sizeMax.toCValue(),
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

private inline fun <T> withItemsGetter(
	noinline itemsGetter: (idx: Int) -> String?,
	block: (getter: ItemsGetter, userData: CValuesRef<*>) -> T
): T {
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

actual fun ImGui.combo(
	label: String,
	currentItem: KMutableProperty0<Int>,
	items: Array<String>,
	popupMaxHeightInItems: Int
): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		memScoped {
			igComboStr_arr(label, currentItemPtr, items.toCStringArray(memScope), items.size, popupMaxHeightInItems)
		}
	}
}

actual fun ImGui.combo(
	label: String,
	currentItem: KMutableProperty0<Int>,
	itemsGetter: (idx: Int) -> String?,
	itemsCount: Int,
	popupMaxHeightInItems: Int
): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		withItemsGetter(itemsGetter) { getter, data ->
			igComboFnBoolPtr(label, currentItemPtr, getter, data, itemsCount, popupMaxHeightInItems)
		}
	}
}


actual fun ImGui.listBox(
	label: String,
	currentItem: KMutableProperty0<Int>,
	items: Array<String>,
	heightInItems: Int
): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		memScoped {
			igListBoxStr_arr(label, currentItemPtr, items.toCStringArray(memScope), items.size, heightInItems)
		}
	}
}

actual fun ImGui.listBox(
	label: String,
	currentItem: KMutableProperty0<Int>,
	itemsGetter: (idx: Int) -> String?,
	itemsCount: Int,
	heightInItems: Int
): Boolean {
	return usingProperty(currentItem) { currentItemPtr ->
		withItemsGetter(itemsGetter) { getter, data ->
			igListBoxFnBoolPtr(label, currentItemPtr, getter, data, itemsCount, heightInItems)
		}
	}
}


actual fun ImGui.plotHistogram(
	label: String,
	values: FloatArray,
	valuesOffset: Int,
	overlayText: String?,
	scaleMin: Float,
	scaleMax: Float,
	graphSize: Vec2,
	stride: Int
) {
	values.usePinned { valuesPinned ->
		igPlotHistogramFloatPtr(
			label,
			valuesPinned.addressOf(0),
			values.size,
			valuesOffset,
			overlayText,
			scaleMin,
			scaleMax,
			graphSize.toCValue(),
			stride
		)
	}
}

actual fun ImGui.plotHistogram(
	label: String,
	valuesGetter: (Int) -> Float,
	valuesCount: Int,
	valuesOffset: Int,
	overlayText: String?,
	scaleMin: Float,
	scaleMax: Float,
	graphSize: Vec2
) {
	val stableRef = StableRef.create(valuesGetter)
	try {
		return igPlotHistogramFnFloatPtr(
			label,
			staticCFunction { data, idx ->
				val getter = data!!.asStableRef<(Int) -> Float>().get()
				getter(idx)
			},
			stableRef.asCPointer(),
			valuesCount, valuesOffset, overlayText, scaleMin, scaleMax, graphSize.toCValue()
		)
	} finally {
		stableRef.dispose()
	}
}


actual fun ImGui.plotLines(
	label: String,
	values: FloatArray,
	valuesOffset: Int,
	overlayText: String?,
	scaleMin: Float,
	scaleMax: Float,
	graphSize: Vec2,
	stride: Int
) {
	values.usePinned { valuesPinned ->
		igPlotLinesFloatPtr(
			label,
			valuesPinned.addressOf(0),
			values.size,
			valuesOffset,
			overlayText,
			scaleMin,
			scaleMax,
			graphSize.toCValue(),
			stride
		)
	}
}

actual fun ImGui.plotLines(
	label: String,
	valuesGetter: (Int) -> Float,
	valuesCount: Int,
	valuesOffset: Int,
	overlayText: String?,
	scaleMin: Float,
	scaleMax: Float,
	graphSize: Vec2
) {
	val stableRef = StableRef.create(valuesGetter)
	try {
		return igPlotLinesFnFloatPtr(
			label,
			staticCFunction { data, idx ->
				val getter = data!!.asStableRef<(Int) -> Float>().get()
				getter(idx)
			},
			stableRef.asCPointer(),
			valuesCount, valuesOffset, overlayText, scaleMin, scaleMax, graphSize.toCValue()
		)
	} finally {
		stableRef.dispose()
	}
}

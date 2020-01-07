package com.imgui

data class Vec4(val x: Float, val y: Float, val z: Float, val w: Float) {
	constructor() : this(0.0f, 0.0f, 0.0f, 0.0f)

	companion object {
		val Zero = Vec4(0.0f, 0.0f, 0.0f, 0.0f)
	}
}

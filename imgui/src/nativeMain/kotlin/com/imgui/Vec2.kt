package com.imgui

data class Vec2(val x: Float, val y: Float) {
	constructor() : this(0.0f, 0.0f)

	companion object {
		val Zero = Vec2(0.0f, 0.0f)
	}
}

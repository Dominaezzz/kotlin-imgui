package com.imgui

import kotlin.jvm.JvmName

interface Flag<T> where T : Enum<T>, T : Flag<T> {
	val value: Int

	@ImGuiInternal
	val info: EnumInfo<T>

	companion object {
		internal operator fun <T> invoke(value: Int, info: EnumInfo<T>): Flag<T> where T : Enum<T>, T : Flag<T> {
			return info.lookUp.getOrElse(value) { Flags(value, info) }
		}

		internal inline fun <reified T> enumInfo(): EnumInfo<T> where T : Enum<T>, T : Flag<T> {
			val values = enumValues<T>()
			return EnumInfo(values, values.associateBy { it.value })
		}
	}

	@ImGuiInternal
	class EnumInfo<T> internal constructor(
			val values: Array<T>,
			val lookUp: Map<Int, T>
	) where T : Enum<T>, T : Flag<T>

	private class Flags<T>(
			override val value: Int,
			override val info: EnumInfo<T>
	) : Flag<T> where T : Enum<T>, T : Flag<T> {
       override fun toString(): String {
           return info.values.filter { it in this }.joinToString(" | ") { it.name }
       }
	}
}

operator fun <T> Flag<T>?.contains(other: Flag<T>?): Boolean where T : Enum<T>, T : Flag<T> {
	if (other == null) return true
	if (this == null) return false
	return value and other.value == other.value
}

operator fun <T> Flag<T>.plus(other: Flag<T>): Flag<T> where T : Enum<T>, T : Flag<T> {
	return Flag(value or other.value, info)
}

@JvmName("plusNull")
operator fun <T> Flag<T>?.plus(other: Flag<T>?): Flag<T>? where T : Enum<T>, T : Flag<T> {
	if (this == null) return other
	if (other == null) return this
	return this + other
}

operator fun <T> Flag<T>.minus(other: Flag<T>): Flag<T> where T : Enum<T>, T : Flag<T> {
	return Flag(value and other.value.inv(), info)
}

@JvmName("minusNull")
operator fun <T> Flag<T>?.minus(other: Flag<T>?): Flag<T>? where T : Enum<T>, T : Flag<T> {
	if (this == null) return null
	if (other == null) return this
	return this - other
}

infix fun <T> Flag<T>.or(other: Flag<T>): Flag<T> where T : Enum<T>, T : Flag<T> {
	return Flag(value or other.value, info)
}

@JvmName("orNull")
infix fun <T> Flag<T>?.or(other: Flag<T>?): Flag<T>? where T : Enum<T>, T : Flag<T> {
	if (this == null) return other
	if (other == null) return this
	return this or other
}

infix fun <T> Flag<T>?.and(other: Flag<T>?): Flag<T>? where T : Enum<T>, T : Flag<T> {
	if (other == null || this == null) return null
	val result = value and other.value
	return if (result != 0) Flag(result, info) else null
}

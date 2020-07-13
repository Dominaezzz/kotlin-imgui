@file:JvmName("CommonUtils")

package sample

import kotlin.jvm.*
import kotlin.math.*

expect val isMacOS: Boolean

fun pow(base: Int, exponent: Int): Int {
	if (exponent == 0) return 1
	if (exponent == 1) return base

	return if (exponent % 2 == 0) {
		// 2^6  -> 4^3
		pow(base * base, exponent shr 1)
	} else {
		// 2^7  -> 2 * 2^6
		base * pow(base, exponent - 1)
	}
}

fun round(x: Float, decimalPlaces: Int): Float {
	val tens = pow(10, decimalPlaces)
	return round(x * tens) / tens.toFloat()
}


// TODO commonize in KGL
expect val GL_COLOR_BUFFER_BIT: UInt
expect fun glClear(mask: UInt)
expect fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float)
expect fun glViewport(x: Int, y: Int, width: Int, height: Int)

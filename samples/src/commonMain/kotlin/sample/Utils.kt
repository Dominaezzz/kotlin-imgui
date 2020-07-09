package sample

import kotlin.math.*

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

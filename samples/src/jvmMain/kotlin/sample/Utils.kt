package sample

import org.lwjgl.opengl.*

actual val isMacOS: Boolean = "mac" in System.getProperty("os.name")

actual val GL_COLOR_BUFFER_BIT: UInt get() = GL11.GL_COLOR_BUFFER_BIT.toUInt()

actual fun glClear(mask: UInt) {
	GL11.glClear(mask.toInt())
}

actual fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float) {
	GL11.glClearColor(red, green, blue, alpha)
}

actual fun glViewport(x: Int, y: Int, width: Int, height: Int) {
	GL11.glViewport(x, y, width, height)
}

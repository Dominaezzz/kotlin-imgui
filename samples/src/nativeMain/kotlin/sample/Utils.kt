package sample

actual val isMacOS: Boolean = Platform.osFamily == OsFamily.MACOSX

actual val GL_COLOR_BUFFER_BIT: UInt get() = com.kgl.opengl.GL_COLOR_BUFFER_BIT

actual fun glClear(mask: UInt) {
	com.kgl.opengl.glClear(mask)
}

actual fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float) {
	com.kgl.opengl.glClearColor(red, green, blue, alpha)
}

actual fun glViewport(x: Int, y: Int, width: Int, height: Int) {
	com.kgl.opengl.glViewport(x, y, width, height)
}

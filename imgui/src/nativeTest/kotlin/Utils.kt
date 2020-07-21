import cimgui.internal.ImFontAtlas_GetTexDataAsRGBA32
import com.imgui.ImFontAtlas
import kotlinx.cinterop.*

actual fun ImFontAtlas.getTexDataAsRGBA32() {
	memScoped {
		val pixels = allocPointerTo<UByteVar>()
		val width = alloc<IntVar>()
		val height = alloc<IntVar>()

		ImFontAtlas_GetTexDataAsRGBA32(ptr, pixels.ptr, width.ptr, height.ptr, null)
	}
}

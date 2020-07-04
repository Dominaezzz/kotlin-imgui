import com.squareup.kotlinpoet.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

val POINTED = MemberName("kotlinx.cinterop", "pointed")
val VALUE = MemberName("kotlinx.cinterop", "value")
val GET = MemberName("kotlinx.cinterop", "get")
val SET = MemberName("kotlinx.cinterop", "set")
val CONVERT = MemberName("kotlinx.cinterop", "convert")
val WCSTR = MemberName("kotlinx.cinterop", "wcstr")
val TO_KSTRING = MemberName("kotlinx.cinterop", "toKString")
val USE_PINNED = MemberName("kotlinx.cinterop", "usePinned")
val ADDRESS_OF = MemberName("kotlinx.cinterop", "addressOf")
val FLAG = ClassName("com.imgui", "Flag")
val VEC2 = ClassName("com.imgui", "Vec2")
val VEC4 = ClassName("com.imgui", "Vec4")
val C_POINTER = ClassName("kotlinx.cinterop", "CPointer")
val K_MUTABLE_PROPERTY = ClassName("kotlin.reflect", "KMutableProperty0")

val ACTUAL_WITHOUT_EXPECT = AnnotationSpec.builder(Suppress::class)
		.addMember("%S", "ACTUAL_WITHOUT_EXPECT").build()

val simpleTypeMap = mapOf(
		"float" to FLOAT,
		"unsigned short" to U_SHORT,
		"unsigned int" to U_INT,
		"int" to INT,
		"short" to SHORT,
		"bool" to BOOLEAN,
		"double" to DOUBLE,
		"ImU32" to U_INT
)
val valueTypes = mapOf(
		"ImGuiID" to LONG,
		"ImTextureID" to ClassName("cimgui.internal", "SWIGTYPE_p_void")
)
val privateTypes = setOf(
		"ImDrawListSharedData",
		"ImGuiContext"
)
val functionsToSkip = setOf(
		"igInputText",
		"igInputTextMultiline",
		"igInputTextWithHint",
		"igSetNextWindowSizeConstraints"
)

// TODO: Move to JSON file.
val mutableStructFields = mapOf(
		"ImGuiIO" to setOf(
				"MouseWheel",
				"MouseWheelH",
				"DeltaTime",
				"KeyCtrl",
				"KeyShift",
				"KeyAlt",
				"KeySuper",
				"BackendFlags",
				"MouseDown",
				"KeysDown",
				"KeyMap",
				"NavInputs",
				"MousePos",
				"DisplaySize",
				"DisplayFramebufferScale"
		)
)

fun String.snakeToPascalCase(abbreviations: Set<String> = emptySet()): String {
	return splitToSequence("_")
			.map {
				val lower = it.toLowerCase()
				if (lower in abbreviations) {
					it.toUpperCase()
				} else {
					lower.capitalize()
				}
			}
			.joinToString("")
}

val cArrayRegex = Regex("([a-z]+)\\[([2-9])]")

val vec2Regex = Regex("ImVec2\\((-?\\d+),(-?\\d+)\\)")
val vec4Regex = Regex("ImVec4\\((-?\\d+),(-?\\d+),(-?\\d+),(-?\\d+)\\)")

val CImGuiJson = Json(JsonConfiguration.Stable.copy(isLenient = true, ignoreUnknownKeys = true))

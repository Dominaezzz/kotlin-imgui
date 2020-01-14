import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.internal.StringSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonLiteral
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.list
import kotlinx.serialization.map
import java.nio.file.Paths

val POINTED = MemberName("kotlinx.cinterop", "pointed")
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

val simpleTypeMap = mapOf(
		"float" to FLOAT,
		"unsigned short" to U_SHORT,
		"unsigned int" to U_INT,
		"size_t" to U_LONG,
		"int" to INT,
		"short" to SHORT,
		"bool" to BOOLEAN,
		"double" to DOUBLE,
		"ImU32" to U_INT
)
val valueTypes = setOf(
		"ImGuiID",
		"ImTextureID"
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

@UnstableDefault
@ImplicitReflectionSerializer
fun main(args: Array<String>) {
	val inputDir = Paths.get(args[0])

	val outputDir = Paths.get(".").toAbsolutePath()
			.resolve("nativeMain").resolve("generated")

	val definitionsStr = inputDir.resolve("definitions.json").toFile().readText()
	val structsAndEnumsStr = inputDir.resolve("structs_and_enums.json").toFile().readText()

	val definitions = Json.nonstrict.parse((StringSerializer to Definition.serializer().list).map, definitionsStr)
	val (enums, structs) = Json.nonstrict.parse(StructsAndEnums.serializer(), structsAndEnumsStr)

	val enumBitMasks = enums.entries
			.filter { (enumName, entries) ->
				enumName.endsWith("Flags_") || entries.any { it.value.contains("<<") }
			}.map { it.key }.toSet()

	// Returns an appendable converter, to convert from cimgui value to Kotlin value.
	fun convertNativeTypeToKt(type: String): Pair<TypeName, CodeBlock> {
		val imGuiPackageName = "com.imgui"

		return when (type) {
			"const char*" -> STRING to CodeBlock.of(".%M()", TO_KSTRING)
			"const ImWchar*" -> STRING to CodeBlock.of(".%M()", TO_KSTRING)
			"ImVec2" -> VEC2 to CodeBlock.of(".fromCValue()")
			"ImVec4" -> VEC4 to CodeBlock.of(".fromCValue()")
			"ImWchar" -> CHAR to CodeBlock.of(".toShort().toChar()")
			in valueTypes -> {
				val typeKt = ClassName(imGuiPackageName, type)
				typeKt to CodeBlock.of(".let(::%T)", typeKt)
			}
			in simpleTypeMap.keys -> simpleTypeMap.getValue(type) to CodeBlock.of("")
			else -> {
				if ("${type}_"  in enums.keys) {
					val enumType = ClassName(imGuiPackageName, type)
					if ("${type}_" in enumBitMasks){
						val typeKt = FLAG.parameterizedBy(enumType)
						typeKt to CodeBlock.of(".let { %T.fromMultiple(it) }", enumType)
					} else {
						enumType to CodeBlock.of(".let { %T.from(it) }", enumType)
					}
				} else if (type.endsWith('*')) {
					// ImGuiContext* -> ImGuiContext
					// const ImVec4* -> ImVec4
					val derefType = type.dropLast(1).removePrefix("const ")
					if (derefType in privateTypes || derefType in structs.keys) {
						val typeKt = ClassName(imGuiPackageName, derefType)
						typeKt to CodeBlock.of(".let(::%T)", typeKt)
					} else {
						TODO()
					}
				} else {
					TODO()
				}
			}
		}
	}

	data class FuncArg(val type: TypeName, val converter: CodeBlock = CodeBlock.of(""), val propToPtr: Boolean = false)

	// Returns a appendable converter, to convert from (returned) Kotlin type to cimgui value.
	fun convertKotlinTypeToNative(type: String, isNullable: Boolean, assertIfNull: Boolean): FuncArg {
		val imGuiPackageName = "com.imgui"

		val nullOp = if (isNullable) {
			if (assertIfNull) "!!" else "?"
		} else {
			""
		}

		val simpleKtType = simpleTypeMap[type]
		if (simpleKtType != null) {
			return FuncArg(simpleKtType)
		}
		if (type in valueTypes) {
			return FuncArg(ClassName("com.imgui", type), CodeBlock.of("$nullOp.value"))
		}
		if (type == "const char*") return FuncArg(STRING)
		if (type == "const ImWchar*") return FuncArg(STRING, CodeBlock.of("$nullOp.%M", WCSTR))
		if (type == "ImWchar") return FuncArg(CHAR, CodeBlock.of(".toShort().toUShort()"))
		if ("${type}_" in enums.keys) {
			val isBitFlags = "${type}_" in enumBitMasks
			val enumKt = ClassName("com.imgui", type)
			val paramType = if (isBitFlags) FLAG.parameterizedBy(enumKt) else enumKt
			val conv = if (isBitFlags && isNullable && !assertIfNull) {
				CodeBlock.of("$nullOp.value ?: 0")
			} else {
				CodeBlock.of("$nullOp.value")
			}
			return FuncArg(paramType, conv)
		}
		if (type == "const ImVec2" || type == "ImVec2") return FuncArg(VEC2, CodeBlock.of("$nullOp.toCValue()"))
		if (type == "const ImVec4" || type == "ImVec4") return FuncArg(VEC4, CodeBlock.of("$nullOp.toCValue()"))
		if (type.endsWith('*')) {
			val derefType = type.dropLast(1).removePrefix("const ")
			if (derefType in privateTypes || derefType in structs.keys) {
				val typeKt = ClassName(imGuiPackageName, derefType)
				return FuncArg(typeKt, CodeBlock.of("$nullOp.ptr"))
			}
			if (type == "bool*" || type == "int*" || type == "unsigned int*" || type == "size_t*" || type == "float*" || type == "double*") {
				val propType = when (derefType) {
					"bool" -> BOOLEAN
					"int" -> INT
					"unsigned int" -> U_INT
					"size_t" -> U_LONG
					"float" -> FLOAT
					"double" -> DOUBLE
					else -> TODO()
				}
				return FuncArg(K_MUTABLE_PROPERTY.parameterizedBy(propType), propToPtr = true)
			}
		}
		if (type == "float&") {
			return FuncArg(K_MUTABLE_PROPERTY.parameterizedBy(FLOAT), propToPtr = true)
		}
		TODO()
	}

	for ((enumName, entries) in enums) {
		val isBitmask = enumName in enumBitMasks

		val enumNameKt = enumName.dropLast(1) // Remove trailing underscore.
		val enumClass = ClassName("com.imgui", enumNameKt)
		val enumValueType = ClassName("cimgui.internal", enumNameKt)

		val enum = TypeSpec.enumBuilder(enumClass)
		enum.primaryConstructor(FunSpec.constructorBuilder()
				.addParameter("value", enumValueType)
				.build())

		val valueProp = PropertySpec.builder("value", enumValueType)
		valueProp.initializer("value")
		if (isBitmask) {
			enum.addSuperinterface(FLAG.parameterizedBy(enumClass))
			valueProp.addModifiers(KModifier.OVERRIDE)
		}
		enum.addProperty(valueProp.build())

		val compositeFlags = mutableListOf<Pair<String, CodeBlock>>()
		val lookUpTable = CodeBlock.builder()
		lookUpTable.beginControlFlow("when (value.%M<%T>())", CONVERT, ClassName("cimgui.internal", enumName))

		for (enumValue in entries) {
			val enumValueNameKt = enumValue.name.removePrefix(enumName)
			check(enumValue.name != enumValueNameKt)

			val member = MemberName("cimgui.internal", enumValue.name)

			if (isBitmask) {
				if (enumValueNameKt == "None") {
					continue
				}
				if (enumValue.calcValue != 0 && !enumValue.value.contains("<<")) {
					// Then this value is a composite of multiple flags.
					if (!enumValueNameKt.startsWith('_')) { // Check if not internal.
						compositeFlags.add(enumValueNameKt to CodeBlock.of("%T(%M.toInt(), cachedInfo)", FLAG, member))
					}
					continue
				}
			} else if (enumValueNameKt == "COUNT") {
				continue
			}

			val constParam = CodeBlock.of("%M.%M()", member, CONVERT)
			enum.addEnumConstant(enumValueNameKt, TypeSpec.anonymousClassBuilder()
					.addSuperclassConstructorParameter(constParam)
					.build())
			lookUpTable.addStatement("%N -> %N", enumValue.name, enumValueNameKt)
		}

		lookUpTable.addStatement("else -> throw NoSuchElementException(%P)", "Unknown enum constant \$value")
		lookUpTable.endControlFlow()

		val companionObject = TypeSpec.companionObjectBuilder()

		companionObject.addFunction(FunSpec.builder("from")
				.returns(enumClass)
				.addParameter("value", enumValueType)
				.addStatement("return %L", lookUpTable.build())
				.build())

		if (isBitmask) {
			val enumInfoType = FLAG
					.nestedClass("EnumInfo")
					.parameterizedBy(enumClass)

			companionObject.addProperty(PropertySpec.builder("cachedInfo", enumInfoType, KModifier.PRIVATE)
							.initializer("%T.enumInfo()", FLAG)
							.build())
			for ((propName, initializer) in compositeFlags) {
				companionObject.addProperty(PropertySpec.builder(propName, FLAG.parameterizedBy(enumClass))
						.initializer(initializer)
						.build())
			}

			companionObject.addFunction(FunSpec.builder("fromMultiple")
					.returns(FLAG.parameterizedBy(enumClass))
					.addParameter("value", enumValueType)
					.addStatement("return %T(value.%M(), cachedInfo)", FLAG, CONVERT)
					.build())

			enum.addProperty(PropertySpec.builder("info", enumInfoType, KModifier.OVERRIDE)
					.getter(FunSpec.getterBuilder().addCode("return cachedInfo").build())
					.build())
		}
		enum.addType(companionObject.build())

		FileSpec.get("com.imgui", enum.build()).writeTo(outputDir)
	}

	for (valueType in valueTypes) {
		val pointerClass = ClassName("cimgui.internal", valueType)
		val type = TypeSpec.classBuilder(valueType)
				.addModifiers(KModifier.INLINE)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("value", pointerClass)
						.build())
				.addProperty(PropertySpec.builder("value", pointerClass)
						.initializer("value")
						.build())
				.build()

		FileSpec.get("com.imgui", type).writeTo(outputDir)
	}

	for (privateType in privateTypes) {
		val pointerClass = C_POINTER.parameterizedBy(ClassName("cnames.structs", privateType))
		val type = TypeSpec.classBuilder(privateType)
				.addModifiers(KModifier.INLINE)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("ptr", pointerClass)
						.build())
				.addProperty(PropertySpec.builder("ptr", pointerClass, KModifier.INTERNAL)
						.initializer("ptr")
						.build())
				.build()

		FileSpec.get("com.imgui", type).writeTo(outputDir)
	}

	val structFunctions = mutableMapOf<String, MutableList<FunSpec>>()
	val imguiObj = TypeSpec.objectBuilder("ImGui")
	defLoop@for (overload in definitions.flatMap { (_, overloads) -> overloads }) {
		// TODO: Not needed in wrapper.
		if (overload.nonUDT != null) continue

		val defName = overload.cimguiName
		if (defName in functionsToSkip) continue

		// Explicitly drop support for *Scalar functions.
		if (defName.endsWith("Scalar") || defName.endsWith("ScalarN")) continue

		// Skip member functions for now.
		val isMemberFunction = overload.structName.isNotEmpty() || overload.functionName == null

		// TODO: Some design choices to be made here.
		if (overload.structName == "ImVector") continue

		val functionKt = when {
			overload.isCtor -> FunSpec.constructorBuilder()
			overload.isDtor -> FunSpec.builder("destroy")
			else -> FunSpec.builder(overload.functionName!!.decapitalize())
		}

		val cimguiFun = MemberName("cimgui.internal",
				overload.overloadedCimguiName ?: overload.cimguiName)

		val defaultMap = if (overload.defaults is JsonObject) {
			overload.defaults.mapValues { (_, value) -> (value as JsonLiteral).content }
		} else {
			emptyMap()
		}

		val checks = mutableListOf<CodeBlock>()
		val scopedHelpers = mutableListOf<CodeBlock>()
		val arguments = mutableListOf<CodeBlock>()
		for (arg in overload.argsT) {
			val argNameKt = arg.name.snakeToPascalCase().decapitalize()
			val defaultValue = defaultMap[arg.name]?.let {
				// Must be a better way to do this.
				if (it == "(((ImU32)(255)<<24)|((ImU32)(255)<<16)|((ImU32)(255)<<8)|((ImU32)(255)<<0))") {
					"(255u shl 24) or (255u shl 16) or (255u shl 8) or (255u shl 0)"
				} else {
					it
				}
			}

			// Explicitly not supporting va_list functions.
			if (arg.type == "va_list") continue@defLoop

			// Just skip the param. KN doesn't support this yet.
			if (arg.type == "...") continue

			if (isMemberFunction && arg.name == "self") {
				arguments.add(CodeBlock.of("ptr"))
			} else if (arg.type matches cArrayRegex) {
				val (elemType, sizeStr) = cArrayRegex.matchEntire(arg.type)!!.destructured

				checks.add(CodeBlock.of("require($argNameKt.size >= ${sizeStr.toInt()})"))
				val pinnedName = "pinned${argNameKt.capitalize()}"
				scopedHelpers.add(CodeBlock.of("$argNameKt.%M { $pinnedName ->", USE_PINNED))

				val paramType = when (elemType) {
					"int" -> INT_ARRAY
					"float" -> FLOAT_ARRAY
					else -> TODO()
				}
				check(defaultValue == null)
				functionKt.addParameter(argNameKt, paramType)
				arguments.add(CodeBlock.of("$pinnedName.%M(0)", ADDRESS_OF))
			} else {
				try {
					val isBitMask = "${arg.type}_" in enumBitMasks
					val isNullable = defaultValue == "((void*)0)" || (isBitMask && defaultValue == "0")

					val (type, converter, propToPtr) = convertKotlinTypeToNative(arg.type, isNullable, false)

					val paramType = type.copy(nullable = isNullable)
					if (propToPtr) {
						val ptrName = "ptr${argNameKt.capitalize()}"
						val helper = if (isNullable) {
							CodeBlock.of("usingPropertyN($argNameKt) { $ptrName ->")
						} else {
							CodeBlock.of("usingProperty($argNameKt) { $ptrName ->")
						}
						scopedHelpers.add(helper)
					}

					val param = ParameterSpec.builder(argNameKt, paramType)
					if (defaultValue != null) {
						val value = if (defaultValue.startsWith('"')) {
							CodeBlock.of("%L", defaultValue)
						} else {
							CodeBlock.of(when {
								defaultValue == "((void*)0)" -> "null"
								type == U_LONG -> "${defaultValue}uL"
								defaultValue == "ImVec2(0,0)" -> "Vec2.Zero"
								defaultValue == "ImVec4(0,0,0,0)" -> "Vec4.Zero"
								defaultValue matches vec2Regex -> vec2Regex.replace(defaultValue, "Vec2($1f, $2f)")
								defaultValue matches vec4Regex -> vec4Regex.replace(defaultValue, "Vec4($1f, $2f, $3f, $4f)")
								// For enum flags.
								isBitMask && defaultValue == "0" -> "null"
								isBitMask -> defaultValue.replaceFirst('_', '.')
								else -> defaultValue
							})
						}
						param.defaultValue(value)
					}

					functionKt.addParameter(param.build())
					val passedArgName = if (propToPtr) "ptr${argNameKt.capitalize()}" else argNameKt
					arguments.add(CodeBlock.of("%N%L", passedArgName, converter))
				} catch (e: NotImplementedError) {
					// If type is unknown but has a reasonable default value, we can skip the param.
					if (defaultValue == "((void*)0)") {
						arguments.add(CodeBlock.of("null"))
					} else {
						// Skip functions with unknown param types.
						println(overload.cimguiName + " -> " + arg.type)
						continue@defLoop
					}
				}
			}
		}

		val igFuncCall = buildCodeBlock {
			for (helper in scopedHelpers) {
				add(helper)
				add("\n")
				indent()
			}
			add("%M(", cimguiFun)
			add(arguments.joinToCode())
			add(")")
			for (helper in scopedHelpers) {
				add("\n")
				unindent()
				add("}")
			}
		}

		if (overload.returnType == null) {
			check(isMemberFunction)
			check(checks.isEmpty())
			if (overload.isCtor) {
				functionKt.callThisConstructor(CodeBlock.of("%L!!", igFuncCall))
			} else {
				check(overload.isDtor)
				functionKt.addCode(igFuncCall)
				functionKt.addCode("\n")
			}
		} else {
			for (it in checks) {
				functionKt.addCode(it)
				functionKt.addCode("\n")
			}
			if (overload.returnType == "void") {
				functionKt.addCode(igFuncCall)
				functionKt.addCode("\n")
			} else {
				// TODO: Improve this here with a white list of functions.
				val canBeNull = overload.returnType.endsWith("*") || overload.returnType == "ImTextureID"
				val shouldAssert = overload.returnType != "const char*" || overload.returnType == "const ImWchar*"
				try {
					val (typeKt, converter) = convertNativeTypeToKt(overload.returnType)
					// If return value can be null and we're not asserting, then we return nullable.
					functionKt.returns(typeKt.copy(canBeNull && !shouldAssert))
					functionKt.addCode("return ")
					functionKt.addCode(igFuncCall)
					if (canBeNull) functionKt.addCode(if (shouldAssert) "!!" else "?")
					functionKt.addCode(converter)
					functionKt.addCode("\n")
				} catch (e: NotImplementedError) {
					// Skip functions with non-trivial return value.
					println(overload.cimguiName + " returns " + overload.returnType)
					continue
				}
			}
		}

		if (isMemberFunction) {
			structFunctions.getOrPut(overload.structName) { mutableListOf() }.add(functionKt.build())
		} else {
			imguiObj.addFunction(functionKt.build())
		}
	}
	FileSpec.get("com.imgui", imguiObj.build())
			.toBuilder().indent("    ").build()
			.writeTo(outputDir)

	for ((structName, members) in structs) {
		val imguiStructClass = ClassName("cimgui.internal", structName)

		val pointerClass = C_POINTER.parameterizedBy(imguiStructClass)
		val struct = TypeSpec.classBuilder(structName)
				.addModifiers(KModifier.INLINE)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("ptr", pointerClass)
						.build())
				.addProperty(PropertySpec.builder("ptr", pointerClass)
						// .addModifiers(KModifier.INTERNAL)
						.initializer("ptr")
						.build())

		for (member in members) {
			// Skip imgui internal/private members.
			if (member.name.startsWith('_')) continue

			val memberNameKt = member.name.decapitalize()

			if (member.size == null) {
				// TODO: Improve this here with a white list of functions.
				val canBeNull = member.type.endsWith("*") || member.type == "ImTextureID"
				val shouldAssert = !canBeNull || member.type == "const char*"
				try {
					val (typeKt, converter) = convertNativeTypeToKt(member.type)
					// If return value can be null and we're not asserting, then we return nullable.
					val prop = PropertySpec.builder(memberNameKt, typeKt.copy(canBeNull && !shouldAssert))

					val getter = FunSpec.getterBuilder()
					getter.addCode("return ptr.%M.%N", POINTED, member.name)
					if (canBeNull) getter.addCode(if (shouldAssert) "!!" else "?")
					getter.addCode(converter)
					getter.addCode("\n")
					prop.getter(getter.build())
					struct.addProperty(prop.build())
				} catch (e: NotImplementedError) {
					// Skip members with non-trivial type.
					continue
				}
			}
		}

		struct.addFunctions(structFunctions[structName] ?: emptyList())

		FileSpec.get("com.imgui", struct.build()).writeTo(outputDir)
	}
}

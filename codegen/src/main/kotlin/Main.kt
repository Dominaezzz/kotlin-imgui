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

	val srcDir = Paths.get(".").toAbsolutePath()
	val commonDir = srcDir.resolve("commonMain").resolve("generated")
	val nativeDir = srcDir.resolve("nativeMain").resolve("generated")
	val jvmDir = srcDir.resolve("jvmMain").resolve("generated")

	val definitionsStr = inputDir.resolve("definitions.json").toFile().readText()
	val structsAndEnumsStr = inputDir.resolve("structs_and_enums.json").toFile().readText()

	val definitions = Json.nonstrict.parse((StringSerializer to Definition.serializer().list).map, definitionsStr)
	val (enums, structs) = Json.nonstrict.parse(StructsAndEnums.serializer(), structsAndEnumsStr)

	val enumBitMasks = enums.entries
			.filter { (enumName, entries) ->
				enumName.endsWith("Flags_") || entries.any { it.value.contains("<<") }
			}.map { it.key }.toSet()

	data class ReturnValue(val type: TypeName, val nativeConverter: CodeBlock, val jvmConverter: CodeBlock = nativeConverter)

	// Returns an appendable converter, to convert from cimgui value to Kotlin value.
	fun convertNativeTypeToKt(type: String, isField: Boolean): ReturnValue {
		val imGuiPackageName = "com.imgui"

		val jvmVecConverter = if (isField) CodeBlock.of(".fromCValue()") else CodeBlock.of("")

		return when (type) {
			"size_t" -> ReturnValue(U_LONG, CodeBlock.of(".%M()", CONVERT), CodeBlock.of(".toULong()"))
			"void" -> ReturnValue(UNIT, CodeBlock.of(""))
			"ImU32" -> ReturnValue(U_INT, CodeBlock.of(".toUInt()"))
			"unsigned int" -> ReturnValue(U_INT, CodeBlock.of(".toUInt()"))
			"unsigned short" -> ReturnValue(U_SHORT, CodeBlock.of(".toUShort()"))
			"const char*" -> ReturnValue(STRING, CodeBlock.of(".%M()", TO_KSTRING), CodeBlock.of(""))
			"const ImWchar*" -> ReturnValue(STRING, CodeBlock.of(".%M()", TO_KSTRING), CodeBlock.of(".toUTF16String()"))
			"ImVec2" -> ReturnValue(VEC2, CodeBlock.of(".fromCValue()"), jvmVecConverter)
			"ImVec4" -> ReturnValue(VEC4, CodeBlock.of(".fromCValue()"), jvmVecConverter)
			"ImWchar" -> ReturnValue(CHAR, CodeBlock.of(".toShort().toChar()"))
			in valueTypes -> {
				val typeKt = ClassName(imGuiPackageName, type)
				ReturnValue(typeKt, CodeBlock.of(".let(::%T)", typeKt))
			}
			in simpleTypeMap.keys -> ReturnValue(simpleTypeMap.getValue(type), CodeBlock.of(""))
			else -> {
				if ("${type}_"  in enums.keys) {
					val enumType = ClassName(imGuiPackageName, type)
					if ("${type}_" in enumBitMasks){
						val typeKt = FLAG.parameterizedBy(enumType)
						ReturnValue(typeKt, CodeBlock.of(".let { %T.fromMultiple(it) }", enumType))
					} else {
						ReturnValue(enumType, CodeBlock.of(".let { %T.from(it) }", enumType))
					}
				} else if (type.endsWith('*')) {
					// ImGuiContext* -> ImGuiContext
					// const ImVec4* -> ImVec4
					val derefType = type.dropLast(1).removePrefix("const ")
					if (derefType in privateTypes || derefType in structs.keys) {
						val typeKt = ClassName(imGuiPackageName, derefType)
						ReturnValue(typeKt, CodeBlock.of(".let(::%T)", typeKt))
					} else {
						TODO()
					}
				} else {
					TODO()
				}
			}
		}
	}

	data class FuncArg(val type: TypeName, val nativeConv: CodeBlock = CodeBlock.of(""), val jvmConv: CodeBlock = nativeConv, val propToPtr: Boolean = false)

	// Returns a appendable converter, to convert from (returned) Kotlin ReturnValue(type, cimgui value.)
	fun convertKotlinTypeToNative(type: String, isNullable: Boolean, assertIfNull: Boolean): FuncArg {
		val imGuiPackageName = "com.imgui"

		val nullOp = if (isNullable) {
			if (assertIfNull) "!!" else "?"
		} else {
			""
		}

		if (type == "unsigned int") return FuncArg(U_INT, jvmConv = CodeBlock.of(".toLong()"))
		if (type == "ImU32") return FuncArg(U_INT, jvmConv = CodeBlock.of(".toLong()"))
		val simpleKtType = simpleTypeMap[type]
		if (simpleKtType != null) {
			return FuncArg(simpleKtType)
		}
		if (type in valueTypes) {
			return FuncArg(ClassName("com.imgui", type), CodeBlock.of("$nullOp.value"))
		}
		if (type == "const char*") return FuncArg(STRING)
		if (type == "const ImWchar*") return FuncArg(STRING, CodeBlock.of("$nullOp.%M", WCSTR), CodeBlock.of(""))
		if (type == "size_t") return FuncArg(U_LONG, CodeBlock.of(".%M()", CONVERT), CodeBlock.of(".toLong()"))
		if (type == "ImWchar") return FuncArg(CHAR, CodeBlock.of(".toShort().toUShort()"), CodeBlock.of(".toInt()"))
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
		if (type == "const ImVec2" || type == "ImVec2") return FuncArg(VEC2, CodeBlock.of("$nullOp.toCValue()"), CodeBlock.of(""))
		if (type == "const ImVec4" || type == "ImVec4") return FuncArg(VEC4, CodeBlock.of("$nullOp.toCValue()"), CodeBlock.of(""))
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
		val enumJvmClass = ClassName("cimgui.internal", enumName)

		val commonEnum = TypeSpec.enumBuilder(enumClass).addModifiers(KModifier.EXPECT)
		val nativeEnum = TypeSpec.enumBuilder(enumClass).addModifiers(KModifier.ACTUAL)
		val jvmEnum = TypeSpec.enumBuilder(enumClass).addModifiers(KModifier.ACTUAL)

		nativeEnum.primaryConstructor(FunSpec.constructorBuilder()
				.addParameter("value", enumValueType).build())
		jvmEnum.primaryConstructor(FunSpec.constructorBuilder()
				.addParameter("value", INT).build())

		val nativeValueProp = PropertySpec.builder("value", enumValueType)
		val jvmValueProp = PropertySpec.builder("value", INT)
		nativeValueProp.initializer("value")
		jvmValueProp.initializer("value")
		if (isBitmask) {
			commonEnum.addSuperinterface(FLAG.parameterizedBy(enumClass))
			nativeEnum.addSuperinterface(FLAG.parameterizedBy(enumClass))
			nativeValueProp.addModifiers(KModifier.OVERRIDE)
			jvmEnum.addSuperinterface(FLAG.parameterizedBy(enumClass))
			jvmValueProp.addModifiers(KModifier.OVERRIDE)
		}
		nativeEnum.addProperty(nativeValueProp.build())
		jvmEnum.addProperty(jvmValueProp.build())

		val compositeFlags = mutableListOf<Pair<String, String>>()
		val lookUpTable = CodeBlock.builder()

		for (enumValue in entries) {
			val enumValueNameKt = enumValue.name.removePrefix(enumName)
			check(enumValue.name != enumValueNameKt)

			if (isBitmask) {
				if (enumValueNameKt == "None") {
					continue
				}
				if (enumValue.calcValue != 0 && !enumValue.value.contains("<<")) {
					// Then this value is a composite of multiple flags.
					if (!enumValueNameKt.startsWith('_')) { // Check if not internal.
						compositeFlags.add(enumValueNameKt to enumValue.name)
					}
					continue
				}
			} else if (enumValueNameKt == "COUNT") {
				continue
			}

			commonEnum.addEnumConstant(enumValueNameKt)
			nativeEnum.addEnumConstant(enumValueNameKt, TypeSpec.anonymousClassBuilder()
					.addSuperclassConstructorParameter(CodeBlock.of("%M.%M()", MemberName("cimgui.internal", enumValue.name), CONVERT))
					.build())
			jvmEnum.addEnumConstant(enumValueNameKt, TypeSpec.anonymousClassBuilder()
					.addSuperclassConstructorParameter("%M", MemberName(enumJvmClass, enumValue.name))
					.build())
			lookUpTable.addStatement("%N -> %N", enumValue.name, enumValueNameKt)
		}

		lookUpTable.addStatement("else -> throw NoSuchElementException(%P)", "Unknown enum constant \$value")

		val commonCompanionObject = TypeSpec.companionObjectBuilder()
		val nativeCompanionObject = TypeSpec.companionObjectBuilder().addModifiers(KModifier.ACTUAL)
		val jvmCompanionObject = TypeSpec.companionObjectBuilder().addModifiers(KModifier.ACTUAL)

		nativeCompanionObject.addFunction(FunSpec.builder("from")
				.returns(enumClass)
				.addParameter("value", enumValueType)
				.beginControlFlow("return when (value.%M<%T>())", CONVERT, ClassName("cimgui.internal", enumName))
				.addCode(lookUpTable.build())
				.endControlFlow()
				.build())
		jvmCompanionObject.addFunction(FunSpec.builder("from").returns(enumClass)
				.addParameter("value", INT)
				.beginControlFlow("return when (value)")
				.addCode(lookUpTable.build())
				.endControlFlow()
				.build())

		if (isBitmask) {
			val enumInfoType = FLAG.nestedClass("EnumInfo").parameterizedBy(enumClass)

			val cachedInfoProp = PropertySpec.builder("cachedInfo", enumInfoType, KModifier.PRIVATE)
					.initializer("%T.enumInfo()", FLAG)
					.build()
			nativeCompanionObject.addProperty(cachedInfoProp)
			jvmCompanionObject.addProperty(cachedInfoProp)
			val flagKt = FLAG.parameterizedBy(enumClass)
			for ((propName, constName) in compositeFlags) {
				commonCompanionObject.addProperty(propName, flagKt)

				nativeCompanionObject.addProperty(PropertySpec.builder(propName, flagKt)
						.initializer(CodeBlock.of("%T(%M.toInt(), cachedInfo)", FLAG, MemberName("cimgui.internal", constName)))
						.addModifiers(KModifier.ACTUAL)
						.build())
				jvmCompanionObject.addProperty(PropertySpec.builder(propName, flagKt)
						.initializer(CodeBlock.of("%T(%M, cachedInfo)", FLAG, MemberName(enumJvmClass, constName)))
						.addModifiers(KModifier.ACTUAL)
						.build())
			}

			nativeCompanionObject.addFunction(FunSpec.builder("fromMultiple").returns(flagKt)
					.addParameter("value", enumValueType)
					.addStatement("return %T(value.%M(), cachedInfo)", FLAG, CONVERT)
					.build())
			jvmCompanionObject.addFunction(FunSpec.builder("fromMultiple").returns(flagKt)
					.addParameter("value", INT)
					.addStatement("return %T(value, cachedInfo)", FLAG)
					.build())

			val cachedInfoMember = PropertySpec.builder("info", enumInfoType, KModifier.OVERRIDE)
					.getter(FunSpec.getterBuilder().addCode("return cachedInfo").build())
					.build()
			nativeEnum.addProperty(cachedInfoMember)
			jvmEnum.addProperty(cachedInfoMember)
		}
		commonEnum.addType(commonCompanionObject.build())
		nativeEnum.addType(nativeCompanionObject.build())
		jvmEnum.addType(jvmCompanionObject.build())

		FileSpec.get("com.imgui", commonEnum.build()).writeTo(commonDir)
		FileSpec.get("com.imgui", nativeEnum.build()).writeTo(nativeDir)
		FileSpec.get("com.imgui", jvmEnum.build()).writeTo(jvmDir)
	}

	for ((valueType, jvmUnderlyingType) in valueTypes) {
		val pointerClass = ClassName("cimgui.internal", valueType)
		val commonType = TypeSpec.expectClassBuilder(valueType).build()
		val nativeType = TypeSpec.classBuilder(valueType)
				.addModifiers(KModifier.INLINE, KModifier.ACTUAL)
				.addAnnotation(ACTUAL_WITHOUT_EXPECT)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("value", pointerClass)
						.build())
				.addProperty(PropertySpec.builder("value", pointerClass)
						.initializer("value")
						.build())
				.build()
		val jvmType = TypeSpec.classBuilder(valueType)
				.addModifiers(KModifier.INLINE, KModifier.ACTUAL)
				.addAnnotation(ACTUAL_WITHOUT_EXPECT)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("value", jvmUnderlyingType)
						.build())
				.addProperty(PropertySpec.builder("value", jvmUnderlyingType)
						.initializer("value")
						.build())
				.build()

		FileSpec.get("com.imgui", commonType).writeTo(commonDir)
		FileSpec.get("com.imgui", nativeType).writeTo(nativeDir)
		FileSpec.get("com.imgui", jvmType).writeTo(jvmDir)
	}

	for (privateType in privateTypes) {
		val nativePointerClass = C_POINTER.parameterizedBy(ClassName("cnames.structs", privateType))
		val jvmPointerClass = ClassName("cimgui.internal", "SWIGTYPE_p_$privateType")

		val commonType = TypeSpec.expectClassBuilder(privateType).build()
		val nativeType = TypeSpec.classBuilder(privateType)
				.addModifiers(KModifier.INLINE, KModifier.ACTUAL)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("ptr", nativePointerClass)
						.build())
				.addProperty(PropertySpec.builder("ptr", nativePointerClass, KModifier.INTERNAL)
						.initializer("ptr")
						.build())
				.addAnnotation(ACTUAL_WITHOUT_EXPECT)
				.build()
		val jvmType = TypeSpec.classBuilder(privateType)
				.addModifiers(KModifier.INLINE, KModifier.ACTUAL)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("ptr", jvmPointerClass)
						.build())
				.addProperty(PropertySpec.builder("ptr", jvmPointerClass, KModifier.INTERNAL)
						.initializer("ptr")
						.build())
				.addAnnotation(ACTUAL_WITHOUT_EXPECT)
				.build()

		FileSpec.get("com.imgui", commonType).writeTo(commonDir)
		FileSpec.get("com.imgui", nativeType).writeTo(nativeDir)
		FileSpec.get("com.imgui", jvmType).writeTo(jvmDir)
	}

	val commonStructMemberFuncs = mutableMapOf<String, MutableList<FunSpec>>()
	val nativeStructMemberFuncs = mutableMapOf<String, MutableList<FunSpec>>()
	val jvmStructMemberFuncs = mutableMapOf<String, MutableList<FunSpec>>()

	val commonImGuiObj = TypeSpec.objectBuilder("ImGui").addModifiers(KModifier.EXPECT)
	val nativeImGuiObj = TypeSpec.objectBuilder("ImGui").addModifiers(KModifier.ACTUAL)
	val jvmImGuiObj = TypeSpec.objectBuilder("ImGui").addModifiers(KModifier.ACTUAL)

	jvmImGuiObj.addInitializerBlock(CodeBlock.of("loadCImGuiNativeLibs()\n"))

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

		val defaultMap = if (overload.defaults is JsonObject) {
			overload.defaults.mapValues { (_, value) -> (value as JsonLiteral).content }
		} else {
			emptyMap()
		}

		val parameters = mutableListOf<ParameterSpec>()
		val checks = mutableListOf<CodeBlock>() // e.g require(array.size >= 3)
		val nativeScopedHelpers = mutableListOf<CodeBlock>() // e.g usingProperty or usePinned
		val jvmScopedHelpers = mutableListOf<CodeBlock>() // JVM variants.
		val nativeArguments = mutableListOf<CodeBlock>()
		val jvmArguments = mutableListOf<CodeBlock>()
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
				nativeArguments.add(CodeBlock.of("ptr"))
				jvmArguments.add(CodeBlock.of("ptr"))
			} else if (arg.type matches cArrayRegex) {
				val (elemType, sizeStr) = cArrayRegex.matchEntire(arg.type)!!.destructured

				checks.add(CodeBlock.of("require($argNameKt.size >= ${sizeStr.toInt()})\n"))
				val pinnedName = "pinned${argNameKt.capitalize()}"
				nativeScopedHelpers.add(CodeBlock.of("$argNameKt.%M { $pinnedName ->", USE_PINNED))
				jvmScopedHelpers.add(CodeBlock.of("$argNameKt.nativeCopy { $pinnedName ->"))

				val paramType = when (elemType) {
					"int" -> INT_ARRAY
					"float" -> FLOAT_ARRAY
					else -> TODO()
				}
				check(defaultValue == null)
				parameters.add(ParameterSpec(argNameKt, paramType))
				nativeArguments.add(CodeBlock.of("$pinnedName.%M(0)", ADDRESS_OF))
				jvmArguments.add(CodeBlock.of("%N", pinnedName))
			} else {
				try {
					val isEnum = "${arg.type}_" in enums
					val isBitMask = "${arg.type}_" in enumBitMasks
					val isNullable = defaultValue == "((void*)0)" || (isBitMask && defaultValue == "0")

					val (type, nativeConv, jvmConv, propToPtr) = convertKotlinTypeToNative(arg.type, isNullable, false)
					val actualType = arg.type.removePrefix("const ")
					val passesStructByValue = actualType == "ImVec4" || actualType == "ImVec2"
					val isUnicodeStr = arg.type == "const ImWchar*"

					val paramType = type.copy(nullable = isNullable)
					val ptrName = "ptr${argNameKt.capitalize()}"
					if (propToPtr) {
						val helper = if (isNullable) {
							CodeBlock.of("usingPropertyN($argNameKt) { $ptrName ->")
						} else {
							CodeBlock.of("usingProperty($argNameKt) { $ptrName ->")
						}
						nativeScopedHelpers.add(helper)
						jvmScopedHelpers.add(helper)
					} else if (passesStructByValue) {
						jvmScopedHelpers.add(CodeBlock.of("using${actualType.removePrefix("Im")} { $ptrName -> "))
					} else if (isUnicodeStr) {
						jvmScopedHelpers.add(CodeBlock.of("${argNameKt}.usingUTF16String { $ptrName -> "))
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
								isEnum && defaultValue.toIntOrNull() != null -> enums.getValue("${arg.type}_")
										.single { it.value == defaultValue }.name.replace('_', '.')
								else -> defaultValue
							})
						}
						param.defaultValue(value)
					}

					parameters.add(param.build())
					val passedArgName = if (propToPtr) ptrName else argNameKt
					nativeArguments.add(CodeBlock.of("%N%L", passedArgName, nativeConv))
					jvmArguments.add(CodeBlock.of("%N%L", if (passesStructByValue || isUnicodeStr) ptrName else passedArgName, jvmConv))
				} catch (e: NotImplementedError) {
					// If type is unknown but has a reasonable default value, we can skip the param.
					if (defaultValue == "((void*)0)") {
						nativeArguments.add(CodeBlock.of("null"))
						jvmArguments.add(CodeBlock.of("null"))
					} else {
						// Skip functions with unknown param types.
						println(overload.cimguiName + " -> " + arg.type)
						continue@defLoop
					}
				}
			}
		}

		val cImGuiFunName = overload.overloadedCimguiName ?: overload.cimguiName
		val returnsStructByValue = overload.returnType == "ImVec4" || overload.returnType == "ImVec2"
		if (returnsStructByValue) {
			jvmScopedHelpers.add(CodeBlock.of("return${overload.returnType!!.removePrefix("Im")}·{ returnVal ->"))
		}

		val nativeIgFuncCall = buildCodeBlock {
			for (helper in nativeScopedHelpers) {
				add(helper)
				add("\n")
				indent()
			}
			add("%M(", MemberName("cimgui.internal", cImGuiFunName))
			add(nativeArguments.joinToCode())
			add(")")
			for (helper in nativeScopedHelpers) {
				add("\n")
				unindent()
				add("}")
			}
		}
		val jvmIgFuncCall = buildCodeBlock {
			val cimguiClass = ClassName("cimgui.internal", "CImGui")
			for (helper in jvmScopedHelpers) {
				add(helper)
				add("\n")
				indent()
			}
			add("%M(", MemberName(cimguiClass, if (returnsStructByValue) "${cImGuiFunName}_nonUDT" else cImGuiFunName))
			if (returnsStructByValue) {
				add("returnVal")
				if (jvmArguments.isNotEmpty()) add(", ")
			}
			add(jvmArguments.joinToCode())
			add(")")
			for (helper in jvmScopedHelpers) {
				add("\n")
				unindent()
				add("}")
			}
		}

		val commonFunction: FunSpec.Builder
		val nativeFunction: FunSpec.Builder
		val jvmFunction: FunSpec.Builder

		if (overload.isCtor) {
			check(checks.isEmpty())

			commonFunction = FunSpec.constructorBuilder()
			nativeFunction = FunSpec.constructorBuilder()
			jvmFunction = FunSpec.constructorBuilder()

			nativeFunction.callThisConstructor(CodeBlock.of("%L!!", nativeIgFuncCall))
			jvmFunction.callThisConstructor(CodeBlock.of("%L!!", jvmIgFuncCall))
		} else {
			val actualName = if (overload.isDtor) "destroy" else overload.functionName!!.decapitalize()
			commonFunction = FunSpec.builder(actualName)
			nativeFunction = FunSpec.builder(actualName)
			jvmFunction = FunSpec.builder(actualName)
		}
		commonFunction.addModifiers(KModifier.EXPECT)
		nativeFunction.addModifiers(KModifier.ACTUAL)
		jvmFunction.addModifiers(KModifier.ACTUAL)

		commonFunction.addParameters(parameters)
		val platformParams = parameters.map { ParameterSpec(it.name, it.type, it.modifiers) }
		nativeFunction.addParameters(platformParams)
		jvmFunction.addParameters(platformParams)

		if (overload.returnType == null) {
			check(isMemberFunction)
			if (overload.isDtor) {
				nativeFunction.addCode(nativeIgFuncCall)
				nativeFunction.addCode("\n")

				jvmFunction.addCode(jvmIgFuncCall)
				jvmFunction.addCode("\n")
			}
		} else {
			for (it in checks) {
				nativeFunction.addCode(it)
				nativeFunction.addCode("\n")

				jvmFunction.addCode(it)
				jvmFunction.addCode("\n")
			}
			if (overload.returnType == "void") {
				nativeFunction.addCode(nativeIgFuncCall)
				nativeFunction.addCode("\n")

				jvmFunction.addCode(jvmIgFuncCall)
				jvmFunction.addCode("\n")
			} else {
				// TODO: Improve this here with a white list of functions.
				val canBeNull = overload.returnType.endsWith("*") || overload.returnType == "ImTextureID"
				val shouldAssert = overload.returnType != "const char*" || overload.returnType == "const ImWchar*"
				try {
					val (typeKt, nativeConv, jvmConv) = convertNativeTypeToKt(overload.returnType, false)
					// If return value can be null and we're not asserting, then we return nullable.
					val actualType = typeKt.copy(canBeNull && !shouldAssert)
					commonFunction.returns(actualType)
					nativeFunction.returns(actualType)
					jvmFunction.returns(actualType)
					nativeFunction.addCode("return ")
					jvmFunction.addCode("return ")
					nativeFunction.addCode(nativeIgFuncCall)
					jvmFunction.addCode(jvmIgFuncCall)
					if (canBeNull) {
						nativeFunction.addCode(if (shouldAssert) "!!" else "?")
						if (overload.returnType != "const char*") jvmFunction.addCode(if (shouldAssert) "!!" else "?")
					}
					nativeFunction.addCode(nativeConv)
					jvmFunction.addCode(jvmConv)
					nativeFunction.addCode("\n")
					jvmFunction.addCode("\n")
				} catch (e: NotImplementedError) {
					// Skip functions with non-trivial return value.
					println(overload.cimguiName + " returns " + overload.returnType)
					continue
				}
			}
		}

		if (isMemberFunction) {
			commonStructMemberFuncs.getOrPut(overload.structName) { mutableListOf() }.add(commonFunction.build())
			nativeStructMemberFuncs.getOrPut(overload.structName) { mutableListOf() }.add(nativeFunction.build())
			jvmStructMemberFuncs.getOrPut(overload.structName) { mutableListOf() }.add(jvmFunction.build())
		} else {
			commonImGuiObj.addFunction(commonFunction.build())
			nativeImGuiObj.addFunction(nativeFunction.build())
			jvmImGuiObj.addFunction(jvmFunction.build())
		}
	}
	val imguiObj = commonImGuiObj.build()
	FileSpec.get("com.imgui", imguiObj)
			.toBuilder().indent("    ").build()
			.writeTo(commonDir)
	FileSpec.get("com.imgui", nativeImGuiObj.build())
			.toBuilder().indent("    ").build()
			.writeTo(nativeDir)
	FileSpec.get("com.imgui", jvmImGuiObj.build())
			.toBuilder().indent("    ").build()
			.writeTo(jvmDir)

	val imguiObjName = ClassName("com.imgui", "ImGui")
	val dslLambdaTypeName = LambdaTypeName.get(returnType = UNIT)
	val contractExactlyOnce = buildCodeBlock {
		beginControlFlow("%M", MemberName("kotlin.contracts", "contract"))
		addStatement("callsInPlace(block, %T.EXACTLY_ONCE)", ClassName("kotlin.contracts", "InvocationKind"))
		endControlFlow()
	}
	val contractAtMostOnce = buildCodeBlock {
		beginControlFlow("%M", MemberName("kotlin.contracts", "contract"))
		addStatement("callsInPlace(block, %T.AT_MOST_ONCE)", ClassName("kotlin.contracts", "InvocationKind"))
		endControlFlow()
	}
	val useExperimental = ClassName("kotlin", "UseExperimental")
	val experimentalContracts = ClassName("kotlin.contracts", "ExperimentalContracts")
	val experimentalAnnotation = AnnotationSpec.builder(useExperimental)
			.addMember("%T::class", experimentalContracts)
			.build()

	val imguiDSL = FileSpec.builder("com.imgui", "ImguiDSL")
	val functionMap = imguiObj.funSpecs.groupBy { it.name }
	for (funSpec in imguiObj.funSpecs) {
		val exitFunction: FunSpec
		val dslName: String
		val isConditional: Boolean
		if (funSpec.name.startsWith("push")) {
			val noun = funSpec.name.removePrefix("push")
			exitFunction = functionMap.getValue("pop$noun").single()
			dslName = "with$noun"
			isConditional = false
		} else if (funSpec.name.startsWith("begin")) {
			val noun = funSpec.name.removePrefix("begin")
			if (noun.isEmpty() || noun == "Child" || noun == "ChildFrame") {
				// TODO: Will handle these in future release.
				continue
			}
			val endFunctionName = if (noun.startsWith("Popup")) {
				"endPopup"
			} else {
				"end$noun"
			}
			exitFunction = functionMap.getValue(endFunctionName).single()
			dslName = noun.decapitalize()
			isConditional = funSpec.returnType == BOOLEAN
		} else if (funSpec.name.startsWith("treeNode")) {
			exitFunction = functionMap.getValue("treePop").single()
			dslName = funSpec.name
			isConditional = true
		} else if (funSpec.name.startsWith("listBoxHeader")) {
			exitFunction = functionMap.getValue("listBoxFooter").single()
			dslName = "listBox"
			isConditional = true
		} else {
			continue
		}

		val dsl = FunSpec.builder(dslName)
				.addModifiers(KModifier.INLINE)
				.receiver(imguiObjName)
				.addParameters(funSpec.parameters)
				.addParameter("block", dslLambdaTypeName)
				.addAnnotation(experimentalAnnotation)
				.addCode(buildCodeBlock {
					if (isConditional) {
						add(contractAtMostOnce)
					} else {
						add(contractExactlyOnce)
					}
					add("\n")
					val params = funSpec.parameters.map { it.name }.toTypedArray()
					val call = CodeBlock.of("${funSpec.name}(${params.joinToString { "%N" }})", *params)
					if (isConditional) {
						beginControlFlow("if (%L)", call)
					} else {
						addStatement("%L", call)
					}
					beginControlFlow("try")
					addStatement("block()")
					nextControlFlow("finally")
					addStatement("${exitFunction.name}()")
					endControlFlow()
					if (isConditional) {
						endControlFlow()
					}
				})
				.build()
		imguiDSL.addFunction(dsl)
	}
	imguiDSL.indent("    ").build().writeTo(commonDir)

	for ((structName, members) in structs) {
		val imguiStructClass = ClassName("cimgui.internal", structName)

		val nativePointerClass = C_POINTER.parameterizedBy(imguiStructClass)
		val jvmPointerClass = imguiStructClass

		val commonStruct = TypeSpec.expectClassBuilder(structName)
		val nativeStruct = TypeSpec.classBuilder(structName)
				.addModifiers(KModifier.INLINE, KModifier.ACTUAL)
				.addAnnotation(ACTUAL_WITHOUT_EXPECT)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("ptr", nativePointerClass)
						.build())
				.addProperty(PropertySpec.builder("ptr", nativePointerClass)
						// .addModifiers(KModifier.INTERNAL)
						.initializer("ptr")
						.build())
		val jvmStruct = TypeSpec.classBuilder(structName)
				.addModifiers(KModifier.INLINE, KModifier.ACTUAL)
				.addAnnotation(ACTUAL_WITHOUT_EXPECT)
				.primaryConstructor(FunSpec.constructorBuilder()
						.addParameter("ptr", jvmPointerClass)
						.build())
				.addProperty(PropertySpec.builder("ptr", jvmPointerClass)
						// .addModifiers(KModifier.INTERNAL)
						.initializer("ptr")
						.build())

		for (member in members) {
			// Skip imgui internal/private members.
			if (member.name.startsWith('_')) continue

			val memberNameKt = member.name.let {
				if (member.name == "ID") "id" else it.decapitalize()
			}

			if (member.size == null || member.type == "const char*") {
				// TODO: Improve this here with a white list of functions.
				val canBeNull = member.type.endsWith("*") || member.type == "ImTextureID"
				val shouldAssert = !canBeNull || member.type == "const char*"
				try {
					val (typeKt, nativeConv, jvmConv) = convertNativeTypeToKt(member.type, true)
					// If return value can be null and we're not asserting, then we return nullable.
					val propType = typeKt.copy(canBeNull && !shouldAssert)

					val commonProp = PropertySpec.builder(memberNameKt, propType, KModifier.EXPECT)
					val nativeProp = PropertySpec.builder(memberNameKt, propType, KModifier.ACTUAL)
					val jvmProp = PropertySpec.builder(memberNameKt, propType, KModifier.ACTUAL)

					val nativeGetter = FunSpec.getterBuilder()
					nativeGetter.addCode("return ptr.%M.%N", POINTED, member.name)
					if (canBeNull) nativeGetter.addCode(if (shouldAssert) "!!" else "?")
					nativeGetter.addCode(nativeConv)
					nativeGetter.addCode("\n")

					val jvmGetter = FunSpec.getterBuilder()
					jvmGetter.addCode("return ptr.%N", memberNameKt)
					if (canBeNull) jvmGetter.addCode(if (shouldAssert) "!!" else "?")
					jvmGetter.addCode(jvmConv)
					jvmGetter.addCode("\n")

					nativeProp.getter(nativeGetter.build())
					jvmProp.getter(jvmGetter.build())

					commonStruct.addProperty(commonProp.build())
					nativeStruct.addProperty(nativeProp.build())
					jvmStruct.addProperty(jvmProp.build())
				} catch (e: NotImplementedError) {
					println("MEMBER: $structName -> ${member.name}: ${member.type}")
					// Skip members with non-trivial type.
					continue
				}
			}
		}

		commonStruct.addFunctions(commonStructMemberFuncs[structName] ?: emptyList())
		nativeStruct.addFunctions(nativeStructMemberFuncs[structName] ?: emptyList())
		jvmStruct.addFunctions(jvmStructMemberFuncs[structName] ?: emptyList())

		FileSpec.get("com.imgui", commonStruct.build()).writeTo(commonDir)
		FileSpec.get("com.imgui", nativeStruct.build()).writeTo(nativeDir)
		FileSpec.get("com.imgui", jvmStruct.build()).writeTo(jvmDir)
	}
}

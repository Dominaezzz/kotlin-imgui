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
		"ImTextureID",
		"ImGuiMouseCursor"
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

val cArrayRegex = Regex("[a-z]+\\[[2-9]\\]")

@UnstableDefault
@ImplicitReflectionSerializer
fun main(args: Array<String>) {
	val inputDir = Paths.get(args[0])

	val outputDir = Paths.get(".").toAbsolutePath()

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

		FileSpec.get("com.imgui", struct.build()).writeTo(outputDir)
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

	val imguiObj = TypeSpec.objectBuilder("ImGui")
	defLoop@for (overload in definitions.flatMap { (_, overloads) -> overloads }) {
		// TODO: Not needed in wrapper.
		if (overload.nonUDT != null) continue

		val defName = overload.cimguiName
		if (defName in functionsToSkip) continue

		// Explicitly drop support for *Scalar functions.
		if (defName.endsWith("Scalar") || defName.endsWith("ScalarN")) continue

		// Skip member functions for now.
		if (overload.structName.isNotEmpty() || overload.functionName == null) continue

		val functionKt = FunSpec.builder(overload.functionName.decapitalize())
		val cimguiFun = MemberName("cimgui.internal",
				overload.overloadedCimguiName ?: overload.cimguiName)

		val defaultMap = if (overload.defaults is JsonObject) {
			overload.defaults.mapValues { (_, value) -> (value as JsonLiteral).content }
		} else {
			emptyMap()
		}

		var endControlFlowCount = 0
		val arguments = mutableListOf<CodeBlock>()
		for (arg in overload.argsT) {
			val argNameKt = arg.name.snakeToPascalCase().decapitalize()
			val defaultValue = defaultMap[arg.name]

			val ktType = simpleTypeMap[arg.type]
			if (ktType != null) {
				val param = ParameterSpec.builder(argNameKt, ktType)
				if (defaultValue != null) {
					if (ktType == U_LONG) {
						param.defaultValue("${defaultValue}uL")
					} else {
						param.defaultValue(defaultValue)
					}
				}
				functionKt.addParameter(param.build())
				arguments.add(CodeBlock.of("%N", argNameKt))
			} else if (arg.type in valueTypes) {
				functionKt.addParameter(argNameKt, ClassName("com.imgui", arg.type))
				arguments.add(CodeBlock.of("%N.value", argNameKt))
			} else if (arg.type.dropLast(1) in privateTypes) {
				val type = ClassName("com.imgui", arg.type.dropLast(1))
				if (defaultValue != null) {
					check(defaultValue == "((void*)0)")
					val param = ParameterSpec.builder(argNameKt, type.copy(nullable = true))
							.defaultValue("null")
					functionKt.addParameter(param.build())
					arguments.add(CodeBlock.of("%N?.ptr", argNameKt))
				} else {
					functionKt.addParameter(argNameKt, type)
					arguments.add(CodeBlock.of("%N.ptr", argNameKt))
				}
			} else if (arg.type == "const char*") {
				val param = if (defaultValue != null) {
					if (defaultValue == "((void*)0)") {
						ParameterSpec.builder(argNameKt, STRING.copy(nullable = true))
								.defaultValue("null")
					} else {
						ParameterSpec.builder(argNameKt, STRING)
								.defaultValue("%L", defaultValue)
					}
				} else {
					ParameterSpec.builder(argNameKt, STRING)
				}
				functionKt.addParameter(param.build())
				arguments.add(CodeBlock.of("%N", argNameKt))
			} else if (arg.type == "...") {
				// functionKt.addParameter("args", ANY.copy(nullable = true), KModifier.VARARG)
				// arguments.add(CodeBlock.of("*args"))
				//
				// // FIXME: When calling variadic C functions spread operator is supported only for *arrayOf(...)
				// continue@defLoop

				continue // Just skip the param.
			} else if (arg.type == "va_list") {
				// Explicitly not supporting va_list
				continue@defLoop
			} else if (arg.type + "_" in enums.keys) {
				val isBitFlags = arg.type + "_" in enumBitMasks
				val enumKt = ClassName("com.imgui", arg.type)
				val paramType = if (isBitFlags) FLAG.parameterizedBy(enumKt) else enumKt
				val param = if (defaultValue != null) {
					if (isBitFlags && defaultValue == "0") {
						ParameterSpec.builder(argNameKt, paramType.copy(nullable = true))
								.defaultValue("null")
					} else {
						ParameterSpec.builder(argNameKt, paramType).defaultValue(defaultValue)
					}
				} else {
					ParameterSpec.builder(argNameKt, paramType)
				}
				val builtParam = param.build()
				functionKt.addParameter(builtParam)
				if (builtParam.type.isNullable) {
					arguments.add(CodeBlock.of("%N?.value ?: 0", argNameKt))
				} else {
					arguments.add(CodeBlock.of("%N.value.%M()", argNameKt, CONVERT))
				}
			} else if (arg.type matches cArrayRegex) {
				val size = arg.type.substring(arg.type.lastIndex - 1, arg.type.lastIndex).toInt()
				functionKt.addCode("require($argNameKt.size >= $size)\n")
				val pinnedName = "pinned${argNameKt.capitalize()}"
				functionKt.beginControlFlow("$argNameKt.%M { $pinnedName ->", USE_PINNED)
				endControlFlowCount++

				functionKt.addParameter(argNameKt, when (arg.type.substringBefore('[')) {
					"int" -> INT_ARRAY
					"float" -> FLOAT_ARRAY
					else -> TODO()
				})
				arguments.add(CodeBlock.of("$pinnedName.%M(0)", ADDRESS_OF))
			} else if (arg.type == "bool*" || arg.type == "int*" || arg.type == "unsigned int*" || arg.type == "size_t*" || arg.type == "float*" || arg.type == "double*" || arg.type == "float&") {
				val ptrName = "ptr${argNameKt.capitalize()}"

				val propType = when (arg.type.dropLast(1)) {
					"bool" -> BOOLEAN
					"int" -> INT
					"unsigned int" -> U_INT
					"size_t" -> U_LONG
					"float" -> FLOAT
					"double" -> DOUBLE
					else -> TODO()
				}

				val paramType = K_MUTABLE_PROPERTY.parameterizedBy(propType)
				val param = if (defaultValue == null) {
					functionKt.beginControlFlow("usingProperty($argNameKt) { $ptrName ->")
					ParameterSpec.builder(argNameKt, paramType)
				} else {
					check(defaultValue == "((void*)0)")
					functionKt.beginControlFlow("usingPropertyN($argNameKt) { $ptrName ->")
					ParameterSpec.builder(argNameKt, paramType.copy(nullable = true))
							.defaultValue("null")
				}.build()
				endControlFlowCount++
				functionKt.addParameter(param)
				arguments.add(CodeBlock.of("%N", ptrName))
			} else if (arg.type == "const ImVec2" || arg.type == "ImVec2") {
				val param = ParameterSpec.builder(argNameKt, VEC2)
				if (defaultValue != null) {
					if (defaultValue == "ImVec2(0,0)") {
						param.defaultValue("Vec2.Zero")
					} else {
						val (x, y) = defaultValue.substringAfter('(').dropLast(1).split(',')
						param.defaultValue("Vec2(${x}f, ${y}f)")
					}
				}
				functionKt.addParameter(param.build())
				arguments.add(CodeBlock.of("%N.toCValue()", argNameKt))
			} else if (arg.type == "const ImVec4") {
				val param = ParameterSpec.builder(argNameKt, VEC4)
				if (defaultValue != null) {
					if (defaultValue == "ImVec4(0,0,0,0)") {
						param.defaultValue("Vec4.Zero")
					} else {
						val (x, y, z, w) = defaultValue.substringAfter('(').dropLast(1).split(',')
						param.defaultValue("Vec4(${x}f, ${y}f, ${z}f, ${w}f)")
					}
				}
				functionKt.addParameter(param.build())
				arguments.add(CodeBlock.of("%N.toCValue()", argNameKt))
			}  else if (arg.type.endsWith('*') && arg.type.dropLast(1).removePrefix("const ") in structs.keys) {
				val structNameKt = arg.type.dropLast(1).removePrefix("const ")
				val structKt = ClassName("com.imgui", structNameKt)
				if (defaultValue != null) {
					check(defaultValue == "((void*)0)")
					val param = ParameterSpec.builder(argNameKt, structKt.copy(nullable = true))
					param.defaultValue("null")
					functionKt.addParameter(param.build())
					arguments.add(CodeBlock.of("%N?.ptr", argNameKt))
				} else {
					functionKt.addParameter(argNameKt, structKt)
					arguments.add(CodeBlock.of("%N.ptr", argNameKt))
				}
			} else {
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
		val igFuncCall = buildCodeBlock {
			add("%M(", cimguiFun)
			add(arguments.joinToCode())
			add(")")
		}

		checkNotNull(overload.returnType)
		if (overload.returnType == "void") {
			functionKt.addCode(igFuncCall)
			functionKt.addCode("\n")
		} else {
			// TODO: Improve this here with a white list of functions.
			val canBeNull = overload.returnType.endsWith("*") || overload.returnType == "ImTextureID"
			val shouldAssert = overload.returnType != "const char*"
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
		repeat(endControlFlowCount) { functionKt.endControlFlow() }

		imguiObj.addFunction(functionKt.build())
	}
	FileSpec.get("com.imgui", imguiObj.build())
			.toBuilder().indent("    ").build()
			.writeTo(outputDir)
}

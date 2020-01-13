import kotlinx.serialization.Serializable

@Serializable
data class StructsAndEnums(
		val enums: Map<String, List<EnumValue>>,
		val structs: Map<String, List<StructMember>>
)

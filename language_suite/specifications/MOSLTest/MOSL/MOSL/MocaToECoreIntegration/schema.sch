source /MocaTree
target /Ecore
 
class MPackageToEPackage {
	source -> Node
	target -> EPackage
}

class MClassToEClass {
	source -> Node
	target -> EClass
}

class MReferenceToEReference {
	source -> Node
	target -> EReference
}

class MSuperClassToESuperClass {
	source -> Node
	target -> EClass
}

class MAttributeToEAttribute {
	source -> Node
	target -> EAttribute
}

class MLiteralToEEnumLiteral {
	source -> Node
	target -> EEnumLiteral
}

class MDataTypeToEDataType {
	source -> Node
	target -> EDataType
}

class MEnumToEEnum extends MDataTypeToEDataType

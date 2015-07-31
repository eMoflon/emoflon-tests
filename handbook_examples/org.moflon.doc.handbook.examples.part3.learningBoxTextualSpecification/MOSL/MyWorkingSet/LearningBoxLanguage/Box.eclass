class Box {

	name : EString
	stringRep: EString
	
	// Container reference to store an infinite number of Partitions
	<>- containedPartition(0..*) -> Partition

	addToStringRep(card : Card) : void
	determineNextSize() : EInt
	grow() : EBoolean
	toString() : EString
	
}
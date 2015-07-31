class Box {

	name : EString
	
	stringRep: EString
	
	<>- containedPartition(0..*) -> Partition

	determineNextSize() : EInt
	
	grow() : EBoolean {
		if [addNewPartitionBox] {
			return true
		} else {
			if <@this.initializeBox()> {
				return true
			} else {
				return false
			}
		}
	}
	
	initializeBox() : EBoolean {
		[buildPartitions]
		return true
	}
	
	toString() : EString {
		forEach [forAllPartitions] {
			forEach [forAllCards] {
				<@this.addToStringRep(@card)>
			}
		}
		return this.stringRep
	}
	
	addToStringRep(card : Card) : void
	
	
}
class Box {
	name : EString
	stringRep : EString
	
	
	<>-> containedPartition (0..*) : Partition
	
	addToStringRep(card : Card) : void
	
	grow() : void {
		[addNewPartitionBox]
		return
	}
	
	toString() : EString {
		forEach [forAllPartitions] {
			forEach [forAllCards] {
				<@this.addToStringRep(card)>
			}
		}
		return this.stringRep
	}
	
	determineNextSize() : EInt
}

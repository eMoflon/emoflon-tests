class Partition {

	index : EInt
	partitionSize : EInt

	<>- card(0..*) -> Card

	- box(0..1) -> Box
	- next(0..1) -> Partition
	- previous(0..1) -> Partition
	
	empty() : void {
		forEach [deleteCardsInPartition]
		return
	}
	
	removeCard(card : Card) : Card {
		 [deleteSingleCard]
		 return @card
	}
	
	check(guess : EString, card : Card) : EBoolean {
		if [checkCard] 
		{
			if [isFastCard] {
 				[promoteFastCard]
 			} else {
	 			[promoteCard]
			}
		return true
		} else {
			[penalizeCard]
			return false
		}		
	}
}

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
	
	check(card : Card, guess : EString) : EBoolean {
		if [checkCard] 
		{
			if [isFastCard] {
 				[promoteFastCard]
 			} else {
	 			[promoteCard]
			}
		return true
		} else {
			if [penalizeCard] { 
				return false
			} else {
				return false 
			}
		}		
	}
}

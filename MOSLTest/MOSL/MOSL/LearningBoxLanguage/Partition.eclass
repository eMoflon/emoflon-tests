class Partition {
	index : EInt
	partitionSize : EInt

	-> box(0..1) : Box 
	
	<>-> card(0..*) : Card
	
	-> next(0..1) : Partition
	-> previous(0..1) : Partition
	
	removeCard(card : Card) : Card {
		[removeCard]
		return @card
	}
	
	check(card : Card, guessed : EString) : EBoolean {
		if [checkIfGuessIsCorrect] {
			if [isFastCard] {
				if [promoteFastCard] {
					return true 
				} else {
					return true 
				}
			} else {
				if [promoteCard] { 
					return true	
				} else { 
					return true
				}
			}
		} else {
			if [penalizeCard] {
				return false 
			} else { 
				return false
			}
		}
	}
	
	empty() : void {
		forEach [deleteCardsInPartition]
		return
	}
}

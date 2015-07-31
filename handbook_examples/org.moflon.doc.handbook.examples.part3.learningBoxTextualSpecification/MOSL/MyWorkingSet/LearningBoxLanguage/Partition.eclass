class Partition {

	index : EInt
	partitionSize : EInt

	<>- card(0..*) -> Card

	- box(0..1) -> Box
	- next(0..1) -> Partition
	- previous(0..1) -> Partition
	
	check(card : Card, guess : EString) : EBoolean
	empty() : void
	removeCard(card : Card) : Card
	
}
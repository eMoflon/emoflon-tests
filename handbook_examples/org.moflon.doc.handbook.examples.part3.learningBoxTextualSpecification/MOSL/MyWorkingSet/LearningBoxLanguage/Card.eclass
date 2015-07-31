class Card {
	
	back : EString
	face : EString
	partitionHistory : EString
	
	// Simple reference permitting a card to belong to zero or one Partition
	- cardContainer(0..1) -> Partition

	invert() : void
	printCard() : void
	
}
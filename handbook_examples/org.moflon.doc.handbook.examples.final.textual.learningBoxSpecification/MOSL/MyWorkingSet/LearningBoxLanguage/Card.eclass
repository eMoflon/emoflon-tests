class Card {
	
	back : EString
	face : EString
	partitionHistory : EString
	
	- cardContainer(0..1) -> Partition

	invert() : void {
		[initializeTemp]
		[swapVariable]
		return
	}
	
	printCard() : void
	
}
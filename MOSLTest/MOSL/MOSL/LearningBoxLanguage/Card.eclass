class Card {
	back : EString
	face : EString
	color : CardColor
	
	-> cardContainer(1..1) : Partition
	
	invert() : void {
		[initializeTemp]
		[swapVariables]
		return
	}
} 

class Library {
	name : EString
	
	<>- author(0..*) -> Author
	<>- shelf(0..*) -> Shelf
}
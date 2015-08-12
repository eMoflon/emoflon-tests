class Dictionary {
	title : EString

	<>- entry(0..*) -> Entry

	- shelf(1..1) -> Shelf
	- author(1..1) -> Author
}
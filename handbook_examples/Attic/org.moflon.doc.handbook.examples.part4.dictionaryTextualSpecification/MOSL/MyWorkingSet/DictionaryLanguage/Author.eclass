class Author {
	email : EString

	- library(1..1) -> Library
	- dictionary(0..*) -> Dictionary
}
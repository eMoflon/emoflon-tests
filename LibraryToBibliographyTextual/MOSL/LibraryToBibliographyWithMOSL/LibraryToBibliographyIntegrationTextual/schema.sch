source /LibraryLanguage
target /BibliographyLanguage

class LibraryToBibliography {
	source -> Library
	target -> Bibliography
}

class AuthorToResearcher {
	source -> Author
	target -> Researcher
}

class BookToPublication {
	source -> Book	
	target -> Publication
}


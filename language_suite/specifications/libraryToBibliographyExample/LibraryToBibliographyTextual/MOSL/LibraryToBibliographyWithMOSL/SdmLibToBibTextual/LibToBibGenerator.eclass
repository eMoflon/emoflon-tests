class LibToBibGenerator {
	enforceDoubleBooktitlePerTest : EBoolean
	publicationProcessed : EBoolean
	 
	bibliographyToLibrary(bibliography : /BibliographyLanguage/Bibliography) : ../LibraryLanguage/Library {
		[generateNewLibrary]
		forEach [loopOverAllResearchers] {
			[generateNewAuthorPerResearcher]
			
			forEach [initialProcessForAllPublicationsOfAResearcher] {
				if [checkForDoubleBooktitleEnforcement]{
					<@this.createANewBook(aPublicationOfResearcher, newAuthor, newLibrary)>
				} else {
					if ! [checkAlreadyGeneratedBooks]{
						<@this.createANewBook(aPublicationOfResearcher, newAuthor, newLibrary)>
					}
				}	
			}
		} 
		
		return @newLibrary 
	}
	 
	createANewBook(aPublicationOfResearcher : /BibliographyLanguage/Publication, 
				   newAuthor                : /LibraryLanguage/Author,
				   newLibrary				: /LibraryLanguage/Library) : void {
		[createANewBook]
		return			   
	}			   
	
	libraryToBibliography(library : /LibraryLanguage/Library) :  /BibliographyLanguage/Bibliography {
		[generateBibliography]
		
		forEach [authorInTheLibrary] {
			[generateNewResearcher]
			
			forEach [bookOfTheAuthor] {
				[generateNewPublication]
			}
		}
		
		return @bibliography
	}
}   
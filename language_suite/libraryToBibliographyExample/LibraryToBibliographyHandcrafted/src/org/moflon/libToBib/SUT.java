package org.moflon.libToBib;

import BibliographyLanguage.Bibliography;
import LibraryLanguage.Library;

public interface SUT
{
   public Bibliography libraryToBibliography(Library library);
   public Library bibliographyToLibrary(Bibliography bibliography);
}

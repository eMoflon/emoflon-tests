package org.moflon.libToBib.javaMutants;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.moflon.libToBib.SUT;

import BibliographyLanguage.Bibliography;
import BibliographyLanguage.BibliographyLanguageFactory;
import BibliographyLanguage.BibliographyLanguagePackage;
import BibliographyLanguage.Publication;
import BibliographyLanguage.Researcher;
import LibraryLanguage.Author;
import LibraryLanguage.Book;
import LibraryLanguage.Item;
import LibraryLanguage.Library;
import LibraryLanguage.LibraryLanguageFactory;
import LibraryLanguage.LibraryLanguagePackage;
import TGGLanguage.algorithm.ApplicationTypes;

public class HandcraftedImplementationMutantC implements SUT
{

   private static BibliographyLanguageFactory bibFactory = BibliographyLanguagePackage.eINSTANCE.getBibliographyLanguageFactory();

   private static LibraryLanguageFactory libFactory = LibraryLanguagePackage.eINSTANCE.getLibraryLanguageFactory();

   private boolean enforceDoubleBooktitle;

   public EObject performTransformation(ApplicationTypes direction, EObject inputModel, String testCaseName)
   {
      return (direction == ApplicationTypes.FORWARD) ? libraryToBibliography((Library) inputModel) : bibliographyToLibrary((Bibliography) inputModel);
   }

   // ### V.: 2.0
   // L2B - Library2Bibliography
   public Bibliography libraryToBibliography(Library library)
   {

      // A2R - Author2Researcher
      HashMap<Author, Researcher> authorToResearcherMapping = transformAuthorsToResearchers(library.getAuthor());

      // B2P - Book2Publication
      // 2. Alle Books zu Publications
      transformBooksToPublications(library, authorToResearcherMapping);

      Bibliography bibliography = bibFactory.createBibliography();
      bibliography.setName(library.getLocation());

      Collection<Researcher> researcherCollection = authorToResearcherMapping.values();

      bibliography.getResearcher().addAll(researcherCollection);

      return bibliography;
   }

   public void transformBooksToPublications(Library library, HashMap<Author, Researcher> authorToResearcherMapping)
   {
      // iterate over all books and create a publication for every author of a book
      EList<Item> items = library.getItem();
      for (Iterator<Item> bookIter = items.iterator(); bookIter.hasNext();)
      {
         Book book = (Book) bookIter.next();
         EList<Author> bookauthors = book.getAuthor();
         // iterate over all authors of the current book
         for (Iterator<Author> authorIter = bookauthors.iterator(); authorIter.hasNext();)
         {
            Author bookauthor = authorIter.next();
            Researcher researcherCorrToAuthor = authorToResearcherMapping.get(bookauthor);
            // creating of a new publication for the researcher (based on his book)
            Publication publication = bibFactory.createPublication();
            publication.setCitation(book.getTitle());
            researcherCorrToAuthor.getPublication().add(publication);
            // TODO: bisher wird die Korrespondenz: "Book<->Publication" nicht persistiert,
            // lässt sich dies am Modell verargumentieren, oder fehlen dies passenden Tests um diesen Misstatnd
            // aufzudecken?
         }
      }
   }

   public HashMap<Author, Researcher> transformAuthorsToResearchers(EList<Author> authors)
   {
      HashMap<Author, Researcher> authorToResearcherMapping = new HashMap<Author, Researcher>();

      for (Iterator<Author> authorIter = authors.iterator(); authorIter.hasNext();)
      {
         Author author = authorIter.next();

         Researcher researcher = bibFactory.createResearcher();
         researcher.setName(author.getName());

         authorToResearcherMapping.put(author, researcher);
      }
      ;
      return authorToResearcherMapping;
   };

   // B2L - Bibliography2Library
   public Library bibliographyToLibrary(Bibliography bibliography)
   {

      Library library = libFactory.createLibrary();

      library.setLocation(bibliography.getName());

      EList<Researcher> researchers = bibliography.getResearcher();

      // R2A - Researcher2Author
      for (Iterator<Researcher> researchIter = researchers.iterator(); researchIter.hasNext();)
      {
         Researcher researcher = researchIter.next();
         Author author = researcherToAuthor(library, researcher);
         // P2B - Publication2Book
         // wenn noch nciht vorhanden: Buch anlegen und Author eintragen, sonst bei vorhandenem Buch den Author
         // hinzufügen
         EList<Publication> publications = researcher.getPublication();
         for (Iterator<Publication> pubIter = publications.iterator(); pubIter.hasNext();)
         {
            boolean bookAllreadyExists = false;
            Publication publication = pubIter.next();
            if (!enforceDoubleBooktitle)
            {
               EList<Item> books = library.getItem();
               for (Iterator<Item> bookIter = books.iterator(); bookIter.hasNext();)
               {
                  Book book = (Book) bookIter.next();
                  if (book.getTitle() == publication.getCitation())
                  {
                     bookAllreadyExists = true;
                     book.getAuthor().add(author);
                  }
               }
            }
            if (!bookAllreadyExists)
            {
               Book book = generateBookOfPublication(author, publication);
               library.getItem().add(book);
            }
         }
      }
      return library;
   }

   public Author researcherToAuthor(Library targetLibrary, Researcher sourceResearcher)
   {
      Author author = libFactory.createAuthor();
      author.setName(sourceResearcher.getName());
      targetLibrary.getAuthor().add(author);
      return author;
   }

   public Book generateBookOfPublication(Author author, Publication publication)
   {
      Book book = libFactory.createBook();
      book.setTitle(publication.getCitation());
      book.getAuthor().add(author);
      return book;
   }

   public void setEnforceDoubleBooktitle(boolean enforceDoubleBooktitle)
   {
      this.enforceDoubleBooktitle = enforceDoubleBooktitle;
   }

}

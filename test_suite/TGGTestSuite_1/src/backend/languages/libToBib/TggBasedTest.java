package backend.languages.libToBib;

import org.eclipse.emf.ecore.EObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;
import org.moflon.tie.configurators.PreferRuleBookToPublicationConfigurator;
import org.moflon.tie.configurators.PreferRuleConnectionBookToAuthorConfigurator;

import BibliographyLanguage.BibliographyLanguagePackage;
import LibraryLanguage.LibraryLanguagePackage;
import LibraryToBibliographyIntegration.LibraryToBibliographyIntegrationPackage;

public class TggBasedTest extends IntegratorTest {
	public boolean enforceDoubleBooktitlePerTest;

	public TggBasedTest() {
		super(LibraryLanguagePackage.eINSTANCE,
				LibraryToBibliographyIntegrationPackage.eINSTANCE,
				BibliographyLanguagePackage.eINSTANCE);
		enforceDoubleBooktitlePerTest = false;

		integrationName = "LibraryToBibliographyIntegration";
	}

	@Test
	public void basicTggBasedFWD() {
		integrate("basic_FWD");
	}

	@Test
	public void basicTggBasedBWD() {
		setConfigurator(new PreferRuleConnectionBookToAuthorConfigurator());
		integrate("basic_BWD");
	}

	@Test
	public void emptyLibFWD() {
		integrate("emptyLib_FWD");
	}

	@Test
	public void emptyBibBWD() {
		integrate("emptyBib_BWD");
	}

	@Test
	public void emptyLibNoNameFWD() {
		integrate("emptyLibNoName_FWD");
	}

	@Test
	public void emptyBibNoNameBWD() {
		integrate("emptyBibNoName_BWD");
	}

	@Test
	public void onlyAuthorNoBookFWD() {
		integrate("onlyAuthorNoBook_FWD");
	}

	@Test
	public void onlyAuthorNoBookbWD() {
		integrate("onlyAuthorNoBook_BWD");
	}

	@Test
	public void onlyAuthorWithoutNameNoBookFWD() {
		integrate("onlyAuthorWithoutNameNoBook_FWD");
	}

	@Test
	public void onlyAuthorWithoutNameNoBookBWD() {
		integrate("onlyAuthorWithoutNameNoBook_BWD");
	}

	@Test
	public void onlyAuthorsWithoutNamesNoBookFWD() {
		integrate("onlyAuthorsWithoutNamesNoBook_FWD");
	}

	@Test
	public void onlyAuthorsWithoutNamesNoBookBWD() {
		integrate("onlyAuthorsWithoutNamesNoBook_BWD");
	}

	@Test
	public void onlyAuthorsSameNamesNoBookFWD() {
		integrate("onlyAuthorsSameNamesNoBook_FWD");
	}

	@Test
	public void onlyAuthorsSameNamesNoBookBWD() {
		integrate("onlyAuthorsSameNamesNoBook_BWD");
	}

	@Test
	public void fourAuthorsOneBookMultipleAuthorsFWD() {
		integrate("4Authors1BookMultipleAuthors_FWD");
	}

	@Test
	public void fourAuthorsOneBookMultipleAuthorsBWD() {
		setConfigurator(new PreferRuleConnectionBookToAuthorConfigurator());
		integrate("4Authors1BookMultipleAuthors_BWD");
	}

	@Test
	public void fourAuthorsTwoBooksSingleAuthorFWD() {
		integrate("4Authors2BooksSingleAuthor_FWD");
	}

	@Test
	public void fourAuthorsTwoBooksSingleAuthorBWD() {

		integrate("4Authors2BooksSingleAuthor_BWD");
	}

	@Test
	public void fourAuthorsTwoBooksDoubleAuthorsFWD() {

		integrate("4Authors2BooksDoubleAuthors_FWD");
	}

	@Test
	public void fourAuthorsTwoBooksDoubleAuthorsBWD() {
		setConfigurator(new PreferRuleConnectionBookToAuthorConfigurator());
		integrate("4Authors2BooksDoubleAuthors_BWD");
	}

	@Test
	public void fourAuthorsTwoBooksMultipleAuthorsFWD() {

		integrate("4Authors2BooksMultipleAuthors_FWD");
	}

	@Test
	public void fourAuthorsTwoBooksMultipleAuthorsBWD() {
		setConfigurator(new PreferRuleConnectionBookToAuthorConfigurator());
		integrate("4Authors2BooksMultipleAuthors_BWD");
	}

	@Test
	public void fiveAuthorsSameNamesTwoBooksFWD() {

		integrate("5AuthorsSameNames2Books_FWD");
	}

	@Test
	public void fiveAuthorsSameNamesTwoBooksBWD() {
		setConfigurator(new PreferRuleConnectionBookToAuthorConfigurator());
		integrate("5AuthorsSameNames2Books_BWD");
	}

	@Test
	public void twoAuthorsTwoBooksSameTitled_injectiveExampleA_FWD() {

		integrate("2Authors2BooksSameTitled_injectiveExampleA_FWD");
	}

	@Test
	public void twoAuthorsTwoBooksSameTitled_injectiveExampleA_BWD() {
		setConfigurator(new PreferRuleBookToPublicationConfigurator());
		enforceDoubleBooktitlePerTest = true;
		integrate("2Authors2BooksSameTitled_injectiveExampleA_BWD");
		enforceDoubleBooktitlePerTest = false;
	}

	@Test
	public void twoAuthorsOneBook_injectiveExampleB_FWD() {
		integrate("2Authors1Book_injectiveExampleB_FWD");
	}

	@Test
	public void twoAuthorsOneBook_injectiveExampleB_BWD() {
		setConfigurator(new PreferRuleConnectionBookToAuthorConfigurator());
		integrate("2Authors1Book_injectiveExampleB_BWD");
	}

	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		TreeComparator.compare(
				(new ModelToTreeConverter()).modelToTree(created, false),
				(new ModelToTreeConverter()).modelToTree(expected, false));

	}

}

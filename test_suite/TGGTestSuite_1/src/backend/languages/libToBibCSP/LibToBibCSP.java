package backend.languages.libToBibCSP;


import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import BibliographyLanguageCSP.BibliographyLanguageCSPPackage;
import LibraryLanguageCSP.LibraryLanguageCSPPackage;
import LibraryToBibliographyIntegrationCSP.LibraryToBibliographyIntegrationCSPPackage;

public class LibToBibCSP extends IntegratorTest {
	
	// EPackage sourcePackage, EPackage corrPackage, EPackage targetPackage
	public LibToBibCSP() {
		super(LibraryLanguageCSPPackage.eINSTANCE,
				LibraryToBibliographyIntegrationCSPPackage.eINSTANCE,
				BibliographyLanguageCSPPackage.eINSTANCE);
	}

	@Test
	public void testNotConstraint() {
		integrate("LibraryNotConstraint_FWD");
	}

	@Test
	public void testNegativeValueLiteral() {
		integrate("TestNegativeValueLiteral_BWD");
	}
}

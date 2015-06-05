package backend.languages.csp;


import org.junit.Test;

import org.moflon.testframework.tgg.IntegratorTest;

import BibliographyLanguageCSP.BibliographyLanguageCSPPackage;
import LibraryLanguageCSP.LibraryLanguageCSPPackage;
import LibraryToBibliographyIntegrationCSP.LibraryToBibliographyIntegrationCSPPackage;

public class TestNotConstraint extends IntegratorTest {
	
	// EPackage sourcePackage, EPackage corrPackage, EPackage targetPackage
	public TestNotConstraint() {
		super(LibraryLanguageCSPPackage.eINSTANCE,
				LibraryToBibliographyIntegrationCSPPackage.eINSTANCE,
				BibliographyLanguageCSPPackage.eINSTANCE);
	}

	@Test
	public void testNotConstraint() {
		integrate("LibraryNotConstraint_FWD");
	}

}

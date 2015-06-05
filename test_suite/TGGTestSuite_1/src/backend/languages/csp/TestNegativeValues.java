package backend.languages.csp;


import org.junit.Test;

import org.moflon.testframework.tgg.IntegratorTest;

import BibliographyLanguageCSP.BibliographyLanguageCSPPackage;
import LibraryLanguageCSP.LibraryLanguageCSPPackage;
import LibraryToBibliographyIntegrationCSP.LibraryToBibliographyIntegrationCSPPackage;

public class TestNegativeValues extends IntegratorTest {
	
	// EPackage sourcePackage, EPackage corrPackage, EPackage targetPackage
	public TestNegativeValues() {
		super(LibraryLanguageCSPPackage.eINSTANCE,
				LibraryToBibliographyIntegrationCSPPackage.eINSTANCE,
				BibliographyLanguageCSPPackage.eINSTANCE);
	}

	@Test
	public void testNegativeValueLiteral() {
		integrate("TestNegativeValueLiteral_BWD");
	}

}

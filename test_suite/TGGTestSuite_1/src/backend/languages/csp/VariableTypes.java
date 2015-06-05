package backend.languages.csp;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import BibliographyLanguageCSP.BibliographyLanguageCSPPackage;
import LibraryLanguageCSP.LibraryLanguageCSPPackage;
import LibraryToBibliographyIntegrationCSP.LibraryToBibliographyIntegrationCSPPackage;


public class VariableTypes extends IntegratorTest  {

	public VariableTypes() {
		super(LibraryLanguageCSPPackage.eINSTANCE,
				LibraryToBibliographyIntegrationCSPPackage.eINSTANCE,
				BibliographyLanguageCSPPackage.eINSTANCE);
	}
	
	@Test
	public void testChangedLibraryConstraint() {
		integrate("TestNegativeValueLiteral_BWD");
	}

	
	@Test 
	public void testConstraintWithLiteral() {
		integrate("TestNegativeValueLiteral_BWD");
	}
}

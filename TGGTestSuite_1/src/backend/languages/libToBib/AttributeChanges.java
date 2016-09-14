package backend.languages.libToBib;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;
import org.moflon.tgg.language.algorithm.ApplicationTypes;

import BibliographyLanguage.Bibliography;
import BibliographyLanguage.BibliographyLanguagePackage;
import BibliographyLanguage.Researcher;
import LibraryLanguage.LibraryLanguagePackage;
import LibraryToBibliographyIntegration.LibraryToBibliographyIntegrationPackage;

public class AttributeChanges extends IncrementalIntegratorTest {
	public AttributeChanges() {
		super(LibraryLanguagePackage.eINSTANCE,
				LibraryToBibliographyIntegrationPackage.eINSTANCE,
				BibliographyLanguagePackage.eINSTANCE);
	}

	@Test
	public void testFixWithChanges1() throws InterruptedException {
		String testCaseName = "testFixWithChanges1";
		setInputModel(ApplicationTypes.FORWARD, testCaseName);

		helper.integrateForward();
		helper.setChangeTrg(root -> {
			Bibliography bibl = Bibliography.class.cast(root);
			bibl.setName("NewES");
		});
		helper.integrateBackward(); 
		
		saveOutput(testCaseName);
		compareWithExpected(testCaseName, ApplicationTypes.BACKWARD, helper.getSrc());
	}
	
	@Test
	public void testFixWithChanges2() throws InterruptedException {
		String testCaseName = "testFixWithChanges2";
		setInputModel(ApplicationTypes.FORWARD, testCaseName);

		helper.integrateForward();
		helper.setChangeTrg(root -> {
			Bibliography bibl = Bibliography.class.cast(root);
			bibl.setName("NewES");
		});
		helper.integrateBackward(); 
		
		saveOutput(testCaseName);
		compareWithExpected(testCaseName, ApplicationTypes.BACKWARD, helper.getSrc());
	}

	@Test
	public void testFixWithChanges3() throws InterruptedException {
		String testCaseName = "testFixWithChanges3";
		setInputModel(ApplicationTypes.FORWARD, testCaseName);

		helper.integrateForward();
		helper.setChangeTrg(root -> {
			Bibliography bibl = Bibliography.class.cast(root);
			Researcher tony = bibl.getResearcher().stream().filter(r ->  r.getName().equals("tony")).findAny().get();
			tony.getPublication().get(0).setCitation("different");
		});
		helper.integrateBackward(); 
		
		saveOutput(testCaseName);
		compareWithExpected(testCaseName, ApplicationTypes.BACKWARD, helper.getSrc());
	}

	
	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		TreeComparator.compare(
				(new ModelToTreeConverter()).modelToTree(created, false),
				(new ModelToTreeConverter()).modelToTree(expected, false));

	}
}

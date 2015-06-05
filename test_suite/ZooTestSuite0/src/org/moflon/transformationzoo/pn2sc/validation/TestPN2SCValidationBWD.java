package org.moflon.transformationzoo.pn2sc.validation;


import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.File;
import PetriNetLanguage.PetriNetLanguagePackage;
import PetriNetToStatechartIntegration.PetriNetToStatechartIntegrationPackage;
import StatechartLanguage.StatechartLanguagePackage;


public class TestPN2SCValidationBWD extends IntegratorTest {
	
	// EPackage sourcePackage, EPackage corrPackage, EPackage targetPackage
	public TestPN2SCValidationBWD() {
		super(PetriNetLanguagePackage.eINSTANCE,
				PetriNetToStatechartIntegrationPackage.eINSTANCE,
				StatechartLanguagePackage.eINSTANCE);
	}
	
	@Test
	public void testBackwardTestcase1() {
		integrate("testcase1_BWD");
	}
	@Test
	public void testBackwardTestcase2() {
		integrate("testcase2_BWD");
	}
	@Test
	public void testBackwardTestcase3() {
		integrate("testcase3_BWD");
	}
	@Test
	public void testBackwardTestcase4() {
		integrate("testcase4_BWD");
	}
	@Test
	public void testBackwardTestcase5() {
		integrate("testcase5_BWD");
	}
	@Test
	public void testBackwardTestcase6() {
		integrate("testcase6_BWD");
	}
	@Test
	public void testBackwardTestcase7() {
		integrate("testcase7_BWD");
	}
	@Test
	public void testBackwardTestcase8() {
		integrate("testcase8_BWD");
	}

	@Test
	public void testBackwardTestcase9() {
		integrate("testcase9_BWD");
	}
	@Test
	public void testBackwardTestcase10() {
		integrate("testcase10_BWD");
	}
	@Test
	public void testBackwardTestcase11() {
		integrate("testcase11_BWD");
	}
	
	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		File expFile = new ModelToTreeConverter().modelToTree(expected, false);
		File createdFile = new ModelToTreeConverter().modelToTree(created, false);
		TreeComparator.compare(expFile, createdFile);
	}
	
}

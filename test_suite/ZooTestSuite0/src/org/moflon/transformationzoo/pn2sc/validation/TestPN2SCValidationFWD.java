package org.moflon.transformationzoo.pn2sc.validation;


import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.File;
import PetriNetLanguage.PetriNetLanguagePackage;
import PetriNetToStatechartIntegration.PetriNetToStatechartIntegrationPackage;
import StatechartLanguage.Statechart;
import StatechartLanguage.StatechartLanguagePackage;


public class TestPN2SCValidationFWD extends IntegratorTest {
	
	// EPackage sourcePackage, EPackage corrPackage, EPackage targetPackage
	public TestPN2SCValidationFWD() {
		super(PetriNetLanguagePackage.eINSTANCE,
				PetriNetToStatechartIntegrationPackage.eINSTANCE,
				StatechartLanguagePackage.eINSTANCE);
	}
	
	@Test
	public void testForwardTestcase1() {
		integrate("testcase1_FWD");
	}
	
	@Test
	public void testForwardTestcase2() {
		integrate("testcase2_FWD");
	}
	@Test
	public void testForwardTestcase3() {
		integrate("testcase3_FWD");
	}
	@Test
	public void testForwardTestcase4() {
		integrate("testcase4_FWD");
	}
	@Test
	public void testForwardTestcase5() {
		integrate("testcase5_FWD");
	}
	@Test
	public void testForwardTestcase6() {
		integrate("testcase6_FWD");
	}
	
	@Test
	public void testForwardTestcase7() {
		integrate("testcase7_FWD");
	}
	
	@Test
	public void testForwardTestcase8() {
		integrate("testcase8_FWD");
	}
	@Test
	public void testForwardTestcase9() {
		integrate("testcase9_FWD");
	}
	@Test
	public void testForwardTestcase10() {
		integrate("testcase10_FWD");
	}
	
	@Test	
	public void testForwardTestcase11() {
		integrate("testcase11_FWD");
	}
	
	@Override
	public void postProcessing(EObject created){
		Statechart st = (Statechart) created;
		Boolean reduction = true;
		st.initiateBasics();
		
		while(reduction) {
			reduction = false;
			st.applyOrRule();
			reduction |= st.extendAndRule();
			reduction |= st.applyAndRule();
		}
		System.out.println(st.wrapUp());
	}
	
	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		File expFile = new ModelToTreeConverter().modelToTree(expected, false);
		File createdFile = new ModelToTreeConverter().modelToTree(created, false);
		TreeComparator.compare(expFile, createdFile);
	}
}

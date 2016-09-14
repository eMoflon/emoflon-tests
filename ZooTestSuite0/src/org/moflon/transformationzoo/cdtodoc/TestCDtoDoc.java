package org.moflon.transformationzoo.cdtodoc;


import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import ClassDiagramLanguage.ClassDiagramLanguagePackage;
import ClassDiagramToDocumentationIntegration.ClassDiagramToDocumentationIntegrationPackage;
import DocumentationLanguage.DocumentationLanguagePackage;


public class TestCDtoDoc extends IntegratorTest {
	
	// EPackage sourcePackage, EPackage corrPackage, EPackage targetPackage
	public TestCDtoDoc() {
		super(ClassDiagramLanguagePackage.eINSTANCE,
				ClassDiagramToDocumentationIntegrationPackage.eINSTANCE,
				DocumentationLanguagePackage.eINSTANCE);
	}
	
	@Test 
	public void testCD1_FWD() {
		integrate("CD1_FWD");
	}
	
	@Test 
	public void testCD2_FWD() {
		integrate("CD2_FWD");
	}
	
	@Test 
	public void testCD3_FWD() {
		integrate("CD3_FWD");
	}
	
	@Test 
	public void testCD4_FWD() {
		integrate("CD4_FWD");
	}
	
	@Test 
	public void testCD5_FWD() {
		integrate("CD5_FWD");
	}
	
	@Test 
	public void testCD1_BWD() {
		integrate("CD1_BWD");
	}
	
	@Test 
	public void testCD2_BWD() {
		integrate("CD2_BWD");
	}
	
	@Test 
	public void testCD3_BWD() {
		integrate("CD3_BWD");
	}
	
	@Test 
	public void testCD4_BWD() {
		integrate("CD4_BWD");
	}
	
	@Test 
	public void testCD5_BWD() {
		integrate("CD5_BWD");
	}
}


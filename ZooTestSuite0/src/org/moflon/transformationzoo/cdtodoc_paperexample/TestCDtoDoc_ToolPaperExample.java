package org.moflon.transformationzoo.cdtodoc_paperexample;


import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import CDtoDocTGG.CDtoDocTGGPackage;
import ClassDiagramModel.ClassDiagramModelPackage;
import DocumentModel.DocumentModelPackage;
import MocaTree.File;


public class TestCDtoDoc_ToolPaperExample extends IntegratorTest {
	
	// EPackage sourcePackage, EPackage corrPackage, EPackage targetPackage
	public TestCDtoDoc_ToolPaperExample() {
		super(ClassDiagramModelPackage.eINSTANCE,
				CDtoDocTGGPackage.eINSTANCE,
				DocumentModelPackage.eINSTANCE);
	}
	
	@Test 
	public void PaperExample_FWD() {
		integrate("PaperExample_FWD");
	}
	

	@Test 
	public void antlr_FWD() {
		integrate("antlr_FWD");
	}

	
	@Test 
	public void PaperExample_BWD() {
		integrate("PaperExample_BWD");
	}

	
	@Test 
	public void antlr_BWD() {
		integrate("antlr_BWD");
	}

	
	@Override
	public void compare(EObject expected, EObject created) throws InterruptedException {
		File expFile = new ModelToTreeConverter().modelToTree(expected, false);
		File createdFile = new ModelToTreeConverter().modelToTree(created, false);
		TreeComparator.compare(createdFile, expFile);
	}
	
}


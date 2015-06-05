package org.moflon.transformationzoo.osm;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.File;
import MocaTree.MocaTreePackage;
import OSMLanguage.OSMLanguagePackage;
import OSMLanguage.impl.OSMapContainerImpl;
import OSMTGG.OSMTGGPackage;

public class TestOSMGenerateSimpleGraph extends IntegratorTest{
	
	public TestOSMGenerateSimpleGraph() {
		super(OSMLanguagePackage.eINSTANCE, OSMTGGPackage.eINSTANCE ,MocaTreePackage.eINSTANCE);
	}
	
	@Override
	public void postProcessing(EObject created) {
		if(created instanceof OSMapContainerImpl)
			((OSMapContainerImpl) created).getOsmap().get(0).generateSimpleStreetGraph();
	}
	
	
	@Test
	public void testGenerateSimpleGraphOneWay_BWD() {
		integrate("generateSimpleGraphOneWay_BWD");
	}
	
	
	@Test
	public void testGenerateSimpleGraph_BWD() {
		integrate("generateSimpleGraph_BWD");
	}

	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		File expFile = new ModelToTreeConverter().modelToTree(expected, false);
		File createdFile = new ModelToTreeConverter().modelToTree(created, false);
		TreeComparator.compare(expFile, createdFile);
	}
}

package org.moflon.transformationzoo.osm;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.File;
import MocaTree.MocaTreePackage;
import OSMLanguage.OSMLanguagePackage;
import OSMTGG.OSMTGGPackage;


public class TestOSMTransformation extends IntegratorTest {

	public TestOSMTransformation() {
		super(OSMLanguagePackage.eINSTANCE, OSMTGGPackage.eINSTANCE ,MocaTreePackage.eINSTANCE);
	}
	
	@Test
	public void testFileToOSMap_FWD() {
		integrate("single_osmap_FWD");
	}
	
	@Test
	public void testFileToOSMap_BWD() {
		integrate("single_osmap_BWD");
	}
	
	@Test
	public void testNodeToOSMNode_FWD() 
	{
		integrate("single_node_FWD");
	}
	
	@Test 
	public void testNodeToOSMNode_BWD() 
	{
		integrate("single_node_BWD");
	}
	
	@Test
	public void testNodeToOSMWay_FWD()
	{
		integrate("single_way_FWD");
	}
	
	@Test
	public void testNodeToOSMWay_BWD()
	{
		integrate("single_way_BWD");
	}
	
	@Test
	public void testNodeToOSMRelation_FWD() 
	{
		integrate("single_relation_FWD");
	}
	
	@Test
	public void testNodeToOSMRelation_BWD() 
	{
		integrate("single_relation_BWD");
	}

	@Test
	public void testMocaTreetoComplexOSMModel_FWD() {
		integrate("complexMap_FWD");
	}
	
	@Test
	public void testMocaTreetoComplexOSMModel_BWD() {
		integrate("complexMap_BWD");
	}
	
	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		File expFile = new ModelToTreeConverter().modelToTree(expected, false);
		File createdFile = new ModelToTreeConverter().modelToTree(created, false);
		TreeComparator.compare(expFile, createdFile);
	}
}

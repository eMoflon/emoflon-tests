package org.moflon.transformationzoo.soko;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import MocaTree.MocaTreePackage;
import SokobanImportExport.SokobanImportExportPackage;
import SokobanLanguage.SokobanLanguagePackage;


public class SokobanTest extends IntegratorTest {
	public SokobanTest() {
		super(MocaTreePackage.eINSTANCE, SokobanImportExportPackage.eINSTANCE, SokobanLanguagePackage.eINSTANCE);
	}
	
	@Test
	public void test0_FWD() {
		integrate("test0_FWD");
	}
	
	@Test
	public void test0_BWD() {
		integrate("test0_BWD");
	}
}

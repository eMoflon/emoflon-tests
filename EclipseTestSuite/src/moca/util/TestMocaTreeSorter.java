package moca.util;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Assert;
import org.junit.Test;
import org.moflon.core.utilities.EmfCompareUtil;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.moca.MocaTreeSorter;

import MocaTree.File;
import MocaTree.MocaTreePackage;

public class TestMocaTreeSorter {

	public void test(String name) throws IOException, InterruptedException {
		MocaTreePackage.eINSTANCE.getClass();
		ResourceSet rs = eMoflonEMFUtil.createDefaultResourceSet();
		Resource res = rs.getResource(
				eMoflonEMFUtil.createFileURI("./resources/mocaUtilTestData/in/" + name + ".xmi", true), true);
		File file = (File) res.getContents().get(0);

		MocaTreeSorter.sort(file);
		eMoflonEMFUtil.saveModel(eMoflonEMFUtil.createDefaultResourceSet(), file,
				"./resources/mocaUtilTestData/out/" + name + ".xmi");
		File expected = (File) rs.getResource(
				eMoflonEMFUtil.createFileURI("./resources/mocaUtilTestData/expected/" + name + ".xmi", true), true)
				.getContents().get(0);

		Assert.assertEquals(0, EmfCompareUtil.compareAndFilter(file, expected, true).size());
	}

	@Test
	public void testNodeIndices() throws IOException, InterruptedException {
		test("Indices");
	}

	@Test
	public void testIntervals() throws IOException, InterruptedException {
		test("Intervals");
	}

}

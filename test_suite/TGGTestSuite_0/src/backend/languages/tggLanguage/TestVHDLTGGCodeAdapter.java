package backend.languages.tggLanguage;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.MocaTreePackage;
import VHDLModel.VHDLModelPackage;
import VHDLTGGCodeAdapter.VHDLTGGCodeAdapterPackage;

public class TestVHDLTGGCodeAdapter extends IntegratorTest {

	public TestVHDLTGGCodeAdapter() {
		super(MocaTreePackage.eINSTANCE, VHDLTGGCodeAdapterPackage.eINSTANCE,
				VHDLModelPackage.eINSTANCE);
	}

	@Test
	public void testEntity2CompositeBlock_BWD() {
		integrate("Entity2CompositeBlock_BWD");
	}

	@Test
	public void testEntity2CompositeBlock_FWD() {
		integrate("Entity2CompositeBlock_FWD");
	}

	@Test
	public void testFile2VHDLSpec_BWD() {
		integrate("File2VHDLSpec_BWD");
	}

	@Test
	public void testFile2VHDLSpec_FWD() {
		integrate("File2VHDLSpec_FWD");
	}

	@Test
	public void testHandleInPort_BWD() {
		integrate("HandleInPort_BWD");
	}

	@Test
	public void testHandleInPort_FWD() {
		integrate("HandleInPort_FWD");
	}

	@Test
	public void testHandleOutPort_BWD() {
		integrate("HandleOutPort_BWD");
	}

	@Test
	public void testHandleOutPort_FWD() {
		integrate("HandleOutPort_FWD");
	}

	@Test
	public void testNotGate_BWD() {
		integrate("NotGate_BWD");
	}

	@Test
	public void testNotGate_FWD() {
		integrate("NotGate_FWD");
	}

	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		if (created instanceof MocaTree.File) {
			TreeComparator.compare((MocaTree.File) created,
					(MocaTree.File) expected);
		} else {
			super.compare(expected, created);
		}
	}
}

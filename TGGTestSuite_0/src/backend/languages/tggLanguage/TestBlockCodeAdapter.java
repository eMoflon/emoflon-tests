package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import BlockCodeAdapter.BlockCodeAdapterPackage;
import BlockLanguage.BlockLanguagePackage;
import MocaTree.MocaTreePackage;


public class TestBlockCodeAdapter extends IntegratorTest {

	public TestBlockCodeAdapter() {
		super(MocaTreePackage.eINSTANCE,
				BlockCodeAdapterPackage.eINSTANCE,
				BlockLanguagePackage.eINSTANCE);
	}

	@Test
	public void testSpec_FWD() {
		integrate("Spec_FWD");
	}
	
	@Test
	public void testSpec_BWD() {
		integrate("Spec_BWD");
	}
	
	@Test
	public void testBlock_FWD() {
		integrate("Block_FWD");
	}
	
	@Test
	public void testBlock_BWD() {
		integrate("Block_BWD");
	}
	
	@Test
	public void testPort_FWD() {
		integrate("Port_FWD");
	}
	
	@Test
	public void testPort_BWD() {
		integrate("Port_BWD");
	}
	
	@Test
	public void testWire_FWD() {
		integrate("Wire_FWD");
	}
	
	@Test
	public void testWire_BWD() {
		integrate("Wire_BWD");
	}
	
	@Test
	public void testWireCloseLoop_FWD() {
		integrate("WireCloseLoop_FWD");
	}
	
	@Test
	public void testWireCloseLoop_BWD() {
		integrate("WireCloseLoop_BWD");
	}
	


}

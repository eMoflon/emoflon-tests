package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import CD.CDPackage;
import CDDSWithNACs.CDDSWithNACsPackage;
import DS.DSPackage;


public class TestCDDSWithNACs extends IntegratorTest {

	public TestCDDSWithNACs() {
		super(CDPackage.eINSTANCE, CDDSWithNACsPackage.eINSTANCE,
				DSPackage.eINSTANCE);
	}

	@Test
	public void testAttr2Column_FWD() {
		integrate("Attr2Column_FWD");
	}

	@Test
	public void testAttr2Column_BWD() {
		integrate("Attr2Column_BWD");
	}

	@Test
	public void testAssoc2ForeignKey_BWD() {
		integrate("Assoc2ForeignKey_BWD");
	}

	@Test
	public void testInheritance2ForeignKey_FWD() {
		integrate("Inheritance2ForeignKey_FWD");
	}

	@Test
	public void testInheritance2ForeignKey_BWD() {
		integrate("Inheritance2ForeignKey_BWD");
	}
	
}

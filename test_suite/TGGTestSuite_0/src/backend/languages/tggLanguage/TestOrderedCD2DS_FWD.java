package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import CDWithOrderedAttrs.CDWithOrderedAttrsPackage;
import DSWithOrderedCols.DSWithOrderedColsPackage;
import OrderedCD2DS.OrderedCD2DSPackage;


public class TestOrderedCD2DS_FWD extends IntegratorTest {

	public TestOrderedCD2DS_FWD() {
		super(CDWithOrderedAttrsPackage.eINSTANCE,
				OrderedCD2DSPackage.eINSTANCE,
				DSWithOrderedColsPackage.eINSTANCE);
	}


	@Test
	public void testClass2Table_FWD() {
		integrate("Class2Table_FWD");
	}
	
	@Test
	public void testSubClass2Table_FWD() {
		integrate("SubClass2Table_FWD");
	}
	




}

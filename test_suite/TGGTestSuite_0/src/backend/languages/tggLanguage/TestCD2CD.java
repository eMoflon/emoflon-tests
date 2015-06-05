package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import CD.CDPackage;
import CDToCDIntegration.CDToCDIntegrationPackage;


public class TestCD2CD extends IntegratorTest {
	
	public TestCD2CD()
	{
		super(CDPackage.eINSTANCE, CDToCDIntegrationPackage.eINSTANCE, CDPackage.eINSTANCE);
	}
	

	
	@Test
	public void testCD2CD_FWD()
	{
		integrate("CD2CD_FWD");
	}
	
	@Test
	public void testCD2CD_BWD()
	{
		integrate("CD2CD_BWD");
	}
	

}

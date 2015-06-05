package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import BxSurveyClassDiagram.BxSurveyClassDiagramPackage;
import BxSurveyClassDiagramToRDBMSIntegration.BxSurveyClassDiagramToRDBMSIntegrationPackage;
import BxSurveyDatabase.BxSurveyDatabasePackage;



public class TestBXSurveyCDtoDS extends IntegratorTest {

	public TestBXSurveyCDtoDS() {
		super(BxSurveyClassDiagramPackage.eINSTANCE, BxSurveyClassDiagramToRDBMSIntegrationPackage.eINSTANCE,
				BxSurveyDatabasePackage.eINSTANCE);
	}

	@Test
	public void testBx1_FWD() {
		integrate("Bx1_FWD");
	}

	@Test
	public void testBx2_FWD() {
		integrate("Bx2_FWD");
	}
	
	@Test
	public void testBx1_BWD() {
		integrate("Bx1_BWD");
	}
	
	@Test
	public void testBx2_BWD() {
		integrate("Bx2_BWD");
	}

	
}

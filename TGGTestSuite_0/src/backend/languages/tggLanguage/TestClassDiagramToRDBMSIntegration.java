package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import ClassDiagramLanguage.ClassDiagramLanguagePackage;
import ClassDiagramToRDBMSIntegration.ClassDiagramToRDBMSIntegrationPackage;
import DatabaseLanguage.DatabaseLanguagePackage;


public class TestClassDiagramToRDBMSIntegration extends IntegratorTest {

	public TestClassDiagramToRDBMSIntegration() {
		super(ClassDiagramLanguagePackage.eINSTANCE,
				ClassDiagramToRDBMSIntegrationPackage.eINSTANCE,
				DatabaseLanguagePackage.eINSTANCE);
	}
	
	
	@Test
	public void testCD_FWD() {
		integrate("CD_FWD");
	}
	
	@Test
	public void testSchema_BWD() {
		integrate("Schema_BWD");
	}
	
	@Test
	public void testClazz_FWD() {
		integrate("Clazz_FWD");
	}
	
	@Test
	public void testTable_BWD() {
		integrate("Table_BWD");
	}
	
	@Test
	public void testAssoc_FWD() {
		integrate("Assoc_FWD");
	}
	
	@Test
	public void testColumn_BWD() {
		integrate("Column_BWD");
	}
	
	@Test
	public void testSelfAssoc_FWD() {
		integrate("SelfAssoc_FWD");
	}
	
	@Test
	public void testSelfColumn_BWD() {
		integrate("SelfColumn_BWD");
	}
	

}

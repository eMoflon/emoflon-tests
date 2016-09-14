package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import CompanyLanguage.CompanyLanguagePackage;
import CompanyToITIntegration.CompanyToITIntegrationPackage;
import ITLanguage.ITLanguagePackage;


public class TestCompanyToITIntegration extends IntegratorTest {

	public TestCompanyToITIntegration() {
		super(CompanyLanguagePackage.eINSTANCE,
				CompanyToITIntegrationPackage.eINSTANCE,
				ITLanguagePackage.eINSTANCE);
		setConfigurator(new StaticConfigurator());
	}

	@Test
	public void testCompany_FWD() {
		integrate("Company_FWD");
	}

	@Test
	public void testCompany_BWD() {
		integrate("Company_BWD");
	}

	@Test
	public void testAdmin_FWD() {
		integrate("Admin_FWD");
	}

	@Test
	public void testAdmin_BWD() {
		integrate("Admin_BWD");
	}

	@Test
	public void testEmployee_Laptop_FWD() {
	   integrate("Employee_Laptop_FWD");
	}

	@Test
	public void testEmployee_Laptop_BWD() {
		integrate("Employee_Laptop_BWD");
	}
	
	@Test
	public void testEmployee_PC_FWD() {
		integrate("Employee_PC_FWD");
	}

	@Test
	public void testEmployee_PC_BWD() {
		integrate("Employee_PC_BWD");
	}
	
	@Test
	public void testEmployee_PC_Laptop_FWD() {
		integrate("Employee_PC_Laptop_FWD");
	}

}

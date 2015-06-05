package backend.languages.productrequirementsToSimulinkproject;

import org.junit.Ignore;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import ProductRequirementsLanguage.ProductRequirementsLanguagePackage;
import ProductrequirementsToSimulinkprojectIntegration.ProductrequirementsToSimulinkprojectIntegrationPackage;
import SimulinkProjectLanguage.SimulinkProjectLanguagePackage;


public class RuleTests extends IntegratorTest{
	
	public RuleTests() {
		super(ProductRequirementsLanguagePackage.eINSTANCE, 
			  ProductrequirementsToSimulinkprojectIntegrationPackage.eINSTANCE, 
			  SimulinkProjectLanguagePackage.eINSTANCE);
	}

	@Test
	public void productAndFunctionality2ProjectRule_FWD(){
		integrate("productAndFunctionality2ProjectRule_FWD");
	}
	
	@Test
	public void productAndFunctionality2ProjectRule_BWD(){
		integrate("productAndFunctionality2ProjectRule_BWD");
	}
	
	@Test
	public void functionality2SubsystemSimple_FWD(){
		integrate("functionality2SubsystemSimple_FWD");
	}
	
	@Test
	public void functionality2SubsystemSimple_BWD(){
		integrate("functionality2SubsystemSimple_BWD");
	}
	
	@Test
	public void ruleRequirement2FunctionBlock_FWD(){
		integrate("ruleRequirement2FunctionBlock_FWD");
	}
	
	@Test
	public void ruleRequirement2FunctionBlock_BWD(){
		integrate("ruleRequirement2FunctionBlock_BWD");
	}
	
	@Test
	@Ignore
	public void newRequirement2FunctionBlock_FWD(){
		integrate("newRequirement2FunctionBlock_FWD");
	}
	
	@Test
	@Ignore
	public void requirement2NewFunctionBlock_BWD(){
		integrate("requirement2NewFunctionBlock_BWD");
	}

}

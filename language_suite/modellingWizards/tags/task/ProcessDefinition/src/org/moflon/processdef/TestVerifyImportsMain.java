package org.moflon.processdef;

import org.apache.log4j.BasicConfigurator;
import org.moflon.util.eMoflonEMFUtil;

import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition.SystemModule;

public class TestVerifyImportsMain {

	/**
	 * A test of the verify imports exercise
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();

		SystemModule system = (SystemModule) eMoflonEMFUtil.loadModel(ProcessDefinitionPackage.eINSTANCE, "instances/processDefModuleWithMissingImport.xmi", null);

		//system.verifyImports();

	}
		

}

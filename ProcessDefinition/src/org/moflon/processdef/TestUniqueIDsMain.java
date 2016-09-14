package org.moflon.processdef;

import org.apache.log4j.BasicConfigurator;
import org.moflon.util.eMoflonEMFUtil;

import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition.SystemModule;

public class TestUniqueIDsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();

		SystemModule system = (SystemModule) eMoflonEMFUtil.loadAndInitModel(ProcessDefinitionPackage.eINSTANCE, "instances/processDefModuleWithConflictingIDs.xmi");

		system.ensureUniqueIDs();

	}

}

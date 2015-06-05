package org.moflon.processdef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.BasicConfigurator;
import org.moflon.util.eMoflonEMFUtil;

import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition.SystemModule;

public class Main {
	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		
		SystemModule system = (SystemModule) eMoflonEMFUtil.loadAndInitModel(ProcessDefinitionPackage.eINSTANCE, "instances/processDefModule.xmi");
		
		System.out.print("Enter ID of Task to run: ");
		String taskToSimulate = new BufferedReader(new InputStreamReader(System.in)).readLine();
		
		system.runSimulation(taskToSimulate);
	}
}

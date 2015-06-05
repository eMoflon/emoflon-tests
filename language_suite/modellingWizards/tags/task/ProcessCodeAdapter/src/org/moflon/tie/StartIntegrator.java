package org.moflon.tie;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.EPackage;
import org.moflon.integrator.IntegratorApp;
import ProcessCodeAdapter.ProcessCodeAdapterPackage;
import ProcessDefinition.ProcessDefinitionPackage;


public class StartIntegrator {

    public static void main(String[] args) throws Exception {

         // Set up logging
         BasicConfigurator.configure();

         // Register projects

         //Register ProcessCodeAdapter
         EPackage packageProcessCodeAdapter = ProcessCodeAdapterPackage.eINSTANCE;
         packageProcessCodeAdapter.getName();

         //Register ProcessDefinition
         EPackage packageProcessDefinition = ProcessDefinitionPackage.eINSTANCE;
         packageProcessDefinition.getName();
     
         // Start integrator
         IntegratorApp.startIntegrator(args);

    }

}
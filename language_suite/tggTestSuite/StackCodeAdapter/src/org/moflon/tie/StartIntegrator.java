package org.moflon.tie;

import org.apache.log4j.BasicConfigurator;
import org.moflon.integrator.IntegratorApp;

import LIFOStack.LIFOStackPackage;
import MocaTree.MocaTreePackage;
import StackCodeAdapter.StackCodeAdapterPackage;


public class StartIntegrator {
    public static void main(String[] args) throws Exception
      {
         // Set up logging
         BasicConfigurator.configure();

         // Register projects
         MocaTreePackage.eINSTANCE.getName();
         LIFOStackPackage.eINSTANCE.getName();
         StackCodeAdapterPackage.eINSTANCE.getName();
         
         // Start integrator
         IntegratorApp.startIntegrator(args);
      }
}

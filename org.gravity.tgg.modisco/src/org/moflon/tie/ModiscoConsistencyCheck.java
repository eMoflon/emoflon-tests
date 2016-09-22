package org.moflon.tie;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;


import org.gravity.tgg.modisco.ModiscoPackage;


public class ModiscoConsistencyCheck extends SynchronizationHelper{

   public ModiscoConsistencyCheck()
   {
      super(ModiscoPackage.eINSTANCE, ".");
   }
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Consistency Check
        ModiscoConsistencyCheck helper = new ModiscoConsistencyCheck();
        helper.loadSrc("instances/src.xmi");
		helper.loadTrg("instances/trg.xmi");
		helper.createCorrespondences();
		helper.saveCorr("instances/corr.xmi");
		helper.saveConsistencyCheckProtocol("instances/protocol.xmi");
	}
}
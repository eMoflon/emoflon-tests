package FamiliesToPersonsCodeAdapter.org.moflon.tie;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;


import FamiliesToPersonsCodeAdapter.FamiliesToPersonsCodeAdapterPackage;


public class FamiliesToPersonsCodeAdapterConsistencyCheck extends SynchronizationHelper{

   public FamiliesToPersonsCodeAdapterConsistencyCheck()
   {
      super(FamiliesToPersonsCodeAdapterPackage.eINSTANCE, ".");
   }
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();
        
        FamiliesToPersonsCodeAdapterConsistencyCheck helper = new FamiliesToPersonsCodeAdapterConsistencyCheck();
        helper.loadSrc("instances/src.xmi");
		helper.loadTrg("instances/trg.xmi");

		boolean prepareDeltas = true;
		helper.createCorrespondences(prepareDeltas);
		
		if(prepareDeltas){
			//src and trg models are modified when preparing deltas.
			//save all files in a separate location
			helper.saveSrc("instances/cc_result/src.xmi");
			helper.saveTrg("instances/cc_result/trg.xmi");
			helper.saveCorr("instances/cc_result/corr.xmi");
			helper.saveConsistencyCheckProtocol("instances/cc_result/protocol.xmi");
			helper.saveInconsistentSourceDelta("instances/cc_result/src.delta.xmi");
			helper.saveInconsistentTargetDelta("instances/cc_result/trg.delta.xmi");
		}
		else{
			//src and trg models are not modified.
			//save correspondence model and protocol only
			helper.saveCorr("instances/corr.xmi");
			helper.saveConsistencyCheckProtocol("instances/protocol.xmi");
		}
	}
}
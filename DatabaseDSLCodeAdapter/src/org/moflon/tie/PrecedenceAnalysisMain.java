package org.moflon.tie;

import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;

import DatabaseDSL.DatabaseDSLPackage;
import DatabaseDSLCodeAdapter.DatabaseDSLCodeAdapterPackage;

public class PrecedenceAnalysisMain extends IntegratorHelper {

	public PrecedenceAnalysisMain() throws IOException{
		// Register packages
        eMoflonEMFUtil.init(DatabaseDSLCodeAdapterPackage.eINSTANCE);
        eMoflonEMFUtil.init(DatabaseDSLPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(DatabaseDSLCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static long main(String testFolder) throws IOException {
		
		PrecedenceAnalysisMain helper = new PrecedenceAnalysisMain();
		
//		helper.loadSrc(testFolder + "sourceBatch.xmi");
//		helper.loadTrg(testFolder + "targetBatch.xmi");
//		helper.loadCorr(testFolder + "corrFWD.xmi");
		
		helper.setSrc(MeasurementSocket.socket.get("source"));
		helper.setTrg(MeasurementSocket.socket.get("target"));
		helper.setCorr(MeasurementSocket.socket.get("corr"));
		
		long start = System.currentTimeMillis();
	    helper.integrateForward();
	    long stop = System.currentTimeMillis();
	    
//	    helper.saveCorr(testFolder + "corrFWD.xmi");
//	    
//	    ObjectDeletor.delete(helper.getCorr(), true);
//	    ObjectDeletor.delete(helper.getSrc(), true);
//	    ObjectDeletor.delete(helper.getTrg(), true);
//	    ObjectDeletor.delete(helper.getTranslator(), true);
//	    ObjectDeletor.delete(helper.getProtocol(), true);
//	    
		return stop-start;

	}

}

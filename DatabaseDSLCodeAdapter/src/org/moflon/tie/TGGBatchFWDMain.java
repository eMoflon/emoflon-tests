package org.moflon.tie;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;

import TGGLanguage.algorithm.precedence.AddedNodeDelta;
import DatabaseDSLCodeAdapter.DatabaseDSLCodeAdapterPackage;
import DatabaseDSL.DatabaseDSLPackage;


public class TGGBatchFWDMain extends IntegratorHelper {

	public TGGBatchFWDMain() throws IOException {
		// Register packages
        eMoflonEMFUtil.init(DatabaseDSLCodeAdapterPackage.eINSTANCE);
        eMoflonEMFUtil.init(DatabaseDSLPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(DatabaseDSLCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static long main(String testFolder, boolean incremental) throws IOException {

		// Forward Transformation
        TGGBatchFWDMain helper = new TGGBatchFWDMain();
		
		helper.setSrc(MeasurementSocket.socket.get("source"));
		
		if(incremental){
			helper.setTrg(MeasurementSocket.socket.get("target"));
			helper.setCorr(MeasurementSocket.socket.get("corr"));
			helper.setModelDeltas((AddedNodeDelta) MeasurementSocket.socket.get("delta"), null, null, null);
		}
		
		long start = System.currentTimeMillis();
		helper.integrateForward();
		long stop = System.currentTimeMillis();
			
		helper.saveSrc("source1000.xmi");
		helper.saveTrg("target1000.xmi");
		helper.saveCorr("corr1000.xmi");
		helper.saveProtocol("protocol1000.xmi");
		
		MeasurementSocket.socket.put("target", helper.getTrg());
		MeasurementSocket.socket.put("corr", helper.getCorr());
		
		return stop-start;
	}


}
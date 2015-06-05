package org.moflon.tie;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;
import DatabaseDSLCodeAdapter.DatabaseDSLCodeAdapterPackage;
import DatabaseDSL.DatabaseDSLPackage;


public class TGGMain extends IntegratorHelper {

	public TGGMain() throws IOException {
		// Register packages
        eMoflonEMFUtil.init(DatabaseDSLCodeAdapterPackage.eINSTANCE);
        eMoflonEMFUtil.init(DatabaseDSLPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(DatabaseDSLCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Forward Transformation
        TGGMain helper = new TGGMain();
		helper.performForward("instances/tree.xmi");
		
		// Backward Transformation
//		helper = new TGGMain();
//		helper.performBackward("instances/target.xmi");
	}

	public void performForward(String source) {
		try {
			loadSrc(source);
		} catch (IllegalArgumentException iae) {
			System.err.println("Unable to load " + source + ", " + iae.getMessage());
			return;
		}
		
		integrateForward();
		saveTrg(source + "_FWD.xmi");
		saveCorr("instances/corr_FWD.xmi");
		saveProtocol("instances/protocol_FWD.xmi");
		
		System.out.println("Completed forward transformation!");
	}

	public void performBackward(String target) {
		try {
			loadTrg(target);
		} catch (IllegalArgumentException iae) {
			System.err.println("Unable to load " + target + ", " + iae.getMessage());
			return;
		}
		
		integrateBackward();
		saveSrc(target + "_BWD.xmi");
		saveCorr("instances/corr_BWD.xmi");
		saveProtocol("instances/protocol_BWD.xmi");
		
		System.out.println("Completed backward transformation!");
	}
}
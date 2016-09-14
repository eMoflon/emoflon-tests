package org.moflon.tie;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;
import ABtoCDIntegration.ABtoCDIntegrationPackage;
import ContextElementsCD.ContextElementsCDPackage;
import ContextElementsAB.ContextElementsABPackage;


public class TGGMain extends IntegratorHelper {

	public TGGMain() throws IOException {
		// Register packages
        eMoflonEMFUtil.init(ABtoCDIntegrationPackage.eINSTANCE);
        eMoflonEMFUtil.init(ContextElementsCDPackage.eINSTANCE);
        eMoflonEMFUtil.init(ContextElementsABPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(ABtoCDIntegrationPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Forward Transformation
        TGGMain helper = new TGGMain();
		helper.performForward("instances/source.xmi");
		
		// Backward Transformation
		helper = new TGGMain();
		helper.performBackward("instances/target.xmi");
	}

	public void performForward(String source) {
		loadSrc(source);
		integrateForward();
		saveTrg(source + "_FWD.xmi");
		saveCorr("instances/corr_FWD.xmi");
		saveProtocol("instances/protocol_FWD.xmi");
	} 

	public void performBackward(String target) {
		loadTrg(target);
		integrateBackward();
		saveSrc(target + "_BWD.xmi");
		saveCorr("instances/corr_BWD.xmi");
		saveProtocol("instances/protocol_BWD.xmi");
	}
}
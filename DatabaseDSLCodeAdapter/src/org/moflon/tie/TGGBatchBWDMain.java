package org.moflon.tie;

import java.io.IOException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;

import DatabaseDSL.DatabaseDSLPackage;
import DatabaseDSLCodeAdapter.DatabaseDSLCodeAdapterPackage;
import DatabaseDSLCodeAdapter.validation.DatabaseValidation;

public class TGGBatchBWDMain extends IntegratorHelper {

	public TGGBatchBWDMain() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(DatabaseDSLCodeAdapterPackage.eINSTANCE);
		eMoflonEMFUtil.init(DatabaseDSLPackage.eINSTANCE);

		// Load rules and set correspondence
		setCorrPackage(DatabaseDSLCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}

	/**
	 * @param args
	 */
	public static long main(String testFolder, boolean incremental) throws IOException {
	
		TGGBatchBWDMain helper = new TGGBatchBWDMain();

		// helper.loadTrg(testFolder + "targetBatch.xmi");
		helper.setTrg(MeasurementSocket.socket.get("target"));

		if (incremental) {

			helper.setSrc(MeasurementSocket.socket.get("source"));
			helper.setCorr(MeasurementSocket.socket.get("corr"));
			DatabaseValidation dbV = (DatabaseValidation) MeasurementSocket.socket
					.get("validator");
			helper.setModelDeltas(dbV.getAddednodedelta(), null, null, null);

		}

		long start = System.currentTimeMillis();
		helper.integrateBackward();
		long stop = System.currentTimeMillis();

		// helper.saveSrc(testFolder + "sourceResult.xmi");
		// helper.saveCorr(testFolder + "corrBWD.xmi");
		// helper.saveProtocol(testFolder + "protocolBWD.xmi");

		MeasurementSocket.socket.put("source", helper.getSrc());
		MeasurementSocket.socket.put("corr", helper.getCorr());

		helper.saveSrc("sourceModel.xmi");
		helper.saveTrg("targetModel.xmi");
		helper.saveCorr("corrModel.xmi");
		helper.saveProtocol("protocolModel.xmi");
		
		return stop - start;
	}
}

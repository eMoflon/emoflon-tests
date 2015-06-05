package org.moflon.tie;

import org.moflon.util.eMoflonEMFUtil;

import DatabaseDSL.Database;
import DatabaseDSL.DatabaseDSLPackage;
import DatabaseDSLCodeAdapter.validation.DatabaseValidation;

public class SDMValidationMain {

	/**
	 * @param args
	 */
	public static long main(String testFolder) {
		
		
//		Database db = (Database) eMoflonEMFUtil.loadAndInitModel(DatabaseDSLPackage.eINSTANCE, testFolder + "targetBatch.xmi");
		Database db = (Database) MeasurementSocket.socket.get("target");
		
		DatabaseValidation dbV = DatabaseDSLCodeAdapter.validation.impl.ValidationFactoryImpl.eINSTANCE.createDatabaseValidation();
		
		long start = System.currentTimeMillis();
		
		dbV.validate(db);
		
		long stop = System.currentTimeMillis();

		
//		eMoflonEMFUtil.saveModel(dbV, testFolder + "validator.xmi");
		MeasurementSocket.socket.put("validator", dbV);
		
//		ObjectDeletor.delete(db, true);
//		ObjectDeletor.delete(dbV, true);
		
		return stop-start;

	}

}

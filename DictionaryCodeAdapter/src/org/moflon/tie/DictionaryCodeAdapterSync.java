package org.moflon.tie;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.common.util.URI;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.util.eMoflonEMFUtil;

import DictionaryCodeAdapter.DictionaryCodeAdapterPackage;
import TGGRuntime.CorrespondenceModel;


public class DictionaryCodeAdapterSync extends SynchronizationHelper {

	public DictionaryCodeAdapterSync() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(DictionaryCodeAdapterPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(DictionaryCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Propagate changes made to source
        DictionaryCodeAdapterSync helper = new DictionaryCodeAdapterSync();
		helper.syncForward("instances/fwd.corr.xmi");
		
		// Propagate changes made to target
		helper = new DictionaryCodeAdapterSync();
		helper.syncBackward("instances/fwd.corr.xmi");
	}

	public void syncForward(String corr) {
		setChangeSrc(root -> {});
		loadTriple(corr);
		integrateForward();
		saveResult("fwd");
		
		System.out.println("Completed forward synchronization");
	}
	
	public void syncBackward(String corr) {
		setChangeTrg(root -> {});
		loadTriple(corr);
		integrateBackward();
		saveResult("bwd");
		
		System.out.println("Completed backward synchronization");
	}
	
	private void loadTriple(String corr){ 
		try {
			loadCorr(corr);
			CorrespondenceModel corrModel = (CorrespondenceModel) getCorr();
			setSrc(corrModel.getSource());
			setTrg(corrModel.getTarget());
		} catch (IllegalArgumentException iae) {
			System.err.println("Unable to load input triple for " + corr
					+ ", " + iae.getMessage());
		}
	}
	
	private void saveResult(String direction){ 
		getSrc().eResource().setURI(URI.createFileURI("sync." + direction + ".src.xmi"));
		getTrg().eResource().setURI(URI.createFileURI("sync." + direction + ".trg.xmi"));
		getCorr().eResource().setURI(URI.createFileURI("sync." + direction + ".corr.xmi"));
		
		saveSrc("instances/sync." + direction + ".src.xmi");
		saveTrg("instances/sync." + direction + ".trg.xmi");
		saveCorr("instances/sync." + direction + ".corr.xmi");
		saveSynchronizationProtocol("instances/sync." + direction + ".protocol.xmi");
	}
}
package org.moflon.tie;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.common.util.URI;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.util.eMoflonEMFUtil;

import DictionaryLanguage.DictionaryLanguagePackage;
import LearningBoxLanguage.LearningBoxLanguagePackage;
import LearningBoxToDictionaryIntegration.LearningBoxToDictionaryIntegrationPackage;
import TGGRuntime.CorrespondenceModel;


public class LearningBoxToDictionaryIntegrationSync extends SynchronizationHelper {

	public LearningBoxToDictionaryIntegrationSync() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(LearningBoxToDictionaryIntegrationPackage.eINSTANCE);
		eMoflonEMFUtil.init(DictionaryLanguagePackage.eINSTANCE);
		eMoflonEMFUtil.init(LearningBoxLanguagePackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(LearningBoxToDictionaryIntegrationPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Propagate changes made to source
        LearningBoxToDictionaryIntegrationSync helper = new LearningBoxToDictionaryIntegrationSync();
		helper.syncForward("instances/fwd.corr.xmi");
		
		// Propagate changes made to target
		helper = new LearningBoxToDictionaryIntegrationSync();
		helper.syncBackward("instances/fwd.corr.xmi");
	}

	public void syncForward(String corr) {
		setChangeSrc(root -> {});
		loadTriple(corr);
		loadSynchronizationProtocol("instances/fwd.protocol.xmi");
		integrateForward();
		saveResult("fwd");
		
		System.out.println("Completed forward synchronization");
	}
	
	public void syncBackward(String corr) {
		setChangeTrg(root -> {});
		loadTriple(corr);
		loadSynchronizationProtocol("instances/bwd.protocol.xmi");
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
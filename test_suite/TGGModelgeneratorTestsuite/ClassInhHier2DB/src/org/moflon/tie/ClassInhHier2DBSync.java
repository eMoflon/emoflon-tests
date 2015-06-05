package org.moflon.tie;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.common.util.URI;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.util.eMoflonEMFUtil;

import ClassInhHier2DB.ClassInhHier2DBPackage;
import ClassInheritanceHierarchy.ClassInheritanceHierarchyPackage;
import Database.DatabasePackage;
import TGGRuntime.CorrespondenceModel;


public class ClassInhHier2DBSync extends SynchronizationHelper {

	public ClassInhHier2DBSync() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(ClassInhHier2DBPackage.eINSTANCE);
		eMoflonEMFUtil.init(DatabasePackage.eINSTANCE);
		eMoflonEMFUtil.init(ClassInheritanceHierarchyPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(ClassInhHier2DBPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Propagate changes made to source
        ClassInhHier2DBSync helper = new ClassInhHier2DBSync();
		helper.syncForward("instances/fwd.corr.xmi");
		
		// Propagate changes made to target
		helper = new ClassInhHier2DBSync();
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
package org.moflon.tie;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.util.eMoflonEMFUtil;

import Families.FamiliesPackage;
import FamiliesToPersonsCodeAdapter.FamiliesToPersonsCodeAdapterPackage;
import Persons.PersonsPackage;


public class FamiliesToPersonsCodeAdapterTrafo extends SynchronizationHelper {

	public FamiliesToPersonsCodeAdapterTrafo() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(FamiliesToPersonsCodeAdapterPackage.eINSTANCE);
		eMoflonEMFUtil.init(FamiliesPackage.eINSTANCE);
		eMoflonEMFUtil.init(PersonsPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(FamiliesToPersonsCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}

	public static void main(String[] args) throws IOException {
		// Set up logging
        BasicConfigurator.configure();

		// Forward Transformation
        FamiliesToPersonsCodeAdapterTrafo helper = new FamiliesToPersonsCodeAdapterTrafo();
		helper.performForward("instances/fwd.src.xmi");
		
		// Backward Transformation
		helper = new FamiliesToPersonsCodeAdapterTrafo();
		helper.performBackward("instances/bwd.src.xmi");
	}

	public void performForward(String source) {
		try {
			loadSrc(source);
		} catch (IllegalArgumentException iae) {
			System.err.println("Unable to load " + source + ", " + iae.getMessage());
			return;
		}
		
		integrateForward();
		
		saveTrg("instances/fwd.trg.xmi");
		saveCorr("instances/fwd.corr.xmi");
		saveSynchronizationProtocol("instances/fwd.protocol.xmi");
		
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
		
		saveSrc("instances/bwd.trg.xmi");
		saveCorr("instances/bwd.corr.xmi");
		saveSynchronizationProtocol("instances/bwd.protocol.xmi");
		
		System.out.println("Completed backward transformation!");
	}
}
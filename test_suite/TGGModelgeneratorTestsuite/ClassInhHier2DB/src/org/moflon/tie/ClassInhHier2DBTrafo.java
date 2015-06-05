package org.moflon.tie;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.util.eMoflonEMFUtil;

import ClassInhHier2DB.ClassInhHier2DBPackage;
import ClassInheritanceHierarchy.ClassInheritanceHierarchyPackage;
import Database.DatabasePackage;


public class ClassInhHier2DBTrafo extends SynchronizationHelper {

	public ClassInhHier2DBTrafo() throws IOException {
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

		// Forward Transformation
        ClassInhHier2DBTrafo helper = new ClassInhHier2DBTrafo();
		helper.performForward("instances/fwd.src.xmi");
		
		// Backward Transformation
		helper = new ClassInhHier2DBTrafo();
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
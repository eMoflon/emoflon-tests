package org.moflon.tie;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.moflon.tgg.algorithm.modelgenerator.ModelGenerator;
import org.moflon.tgg.algorithm.modelgenerator.controller.AbstractModelGenerationController;
import org.moflon.tgg.algorithm.modelgenerator.controller.DefaultModelGenController;
import org.moflon.tgg.algorithm.modelgenerator.controller.LimitedRandomRuleSelector;
import org.moflon.tgg.algorithm.modelgenerator.controller.MaxRulePerformCounterController;
import org.moflon.tgg.algorithm.modelgenerator.controller.RandomEObjectSelector;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.util.eMoflonEMFUtil;

import ClassInhHier2DB.ClassInhHier2DBPackage;
import ClassInheritanceHierarchy.ClassInheritanceHierarchyPackage;
import Database.DatabasePackage;

public class ClassInhHier2DBModelGen extends SynchronizationHelper {

	public ClassInhHier2DBModelGen() throws IOException {
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

		AbstractModelGenerationController controller = new DefaultModelGenController();
		controller.getDeadlineControllers().add(
				new MaxRulePerformCounterController(20));
		controller.setRuleSelector(new LimitedRandomRuleSelector()
				.addRuleLimit("PackageToDatabaseRule", 1));
		controller
				.setEObjectSelector(new RandomEObjectSelector());

		ModelGenerator gen = new ModelGenerator(
				ClassInhHier2DBPackage.eINSTANCE, controller);
		gen.generate();
	}
}
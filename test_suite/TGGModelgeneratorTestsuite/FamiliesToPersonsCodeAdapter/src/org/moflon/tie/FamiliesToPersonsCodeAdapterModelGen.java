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

import Families.FamiliesPackage;
import FamiliesToPersonsCodeAdapter.FamiliesToPersonsCodeAdapterPackage;
import Persons.PersonsPackage;

public class FamiliesToPersonsCodeAdapterModelGen extends SynchronizationHelper {

	public FamiliesToPersonsCodeAdapterModelGen() throws IOException {
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

		AbstractModelGenerationController controller = new DefaultModelGenController();
		controller.getDeadlineControllers().add(
				new MaxRulePerformCounterController(10));
		controller.setRuleSelector(new LimitedRandomRuleSelector()
				.addRuleLimit("FamilyRegisterToPersonsRegisterRule", 1)
				.addRuleLimit("MotherToMemberRule", 1));
		controller.setEObjectSelector(new RandomEObjectSelector());

		ModelGenerator gen = new ModelGenerator(
				FamiliesToPersonsCodeAdapterPackage.eINSTANCE, controller);
		gen.generate();
	}
}
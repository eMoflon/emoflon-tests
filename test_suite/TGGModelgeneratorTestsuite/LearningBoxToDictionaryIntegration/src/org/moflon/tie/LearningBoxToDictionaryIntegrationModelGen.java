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

import DictionaryLanguage.DictionaryLanguagePackage;
import LearningBoxLanguage.LearningBoxLanguagePackage;
import LearningBoxToDictionaryIntegration.LearningBoxToDictionaryIntegrationPackage;


public class LearningBoxToDictionaryIntegrationModelGen extends SynchronizationHelper {

	public LearningBoxToDictionaryIntegrationModelGen() throws IOException {
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

		AbstractModelGenerationController controller = new DefaultModelGenController();
		controller.getDeadlineControllers().add(new MaxRulePerformCounterController(20));
		controller.setRuleSelector(new LimitedRandomRuleSelector().addRuleLimit("BoxToDictionaryRule", 1));
		controller.setEObjectSelector(new RandomEObjectSelector());

		ModelGenerator gen = new ModelGenerator(LearningBoxToDictionaryIntegrationPackage.eINSTANCE, controller);
		gen.generate();
	}
}
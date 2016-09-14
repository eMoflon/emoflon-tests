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

import DictionaryCodeAdapter.DictionaryCodeAdapterPackage;


public class DictionaryCodeAdapterModelGen extends SynchronizationHelper {

	public DictionaryCodeAdapterModelGen() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(DictionaryCodeAdapterPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(DictionaryCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
		BasicConfigurator.configure();

		AbstractModelGenerationController controller = new DefaultModelGenController();
		controller.getDeadlineControllers().add(new MaxRulePerformCounterController(50));
		controller.setRuleSelector(new LimitedRandomRuleSelector().addRuleLimit("FolderToLibraryRule", 1));
		controller.setEObjectSelector(new RandomEObjectSelector());

		ModelGenerator gen = new ModelGenerator(DictionaryCodeAdapterPackage.eINSTANCE, controller);
		gen.generate();
	}
}
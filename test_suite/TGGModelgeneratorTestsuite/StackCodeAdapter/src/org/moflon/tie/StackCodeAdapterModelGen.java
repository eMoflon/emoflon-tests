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

import LIFOStack.LIFOStackPackage;
import StackCodeAdapter.StackCodeAdapterPackage;


public class StackCodeAdapterModelGen extends SynchronizationHelper {

	public StackCodeAdapterModelGen() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(StackCodeAdapterPackage.eINSTANCE);
		eMoflonEMFUtil.init(LIFOStackPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(StackCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
		BasicConfigurator.configure();

		AbstractModelGenerationController controller = new DefaultModelGenController();
		controller.getDeadlineControllers().add(new MaxRulePerformCounterController(20));
		controller.setRuleSelector(new LimitedRandomRuleSelector().addRuleLimit("StackToFileRule", 1));
		controller.setEObjectSelector(new RandomEObjectSelector());

		ModelGenerator gen = new ModelGenerator(StackCodeAdapterPackage.eINSTANCE, controller);
		gen.generate();
	}
}
package org.moflon.tie;

import org.eclipse.emf.ecore.EObject;
import TGGRuntime.CorrespondenceModel;
import org.eclipse.emf.common.util.URI;
import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.moflon.util.eMoflonEMFUtil;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.tgg.algorithm.modelgenerator.ModelGenerator;
import org.moflon.tgg.algorithm.modelgenerator.controller.AbstractModelGenerationController;
import org.moflon.tgg.algorithm.modelgenerator.controller.DefaultModelGenController;
import org.moflon.tgg.algorithm.modelgenerator.controller.LimitedRandomRuleSelector;
import org.moflon.tgg.algorithm.modelgenerator.controller.MaxRulePerformCounterController;
import org.moflon.tgg.algorithm.modelgenerator.controller.RandomEObjectSelector;
import ComponentCodeAdapter_EdgeRules.ComponentCodeAdapter_EdgeRulesPackage;


public class ComponentCodeAdapter_EdgeRulesModelGen extends SynchronizationHelper {

	public ComponentCodeAdapter_EdgeRulesModelGen() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(ComponentCodeAdapter_EdgeRulesPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(ComponentCodeAdapter_EdgeRulesPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
		BasicConfigurator.configure();

		AbstractModelGenerationController controller = new DefaultModelGenController();
		controller.getDeadlineControllers().add(new MaxRulePerformCounterController(20));
		controller.setRuleSelector(new LimitedRandomRuleSelector().addRuleLimit("File2SpecRule", 1));
		controller.setEObjectSelector(new RandomEObjectSelector());

		ModelGenerator gen = new ModelGenerator(ComponentCodeAdapter_EdgeRulesPackage.eINSTANCE, controller);
		gen.generate();
	}
}
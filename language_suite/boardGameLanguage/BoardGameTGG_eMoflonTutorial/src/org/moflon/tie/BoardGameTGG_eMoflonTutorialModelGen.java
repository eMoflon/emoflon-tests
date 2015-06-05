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
import org.moflon.tgg.algorithm.modelgenerator.controller.RandomCorrespondenceObjectSelector;
import BoardGameTGG_eMoflonTutorial.BoardGameTGG_eMoflonTutorialPackage;
import BoardGameLanguage_eMoflonTutorial.BoardGameLanguage_eMoflonTutorialPackage;


public class BoardGameTGG_eMoflonTutorialModelGen extends SynchronizationHelper {

	public BoardGameTGG_eMoflonTutorialModelGen() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(BoardGameTGG_eMoflonTutorialPackage.eINSTANCE);
		eMoflonEMFUtil.init(BoardGameLanguage_eMoflonTutorialPackage.eINSTANCE);

                
        // Load rules and set correspondence
		setCorrPackage(BoardGameTGG_eMoflonTutorialPackage.eINSTANCE);
		loadRulesFromProject("..");
	}
	
	public static void main(String[] args) throws IOException {
		// Set up logging
		BasicConfigurator.configure();

		AbstractModelGenerationController controller = new DefaultModelGenController();
		controller.getDeadlineControllers().add(new MaxRulePerformCounterController(20));
		controller.setRuleSelector(new LimitedRandomRuleSelector().addRuleLimit("CHANGE_ME", 1));
		controller.setCorrespondenceObjectSelector(new RandomCorrespondenceObjectSelector());

		ModelGenerator gen = new ModelGenerator(BoardGameTGG_eMoflonTutorialPackage.eINSTANCE, controller);
		gen.generate();
	}
}
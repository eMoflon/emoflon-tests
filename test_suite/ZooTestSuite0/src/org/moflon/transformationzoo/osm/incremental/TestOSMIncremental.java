package org.moflon.transformationzoo.osm.incremental;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.junit.Ignore;
import org.junit.Test;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.File;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;
import ModelDeltaCreator_OSM.ModelDeltaCreator_OSMFactory;
import ModelDeltaCreator_OSM.OSMModelDeltaCreator;
import OSMLanguage.OSMLanguagePackage;
import OSMLanguage.OSMapContainer;
import OSMTGG.OSMTGGPackage;
import org.moflon.tgg.language.algorithm.ApplicationTypes;

public class TestOSMIncremental extends IncrementalIntegratorTest {

	public TestOSMIncremental() {
		super(OSMLanguagePackage.eINSTANCE, OSMTGGPackage.eINSTANCE, MocaTreePackage.eINSTANCE);
	}

	@Test
	public void testFirstIncremental_ChangeBounds_FWD() throws IOException, InterruptedException {
		
		init();
		
		setInputModel(ApplicationTypes.FORWARD, "FirstIncremental_ChangeBounds_FWD");
		
		helper.integrateForward();
		
		helper.setChangeSrc(root -> {
			OSMModelDeltaCreator modelDeltaCreator = ModelDeltaCreator_OSMFactory.eINSTANCE.createOSMModelDeltaCreator();
			Folder folder = (Folder) root;
			modelDeltaCreator.createNewBounds_FWD(folder);
		}); 

		helper.integrateForward();
		
		saveOutput("FirstIncremental_ChangeBounds_FWD");
		compareWithExpected("FirstIncremental_ChangeBounds_FWD", ApplicationTypes.FORWARD, helper.getTrg());
	}

	//BWD tests are ignored due to missing post processing
    @Test @Ignore
	public void testFirstIncremental_ChangeBounds_BWD() throws IOException, InterruptedException {
		
		init();
		
		setInputModel(ApplicationTypes.BACKWARD, "FirstIncremental_ChangeBounds_BWD");
		
		helper.integrateBackward();
		
		helper.setChangeTrg(root -> {
			OSMModelDeltaCreator modelDeltaCreator = ModelDeltaCreator_OSMFactory.eINSTANCE.createOSMModelDeltaCreator();
			OSMapContainer container = (OSMapContainer) root;
			modelDeltaCreator.createNewBounds_BWD(container);
		}); 

		helper.integrateBackward();
		
		saveOutput("FirstIncremental_ChangeBounds_BWD");
		compareWithExpected("FirstIncremental_ChangeBounds_BWD", ApplicationTypes.BACKWARD, helper.getSrc());
		
	}

	@Override
	public void compare(EObject expected, EObject created) throws InterruptedException {
		File expFile = new ModelToTreeConverter().modelToTree(expected, false);
		File createdFile = new ModelToTreeConverter().modelToTree(created, false);
		TreeComparator.compare(createdFile, expFile);
	}

}

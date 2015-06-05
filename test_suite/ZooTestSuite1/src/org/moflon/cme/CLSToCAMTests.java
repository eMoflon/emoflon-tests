package org.moflon.cme;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.moca.parser.ClsParserAdapter;
import org.moflon.moca.unparser.ClsUnparserAdapter;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;

import CAMLanguage.Argument;
import CAMLanguage.CAMLanguageFactory;
import CAMLanguage.CAMLanguagePackage;
import CAMLanguage.CAMModel;
import CAMLanguage.RAPIDGOTO;
import ClsToCAMLanguageTGG.CLS_TreePreprocessor;
import ClsToCAMLanguageTGG.ClsToCAMLanguageTGGFactory;
import ClsToCAMLanguageTGG.ClsToCAMLanguageTGGPackage;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.MocaTreePackage;
import MocaTree.Node;
import TGGLanguage.algorithm.ApplicationTypes;

public class CLSToCAMTests extends IncrementalIntegratorTest {

	public CLSToCAMTests() {
		super(MocaTreePackage.eINSTANCE,
				ClsToCAMLanguageTGGPackage.eINSTANCE,
				CAMLanguagePackage.eINSTANCE);
	}
	
	public void createCLSTestData(String pathToCLSFile, String pathToCLSModel){
		CodeAdapter codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
		codeAdapter.getParser().add(new ClsParserAdapter());
		MocaTree.File mfile = codeAdapter.parseFile(new File(pathToCLSFile), null);
		eMoflonEMFUtil.saveModel(mfile, pathToCLSModel);	
	}
	
	@Before
	public void beforeTest() throws IOException{
		init(); 
	}
	
	@Test
	public void changeOperationOfFirstRapidGoto() throws Exception {
		setInputModel(ApplicationTypes.FORWARD, "changeOperationOfFirstRapidGoto");

		CLS_TreePreprocessor treePreprocessor = ClsToCAMLanguageTGGFactory.eINSTANCE.createCLS_TreePreprocessor();
		treePreprocessor.preprocessCLSTree((MocaTree.File) helper.getSrc());
		
		helper.integrateForward();
		helper.setChangeTrg(root -> {
			CAMModel model = (CAMModel) root;
			RAPIDGOTO rgoto = (RAPIDGOTO) model.getOperations().get(1);
			
			Argument oldArg = rgoto.getXCoordinate();
			eMoflonEMFUtil.remove(oldArg);
			
			Argument newArg = CAMLanguageFactory.eINSTANCE.createArgument();
			newArg.setValue("42.000");
			newArg.setOperation(rgoto);
			
			rgoto.setXCoordinate(newArg);
		});		
		
		helper.integrateBackward();
		
		saveOutput("changeOperationOfFirstRapidGoto");

		compareWithExpected("changeOperationOfFirstRapidGoto", ApplicationTypes.BACKWARD, helper.getSrc());
	}
	
	@Override
	public void compare(EObject expected, EObject created) throws InterruptedException {
		ClsUnparserAdapter unparser = new ClsUnparserAdapter();
		
		Node expectedRootNode = ((MocaTree.File)expected).getRootNode();
		Node createdRootNode = ((MocaTree.File)created).getRootNode();
		
		String expectedCLS = unparser.unparse(expectedRootNode);
		String createdCLS = unparser.unparse(createdRootNode);
		
		Assert.assertEquals(expectedCLS, createdCLS);
	}
}

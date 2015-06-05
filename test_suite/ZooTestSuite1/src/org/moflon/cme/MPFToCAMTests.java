package org.moflon.cme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.moca.parser.MpfParserAdapter;
import org.moflon.moca.unparser.MpfUnparserAdapter;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;
import org.moflon.tgg.algorithm.delta.Delta;
import org.moflon.tgg.algorithm.delta.OfflineTreeChangeDetector;
import org.moflon.tie.MPFConfigurator;

import CAMLanguage.Argument;
import CAMLanguage.CAMLanguageFactory;
import CAMLanguage.CAMLanguagePackage;
import CAMLanguage.CAMModel;
import CAMLanguage.FEDRATGOTO;
import CAMLanguage.GOTO;
import CAMLanguage.Operation;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.MocaTreePackage;
import MocaTree.Node;
import TGGLanguage.algorithm.ApplicationTypes;

public class MPFToCAMTests extends IncrementalIntegratorTest {

	public MPFToCAMTests() {
		super(MocaTreePackage.eINSTANCE, MpfToCAMLanguageTGGPackage.eINSTANCE, CAMLanguagePackage.eINSTANCE);
	}

	public static void createMPFTestData(String pathToMPFFile, String pathToMPFModel) {
		CodeAdapter codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
		codeAdapter.getParser().add(new MpfParserAdapter());
		MocaTree.File mfile = codeAdapter.parseFile(new File(pathToMPFFile), null);
		eMoflonEMFUtil.saveModel(mfile, pathToMPFModel);
	}

	public static void main(String[] args) {
		createMPFTestData(
				"resources/tggLanguageTestDataIncremental/in/MpfToCAMLanguageTGG/changeOperationOfFirstRapidGoto.mpf",
				"resources/tggLanguageTestDataIncremental/in/MpfToCAMLanguageTGG/test1.xmi");
	}

	@Before
	public void beforeTest() throws IOException {
		init();
	}
	
	@Test
	@Ignore("Fails due to a current bug in handling of dynamic conditions in the synchronization algorithm!")
	public void changeOperation() throws Exception {
		String name = "changeOperation";
		
		setConfigurator(new MPFConfigurator());
		setInputModel(ApplicationTypes.FORWARD, name);

		helper.integrateForward();
		helper.setChangeTrg(root -> {
			CAMModel model = (CAMModel) root;

			FEDRATGOTO fgoto2 = null;
			for (Operation op : model.getOperations()) {
				if (op instanceof FEDRATGOTO) {
					if (op.getNext() instanceof FEDRATGOTO) {
						fgoto2 = (FEDRATGOTO) op.getNext();
						break;
					}
				}
			}

			Argument oldArg = fgoto2.getYCoordinate();
			eMoflonEMFUtil.remove(oldArg);

			Argument newArg = CAMLanguageFactory.eINSTANCE.createArgument();
			newArg.setValue("42.000");
			newArg.setOperation(fgoto2);

			fgoto2.setYCoordinate(newArg);
		});

		helper.integrateBackward();

		saveOutput(name);
		compareWithExpected(name, ApplicationTypes.BACKWARD, helper.getSrc());
	}

	@Test
	public void changeLastOperation() throws Exception {
		String name = "changeLastOperation";
		
		setConfigurator(new MPFConfigurator());
		setInputModel(ApplicationTypes.FORWARD, name);

		helper.integrateForward();
		helper.setChangeTrg(root -> {
			CAMModel model = (CAMModel) root;

			GOTO lastGoto = (GOTO) model.getOperations().get(model.getOperations().size() - 1);

			Argument oldArg = lastGoto.getYCoordinate();
			eMoflonEMFUtil.remove(oldArg);

			Argument newArg = CAMLanguageFactory.eINSTANCE.createArgument();
			newArg.setValue("42.000");
			newArg.setOperation(lastGoto);

			lastGoto.setYCoordinate(newArg);
		});

		helper.integrateBackward();

		saveOutput(name);
		compareWithExpected(name, ApplicationTypes.BACKWARD, helper.getSrc());
	}

	@Test
	public void addNewOperationInMPF() throws Exception {
		String name = "addNewOperationInMPF";
		
		setConfigurator(new MPFConfigurator());
		setInputModel(ApplicationTypes.FORWARD, name);

		helper.integrateForward();
		
		MocaTree.File treeAfter = (MocaTree.File) helper.getSrc();
		MocaTree.File treeBefore = parseMPFFile(getFullInpath() + name + ".before.mpf");
		Delta forwardDelta = new OfflineTreeChangeDetector(treeBefore.getRootNode(), treeAfter.getRootNode()).computeForwardDelta();
		
		helper.setDelta(forwardDelta);
		
		helper.integrateForward();

		saveOutput(name);
		compareWithExpected(name, ApplicationTypes.FORWARD, helper.getTrg());
	}
	
	
	@Override
	public void compare(EObject expected, EObject created) throws InterruptedException {
		if (expected instanceof MocaTree.File) {
			MpfUnparserAdapter unparser = new MpfUnparserAdapter();

			Node expectedRootNode = ((MocaTree.File) expected).getRootNode();
			Node createdRootNode = ((MocaTree.File) created).getRootNode();

			String expectedMPF = unparser.unparse(expectedRootNode);
			String createdMPF = unparser.unparse(createdRootNode);

			Assert.assertEquals(expectedMPF, createdMPF);
		} else {
			normalizeModel(created);
			normalizeModel(expected);
			super.compare(expected, created); 
		}
	}
	
	private void normalizeModel(EObject cam) {
		CAMModel camModel = (CAMModel) cam;
		camModel.getOperations().forEach(op -> {
			if(op instanceof GOTO){
				GOTO gotoOp = (GOTO)op;
				Argument xArg = gotoOp.getXCoordinate();
				Argument yArg = gotoOp.getYCoordinate();
				Argument zArg = gotoOp.getZCoordinate();
				
				gotoOp.getArguments().clear();
				
				gotoOp.getArguments().add(xArg);
				gotoOp.getArguments().add(yArg);
				gotoOp.getArguments().add(zArg);
			}
		});
	}

	@Override
	protected EObject loadExpected(String testCaseName, ApplicationTypes direction) {
		if (direction.equals(ApplicationTypes.BACKWARD)) {
			try {
				return parseMPFFile(getExpectedPath() + testCaseName + ".mpf");
			} catch (Exception e) {
				return null;
			}
		} else {
			return super.loadExpected(testCaseName, direction);
		}
	}
	
	@Override
	protected void setInputModel(ApplicationTypes direction, String testCaseName) {
		if (direction == ApplicationTypes.FORWARD) {
			helper.setSrc(parseMPFFile(getFullInpath() + testCaseName + ".mpf"));
		} else {
			super.setInputModel(direction, testCaseName);
		}
	}

	private MocaTree.File parseMPFFile(String fileName) {
		CodeAdapter codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
		codeAdapter.getParser().add(new MpfParserAdapter());
		MocaTree.File mfile = codeAdapter.parseFile(new File(fileName), null);
		Resource resource = new ResourceImpl();
		resource.getContents().add(mfile);
		return mfile;
	}
	
	@Override
	protected void saveOutput(String testCaseName){
		super.saveOutput(testCaseName);
		
		MpfUnparserAdapter unparser = new MpfUnparserAdapter();
		String expectedMPF = unparser.unparse(((MocaTree.File) helper.getSrc()).getRootNode());
		
		File outFile = new File(getFullOutpath() + testCaseName + ".mpf");

		try {
			FileWriter writer = new FileWriter(outFile);
			writer.write(expectedMPF);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

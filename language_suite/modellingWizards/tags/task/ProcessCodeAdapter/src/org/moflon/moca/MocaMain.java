package org.moflon.moca;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.moflon.moca.dot.MocaTreeDotPrinter;
import org.moflon.moca.proc.parser.ProcParserAdapter;
import org.moflon.moca.proc.unparser.ProcUnparserAdapter;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.TranslatorHelper;
import org.moflon.util.eMoflonEMFUtil;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;
import ProcessCodeAdapter.ProcessCodeAdapterPackage;
import ProcessDefinition.Module;
import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition.SystemModule;
import TGGLanguage.TGGLanguagePackage;
import TGGLanguage.algorithm.ApplicationTypes;

public class MocaMain {

	private static CodeAdapter codeAdapter;

	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();

		// Register parsers and unparsers
		codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
		codeAdapter.getParser().add(new ProcParserAdapter());
		codeAdapter.getUnparser().add(new ProcUnparserAdapter());

		// Initialize helper
		IntegratorHelper helper = new IntegratorHelper();
		helper.loadRulesFromProject("..", "ProcessCodeAdapter");
		helper.setCorrPackage(ProcessCodeAdapterPackage.eINSTANCE);
		
		// Perform text-to-tree
		Folder treeFWD = codeAdapter.parse(new File("./instances/in/deploy_eMoflon"));

		// Save tree to file
		eMoflonEMFUtil.saveModel(MocaTreePackage.eINSTANCE, treeFWD, "./instances/tree/treeFWD.xmi");

		// Perform tree-to-model
		SystemModule system = treeToModel(helper);

		// Validation
		
		eMoflonEMFUtil.saveModel(ProcessDefinitionPackage.eINSTANCE, system, "./instances/model/processDefModuleVerified.xmi");

		// Perform model-to-tree
		Folder treeBWD = modelToTree(helper);
		
		// Perform tree-to-text
		codeAdapter.unparse("./instances/out", treeBWD);
	}

	private static SystemModule treeToModel(IntegratorHelper helper) throws IOException {
		helper.loadSrc(MocaTreePackage.eINSTANCE, "./instances/tree/treeFWD.xmi");
		
		helper.integrateForward();

		helper.saveTrg(ProcessDefinitionPackage.eINSTANCE, "./instances/model/processDefModule.xmi");
		helper.saveCorr(ProcessCodeAdapterPackage.eINSTANCE, "./instances/corr/corrFWD.xmi");
		helper.saveProtocol("./instances/corr/protocolFWD.xmi");

		return (SystemModule) helper.getTrg();
	}

	private static Folder modelToTree(IntegratorHelper helper) throws IOException {
		helper.loadTrg(ProcessDefinitionPackage.eINSTANCE, "./instances/model/processDefModuleVerified.xmi");
		
		helper.integrateBackward();

		helper.saveSrc(MocaTreePackage.eINSTANCE, "./instances/tree/treeBWD.xmi");
		helper.saveCorr(ProcessCodeAdapterPackage.eINSTANCE, "./instances/corr/corrBWD.xmi");
		helper.saveProtocol("./instances/corr/protocolBWD.xmi");
		
		return (Folder) helper.getSrc();
	}
}
package org.moflon.moca;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.moflon.util.TranslatorHelper;

import BlockDiagram.BlockDiagramPackage;
import BlockDiagramCodeAdapter.BlockDiagramCodeAdapterPackage;
import MocaTree.MocaTreePackage;
import TGGLanguage.algorithm.ApplicationTypes;

public class MocaMain {

	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		platformToModel();
	}

	private static void platformToModel() throws IOException {
		// Tree-to-model
		TranslatorHelper helper = new TranslatorHelper();
		helper.setDirection(ApplicationTypes.FORWARD);
		helper.setInputModel(BlockDiagramPackage.eINSTANCE,
				"./instances/BlockSystem.xmi");
		helper.setOutputModel(MocaTreePackage.eINSTANCE, "./instances/tree.xmi");		
		helper.setCorrModel(BlockDiagramCodeAdapterPackage.eINSTANCE,
				"./instances/correspondence/BlockTotree.xmi");
		helper.setStaticAnalysis("./model/BlockDiagramCodeAdapter.gen.sma.xmi");

		helper.integrate();
	}

	
}
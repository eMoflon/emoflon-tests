package org.moflon.moca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.BasicConfigurator;
import org.moflon.moca.stack.parser.StackParserAdapter;
import org.moflon.moca.stack.unparser.StackUnparserAdapter;
import org.moflon.util.TranslatorHelper;
import org.moflon.util.eMoflonEMFUtil;

import LIFOStack.LIFOStackPackage;
import LIFOStack.Stack;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.Folder;
import MocaTree.MocaTreeFactory;
import MocaTree.MocaTreePackage;
import StackCodeAdapter.StackCodeAdapterPackage;
import TGGLanguage.algorithm.ApplicationTypes;

public class MocaMain
{

   private static CodeAdapter codeAdapter;

   public static void main(String[] args) throws IOException
   {
      BasicConfigurator.configure();

      // Register parsers and unparsers
      codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
      codeAdapter.getParser().add(new StackParserAdapter());
      codeAdapter.getUnparser().add(new StackUnparserAdapter());

      modelToPlatform();
      //platformToModel();
   }

   private static void platformToModel() throws IOException
   {
      // Transform text-to-tree
      Folder tree = codeAdapter.parse(new File("./instances/text"));
      eMoflonEMFUtil.saveModel(MocaTreePackage.eINSTANCE, tree.getFile().get(0), "./instances/tree.xmi");
      
      // Tree-to-model
      TranslatorHelper helper = new TranslatorHelper();
      helper.setDirection(ApplicationTypes.BACKWARD);
      helper.setInputModel(MocaTreePackage.eINSTANCE, "./instances/tree.xmi");
      helper.setOutputModel(LIFOStackPackage.eINSTANCE, "./instances/model/stack.xmi");
      helper.setCorrModel(StackCodeAdapterPackage.eINSTANCE, "./instances/correspondence/stackTotree.xmi");
      helper.setStaticAnalysis("./model/StackCodeAdapter.gen.sma.xmi");

      helper.integrate();
   }

   private static void modelToPlatform() throws IOException
   {
      // Transform model-to-tree
      TranslatorHelper helper = new TranslatorHelper();
      helper.setDirection(ApplicationTypes.FORWARD);
      helper.setInputModel(LIFOStackPackage.eINSTANCE, "./instances/model/stack.xmi");
      helper.setOutputModel(MocaTreePackage.eINSTANCE, "./instances/tree.xmi");
      helper.setCorrModel(StackCodeAdapterPackage.eINSTANCE, "./instances/correspondence/stackTotree.xmi");
      helper.setStaticAnalysis("./model/StackCodeAdapter.gen.sma.xmi");

      helper.integrate();
     
      // Perform tree-to-text (using initial tree)
      Folder folder = MocaTreeFactory.eINSTANCE.createFolder();
      folder.setName("text");
      MocaTree.File file = (MocaTree.File) helper.getOutputRoot();
      folder.getFile().add(file);
      codeAdapter.unparse("instances/", folder);
   }
}
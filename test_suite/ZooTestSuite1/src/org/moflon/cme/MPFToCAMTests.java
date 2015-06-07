package org.moflon.cme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.moca.parser.ClsParserAdapter;
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
import CAMLanguage.TOOLPATH;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.MocaTreePackage;
import MocaTree.Node;
import MpfToCAMLanguageTGG.MpfToCAMLanguageTGGPackage;
import TGGLanguage.algorithm.ApplicationTypes;

public class MPFToCAMTests extends IncrementalIntegratorTest
{

   // Use this method to update all input models from their .mpf files
   public static void main(String[] args)
   {
      String inputFolder = "resources/tggLanguageTestDataIncremental/in/MpfToCAMLanguageTGG/";
      CodeAdapter codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
      codeAdapter.getParser().add(new MpfParserAdapter());

      File inputFiles = new File(inputFolder);
      Arrays.asList(inputFiles.listFiles((f, name) -> name.endsWith(".mpf"))).forEach(mpfFile -> {
         MocaTree.File mpfModel = codeAdapter.parseFile(mpfFile, null);
         eMoflonEMFUtil.saveModel(mpfModel, inputFolder + mpfFile.getName() + ".xmi");
      });
   }

   public MPFToCAMTests()
   {
      super(MocaTreePackage.eINSTANCE, MpfToCAMLanguageTGGPackage.eINSTANCE, CAMLanguagePackage.eINSTANCE);
   }

   @Before
   public void beforeTest() throws IOException
   {
      init();
      BasicConfigurator.resetConfiguration(); 
      BasicConfigurator.configure();
      helper.setVerbose(true);
   }
   
   @Override
   public void compare(EObject expected, EObject created) throws InterruptedException
   {
      if (expected instanceof MocaTree.File)
      {
         MpfUnparserAdapter unparser = new MpfUnparserAdapter();

         Node expectedRootNode = ((MocaTree.File) expected).getRootNode();
         Node createdRootNode = ((MocaTree.File) created).getRootNode();

         String expectedMPF = unparser.unparse(expectedRootNode);
         String createdMPF = unparser.unparse(createdRootNode);

         Assert.assertEquals(expectedMPF, createdMPF);
      } else
      {
         super.compare(expected, created);
      }
   }

   @Override
   protected void saveOutput(String testCaseName)
   {
      super.saveOutput(testCaseName);

      MpfUnparserAdapter unparser = new MpfUnparserAdapter();
      String expectedMPF = unparser.unparse(((MocaTree.File) helper.getSrc()).getRootNode());

      File outFile = new File(getFullOutpath() + testCaseName);

      try
      {
         FileWriter writer = new FileWriter(outFile);
         writer.write(expectedMPF);
         writer.close();
      } catch (IOException e)
      {
         e.printStackTrace();
      }
   }
   
   private void testBWDSync(String name, Consumer<EObject> delta) throws Exception{
      setConfigurator(new MPFConfigurator());
      setInputModel(ApplicationTypes.FORWARD, name);

      helper.integrateForward();
      
      helper.setChangeTrg(root -> { 
         delta.accept(root);
      });

      helper.integrateBackward();
 
      saveOutput(name);
      compareWithExpected(name, ApplicationTypes.BACKWARD, helper.getSrc());
   }

   @Test
   public void test0() throws Exception
   {
      testBWDSync("test0.mpf", DeltasOnCAMModel::swapChosenTool);
   }

   @Test
   public void test1() throws Exception
   {
      testBWDSync("test1.mpf", DeltasOnCAMModel::swapXArgOfFirstOperation);
   }

   @Test
   public void test2() throws Exception
   {
      testBWDSync("test2.mpf", DeltasOnCAMModel::swapXArgOfFirstOperation);
   }
   
   @Test
   public void test3() throws Exception
   {
      testBWDSync("test3.mpf", x -> {});
   }
}

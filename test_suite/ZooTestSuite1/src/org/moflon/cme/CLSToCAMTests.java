package org.moflon.cme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.moca.parser.ClsParserAdapter;
import org.moflon.moca.unparser.ClsUnparserAdapter;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;
import org.moflon.tie.MPFConfigurator;

import CAMLanguage.CAMLanguagePackage;
import ClsToCAMLanguageTGG.ClsToCAMLanguageTGGPackage;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.MocaTreePackage;
import MocaTree.Node;
import TGGLanguage.algorithm.ApplicationTypes;

public class CLSToCAMTests extends IncrementalIntegratorTest
{

   // Use this method to update all input models from their .cls files
   public static void main(String[] args)
   {
      String inputFolder = "resources/tggLanguageTestDataIncremental/in/ClsToCAMLanguageTGG/";
      CodeAdapter codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
      codeAdapter.getParser().add(new ClsParserAdapter());

      File inputFiles = new File(inputFolder);
      Arrays.asList(inputFiles.listFiles((f, name) -> name.endsWith(".cls"))).forEach(clsFile -> {
         MocaTree.File clsModel = codeAdapter.parseFile(clsFile, null);
         eMoflonEMFUtil.saveModel(clsModel, inputFolder + clsFile.getName() + ".xmi");
      });
   }

   public CLSToCAMTests()
   {
      super(MocaTreePackage.eINSTANCE, ClsToCAMLanguageTGGPackage.eINSTANCE, CAMLanguagePackage.eINSTANCE);
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
         ClsUnparserAdapter unparser = new ClsUnparserAdapter();

         Node expectedRootNode = ((MocaTree.File) expected).getRootNode();
         Node createdRootNode = ((MocaTree.File) created).getRootNode();

         String expectedCLS = unparser.unparse(expectedRootNode);
         String createdCLS = unparser.unparse(createdRootNode);

         Assert.assertEquals(expectedCLS, createdCLS);
      } else
      {
         super.compare(expected, created);
      }
   }
   
   @Override
   protected void saveOutput(String testCaseName)
   {
      super.saveOutput(testCaseName);

      ClsUnparserAdapter unparser = new ClsUnparserAdapter();
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
      testBWDSync("test0.cls", DeltasOnCAMModel::swapChosenTool);
   }
   
   @Test
   public void test1() throws Exception
   {
      testBWDSync("test1.cls", DeltasOnCAMModel::swapXArgOfFirstOperation);
   }
   
   @Test
   public void test2() throws Exception
   {
      testBWDSync("test2.cls", DeltasOnCAMModel::swapXArgOfLastOperation);
   }
   
   @Test
   public void test3() throws Exception
   {
      testBWDSync("test3.cls", DeltasOnCAMModel::swapXArgOfLastOperation);
   }
   
   @Test
   public void test4() throws Exception
   {
      testBWDSync("test4.cls", DeltasOnCAMModel::swapXArgOfLastOperation);
   }
   
   @Test
   public void test5() throws Exception
   {
      testBWDSync("test5.cls", DeltasOnCAMModel::swapXArgOfFirstOperation);
   }
}

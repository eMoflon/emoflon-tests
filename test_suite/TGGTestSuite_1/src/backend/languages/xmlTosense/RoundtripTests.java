package backend.languages.xmlTosense;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.moflon.moca.SDFToSenseMocaMain;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.core.utilities.eMoflonEMFUtil;

import MocaTree.MocaTreePackage;
import SDFToSenseIntegration.SDFToSenseIntegrationPackage;
import Sense.SenseModel;
import Sense.SensePackage;


public class RoundtripTests extends IntegratorTest
{
   private static final Logger logger = Logger.getLogger(RoundtripTests.class);
   
   private String originalTestCase;

   public RoundtripTests()
   {
      super(MocaTreePackage.eINSTANCE, SDFToSenseIntegrationPackage.eINSTANCE, SensePackage.eINSTANCE);
   }

   @BeforeClass
   public static void logging(){      
      BasicConfigurator.configure();
   }
   
   @Before
   public void init()
   {
      SDFToSenseMocaMain.init();
      originalTestCase = null;
   }

   @Test
   public void testFigure15_FWD()
   {
      doFWDTrafoFor("Figure15");
   }

   @Test
   public void testFigure18_FWD()
   {
      doFWDTrafoFor("Figure18");
   }

   @Test
   public void testFigure20_FWD()
   {
      doFWDTrafoFor("Figure20");
   }

   @Test
   public void testFigure15_BWD()
   {
      doBWDTrafoFor("Figure15");
   }

   @Test
   public void testFigure18_BWD()
   {
      doBWDTrafoFor("Figure18");
   }
   
   @Test
   public void testFigure20_BWD()
   {
      doBWDTrafoFor("Figure20");
   }
   
   private void doBWDTrafoFor(String testCaseName){
      originalTestCase = testCaseName;
      helper = new SynchronizationHelper(SDFToSenseIntegrationPackage.eINSTANCE, "../SDFToSenseIntegration");
      integrate(originalTestCase + "_BWD");
   }
   
   private void doFWDTrafoFor(String testCaseName)
   {
      logger.debug("Performing FWD from " + testCaseName + ".xml");
      doFWDTrafoFor(testCaseName + ".xml", testCaseName);
      logger.debug("done");
   }

   private void doFWDTrafoFor(String xmlFile, String testCaseName)
   {
      // Perform text-to-tree
      MocaTree.File tree = SDFToSenseMocaMain.codeAdapter.parseFile(new File(getFullInpath() + xmlFile), null);

      // Save tree to file
      String treeFile = getFullInpath() + testCaseName + "_FWD.xmi";
      helper.getResourceSet().createResource(eMoflonEMFUtil.createFileURI(treeFile, false)).getContents().add(tree);
      
      eMoflonEMFUtil.saveModel(tree, treeFile);

      helper = helper = new SynchronizationHelper(SDFToSenseIntegrationPackage.eINSTANCE, "../SDFToSenseIntegration");
      integrate(testCaseName + "_FWD");
   }

   @Override
   public void compare(EObject expected, EObject created)
   {
      if (created instanceof SenseModel)
      {
         String expectedString;
         try
         {
            expectedString = SDFToSenseMocaMain.modelToNormalizedText((SenseModel) expected);
            String createdString = SDFToSenseMocaMain.modelToNormalizedText((SenseModel) created);

            assertNotNull(expectedString);
            assertNotNull(createdString);
            assertEquals("Models are not equal in the concrete textual syntax", expectedString, createdString);
         } catch (FileNotFoundException e)
         {
            e.printStackTrace();
            fail();
         }
      } else if (created instanceof MocaTree.File)
      {
         logger.debug("Performing BWD from " + originalTestCase + "_BWD.xmi");
         MocaTree.File tree = (MocaTree.File) created;
         tree.setName(originalTestCase + "_fromRoundtrip.xml");
         String xmlFile = tree.getName();
         
         logger.debug("Tree has been created, instead of comparing directly perform roundtrip by unparsing");
         SDFToSenseMocaMain.codeAdapter.unparseFile(tree, new File(getFullInpath()));
         
         logger.debug(".. and running FWD for xml file " + xmlFile);
         doFWDTrafoFor(xmlFile, originalTestCase);
         logger.debug("done");
      } else
      {
         fail();
      }
   }
}

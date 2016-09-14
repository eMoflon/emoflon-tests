package languages.doubleLinkedListLanguage;

import java.io.File;



import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.junit.Assert;
import org.junit.Test;

import DoubleLinkedListLanguage.DoubleLinkedListLanguagePackage;
import DoubleLinkedListLanguage.List;
import DoubleLinkedListLanguage.Node;


public class NodePersistence
{
   private static final String pathToModel = "resources/languages/dllTestData/example.xmi";
   
   private Resource loadModel(){
      
      //1. Initialize metamodel package
      @SuppressWarnings("unused")
      DoubleLinkedListLanguagePackage dlLPackage = DoubleLinkedListLanguagePackage.eINSTANCE;
          
      //2. Get file for model
      File modelFile = new File(pathToModel);
      Assert.assertNotNull(modelFile);
      Assert.assertTrue(modelFile.exists());
      
      //3. Create a ResourceSet
      ResourceSet resourceSet = new ResourceSetImpl();
      URI fileURI = URI.createFileURI(modelFile.getAbsolutePath());
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new EcoreResourceFactoryImpl());

      // Load model
      return resourceSet.getResource(fileURI, true);
   }
   
   @Test
   public void testModelBrowser() throws Exception{
      Resource resource = loadModel();
      
      // Check initial structure
      List list = (List) resource.getContents().get(0);
      
      Node ene = null;
      for (Node node : list.getElements())
      {
         if(node.getLabel().equals("Ene"))
            ene = node;
      }
      Assert.assertNotNull(ene);
      
      String listLabel = NodeTest.listToString(ene);
      Assert.assertEquals("EneMeneMoo", listLabel);
      
      // Call SDM methods to change structure
      Node meini = NodeTest.createNodeInList("Meini", list);
      Node mene = ene.getNext();
      mene.insertNodeAfter(meini);
      
      // Check new structure
      Assert.assertEquals("EneMeneMeiniMoo", NodeTest.listToString(ene));
   }
}

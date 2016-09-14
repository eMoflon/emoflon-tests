package backend.languages.tggLanguage.modelgen;

import org.junit.Ignore;
import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import StackCodeAdapter.StackCodeAdapterPackage;

public class RefinementTestTGGModelgenTest extends ModelgenTest
{

   public RefinementTestTGGModelgenTest()
   {
      super(StackCodeAdapterPackage.eINSTANCE);

   }

 //ignored because tgg refinement structure is not useful for modelgenerator
   @Ignore
   @Test
   public void test_ModelsAreGenerated()
   {
      runDefaultModelgeneratorTest("FolderToPFolderRule", 20);
   }

}
package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import StackCodeAdapter.StackCodeAdapterPackage;

public class StackCodeAdapterModelgenTest extends ModelgenTest
{

   public StackCodeAdapterModelgenTest()
   {
      super(StackCodeAdapterPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("StackToFileRule", 20);
   }

}
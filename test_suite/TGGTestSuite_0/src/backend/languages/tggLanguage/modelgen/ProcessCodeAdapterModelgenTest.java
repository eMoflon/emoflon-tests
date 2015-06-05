package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import ProcessCodeAdapter.ProcessCodeAdapterPackage;

public class ProcessCodeAdapterModelgenTest extends ModelgenTest
{

   public ProcessCodeAdapterModelgenTest()
   {
      super(ProcessCodeAdapterPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("RootToSystemRule", 20);
   }

}
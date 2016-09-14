package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import VHDLTGGCodeAdapter.VHDLTGGCodeAdapterPackage;

public class VHDLTGGCodeAdapterModelgenTest extends ModelgenTest
{

   public VHDLTGGCodeAdapterModelgenTest()
   {
      super(VHDLTGGCodeAdapterPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("File2VHDLSpec", 20);
   }

}
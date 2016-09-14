package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import BlockCodeAdapter.BlockCodeAdapterPackage;

public class BlockCodeAdapterModelgenTest extends ModelgenTest
{

   public BlockCodeAdapterModelgenTest()
   {
      super(BlockCodeAdapterPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("File2SpecRule", 20);
   }

}

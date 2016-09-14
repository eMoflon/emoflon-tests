package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import BlockDiagramCodeAdapter.BlockDiagramCodeAdapterPackage;

public class BlockDiagramCodeAdapterModelgenTest extends ModelgenTest
{

   public BlockDiagramCodeAdapterModelgenTest()
   {
      super(BlockDiagramCodeAdapterPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("SystemToNodeRule", 20);
   }

}

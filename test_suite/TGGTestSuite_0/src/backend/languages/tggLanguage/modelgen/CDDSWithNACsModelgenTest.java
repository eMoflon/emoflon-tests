package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import CDDSWithNACs.CDDSWithNACsPackage;

public class CDDSWithNACsModelgenTest extends ModelgenTest
{

   public CDDSWithNACsModelgenTest()
   {
      super(CDDSWithNACsPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("CD2DSRule", 20);
   }

}
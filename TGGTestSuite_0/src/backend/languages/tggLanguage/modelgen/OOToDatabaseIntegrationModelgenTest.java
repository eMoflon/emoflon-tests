package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import OOToDatabaseIntegration.OOToDatabaseIntegrationPackage;

public class OOToDatabaseIntegrationModelgenTest extends ModelgenTest
{

   public OOToDatabaseIntegrationModelgenTest()
   {
      super(OOToDatabaseIntegrationPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("RuleClassToTable", 20);
   }

}
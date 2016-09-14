package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import CDToCDIntegration.CDToCDIntegrationPackage;

public class CDToCDIntegrationModelgenTest extends ModelgenTest
{

   public CDToCDIntegrationModelgenTest()
   {
      super(CDToCDIntegrationPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("ClazzToClazzRule", 20);
   }

}
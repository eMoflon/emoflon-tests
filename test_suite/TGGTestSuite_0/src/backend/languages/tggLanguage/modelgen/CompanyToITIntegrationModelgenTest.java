package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import CompanyToITIntegration.CompanyToITIntegrationPackage;

public class CompanyToITIntegrationModelgenTest extends ModelgenTest
{

   public CompanyToITIntegrationModelgenTest()
   {
      super(CompanyToITIntegrationPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("CompanyToITRule", 20);
   }

}
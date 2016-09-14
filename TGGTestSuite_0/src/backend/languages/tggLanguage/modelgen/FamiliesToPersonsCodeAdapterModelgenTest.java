package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import FamiliesToPersonsCodeAdapter.FamiliesToPersonsCodeAdapterPackage;

public class FamiliesToPersonsCodeAdapterModelgenTest extends ModelgenTest
{

   public FamiliesToPersonsCodeAdapterModelgenTest()
   {
      super(FamiliesToPersonsCodeAdapterPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("FamilyRegisterToPersonsRegisterRule", 20);
   }

}
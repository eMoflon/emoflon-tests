package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import FamiliesToPersonsRefinementFlat.FamiliesToPersonsRefinementFlatPackage;

public class FamiliesToPersonsRefinementFlatModelgenTest extends ModelgenTest
{

   public FamiliesToPersonsRefinementFlatModelgenTest()
   {
      super(FamiliesToPersonsRefinementFlatPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("FamilyRegisterToPersonsRegisterRule", 20);
   }

}
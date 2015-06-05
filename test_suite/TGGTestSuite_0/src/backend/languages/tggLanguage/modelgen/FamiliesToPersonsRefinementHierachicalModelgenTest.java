package backend.languages.tggLanguage.modelgen;

import org.junit.Ignore;
import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import FamiliesToPersonsRefinementHierachical.FamiliesToPersonsRefinementHierachicalPackage;

public class FamiliesToPersonsRefinementHierachicalModelgenTest extends ModelgenTest
{

   public FamiliesToPersonsRefinementHierachicalModelgenTest()
   {
      super(FamiliesToPersonsRefinementHierachicalPackage.eINSTANCE);

   }

   //ignored because tgg refinement structure is not useful for modelgenerator
   @Ignore 
   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("FamilyRegisterToPersonsRegisterRule", 20);
   }

}
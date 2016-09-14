package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import ClassInhHier2DB.ClassInhHier2DBPackage;

public class ClassInhHier2DBModelgenTest extends ModelgenTest
{

   public ClassInhHier2DBModelgenTest()
   {
      super(ClassInhHier2DBPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("PackageToDatabaseRule", 20);
   }

}
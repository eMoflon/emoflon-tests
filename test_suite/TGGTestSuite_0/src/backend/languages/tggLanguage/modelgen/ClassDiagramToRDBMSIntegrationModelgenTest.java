package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import ClassDiagramToRDBMSIntegration.ClassDiagramToRDBMSIntegrationPackage;

public class ClassDiagramToRDBMSIntegrationModelgenTest extends ModelgenTest
{

   public ClassDiagramToRDBMSIntegrationModelgenTest()
   {
      super(ClassDiagramToRDBMSIntegrationPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("ClassDiagramToSchemaRule", 20);
   }

}
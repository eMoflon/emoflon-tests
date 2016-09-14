package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import BxSurveyClassDiagramToRDBMSIntegration.BxSurveyClassDiagramToRDBMSIntegrationPackage;

public class BxSurveyClassDiagramToRDBMSIntegrationModelgenTest extends ModelgenTest
{

   public BxSurveyClassDiagramToRDBMSIntegrationModelgenTest()
   {
      super(BxSurveyClassDiagramToRDBMSIntegrationPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("ClassDiagramToSchemaRule", 20);
   }

}
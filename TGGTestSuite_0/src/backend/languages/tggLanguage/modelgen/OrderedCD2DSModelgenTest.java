package backend.languages.tggLanguage.modelgen;

import org.junit.Test;
import org.moflon.testframework.tgg.ModelgenTest;

import OrderedCD2DS.OrderedCD2DSPackage;

public class OrderedCD2DSModelgenTest extends ModelgenTest
{

   public OrderedCD2DSModelgenTest()
   {
      super(OrderedCD2DSPackage.eINSTANCE);

   }

   @Test
   public void test_ModelsAreGenerated()
   {

      runDefaultModelgeneratorTest("ClazzDiagram2DatabaseRule", 20);
   }

}
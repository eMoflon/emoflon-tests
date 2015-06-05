package backend.languages.tggLanguage.edgeRules;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.core.utilities.eMoflonEMFUtil;

import MocaTree.MocaTreePackage;
import ProcessCodeAdapter_EdgeRules.ProcessCodeAdapter_EdgeRulesPackage;
import ProcessDefinition_EdgeRules.ProcessDefinition_EdgeRulesPackage;


public class TestProcessCodeAdapter extends IntegratorTest
{

   public TestProcessCodeAdapter()
   {
      super(MocaTreePackage.eINSTANCE, ProcessCodeAdapter_EdgeRulesPackage.eINSTANCE, ProcessDefinition_EdgeRulesPackage.eINSTANCE);
      eMoflonEMFUtil.init(ProcessDefinition_EdgeRulesPackage.eINSTANCE);
   }

   @Test
   public void testInvocationDifferentModule_BWD()
   {
      integrate("InvocationDifferentModule_BWD");
   }

   @Test
   public void testInvocationRecursive_BWD()
   {
      integrate("InvocationRecursive_BWD");
   }

   @Test
   public void testInvocationSameModule_BWD()
   {
      integrate("InvocationSameModule_BWD");
   }

   @Test
   public void testSystemModule_BWD()
   {
      integrate("SystemModule_BWD");
   }
   
}

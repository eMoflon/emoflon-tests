package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import LIFOStack.LIFOStackPackage;
import MocaTree.MocaTreePackage;
import StackCodeAdapter.StackCodeAdapterPackage;


public class TestStackCodeAdapter extends IntegratorTest
{

   public TestStackCodeAdapter()
   {
      super(LIFOStackPackage.eINSTANCE, 
    		  StackCodeAdapterPackage.eINSTANCE, 
    		  MocaTreePackage.eINSTANCE);
   }
   
   @Test
   public void testStackToFile_FWD() {
	   integrate("StackToFile_FWD");
   }
   
   @Test
   public void testEndToNode_FWD() {
	   integrate("EndToNode_FWD");
   }
   
   @Test
   public void testStackElementToNode_FWD() {
	   integrate("StackElementToNode_FWD");
   }
   
   @Test
   public void testStackToFile_BWD() {
	   integrate("StackToFile_BWD");
   }
   
   @Test
   public void testEndToNode_BWD() {
	   integrate("EndToNode_BWD");
   }
   
   @Test
   public void testStackElementToNode_BWD() {
	   integrate("StackElementToNode_BWD");
   }
   
}

package backend.languages.tggLanguage;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import BlockDiagram.BlockDiagramPackage;
import BlockDiagramCodeAdapter.BlockDiagramCodeAdapterPackage;
import MocaTree.MocaTreePackage;


public class TestBlockDiagramCodeAdapter extends IntegratorTest
{

   public TestBlockDiagramCodeAdapter()
   {
      super(BlockDiagramPackage.eINSTANCE, BlockDiagramCodeAdapterPackage.eINSTANCE, MocaTreePackage.eINSTANCE);
   }

   @Test 
   public void testBlockToNode_BWD() 
   { 
     integrate("BlockToNode_BWD"); 
   }

   @Test 
   public void testBlockToNode_FWD() 
   { 
     integrate("BlockToNode_FWD"); 
   }

   @Test 
   public void testConnectorToNode_BWD() 
   { 
     integrate("ConnectorToNode_BWD"); 
   }

   @Test 
   public void testConnectorToNode_FWD() 
   { 
     integrate("ConnectorToNode_FWD"); 
   }

   @Test 
   public void testProvideToNode_BWD() 
   { 
     integrate("ProvideToNode_BWD"); 
   }

   @Test 
   public void testProvideToNode_FWD() 
   { 
     integrate("ProvideToNode_FWD"); 
   }

   @Test 
   public void testRequireToNode_BWD() 
   { 
     integrate("RequireToNode_BWD"); 
   }

   @Test 
   public void testRequireToNode_FWD() 
   { 
     integrate("RequireToNode_FWD"); 
   }

   @Test 
   public void testSystemToNode_BWD() 
   { 
     integrate("SystemToNode_BWD"); 
   }

   @Test 
   public void testSystemToNode_FWD() 
   { 
     integrate("SystemToNode_FWD"); 
   }
   
   @Override
   public void compare(EObject expected, EObject created)
			throws InterruptedException {
		if (created instanceof MocaTree.File) {
			TreeComparator.compare((MocaTree.File) created,
					(MocaTree.File) expected);
		} else {
			super.compare(expected, created);
		}
	}

}

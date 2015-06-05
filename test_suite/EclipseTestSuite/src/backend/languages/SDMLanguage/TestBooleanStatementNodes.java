package backend.languages.SDMLanguage;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import BooleanStatementNodes.Block;
import BooleanStatementNodes.BooleanStatementNodesFactory;
import BooleanStatementNodes.Tower;

public class TestBooleanStatementNodes
{
   private Tower tower;
   private Block block0;
   private Block block1;
   private Block block2;

   @Before
   public void setUpTower(){
      tower = BooleanStatementNodesFactory.eINSTANCE.createTower();
      
      block0 = BooleanStatementNodesFactory.eINSTANCE.createBlock();
      block0.setSize(0);
      
      block1 = BooleanStatementNodesFactory.eINSTANCE.createBlock();
      block1.setSize(1);
      
      block2 = BooleanStatementNodesFactory.eINSTANCE.createBlock();
      block2.setSize(2);
      
      tower.getBlocks().add(block0);
      tower.getBlocks().add(block1);
      tower.getBlocks().add(block2);
   }
   
   @Test
   public void testValidTower(){
      block0.setNext(block1);
      block1.setNext(block2);
      
      Assert.assertTrue("Tower should be valid!", tower.validate());
   }
   
   @Test
   public void testInValidTower(){
      block0.setNext(block2);
      block2.setNext(block1);
      
      Assert.assertFalse("Tower should be invalid!", tower.validate());
   }
   
   @Test
   public void testEmptyTower(){
      Assert.assertTrue("Blocks are not connected so tower is per default valid!", tower.validate());
   }
   
   @Test
   public void testBranchOnNotNull(){
      Assert.assertTrue("Non-null return value should be interpreted as success", tower.validateNotNullButNotBool());
   }
   
   @Test
   public void testBranchWithVoid(){
      Assert.assertTrue("Void without branching is ok", tower.validateVoidWithoutBranch());
   }
}

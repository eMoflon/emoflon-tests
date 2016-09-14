package moca.util;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import org.moflon.moca.MocaUtil;
import static org.junit.Assert.assertEquals;

import MocaTree.Node;

public class CommonTree2MocaTree
{

   private CommonTree createCommonTree(String text) {
      return new CommonTree(new CommonToken(0,text));
   }
   
   /**
    * The root of a CommonTree cannot be a Text node.
    */
   @Test(expected = IllegalArgumentException.class)
   public void testInvalidCommonTree()
   {
      CommonTree tree = createCommonTree("TEXT");
      MocaUtil.commonTreeToMocaTree(tree);
   }
   
   /**
    * Test exceptions for invalid text nodes
    */
   @Test(expected = IllegalArgumentException.class)
   public void testInvalidTextNodes()
   {
      CommonTree root = createCommonTree("root");
      CommonTree text = createCommonTree("TEXT");
      root.addChild(text);
      text.addChild(createCommonTree("a"));
      text.addChild(createCommonTree("b"));
      MocaUtil.commonTreeToMocaTree(root);
   }
   
   /**
    * Test null token
    */
   @Test
   public void testNullToken() {
      CommonTree tree = new CommonTree();
      tree.token = null;
      Node node = MocaUtil.commonTreeToMocaTree(tree);
      assertEquals("",node.getName());
   }

}

package moca.util;

import static org.junit.Assert.*;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import org.moflon.moca.MocaUtil;

import MocaTree.Attribute;
import MocaTree.MocaTreeFactory;
import MocaTree.Node;
import MocaTree.Text;

public class MocaTree2CommonTree
{

   private Node createNode(String text)
   {
      Node node = MocaTreeFactory.eINSTANCE.createNode();
      node.setName(text);
      return node;
   }

   private Node createNode(String text, int index)
   {
      Node node = createNode(text);
      node.setIndex(index);
      return node;
   }

   private Text createText(String text)
   {
      Text textNode = MocaTreeFactory.eINSTANCE.createText();
      textNode.setName(text);
      return textNode;
   }

   private Attribute createAttribute(String name, String value, int index)
   {
      Attribute attribute = MocaTreeFactory.eINSTANCE.createAttribute();
      attribute.setName(name);
      attribute.setValue(value);
      attribute.setIndex(index);
      return attribute;
   }

   private Text createText(String text, int index)
   {
      Text textNode = createText(text);
      textNode.setIndex(index);
      return textNode;
   }

   /*
    * token list usually extractes from a tree grammar. user generated tokens
    * start with index 4
    */
   private static String[] tokenNames = new String[] { "", "", "", "", "ID", "STRING", "TEXT", "ATTRIBUTE" };

   /**
    * The root of a CommonTree cannot be a Text node.
    */
   @Test(expected = IllegalArgumentException.class)
   public void testInvalidTextRoot()
   {
      Text text = createText("a");
      CommonTree tree = MocaUtil.mocaTreeToCommonTree(text, new String[0]);
      System.out.println(tree.toStringTree());
   }

   /**
    * Test node and text transformation
    */
   @Test
   public void testNodeAndText()
   {
      Node node = createNode("root");
      Text text = createText("a");
      node.getChildren().add(text);
      CommonTree tree = MocaUtil.mocaTreeToCommonTree(node, tokenNames);
      assertEquals("(root (TEXT a))", tree.toStringTree());
   }

   /**
    * Test order with indices
    */
   @Test
   public void testOrdered1()
   {
      Node node = createNode("root");
      node.getChildren().add(createText("a", 2));
      node.getChildren().add(createText("b", 1));
      node.getChildren().add(createText("c", 0));
      CommonTree tree = MocaUtil.mocaTreeToCommonTree(node, tokenNames);
      assertEquals("(root (TEXT c) (TEXT b) (TEXT a))", tree.toStringTree());
   }

   /**
    * Test order with indices
    */
   @Test
   public void testOrdered2()
   {
      Node node = createNode("root");
      node.getChildren().add(createText("a", 2));
      node.getChildren().add(createNode("b", 1));
      node.getChildren().add(createText("c", 0));
      node.getAttribute().add(createAttribute("nameA", "valueA", 1));
      node.getAttribute().add(createAttribute("nameB", "valueB", 0));
      node.getAttribute().add(createAttribute("nameC", "valueC", 2));
      CommonTree tree = MocaUtil.mocaTreeToCommonTree(node, tokenNames);
      assertEquals("(root (ATTRIBUTE nameB valueB) (ATTRIBUTE nameA valueA) (ATTRIBUTE nameC valueC) (TEXT c) b (TEXT a))", tree.toStringTree());
   }

   /**
    * Test unordered MocaTree
    */
   @Test
   public void testUnordered()
   {
      Node node = createNode("root");
      node.getChildren().add(createText("a"));
      node.getChildren().add(createText("b"));
      node.getChildren().add(createText("c"));
      MocaUtil.mocaTreeToCommonTree(node, tokenNames);
   }
   
   /**
    * Test transformation of "null token"
    */
   @Test
   public void testNullToken() {
      Node node = createNode("");
      CommonTree tree = MocaUtil.mocaTreeToCommonTree(node, tokenNames);
      assertEquals(null, tree.token);
      assertEquals(0, tree.getChildCount());
   }
   
   

}

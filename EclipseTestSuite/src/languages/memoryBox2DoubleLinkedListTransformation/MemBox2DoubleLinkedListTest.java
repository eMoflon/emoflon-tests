package languages.memoryBox2DoubleLinkedListTransformation;


import static org.junit.Assert.assertEquals;
import languages.memoryBoxLanguage.MemBoxUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DoubleLinkedListLanguage.List;
import MemoryBoxLanguage.Box;
import MemoryBoxLanguage.MemoryBoxLanguageFactory;
import MemoryBoxToDoubleLinkedListTransformation.MemoryBoxToDoubleLinkedListTransformationFactory;
import MemoryBoxToDoubleLinkedListTransformation.Transformator;


public class MemBox2DoubleLinkedListTest
{

   @BeforeClass
   public static void setUpBeforeClass() throws Exception
   {
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception
   {
   }

   @Before
   public void setUp() throws Exception
   {
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void testAxiomMemBox2DLL(){
      // Create Box
      MemoryBoxLanguageFactory factory = MemoryBoxLanguageFactory.eINSTANCE;
      Box box = MemBoxUtil.createBoxWithPartitions(new int[] {10, 30, 90}, factory);
      box.setName("TestMemBox");
      
      // Fill in some cards
      String[] cardOne = { "hallo", "hello", "1" };
      String[] cardTwo = { "morgen", "morning", "1" };
      String[] cardThree = { "heute", "today", "1" };

      MemBoxUtil.fillPartitionWithCards(new String[][] {cardOne, cardTwo}, box.getContainedPartition().get(0), factory);
      MemBoxUtil.fillPartitionWithCards(new String[][] {cardThree}, box.getContainedPartition().get(1), factory);
      
      // Transform to List
      Transformator transformator = MemoryBoxToDoubleLinkedListTransformationFactory.eINSTANCE.createTransformator();
      
      List list = transformator.memBox2DLL(box);
      
      
      // Check created list
      assertEquals(3,list.getElements().size());
   }
}

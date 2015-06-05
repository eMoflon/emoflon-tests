package languages.memoryBoxLanguage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;

import MemoryBoxLanguage.Box;
import MemoryBoxLanguage.Card;
import MemoryBoxLanguage.MemoryBoxLanguageFactory;
import MemoryBoxLanguage.Partition;
import MemoryBoxLanguage.facade.FacadeFactory;
import MemoryBoxLanguage.facade.MemoryBoxUtil;

public class MemoryBoxText
{
   private MemoryBoxLanguageFactory memBoxFactory = MemoryBoxLanguageFactory.eINSTANCE;

   private Box box = null;

   private Partition partition0 = null;

   private Partition partition1 = null;

   private Partition partition2 = null;

   private Card helloCard = null;

   private MemoryBoxUtil helper = null;

   @Before
   public void prepareBox()
   {
      // Create box with three partitions
      box = MemBoxUtil.createBoxWithPartitions(new int[] { 1, 2, 3 }, memBoxFactory);

      // Set handles on partitions in box
      partition0 = box.getContainedPartition().get(0);
      partition1 = partition0.getNext();
      partition2 = partition1.getNext();

      // Fill cards into first partition
      String[] cardOne = { "hallo", "hello", "1" };
      String[] cardTwo = { "morgen", "morning", "1" };
      String[] cardThree = { "heute", "today", "1" };

      MemBoxUtil.fillPartitionWithCards(new String[][] { cardOne, cardTwo, cardThree }, partition0, memBoxFactory);

      // Set handle for card
      helloCard = partition0.getCard().get(0);

      // Create and set helper for MemBox
      helper = FacadeFactory.eINSTANCE.createMemoryBoxUtil();
   }

   @After
   public void cleanUpRepository()
   {
      eMoflonEMFUtil.remove(box);
   }

   @Test
   public void testGrow()
   {
      assertNull("Partition2 should be the last partition in the box", partition2.getNext());

      box.grow(helper);
      assertEquals("1,2,3,4,", MemBoxUtil.sizesOfBoxPartitionsToString(box));
      assertNotNull("Partition2 should now have a next partition", partition2.getNext());

      assertEquals(partition2.getNext().getPrevious(), partition0);

      box.grow(helper);
      assertEquals("1,2,3,4,5,", MemBoxUtil.sizesOfBoxPartitionsToString(box));
      assertNotNull("There should now be two partitions after partition2", partition2.getNext().getNext());

      assertEquals(partition2.getNext().getNext().getPrevious(), partition0);
   }

   @Test
   public void testCheck()
   {
      // use the method check on the first card in the first partition (
      // cardOne with hallo, hello and 1 )
      boolean returnVal = partition0.check(helloCard, "hello");

      // should be true
      assertTrue(returnVal);

      // cardOne should not be in partition 0 any longer (guess was correct!)
      assertEquals("(morgen,morning,1)(heute,today,1)", MemBoxUtil.partitionCardsToString(partition0));

      // cardOne should be in partition 1 (next partition)
      assertEquals("(hallo,hello,1)", MemBoxUtil.partitionCardsToString(partition1));

      assertEquals("Partition2 should be empty", 0, partition2.getCard().size());

      // second test: wrong guess
      returnVal = partition1.check(helloCard, "haello");

      // should be false
      assertFalse(returnVal);

      // card should be back in partition 0 now (wrong guess -> previous)
      assertEquals("(morgen,morning,1)(heute,today,1)(hallo,hello,1)", MemBoxUtil.partitionCardsToString(partition0));

      // partition 1 and 2 should be empty
      assertEquals(0, partition1.getCard().size());
      assertEquals(0, partition2.getCard().size());

      // Guess is correct, but card is not in the partition used to call check
      // - nothing should happen!
      returnVal = partition1.check(helloCard, "hello");

      // Guess was correct so return value is true
      assertTrue(returnVal);

      // But nothing changes since card was not in "this"
      assertEquals("(morgen,morning,1)(heute,today,1)(hallo,hello,1)", MemBoxUtil.partitionCardsToString(partition0));
      assertEquals(0, partition1.getCard().size());
      assertEquals(0, partition2.getCard().size());

      // Try moving a card beyond the last partition
      partition0.check(helloCard, "hello");
      partition1.check(helloCard, "hello");

      // Card should now be in partition2
      assertEquals("(hallo,hello,1)", MemBoxUtil.partitionCardsToString(partition2));
      assertEquals("(morgen,morning,1)(heute,today,1)", MemBoxUtil.partitionCardsToString(partition0));
      assertEquals(0, partition1.getCard().size());

      // Move once more (partition2 is the last partition in the box!)
      returnVal = partition2.check(helloCard, "hello");
      assertTrue(returnVal);

      // Card must however remain in partition2
      assertEquals("(hallo,hello,1)", MemBoxUtil.partitionCardsToString(partition2));

      // Try wrong guess on last partition
      returnVal = partition2.check(helloCard, "Salut");
      assertFalse(returnVal);

      // Check partitions (Wrong guess so card goes to previous partition)
      assertEquals(0, partition2.getCard().size());
      assertEquals(0, partition1.getCard().size());
      assertEquals("(morgen,morning,1)(heute,today,1)(hallo,hello,1)", MemBoxUtil.partitionCardsToString(partition0));

      // Try wrong guess on first partition (card must remain in partition)
      Card morgen = partition0.getCard().get(0);
      assertEquals("morgen", morgen.getFace());

      returnVal = partition0.check(morgen, "afternoon");
      assertFalse(returnVal);

      // Check partitions
      assertEquals(0, partition2.getCard().size());
      assertEquals(0, partition1.getCard().size());
      assertEquals("(morgen,morning,1)(heute,today,1)(hallo,hello,1)", MemBoxUtil.partitionCardsToString(partition0));
   }

   @Test
   public void testEmpty()
   {
      partition0.empty();
      assertEquals(0, partition0.getCard().size());
      assertEquals(0, partition1.getCard().size());
      assertEquals(0, partition2.getCard().size());
   }

   @Test
   public void testRemoveCard()
   {
      Card removed = partition0.removeCard(helloCard);

      assertEquals("(morgen,morning,1)(heute,today,1)", MemBoxUtil.partitionCardsToString(partition0));
      assertEquals("hallo", removed.getFace());
   }

   @Test
   public void testToString()
   {
      // Move cards around a bit
      assertTrue(partition0.check(helloCard, "hello"));

      box.toString(helper);

      String expected = "[===";
      for (Partition partition : box.getContainedPartition())
      {
         for (Card card : partition.getCard())
         {
            expected += "\n  [" + card.getFace() + " => " + card.getBack() + " :: in partition with size: " + partition.getPartitionSize() + "]";
         }
      }
      expected += "\n===]";
      
      assertEquals(expected, helper.getStringRep());
   }
   
   @Test
   public void testInvertCard()
   {
      for (Partition partition : box.getContainedPartition())
      {
         for (Card card : partition.getCard())
         {
            card.invert();
         }
      }

      assertEquals("(hello,hallo,1)(morning,morgen,1)(today,heute,1)", MemBoxUtil.partitionCardsToString(box.getContainedPartition().get(0)));
   }
}

package languages.memoryBoxLanguage;

import MemoryBoxLanguage.Box;
import MemoryBoxLanguage.Card;
import MemoryBoxLanguage.MemoryBoxLanguageFactory;
import MemoryBoxLanguage.Partition;

public class MemBoxUtil
{
   public static Box createBoxWithPartitions(int[] partitionSizes, MemoryBoxLanguageFactory factory)
   {
      Box box = factory.createBox();

      // Add isolated nodes
      for (int partitionSize : partitionSizes)
      {
         Partition partition = factory.createPartition();
         partition.setPartitionSize(partitionSize);
         box.getContainedPartition().add(partition);
      }

      // Create next links
      Partition previous = null;
      for (Partition partition : box.getContainedPartition())
      {
         if (previous != null)
            previous.setNext(partition);

         previous = partition;
      }

      // Create previous links (in a classical memory box all previous links
      // point to the first partition!)
      Partition first = box.getContainedPartition().get(0);
      for (Partition partition : box.getContainedPartition())
      {
         if (!partition.equals(first))
            partition.setPrevious(first);
      }

      return box;
   }
   
   public static Partition fillPartitionWithCards(String[][] cards, Partition partition, MemoryBoxLanguageFactory factory)
   {
      // Add single Cards and add to partition
      for (String[] cardSides : cards)
      {
         Card card = factory.createCard();
         card.setFace(cardSides[0]);
         card.setBack(cardSides[1]);
         card.setPartitionHistory(cardSides[2]);
         partition.getCard().add(card);
      }

      return partition;
   }

   // prints the partitionSizes of all partitions in the box
   public static String sizesOfBoxPartitionsToString(Box box)
   {
      String value = "";
      for (Partition partition : box.getContainedPartition())
      {
         value += partition.getPartitionSize() + ",";
      }
      return value;

   }

   // prints all cards in the partition in the format
   // (face,back,partitionHistory)(...
   public static String partitionCardsToString(Partition partition)
   {
      String value = "";
      for (Card card : partition.getCard())
      {
         value += "(" + card.getFace() + ",";
         value += card.getBack() + ",";
         value += card.getPartitionHistory() + ")";
      }

      return value;
   }
}

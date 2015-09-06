package backend.languages.TGGLanguage;

import java.io.IOException;

import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.testframework.tgg.IntegratorTest;

import DoubleLinkedListLanguage.DoubleLinkedListLanguageFactory;
import DoubleLinkedListLanguage.DoubleLinkedListLanguagePackage;
import DoubleLinkedListLanguage.List;
import DoubleLinkedListLanguage.Node;
import MemoryBoxLanguage.Box;
import MemoryBoxLanguage.MemoryBoxLanguageFactory;
import MemoryBoxLanguage.MemoryBoxLanguagePackage;
import MemoryBoxLanguage.Partition;
import MemoryBoxToDoubleLinkedListIntegration.MemoryBoxToDoubleLinkedListIntegrationPackage;

public class MemoryBoxToDoubleLinkedListIntegration extends IntegratorTest {

	public MemoryBoxToDoubleLinkedListIntegration() {
		super(MemoryBoxLanguagePackage.eINSTANCE, MemoryBoxToDoubleLinkedListIntegrationPackage.eINSTANCE,
				DoubleLinkedListLanguagePackage.eINSTANCE);
	}

	public static void main(String[] args) throws IOException {
		new MemoryBoxToDoubleLinkedListIntegration().createBigList(100);
		new MemoryBoxToDoubleLinkedListIntegration().createBigBoxConnected(100);
		new MemoryBoxToDoubleLinkedListIntegration().createBigBoxNotConnected(100);
	}

	private void createBigList(int size) throws IOException {
		List list = DoubleLinkedListLanguageFactory.eINSTANCE.createList();
		list.setName("Container");

		for (int i = 0; i < size; i++) {
			Node node = DoubleLinkedListLanguageFactory.eINSTANCE.createNode();
			node.setContainer(list);
		}

		eMoflonEMFUtil.saveModel(eMoflonEMFUtil.createDefaultResourceSet(), list,
				getExpectedpath() + getIntegrationName() + "/BigListExpected.xmi");
	}

	private void createBigBoxConnected(int size) throws IOException {
		Box box = MemoryBoxLanguageFactory.eINSTANCE.createBox();
		box.setName("Container");
		for (int i = 0; i < size; i++) {
			Partition partition = MemoryBoxLanguageFactory.eINSTANCE.createPartition();
			partition.setBox(box);
			partition.setIndex(i);
			partition.setPartitionSize(3);
			if (i > 0) {
				Partition previous = box.getContainedPartition().get(i - 1);
				previous.setNext(partition);
				partition.setPrevious(previous);
			}

		}

		eMoflonEMFUtil.saveModel(eMoflonEMFUtil.createDefaultResourceSet(), box, getFullInpath() + "PartitionToNode_FWD_big.xmi");
	}

	private void createBigBoxNotConnected(int size) throws IOException {
		Box box = MemoryBoxLanguageFactory.eINSTANCE.createBox();

		for (int i = 0; i < size; i++) {
			Partition p = MemoryBoxLanguageFactory.eINSTANCE.createPartition();
			p.setBox(box);
			p.setPartitionSize(3);
		}

		eMoflonEMFUtil.saveModel(eMoflonEMFUtil.createDefaultResourceSet(), box, getInpath() + "BigBoxCreatedin.xmi");
	}

	@Test
	public void testBoxToList_BWD_ListOnly() {
		integrate("BoxToList_BWD_ListOnly");
	}

	@Test
	public void testBoxToList_FWD() {
		integrate("BoxToList_FWD");
	}

	@Test
	public void testPartitionToNode_BWD() {
		integrate("PartitionToNode_BWD");
	}

	@Test
	public void testPartitionToNode_FWD() {
		integrate("PartitionToNode_FWD");
	}

}

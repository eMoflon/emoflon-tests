package backend.languages.folksonomy;

import org.eclipse.emf.ecore.EObject;
import org.junit.Ignore;
import org.junit.Test;
import org.moflon.moca.MocaTreeSorter;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import FolksonomyCodeAdapter.FolksonomyCodeAdapterPackage;
import FolksonomyLanguage.FolksonomyLanguagePackage;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;


public class SimpleRuleTests extends IntegratorTest {

	public SimpleRuleTests() {
		super(FolksonomyLanguagePackage.eINSTANCE,
			  FolksonomyCodeAdapterPackage.eINSTANCE,
			  MocaTreePackage.eINSTANCE);
	}
	
	@Test
	public void createFolder_FWD(){
		integrate("createFolder_FWD");
	}
	
	@Test
	public void createFolder_BWD(){
		integrate("createFolder_BWD");
	}
	
	@Test
	public void createUser_FWD(){
		integrate("createUser_FWD");
	}
	
	@Test
	public void createFriendship_FWD(){
		integrate("createFriendship_FWD");
	}
	
	@Test
	public void createItem_FWD(){
		integrate("createItem_FWD");
	}
	
	@Test
	public void createResource_FWD(){
		integrate("createResource_FWD");
	}

	@Test
	public void createTag_FWD(){
		integrate("createTag_FWD");
	}
	
	@Test
	public void createActivity_FWD(){
		integrate("createActivity_FWD");
	}
	
	@Test
	public void createSubActivity_FWD(){
		integrate("createSubActivity_FWD");
	}
	
	@Test
	@Ignore
	public void createActivityUser_FWD(){
		integrate("createActivityUser_FWD");
	}
	
	@Test
	@Ignore
	public void createActivityResourceUser_FWD(){
		integrate("createActivityResourceUser_FWD");
	}
	
	@Test
	@Ignore
	public void createResourceTagUser_FWD(){
		integrate("createResourceTagUser_FWD");
	}

	
	
	@Override
	public void postProcessing(EObject created) {
		// Sort created tree to simplify comparison
		if (created instanceof Folder){
			Folder folder = (Folder) created;
			MocaTreeSorter.sort(folder);
		}
	}
	
	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		if (created instanceof MocaTree.Folder) {
			TreeComparator.compare((MocaTree.Folder) created,
					(MocaTree.Folder) expected);
		} else {
			super.compare(expected, created);
		}
	}
	
}

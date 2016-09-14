package backend.languages.folksonomy;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.moca.MocaTreeSorter;
import org.moflon.testframework.tgg.IntegratorTest;

import FolksonomyCodeAdapter.FolksonomyCodeAdapterPackage;
import FolksonomyLanguage.FolksonomyLanguagePackage;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;

public class TestUsersAndFriendship extends IntegratorTest {

	public TestUsersAndFriendship() {
		super(FolksonomyLanguagePackage.eINSTANCE,
			  FolksonomyCodeAdapterPackage.eINSTANCE,
			  MocaTreePackage.eINSTANCE);
	}
	
	@Test
	public void testUserFriendship1(){
		integrate("usersAndFriends_FWD");
	}
	
	@Override
	public void postProcessing(EObject created) {
		// Sort created tree to simplify comparison
		Folder folder = (Folder) created;
		MocaTreeSorter.sort(folder);
	}
}

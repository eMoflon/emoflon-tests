package backend.languages.simpleEcoreToHtml;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.Folder;
import MocaTree.MocaTreePackage;
import SimpleEcoreToHTML.SimpleEcoreToHTMLPackage;

public class SimpleEcoreToHTMLTest_Batch extends IntegratorTest {

	public SimpleEcoreToHTMLTest_Batch() {
		super(EcorePackage.eINSTANCE, SimpleEcoreToHTMLPackage.eINSTANCE,
				MocaTreePackage.eINSTANCE);
	}

	@Test
	public void tggLanguage_FWD() {
		integrate("TGGLanguage_FWD");
	}

	@BeforeClass
	public static void logging() {
		BasicConfigurator.configure();
	}

	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {

		if (created instanceof MocaTree.Folder) {
			TreeComparator.compare((Folder) created, (Folder) expected);
		} else {
			super.compare(expected, created);
		}

	}
}

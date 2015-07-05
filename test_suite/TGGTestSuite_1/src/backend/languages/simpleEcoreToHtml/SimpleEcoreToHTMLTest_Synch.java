package backend.languages.simpleEcoreToHtml;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import DeltaCreator.DeltaCreatorFactory;
import DeltaCreator.DocumentFileTrgDelta;
import DeltaCreator.DocumentMethodTrgDelta;
import DeltaCreator.MoveMethodSrcDelta;
import MocaTree.File;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;
import SimpleEcoreToHTML.SimpleEcoreToHTMLPackage;
import TGGLanguage.algorithm.ApplicationTypes;

/**
 * Possible deltas to test for: ### Source delta: - add a method / remove a method - move a method (context free ->
 * should preserve documentation) - add a class / remove a class - move a class (context free -> should preserve
 * documentation) - add a package / remove a package - move a package (not context free -> should eliminate
 * documentation) ### Target deltas: - add documentation to package/class/method - (as above): create/remove/move
 * method/class/package
 * 
 * @author rkluge
 *
 */
public class SimpleEcoreToHTMLTest_Synch extends IncrementalIntegratorTest
{

	
   private DirectoryComparator directoryComparator;

   public SimpleEcoreToHTMLTest_Synch()
   {
      super(EcorePackage.eINSTANCE, SimpleEcoreToHTMLPackage.eINSTANCE, MocaTreePackage.eINSTANCE);
   }


	@BeforeClass
	public static void logging() {
		BasicConfigurator.configure();
	}

   
   @Before
	public void beforeTest() throws IOException {
		init();
	}
   
   /**
    * Adds documentation to a file. The synchronization should ignore the documentation, that is, the source model
    * should be unchanged.
    */
   @Test
   public void testDocumentRootFile() throws Exception
   {
	   setInputModel(ApplicationTypes.FORWARD, "TGGLanguage_FWD");

	   helper.integrateForward();

       helper.setChangeTrg(root -> {
         final DocumentFileTrgDelta delta = DeltaCreatorFactory.eINSTANCE.createDocumentFileTrgDelta();

         final Folder rootAsFolder = (Folder) root;
         final File docuFile = rootAsFolder.getFile().stream().filter(file -> file.getName().startsWith("__TGGLanguage.html")).findAny().get();

         delta.perform(docuFile, "TGGLanguage is the metamodel for TGG rules, the TGG compiler, and all required static analyses.");
      });
      helper.integrateBackward();

      saveOutput("TGGLanguageDocumentRootFile_BWD");
      compareWithExpected("TGGLanguageDocumentRootFile_BWD", ApplicationTypes.BACKWARD, helper.getSrc());
   }



   /**
    * On the source side, a package is renamed. On the target side, the method should be moved so that its documentation
    * is preserved.
    */
   @Test
   public void testMoveMethod() throws Exception
   {
	   setInputModel(ApplicationTypes.FORWARD, "TGGLanguage_FWD");

	   helper.integrateForward();

      final String sourcePackageName = "compiler";
      final String soureClassName = "TGGCompiler";

      final String targetPackageName = "analysis";
      final String targetClassName = "StaticAnalysis";

      final String methodName = "createStaticAnalysis";
      final String methodDocumentation = "Documentation for method createStaticAnalysis";

      documentMethod(sourcePackageName, soureClassName + ".html", methodName, methodDocumentation);

      helper.setChangeSrc(root -> {
         final MoveMethodSrcDelta delta = DeltaCreatorFactory.eINSTANCE.createMoveMethodSrcDelta();

         final EPackage rootAsEPackage = (EPackage) root;

         final EPackage compiler = rootAsEPackage.getESubpackages().stream().filter(pack -> pack.getName().equals(sourcePackageName)).findAny().get();
         final EClass tggCompiler = (EClass) compiler.getEClassifier(soureClassName);

         final EPackage analysis = rootAsEPackage.getESubpackages().stream().filter(pack -> pack.getName().equals(targetPackageName)).findAny().get();
         final EClass staticAnalysis = (EClass) analysis.getEClassifier(targetClassName);

         final EOperation method = tggCompiler.getEOperations().stream().filter(m -> m.getName().equals(methodName)).findAny().get();

         delta.perform(method, staticAnalysis);
      });
      helper.integrateForward();

      saveOutput("TGGLanguageMoveMethod_FWD");
      compareWithExpected("TGGLanguageMoveMethod_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
   }

   private void documentMethod(final String packageName, final String classFileName, final String methodName, final String methodDocumentation)
   {
      helper.setChangeTrg(root -> {
         final DocumentMethodTrgDelta delta = DeltaCreatorFactory.eINSTANCE.createDocumentMethodTrgDelta();

         final Folder rootAsFolder = (Folder) root;
         final Folder compilerFolder = rootAsFolder.getSubFolder().stream().filter(f -> f.getName().startsWith(packageName)).findAny().get();
         final File docuFile = compilerFolder.getFile().stream().filter(file -> file.getName().startsWith(classFileName)).findAny().get();

         delta.perform(docuFile, methodName, methodDocumentation);
      });

      helper.integrateBackward();
   }

   @Override
   public void compare(EObject expected, EObject created) throws InterruptedException
   {
      if(created instanceof MocaTree.Folder){
    	  TreeComparator.compare((Folder)created, (Folder)expected);
      }
      else{
    	  super.compare(expected, created);
      }
   }

}

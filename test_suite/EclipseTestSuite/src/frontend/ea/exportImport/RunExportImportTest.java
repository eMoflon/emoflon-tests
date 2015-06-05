package frontend.ea.exportImport;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.eclipse.emf.compare.util.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.compare.match.metamodel.*;
import org.eclipse.emf.compare.match.service.*;

public class RunExportImportTest
{
   private static final String pathToExe = "resources/exportImportTestData/exportImportExe/MOFLON2EAExportImportTest.exe";

   private static final String pathToXmiToTest = "resources/exportImportTestData/simpleClassWithSdm.ecore";

   private static final String pathToTemporaryEap = "resources/exportImportTestData/testeap.eap";

   private static File xmi;

   private static File eap;

   private static File exe;

   @BeforeClass
   public static void loadFiles()
   {
      xmi = new File(pathToXmiToTest);
      Assert.assertTrue(xmi.exists());

      exe = new File(pathToExe);
      Assert.assertTrue(exe.exists());

      // This is created by the test so no assertion
      eap = new File(pathToTemporaryEap);
   }

   @Test
   public void testImportExportCompare() throws Exception 
   {
      Runtime rt = Runtime.getRuntime();

      // Import ecore file to eap
      Process pr = rt.exec("\"" + exe.getAbsolutePath() + "\"" + " -i --xmi " + xmi.getAbsolutePath() + " --eap " + "\"" + eap.getAbsolutePath() + "\"");
      pr.waitFor();
      extractOutput(pr);

      // Export imported model from eap without codegen2 support
      // for codegen2 support add --codegen2
      pr = rt.exec("\"" + exe.getAbsolutePath() + "\"" + " -e --eap " + "\"" + eap.getAbsolutePath() + "\"");
      pr.waitFor();
      extractOutput(pr);

      // Compare original ecore to imported and exported ecore
      final ResourceSet resourceSet1 = new ResourceSetImpl();
      final ResourceSet resourceSet2 = new ResourceSetImpl();

      File file1 = new File(xmi.getAbsolutePath());
      File file2 = new File("resources/exportImportTestData/.temp/ecore.ecore");
      final EObject model1 = ModelUtils.load(file1, resourceSet1);
      final EObject model2 = ModelUtils.load(file2, resourceSet2);
      final MatchModel match = MatchService.doMatch(model1, model2, Collections.<String, Object> emptyMap());

      // If the list of unmatchesElemets has a size of zero the models are equivalent
      Assert.assertEquals(0, match.getUnmatchedElements().size());
   }

   private void extractOutput(Process pr) throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
      String line;
      while ((line = input.readLine()) != null)
         System.out.println(line);
      input.close();

      BufferedReader err = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
      line = "";
      while ((line = err.readLine()) != null)
         System.err.println(line);
      err.close();
   }

}

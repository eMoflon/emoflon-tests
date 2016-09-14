package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import Families.FamiliesPackage;
import FamiliesToPersonsRefinementHierachical.FamiliesToPersonsRefinementHierachicalPackage;
import Persons.PersonsPackage;


public class TestFamiliesToPersonsRefinementHierachical extends IntegratorTest
{

   public TestFamiliesToPersonsRefinementHierachical()
   {
      super(FamiliesPackage.eINSTANCE, FamiliesToPersonsRefinementHierachicalPackage.eINSTANCE, PersonsPackage.eINSTANCE);
   }

   @Test 
   public void testDaughtersToMember_BWD() 
   { 
     integrate("DaughtersToMember_BWD"); 
   }

   @Test 
   public void testDaughtersToMember_FWD() 
   { 
     integrate("DaughtersToMember_FWD"); 
   }

   @Test 
   public void testFamilyRegisterToPersonsRegister_BWD() 
   { 
     integrate("FamilyRegisterToPersonsRegister_BWD"); 
   }

   @Test 
   public void testFamilyRegisterToPersonsRegister_FWD() 
   { 
     integrate("FamilyRegisterToPersonsRegister_FWD"); 
   }

   @Test 
   public void testFatherToMember_BWD() 
   { 
     integrate("FatherToMember_BWD"); 
   }

   @Test 
   public void testFatherToMember_FWD() 
   { 
     integrate("FatherToMember_FWD"); 
   }

   @Test 
   public void testLargeFamily_BWD() 
   { 
     integrate("LargeFamily_BWD"); 
   }

   @Test 
   public void testLargeFamily_FWD() 
   { 
     integrate("LargeFamily_FWD"); 
   }

   @Test 
   public void testMotherToMember_BWD() 
   { 
     integrate("MotherToMember_BWD"); 
   }

   @Test 
   public void testMotherToMember_FWD() 
   { 
     integrate("MotherToMember_FWD"); 
   }

   @Test 
   public void testSonsToMember_BWD() 
   { 
     integrate("SonsToMember_BWD"); 
   }

   @Test 
   public void testSonsToMember_FWD() 
   { 
     integrate("SonsToMember_FWD"); 
   }

}

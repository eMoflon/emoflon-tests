package backend.languages.tggLanguage;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import ClassInhHier2DB.ClassInhHier2DBPackage;
import ClassInheritanceHierarchy.ClassInheritanceHierarchyPackage;
import Database.DatabasePackage;


public class TestClassInhHier2DB extends IntegratorTest
{

   public TestClassInhHier2DB()
   {
      super(ClassInheritanceHierarchyPackage.eINSTANCE, ClassInhHier2DBPackage.eINSTANCE, DatabasePackage.eINSTANCE);
   }

   @Test
   public void testAttributeToColumn2_BWD()
   {
      integrate("AttributeToColumn2_BWD");
   }
   
   @Test
   public void testAttributeToColumn2_FWD()
   {
      integrate("AttributeToColumn2_FWD");
   }

   @Test
   public void testAttributeToColumn_BWD()
   {
      integrate("AttributeToColumn_BWD");
   }

   @Test
   public void testAttributeToColumn_FWD()
   {
      integrate("AttributeToColumn_FWD");
   }

   @Test
   public void testClassToTable_BWD()
   {
      integrate("ClassToTable_BWD");
   }

   @Test
   public void testClassToTable_FWD()
   {
      integrate("ClassToTable_FWD");
   }

   @Test
   public void testLargeExample_BWD()
   {
      integrate("LargeExample_BWD");
   }

   @Test
   public void testLargeExample_FWD()
   {
      integrate("LargeExample_FWD");
   }

   @Test
   public void testPackageToDatabase_BWD()
   {
      integrate("PackageToDatabase_BWD");
   }

   @Test
   public void testPackageToDatabase_FWD()
   {
      integrate("PackageToDatabase_FWD");
   }

   @Test
   public void testSubClassToTable_BWD()
   {
      integrate("SubClassToTable_BWD");
   }

   @Test
   public void testSubClassToTable_FWD()
   {
      integrate("SubClassToTable_FWD");
   }

}

package backend.languages.tggLanguage.generator;

import java.io.File;
import java.io.FilenameFilter;

import org.antlr.stringtemplate.StringTemplate;

public class TestCaseGenerator
{
   
   public static void main(String[] args)
   {
      File dir = new File("./resources/tggLanguageTestData/in/FamiliesToPersonsCodeAdapter");
      File[] testCases = dir.listFiles(new FilenameFilter() {
         
         @Override
         public boolean accept(File dir, String name)
         {            
            return name.endsWith(".xmi");
         }
      });
      String result = "";
      for (int i = 0; i < testCases.length; i++)
      {
         StringTemplate st = new StringTemplate("@Test \npublic void test$name$() \n{ \n  integrate(\"$name$\"); \n}");
         String name = testCases[i].getName();
         name = name.substring(0, name.length()-4);
         st.setAttribute("name", name);
         result += st.toString() + "\n\n";
      }
      System.out.println(result);
      
   }
   
   

}

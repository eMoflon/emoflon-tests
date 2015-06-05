package util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test usage of StringEscapeUtils from apache commons. This functionality is for example used in
 * {@link SDMEcore2SDMFujaba} for handling literal expressions.
 * 
 * @author mwieber
 * @author (last editor) $Author$
 * @version $Revision$ $Date$
 */
public class TestJavaControlCharsStringEscaping
{

   @Test
   public void testEscapingAndUnescaping()
   {
      final String[] testData = { "", "hallo", ".", ";", "\\", "\"; System.out.println(\"hallo\"); String yqxwce = \"" };

      final String[] expectedResult = { "", "hallo", ".", ";", "\\\\", "\\\"; System.out.println(\\\"hallo\\\"); String yqxwce = \\\"" };

      int x = 0;
      for (String s : testData)
      {
         Assert.assertEquals(expectedResult[x++], StringEscapeUtils.escapeJava(s));
         Assert.assertEquals(s, StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJava(s)));
      }
   }
}

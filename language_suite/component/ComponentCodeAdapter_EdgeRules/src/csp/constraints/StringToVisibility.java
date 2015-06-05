package csp.constraints;

import java.util.HashMap;
import java.util.Map;

import ComponentLanguage_EdgeRules.Visibility;
import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class StringToVisibility extends TGGConstraintImpl
{

   private static Map<String, Visibility> string2Visibility;

   private static Map<Visibility, String> visibility2String;
   {
      string2Visibility = new HashMap<String, Visibility>();
      string2Visibility.put("+", Visibility.PUBLIC);
      string2Visibility.put("-", Visibility.PRIVATE);
      visibility2String = reverse(string2Visibility);
   }

   public void solve(Variable string, Variable visibility)
   {

      String bindingStates = getBindingStates(string, visibility);

      if (bindingStates.equals("BB"))
      {
         if (string2Visibility.containsKey(string))
         {
            setSatisfied(string2Visibility.get(string.getValue()).equals(visibility.getValue()));
         } else
         {
            setSatisfied(false);
         }
      } else if (bindingStates.equals("BF"))
      {
         visibility.setValue(string2Visibility.get(string.getValue()));
         setSatisfied(true);
      } else if (bindingStates.equals("FB"))
      {
         string.setValue(visibility2String.get(visibility.getValue()));
         setSatisfied(true);
      }
   }

   private <K, V> Map<V, K> reverse(Map<K, V> map)
   {
      Map<V, K> result = new HashMap<V, K>();
      for (K key : map.keySet())
      {
         result.put(map.get(key), key);
      }
      return result;
   }

}

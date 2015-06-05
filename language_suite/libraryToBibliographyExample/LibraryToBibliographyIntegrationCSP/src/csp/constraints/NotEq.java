package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class NotEq extends Eq
{
   public void solve(Variable var_0, Variable var_1)
   {
      String bindingStates = getBindingStates(var_0, var_1);

      switch (bindingStates)
      {
      case "BB":

         if (var_0.getValue() instanceof Number)
         {
            Number a = (Number) var_0;
            Number b = (Number) var_1;
            setSatisfied(a != b);
         } else
         {
            setSatisfied(!var_0.getValue().equals(var_1.getValue()));
         }
         break;

      default:
         throw new UnsupportedOperationException("This case in the constraint has not been implemented yet: " + bindingStates);
      }

   }
}
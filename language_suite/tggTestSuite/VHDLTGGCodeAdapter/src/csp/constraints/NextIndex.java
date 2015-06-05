package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class NextIndex extends TGGConstraintImpl
{

   public void solve(Variable index) {
      index.setValue(new Integer(0));
      setSatisfied(true);
      index.setBound(true);
   }
   
}

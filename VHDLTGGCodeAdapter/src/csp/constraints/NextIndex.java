package csp.constraints;

import org.moflon.tgg.language.csp.Variable;
import org.moflon.tgg.language.csp.impl.TGGConstraintImpl;

public class NextIndex extends TGGConstraintImpl
{

   public void solve(Variable index) {
      index.setValue(new Integer(0));
      setSatisfied(true);
      index.setBound(true);
   }
   
}

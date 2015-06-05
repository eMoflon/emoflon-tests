package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class SetStandardValue extends TGGConstraintImpl {
   public void solve(Variable var_0, Variable var_1){
    String bindingStates = getBindingStates(var_0, var_1);
    
    switch(bindingStates){
    case "BB":
		setSatisfied(true);
    break;
    case "FB":
    	var_0.setValue(var_1.getValue());
		setSatisfied(true);
    break;
    case "BF":
		setSatisfied(true);
    break;
    }
    
  }  
}
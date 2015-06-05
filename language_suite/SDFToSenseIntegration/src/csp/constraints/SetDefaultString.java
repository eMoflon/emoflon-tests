package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class SetDefaultString extends TGGConstraintImpl {
	public void solve(Variable var_0, Variable var_1){
    	String bindingStates = getBindingStates(var_0, var_1);
    	
    	switch(bindingStates){
    	case "FB":
    		var_0.setValue(var_1.getValue());
    		var_0.setBound(true);
    		setSatisfied(true);
    		break;
    	case "BB":
    		setSatisfied(true);
    		break;
    	}
    	
  	}	  
}
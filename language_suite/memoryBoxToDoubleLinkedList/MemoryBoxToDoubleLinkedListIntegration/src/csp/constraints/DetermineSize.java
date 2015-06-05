package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class DetermineSize extends TGGConstraintImpl {
	public void solve(Variable var_0){
    	String bindingStates = getBindingStates(var_0);
    	
    	switch(bindingStates){
    	case "F":
    		var_0.setValue(3);
    		setSatisfied(true);
    	case "B": 
    		setSatisfied(((Number) var_0.getValue()).intValue() == 3);
    	}
    	
  	}	  
}
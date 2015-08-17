package csp.constraints;

import org.moflon.tgg.language.csp.Variable;
import org.moflon.tgg.language.csp.impl.TGGConstraintImpl;

public class SmallToCapital extends TGGConstraintImpl {
	public void solve(Variable var_0, Variable var_1){
    	String bindingStates = getBindingStates(var_0, var_1);
    	
    	switch(bindingStates){
    	case "BB":
    		setSatisfied(((String) var_0.getValue()).equalsIgnoreCase((String) var_1.getValue()));
    		break;
    	case "BF":
    		var_1.setValue(((String) var_0.getValue()).toUpperCase());
    		var_1.setBound(true);
    		setSatisfied(true);
    		break;
    	case "FB":
    		var_0.setValue(((String) var_1.getValue()).toLowerCase());
    		var_0.setBound(true);
    		setSatisfied(true); 
    	}
    	
  	}	  
}
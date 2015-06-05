package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class SetAttributeTypeString extends TGGConstraintImpl {
	public void solve(Variable var_0){
    	String bindingStates = getBindingStates(var_0);
    	
    	switch(bindingStates){
    	case "F":
    		var_0.bindToValue(SimaticML.AttributeTypes.STRING);
    		setSatisfied(true);
    		break;
    	case "B":
    		setSatisfied(var_0.getValue().equals(SimaticML.AttributeTypes.STRING));
    		break;
    	default: 
    		throw new UnsupportedOperationException("This case in the constraint has not been implemented yet: " + bindingStates);
    	}
  	}	  
}
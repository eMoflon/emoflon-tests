package OSCAx.csp.constraints;

import org.moflon.tgg.language.csp.Variable;
import org.moflon.tgg.language.csp.impl.TGGConstraintImpl;

public class SetAttributeTypeInteger extends TGGConstraintImpl {
	public void solve(Variable var_0){
    	String bindingStates = getBindingStates(var_0);
    	
    	switch(bindingStates){
    	case "F":
    		var_0.bindToValue(SimaticML.AttributeTypes.INTEGER);
    		setSatisfied(true);
    		break;
    	case "B":
    		setSatisfied(var_0.getValue().equals(SimaticML.AttributeTypes.INTEGER));
    		break;
    	default: 
    		throw new UnsupportedOperationException("This case in the constraint has not been implemented yet: " + bindingStates);
    	}

  	}	  
}
package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.ConstraintImpl;

public class Eq_gen extends ConstraintImpl {
	public void solve(Variable<String> var_0, Variable<String> var_1){
    	String bindingStates = getBindingStates(var_0, var_1);
    
    	switch(bindingStates){
    	case "FF":
    		String random = getRandomString(5);
    		var_0.setValue(random);
    		var_1.setValue(random);
    		
    		var_0.setBound(true);
    		var_1.setBound(true);
    		setSatisfied(true);
    		break;
    	default:
    		Eq<String> eq = new Eq<>();
    		eq.solve(var_0, var_1);
    		setSatisfied(eq.isSatisfied());
    	}
  	}

	private String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<length; i++){
			buffer.append((char)(Math.random()*('Z'-'A'+1)+'A'));
		}
		return buffer.toString();
	}	  
}
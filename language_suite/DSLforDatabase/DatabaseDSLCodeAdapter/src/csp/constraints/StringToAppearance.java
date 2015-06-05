package csp.constraints;

import java.util.Random;

import DatabaseDSL.Appearance;
import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.ConstraintImpl;

public class StringToAppearance extends ConstraintImpl {
	
	private static String[] strings = {"-", "!", "*", "?", "+"};
	private static Appearance[] appearances = {Appearance.NONE, Appearance.EXACTLY_ONCE, Appearance.ZERO_OR_MORE, Appearance.ZERO_OR_ONCE, Appearance.ONE_OR_MORE};
	
	private static Random random = new Random();
	
	public void solve(Variable<String> var_0, Variable<DatabaseDSL.Appearance> var_1){
		
    	String bindingStates = getBindingStates(var_0, var_1);
    	
    	switch(bindingStates){
    	case "BB":
    		for(int i = 0; i < strings.length; i++){
    			if(var_0.getValue().equals(strings[i])){
    				setSatisfied(var_1.getValue().equals(appearances  [i]));
    				return;
    			}
    		}
    		
    		break;
    	case "BF":
    		for(int i = 0; i < strings.length; i++){
    			if(var_0.getValue().equals(strings[i])){
    				var_1.setValue(appearances[i]);
    				setSatisfied(true);
    				return;
    			}
    		}
    		
    		break;
    	case "FB":
    		for(int i = 0; i < appearances.length; i++){
    			if(var_1.getValue().equals(appearances[i])){
    				var_0.setValue(strings[i]);
    				setSatisfied(true);
    				return;
    			}
    		}
    		
    		break;
    	case "FF":
    		int randomInt = random.nextInt(5);
    		var_0.setValue(strings[randomInt]);
    		var_1.setValue(appearances[randomInt]);
    		setSatisfied(true);
    		
    		break;
    	}
    	
  	}	  
}
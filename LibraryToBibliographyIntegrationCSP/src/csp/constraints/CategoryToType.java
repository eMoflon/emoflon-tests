package csp.constraints;

import BibliographyLanguageCSP.PaperTypes;
import org.moflon.tgg.language.csp.Variable;
import org.moflon.tgg.language.csp.impl.TGGConstraintImpl;

public class CategoryToType extends TGGConstraintImpl {
   public void solve(Variable category, Variable type){
    String bindingStates = getBindingStates(category, type);
    
    switch(bindingStates){
    case "BB":
    	if(category.getValue().equals(((PaperTypes) type.getValue()).getName()))
    		satisfied = true;
    	else
    		satisfied = false;
    break;
    case "BF":
    	type.setValue(BibliographyLanguageCSP.PaperTypes.UNKNOWN);
    	satisfied = true;
    break;
    case "FB":
    	category.setValue(((PaperTypes) type.getValue()).getName());
    	satisfied = true;
    break;
    }
    
  }  
}
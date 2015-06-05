package csp.constraints;

import java.math.BigDecimal;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class StringToBigDecimal extends TGGConstraintImpl {
	public void solve(Variable var_0, Variable var_1) {
		String bindingStates = getBindingStates(var_0, var_1);

		switch (bindingStates) {
		case "BB": {
			String stringVal = (String) var_0.getValue();
			String numberAsString = var_1.getValue().toString();

			setSatisfied(stringVal.compareTo(numberAsString) == 0);
			break;
		}
		case "BF": {
			String stringVal = (String) var_0.getValue();
			BigDecimal numberVal = new BigDecimal(stringVal);
			var_1.setValue(numberVal);
			var_1.setBound(true);

			setSatisfied(true);
			break;
		}
		case "FB": {
			BigDecimal numberVal = (BigDecimal) var_1.getValue();
			String stringVal = numberVal.toString();
			var_0.setValue(stringVal);
			var_0.setBound(true);
			
			setSatisfied(true);
			break;
		}
		
		}

	}
}
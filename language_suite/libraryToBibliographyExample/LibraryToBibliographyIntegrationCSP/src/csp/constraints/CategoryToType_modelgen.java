package csp.constraints;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.TGGConstraintImpl;

public class CategoryToType_modelgen extends CategoryToType {
	public void solve(Variable var_0, Variable var_1) {
		String bindingStates = getBindingStates(var_0, var_1);

		if (bindingStates.equals("FF")) {
			// TODO Implement BB-operation
			throw new UnsupportedOperationException(
					"This case in the constraint has not been implemented yet.");
		} else {
			super.solve(var_0, var_1);
		}

	}
}
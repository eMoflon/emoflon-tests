package csp.constraints;

import org.moflon.tgg.language.csp.Variable;

public class SetDefaultString_modelgen extends SetDefaultString {
	public void solve(Variable var_0, Variable var_1) {
		String bindingStates = getBindingStates(var_0, var_1);

		if (bindingStates.equals("FF")) {
			throw new UnsupportedOperationException(
					"This case in the constraint has not been implemented yet.");
		} else {
			super.solve(var_0, var_1);
		}

	}
}
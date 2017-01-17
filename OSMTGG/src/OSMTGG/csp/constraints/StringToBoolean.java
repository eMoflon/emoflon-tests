package OSMTGG.csp.constraints;

import org.moflon.tgg.language.csp.Variable;
import org.moflon.tgg.language.csp.impl.TGGConstraintImpl;

public class StringToBoolean extends TGGConstraintImpl {
	public void solve(Variable var_0, Variable var_1) {
		String bindingStates = getBindingStates(var_0, var_1);

		switch (bindingStates) {
		case "BB": {
			setSatisfied(new Boolean((String) var_0.getValue()).equals(var_1.getValue()));
			break;
		}
		case "BF": {
			var_1.setValue(new Boolean((String) var_0.getValue()));
			setSatisfied(true);
			break;
		}
		case "FB":
			var_0.setValue(var_1.getValue().toString());
			setSatisfied(true);
			break;
		}

	}
}
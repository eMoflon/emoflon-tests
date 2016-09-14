package csp.constraints;

import java.util.Random;

import TGGLanguage.csp.Variable;
import TGGLanguage.csp.impl.ConstraintImpl;

public class StringToMode extends ConstraintImpl {

	private final static String[] strings = { "r", "rw" };
	private final static DatabaseDSL.Mode[] modes = { DatabaseDSL.Mode.READ,
			DatabaseDSL.Mode.READ_WRITE };

	private static Random random = new Random();

	public void solve(Variable<String> var_0, Variable<DatabaseDSL.Mode> var_1) {
		String bindingStates = getBindingStates(var_0, var_1);

		switch (bindingStates) {
		case "FF":
			int randomInt = random.nextInt(2);
			var_0.setValue(strings[randomInt]);
			var_1.setValue(modes[randomInt]);
			setSatisfied(true);
			break;
		case "BB":
			for (int i = 0; i < strings.length; i++) {
				if (var_0.getValue().equals(strings[i])) {
					setSatisfied(var_1.getValue().equals(modes[i]));
					return;
				}
			}
			break;
		case "FB":
			for (int i = 0; i < modes.length; i++) {
				if (var_1.getValue().equals(modes[i])) {
					var_0.setValue(strings[i]);
					setSatisfied(true);
					return;
				}
			}
			break;
		case "BF":
			for (int i = 0; i < strings.length; i++) {
				if (var_0.getValue().equals(strings[i])) {
					var_1.setValue(modes[i]);
					setSatisfied(true);
					return;
				}
			}
			break;
		}

	}
}
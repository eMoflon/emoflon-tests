package BxSurveyClassDiagramToRDBMSIntegration.csp.constraints;

import org.moflon.tgg.csp.constraints.Concat;
import org.moflon.tgg.csp.constraints.generator.Generator;
import org.moflon.tgg.language.csp.Variable;

public class Concat_specific extends Concat
{
   public void solve(Variable var_0, Variable var_1, Variable var_2, Variable var_3)
   {
      String bindingStates = getBindingStates(var_0, var_1, var_2, var_3);

      switch (bindingStates)
      {
      case "BFFF":
         var_1.bindToValue(Generator.getNewRandomString("string"));
         var_2.bindToValue(Generator.getNewRandomString("number"));
         var_3.bindToValue((String) var_1.getValue() + var_0.getValue() + var_2.getValue());
         setSatisfied(true);
         return;
      default:
         super.solve(var_0, var_1, var_2, var_3);
      }

   }
}
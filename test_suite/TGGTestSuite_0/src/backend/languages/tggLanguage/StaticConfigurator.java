package backend.languages.tggLanguage;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.moflon.tgg.algorithm.configuration.Configurator;
import org.moflon.tgg.algorithm.configuration.MatchInfo;
import org.moflon.tgg.algorithm.configuration.RuleResult;

import CompanyLanguage.Employee;

public class StaticConfigurator implements Configurator {

	@Override
	public RuleResult chooseOne(Collection<RuleResult> alternatives) {
		alternatives.forEach(rr -> rr.restrictMatchesTo(this::condition));

		return alternatives.stream().filter(rr -> !rr.isEmpty())
				.findAny() 
				.orElse(Configurator.super.chooseOne(alternatives));
	}

	private boolean condition(MatchInfo m) {
		EObject employee = m.getMatchedObject("employee");
		
		if (employee != null) {
			String employeeName = ((Employee) employee).getName();

			return (employeeName.equals("Tony")   && m.isRule("EmployeeToLaptopRule")) ||
			       (employeeName.equals("Marius") && m.isRule("EmployeeToPCRule"));
		}

		return false;
	}
}
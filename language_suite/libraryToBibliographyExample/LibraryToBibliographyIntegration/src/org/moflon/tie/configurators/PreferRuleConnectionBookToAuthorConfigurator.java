package org.moflon.tie.configurators;

import java.util.Collection;

import org.moflon.tgg.algorithm.configuration.Configurator;
import org.moflon.tgg.algorithm.configuration.RuleResult;

public class PreferRuleConnectionBookToAuthorConfigurator implements
		Configurator {

	@Override
	public RuleResult chooseOne(Collection<RuleResult> alternatives) {
		return alternatives.stream()
				.filter(rr -> rr.isRule("RuleConnectionBookToAuthor"))
				.findAny().orElse(Configurator.super.chooseOne(alternatives));
	}
}

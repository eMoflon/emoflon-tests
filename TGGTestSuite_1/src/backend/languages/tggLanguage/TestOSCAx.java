package backend.languages.tggLanguage;

import java.util.Collection;

import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.tgg.algorithm.configuration.Configurator;
import org.moflon.tgg.algorithm.configuration.MatchInfo;
import org.moflon.tgg.algorithm.configuration.RuleResult;

import OSCAx.OSCAxPackage;
import Ortssicht.Module;
import Ortssicht.OrtssichtPackage;
import SimaticML.SimaticMLPackage;

public class TestOSCAx extends IntegratorTest {

	public TestOSCAx() {
		super(OrtssichtPackage.eINSTANCE, OSCAxPackage.eINSTANCE,
				SimaticMLPackage.eINSTANCE);
	}

	@Test
	public void testSimpleOStoCAx_FWD() {
		setConfigurator(new OSCAxConfigurator());

		integrate("OSCAx_FWD");
	}
}

class OSCAxConfigurator implements Configurator {

	@Override
	public RuleResult chooseOne(Collection<RuleResult> alternatives) {
		alternatives.stream().forEach(
				rr -> rr.restrictMatchesTo(this::isProperMatch));

		return alternatives.stream().filter(rr -> !rr.isEmpty()).findAny()
				.orElse(Configurator.super.chooseOne(alternatives));
	}

	private boolean isProperMatch(MatchInfo m) {
		if (m.isRule("Module2DeviceItemCPU"))
			return ((Module) m.getMatchedObject("module")).getName()
					.startsWith("CPU");

		if (m.isRule("Module2DeviceItemT"))
			return !((Module) m.getMatchedObject("module")).getName()
					.startsWith("CPU");

		return true;
	}
}
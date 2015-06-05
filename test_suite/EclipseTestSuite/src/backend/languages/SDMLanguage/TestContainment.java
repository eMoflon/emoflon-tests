package backend.languages.SDMLanguage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import DoubleContainer.Contained;
import DoubleContainer.Container;
import DoubleContainer.DoubleContainerFactory;


public class TestContainment {

	@Test
	public void test() {
		Container cont = DoubleContainerFactory.eINSTANCE.createContainer();
		Contained contained = DoubleContainerFactory.eINSTANCE.createContained();
		
		cont.setContained2(contained);
		assertFalse(contained.testContainment1());
		assertTrue(contained.testContainment2());

		DoubleContainer.System system = DoubleContainerFactory.eINSTANCE.createSystem();
		system.getElements().add(contained);
		system.getElements().add(cont);
		
		assertTrue(system.testUnboundContainer());
		
		cont.getContained1().add(contained);
		assertTrue(contained.testContainment1());
		assertFalse(contained.testContainment2());
		
		assertFalse(system.testUnboundContainer());
	}

}

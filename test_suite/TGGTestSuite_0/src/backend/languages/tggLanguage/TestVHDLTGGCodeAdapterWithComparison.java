package backend.languages.tggLanguage;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import MocaTree.File;
import MocaTree.MocaTreePackage;
import MocaTree.Node;
import MocaTree.Text;
import VHDLModel.AndGate;
import VHDLModel.CompositeBlock;
import VHDLModel.InputPort;
import VHDLModel.OrGate;
import VHDLModel.OutputPort;
import VHDLModel.Port;
import VHDLModel.VHDLModelPackage;
import VHDLModel.VHDLSpecification;
import VHDLTGGCodeAdapter.VHDLTGGCodeAdapterPackage;


public class TestVHDLTGGCodeAdapterWithComparison extends IntegratorTest {

	public TestVHDLTGGCodeAdapterWithComparison() {
		super(MocaTreePackage.eINSTANCE, VHDLTGGCodeAdapterPackage.eINSTANCE,
				VHDLModelPackage.eINSTANCE);
	}

	/**
	 * In this test case, EMFCompareUtil is not reliable. Thus, the assertions
	 * are done manually
	 */
	@Test
	public void testAndGate_BWD() {
		integrate("AndGate_BWD");
		File file = (File) getHelper().getSrc();
		Node vhdl = file.getRootNode();
		Node gate = null;
		for (Text child : vhdl.getChildren()) {
			if (child.getName().equals("GATE"))
				gate = (Node) child;
		}
		Assert.assertNotNull(gate);
		Node example = null;
		Node externalOutput = null;
		for (Text child : gate.getChildren()) {
			if (child.getName().equals("Example"))
				example = (Node) child;
			if (child.getName().equals("ExternalOutput"))
				externalOutput = (Node) child;
		}

		Assert.assertNotNull(example);
		Assert.assertNotNull(externalOutput);

		Node and = (Node) externalOutput.getChildren().get(0);

		Node externalInput1 = null;
		Node externalInput2 = null;
		for (Text child : and.getChildren()) {
			if (child.getName().equals("ExternalInput1"))
				externalInput1 = (Node) child;
			if (child.getName().equals("ExternalInput2"))
				externalInput2 = (Node) child;
		}
		Assert.assertNotNull(externalInput1);
		Assert.assertEquals(0, externalInput1.getIndex());
		Assert.assertNotNull(externalInput2);
		Assert.assertEquals(1, externalInput2.getIndex());

	}

	/**
	 * In this test case, EMFCompareUtil is not reliable. Thus, the assertions
	 * are done manually
	 */
	@Test
	public void testAndGate_FWD() {
		integrate("AndGate_FWD");

		VHDLSpecification spec = (VHDLSpecification) getHelper().getTrg();

		CompositeBlock block = null;
		for (CompositeBlock cb : spec.getBlocks()) {
			if (cb.getName().equals("Example"))
				block = cb;
		}
		Assert.assertNotNull(block);

		InputPort externalInput1 = null;
		InputPort externalInput2 = null;
		OutputPort externalOutput = null;

		for (Port port : block.getPorts()) {
			String portName = port.getName();
			if (portName.equals("ExternalInput1"))
				externalInput1 = (InputPort) port;
			if (portName.equals("ExternalInput2"))
				externalInput2 = (InputPort) port;
			if (portName.equals("ExternalOutput"))
				externalOutput = (OutputPort) port;
		}
		Assert.assertNotNull(externalInput1);
		Assert.assertNotNull(externalInput2);
		Assert.assertNotNull(externalOutput);

		AndGate andGate = (AndGate) block.getBlocks().get(0);
		Assert.assertNotNull(andGate);

		InputPort andIn1 = andGate.getInputport1();
		InputPort andIn2 = andGate.getInputport2();
		OutputPort andOut = andGate.getOutputport();

		Assert.assertNotNull(andIn1);
		Assert.assertNotNull(andIn2);
		Assert.assertNotNull(andOut);
		Assert.assertEquals("AND.in1", andIn1.getName());
		Assert.assertEquals("AND.in2", andIn2.getName());
		Assert.assertEquals("AND.out", andOut.getName());
		Assert.assertEquals(andIn1.getSrc(), externalInput1);
		Assert.assertEquals(andIn2.getSrc(), externalInput2);
		Assert.assertEquals(externalOutput.getSrc(), andOut);
	}

	@Test
	public void testOrGate_BWD() {
		integrate("OrGate_BWD");
		File file = (File) getHelper().getSrc();
		Node vhdl = file.getRootNode();
		Node gate = null;
		for (Text child : vhdl.getChildren()) {
			if (child.getName().equals("GATE"))
				gate = (Node) child;
		}
		Assert.assertNotNull(gate);
		Node example = null;
		Node externalOutput = null;
		for (Text child : gate.getChildren()) {
			if (child.getName().equals("Example"))
				example = (Node) child;
			if (child.getName().equals("ExternalOutput"))
				externalOutput = (Node) child;
		}

		Assert.assertNotNull(example);
		Assert.assertNotNull(externalOutput);

		Node or = (Node) externalOutput.getChildren().get(0);

		Node externalInput1 = null;
		Node externalInput2 = null;
		for (Text child : or.getChildren()) {
			if (child.getName().equals("ExternalInput1"))
				externalInput1 = (Node) child;
			if (child.getName().equals("ExternalInput2"))
				externalInput2 = (Node) child;
		}
		Assert.assertNotNull(externalInput1);
		Assert.assertEquals(0, externalInput1.getIndex());
		Assert.assertNotNull(externalInput2);
		Assert.assertEquals(1, externalInput2.getIndex());
	}

	/**
	 * In this test case, EMFCompareUtil is not reliable. Thus, the assertions
	 * are done manually
	 */
	@Test
	public void testOrGate_FWD() {
		integrate("OrGate_FWD");

		VHDLSpecification spec = (VHDLSpecification) getHelper().getTrg();

		CompositeBlock block = null;
		for (CompositeBlock cb : spec.getBlocks()) {
			if (cb.getName().equals("Example"))
				block = cb;
		}
		Assert.assertNotNull(block);

		InputPort externalInput1 = null;
		InputPort externalInput2 = null;
		OutputPort externalOutput = null;

		for (Port port : block.getPorts()) {
			String portName = port.getName();
			if (portName.equals("ExternalInput1"))
				externalInput1 = (InputPort) port;
			if (portName.equals("ExternalInput2"))
				externalInput2 = (InputPort) port;
			if (portName.equals("ExternalOutput"))
				externalOutput = (OutputPort) port;
		}
		Assert.assertNotNull(externalInput1);
		Assert.assertNotNull(externalInput2);
		Assert.assertNotNull(externalOutput);

		OrGate orGate = (OrGate) block.getBlocks().get(0);
		Assert.assertNotNull(orGate);

		InputPort orIn1 = orGate.getInputport1();
		InputPort orIn2 = orGate.getInputport2();
		OutputPort orOut = orGate.getOutputport();

		Assert.assertNotNull(orIn1);
		Assert.assertNotNull(orIn2);
		Assert.assertNotNull(orOut);
		Assert.assertEquals("OR.in1", orIn1.getName());
		Assert.assertEquals("OR.in2", orIn2.getName());
		Assert.assertEquals("OR.out", orOut.getName());
		Assert.assertEquals(orIn1.getSrc(), externalInput1);
		Assert.assertEquals(orIn2.getSrc(), externalInput2);
		Assert.assertEquals(externalOutput.getSrc(), orOut);
	}
	
	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		// Comparison is test-specific
	}

}

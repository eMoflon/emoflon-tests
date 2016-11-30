package MocaToMoflonAttributeConstrTestSuite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;

import MocaToMoflonAttributeConstrTestGenerator.TestGenerator.TestGeneratorPackage;
import MocaToMoflonAttributeConstrTestGenerator.TestLanguage.TestLanguagePackage;
import SDMLanguage.SDMLanguagePackage;
import SDMLanguage.activities.ActivityNode;
import SDMLanguage.activities.MoflonEOperation;
import SDMLanguage.activities.StoryNode;
import SDMLanguage.patterns.StoryPattern;
import SDMLanguage.patterns.AttributeConstraints.AssignmentConstraint;
import SDMLanguage.patterns.AttributeConstraints.AttributeLookupConstraint;
import SDMLanguage.patterns.AttributeConstraints.CspConstraint;

public class MocaToMoflonAttributeConstrTests {

	
	private EPackage testMM;

	@Before
	public void init() {
		TestGeneratorPackage.eINSTANCE.getClass();
		TestLanguagePackage.eINSTANCE.getClass();
		SDMLanguagePackage.eINSTANCE.getClass();
				
		ResourceSet rs = eMoflonEMFUtil.createDefaultResourceSet();
		Resource res= rs.getResource(eMoflonEMFUtil.createFileURI("../MocaToMoflonAttributeConstrTestGenerator/model/MocaToMoflonAttributeConstrTestGenerator.ecore", true),true);
		testMM = (EPackage)res.getContents().get(0);
		
		 
	}

	@Test
	public void testA2() {

		EPackage subPackage = testMM.getESubpackages().stream()
				.filter(x -> x.getName().equals("TestGenerator")).findFirst()
				.get();
		EClass cls = (EClass) subPackage.getEClassifier("PatternGenerator");
		EOperation eOperation = cls.getEOperations().stream()
				.filter(x -> x.getName().equals("testPattern2")).findFirst()
				.get();
		MoflonEOperation mofEOperation = (MoflonEOperation) eOperation;
		ActivityNode activityNode = mofEOperation.getActivity()
				.getOwnedActivityNode().stream()
				.filter(x -> x instanceof StoryNode).findFirst().get();
		StoryPattern storyPatternActual = ((StoryNode) activityNode)
				.getStoryPattern();
		Assert.assertTrue("X",
				storyPatternActual.getObjectVariable().size() == 1);
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("a")));

		Assert.assertTrue(
				"X",
				storyPatternActual.getConstraints().stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.count() == 1);
		AttributeLookupConstraint al1 = (AttributeLookupConstraint) storyPatternActual
				.getConstraints().stream()
				.filter(x -> x instanceof AttributeLookupConstraint)
				.findFirst().get();
		Assert.assertTrue("X", al1.getType().getName().equals("x")
				&& al1.getObjectVariable().getName().equals("a")
				&& al1.getParameter().getName().equals("a_x")
				&& al1.getParameter().getType().getName().equals("EInt"));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof CspConstraint).count() == 1);
		CspConstraint csp1 = (CspConstraint) storyPatternActual
				.getConstraints().stream()
				.filter(x -> x instanceof CspConstraint).findFirst().get();
		Assert.assertTrue("X", csp1.getName().equals("<")
				&& csp1.getParameters().get(0).getAttributeConstraintVariable().getName().equals("a_x")
				&& csp1.getParameters().get(1).getAttributeConstraintVariable().getName().equals("5"));

	}

	@Test
	public void testA3() {

		EPackage subPackage = testMM.getESubpackages().stream()
				.filter(x -> x.getName().equals("TestGenerator")).findFirst()
				.get();
		EClass cls = (EClass) subPackage.getEClassifier("PatternGenerator");
		EOperation eOperation = cls.getEOperations().stream()
				.filter(x -> x.getName().equals("testPattern3")).findFirst()
				.get();
		MoflonEOperation mofEOperation = (MoflonEOperation) eOperation;
		ActivityNode activityNode = mofEOperation.getActivity()
				.getOwnedActivityNode().stream()
				.filter(x -> x instanceof StoryNode).findFirst().get();
		StoryPattern storyPatternActual = ((StoryNode) activityNode)
				.getStoryPattern();
		Assert.assertTrue("X",
				storyPatternActual.getObjectVariable().size() == 2);
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("a")));
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("b")));

		Assert.assertTrue(
				"X",
				storyPatternActual.getConstraints().stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.count() == 2);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.map(x -> (AttributeLookupConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("a")
										&& x.getParameter().getName()
												.equals("a_x")
										&& x.getParameter().getType().getName()
												.equals("EInt")));
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.map(x -> (AttributeLookupConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("b")
										&& x.getParameter().getName()
												.equals("b_x")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof AssignmentConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AssignmentConstraint)
						.map(x -> (AssignmentConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("a")
										&& x.getParameter().getName()
												.equals("a_x_prime")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof CspConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof CspConstraint)
						.map(x -> (CspConstraint) x)
						.anyMatch(
								x -> x.getParameters().size() == 3
										&& x.getName().equals("+")
										&& x.getParameters().get(0).getAttributeConstraintVariable().getName()
												.equals("a_x_prime")
										&& x.getParameters().get(1).getAttributeConstraintVariable().getName()
												.equals("b_x")
										&& x.getParameters().get(2).getAttributeConstraintVariable().getName()
												.equals("a_x")));

	}

	@Test
	public void testA4() {

		EPackage subPackage = testMM.getESubpackages().stream()
				.filter(x -> x.getName().equals("TestGenerator")).findFirst()
				.get();
		EClass cls = (EClass) subPackage.getEClassifier("PatternGenerator");
		EOperation eOperation = cls.getEOperations().stream()
				.filter(x -> x.getName().equals("testPattern4")).findFirst()
				.get();
		MoflonEOperation mofEOperation = (MoflonEOperation) eOperation;
		ActivityNode activityNode = mofEOperation.getActivity()
				.getOwnedActivityNode().stream()
				.filter(x -> x instanceof StoryNode).findFirst().get();
		StoryPattern storyPatternActual = ((StoryNode) activityNode)
				.getStoryPattern();
		Assert.assertTrue("X",
				storyPatternActual.getObjectVariable().size() == 1);
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("a")));

		Assert.assertTrue(
				"X",
				storyPatternActual.getConstraints().stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.map(x -> (AttributeLookupConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("a")
										&& x.getParameter().getName()
												.equals("a_x")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof AssignmentConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AssignmentConstraint)
						.map(x -> (AssignmentConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("a")
										&& x.getParameter().getName()
												.equals("a_x_prime")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof CspConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof CspConstraint)
						.map(x -> (CspConstraint) x)
						.anyMatch(
								x -> x.getParameters().size() == 3
										&& x.getName().equals("+")
										&& x.getParameters().get(0).getAttributeConstraintVariable().getName()
												.equals("a_x_prime")
										&& x.getParameters().get(1).getAttributeConstraintVariable().getName()
												.equals("2")
										&& x.getParameters().get(2).getAttributeConstraintVariable().getName()
												.equals("a_x")));

	}

	@Test
	public void testA5() {

		EPackage subPackage = testMM.getESubpackages().stream()
				.filter(x -> x.getName().equals("TestGenerator")).findFirst()
				.get();
		EClass cls = (EClass) subPackage.getEClassifier("PatternGenerator");
		EOperation eOperation = cls.getEOperations().stream()
				.filter(x -> x.getName().equals("testPattern5")).findFirst()
				.get();
		MoflonEOperation mofEOperation = (MoflonEOperation) eOperation;
		ActivityNode activityNode = mofEOperation.getActivity()
				.getOwnedActivityNode().stream()
				.filter(x -> x instanceof StoryNode).findFirst().get();
		StoryPattern storyPatternActual = ((StoryNode) activityNode)
				.getStoryPattern();
		Assert.assertTrue("X",
				storyPatternActual.getObjectVariable().size() == 2);
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("a")));
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("b")));

		Assert.assertTrue(
				"X",
				storyPatternActual.getConstraints().stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.map(x -> (AttributeLookupConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("b")
										&& x.getParameter().getName()
												.equals("b_x")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof AssignmentConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AssignmentConstraint)
						.map(x -> (AssignmentConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("a")
										&& x.getParameter().getName()
												.equals("a_x_prime")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof CspConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof CspConstraint)
						.map(x -> (CspConstraint) x)
						.anyMatch(
								x -> x.getParameters().size() == 2
										&& x.getName().equals("=")
										&& x.getParameters().get(0).getAttributeConstraintVariable().getName()
												.equals("a_x_prime")
										&& x.getParameters().get(1).getAttributeConstraintVariable().getName()
												.equals("b_x")));

	}

	@Test
	public void testA6() {

		EPackage subPackage = testMM.getESubpackages().stream()
				.filter(x -> x.getName().equals("TestGenerator")).findFirst()
				.get();
		EClass cls = (EClass) subPackage.getEClassifier("PatternGenerator");
		EOperation eOperation = cls.getEOperations().stream()
				.filter(x -> x.getName().equals("testPattern6")).findFirst()
				.get();
		MoflonEOperation mofEOperation = (MoflonEOperation) eOperation;
		ActivityNode activityNode = mofEOperation.getActivity()
				.getOwnedActivityNode().stream()
				.filter(x -> x instanceof StoryNode).findFirst().get();
		StoryPattern storyPatternActual = ((StoryNode) activityNode)
				.getStoryPattern();
		Assert.assertTrue("X",
				storyPatternActual.getObjectVariable().size() == 2);
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("a")));
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("c")));

		Assert.assertTrue(
				"X",
				storyPatternActual.getConstraints().stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.map(x -> (AttributeLookupConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("c")
										&& x.getParameter().getName()
												.equals("c_x")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof AssignmentConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AssignmentConstraint)
						.map(x -> (AssignmentConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("a")
										&& x.getParameter().getName()
												.equals("a_x_prime")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof CspConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof CspConstraint)
						.map(x -> (CspConstraint) x)
						.anyMatch(
								x -> x.getParameters().size() == 2
										&& x.getName().equals("=")
										&& x.getParameters().get(0).getAttributeConstraintVariable().getName()
												.equals("a_x_prime")
										&& x.getParameters().get(1).getAttributeConstraintVariable().getName()
												.equals("c_x")));

	}

	@Test
	public void testA7() {

		EPackage subPackage = testMM.getESubpackages().stream()
				.filter(x -> x.getName().equals("TestGenerator")).findFirst()
				.get();
		EClass cls = (EClass) subPackage.getEClassifier("PatternGenerator");
		EOperation eOperation = cls.getEOperations().stream()
				.filter(x -> x.getName().equals("testPattern7")).findFirst()
				.get();
		MoflonEOperation mofEOperation = (MoflonEOperation) eOperation;
		ActivityNode activityNode = mofEOperation.getActivity()
				.getOwnedActivityNode().stream()
				.filter(x -> x instanceof StoryNode).findFirst().get();
		StoryPattern storyPatternActual = ((StoryNode) activityNode)
				.getStoryPattern();
		Assert.assertTrue("X",
				storyPatternActual.getObjectVariable().size() == 2);
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("a")));
		Assert.assertTrue("X", storyPatternActual.getObjectVariable().stream()
				.anyMatch(x -> x.getName().equals("c")));

		Assert.assertTrue(
				"X",
				storyPatternActual.getConstraints().stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AttributeLookupConstraint)
						.map(x -> (AttributeLookupConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("a")
										&& x.getParameter().getName()
												.equals("a_x")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof AssignmentConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof AssignmentConstraint)
						.map(x -> (AssignmentConstraint) x)
						.anyMatch(
								x -> x.getType().getName().equals("x")
										&& x.getObjectVariable().getName()
												.equals("c")
										&& x.getParameter().getName()
												.equals("c_x_prime")
										&& x.getParameter().getType().getName()
												.equals("EInt")));

		Assert.assertTrue("X", storyPatternActual.getConstraints().stream()
				.filter(x -> x instanceof CspConstraint).count() == 1);
		Assert.assertTrue(
				"X",
				storyPatternActual
						.getConstraints()
						.stream()
						.filter(x -> x instanceof CspConstraint)
						.map(x -> (CspConstraint) x)
						.anyMatch(
								x -> x.getParameters().size() == 2
										&& x.getName().equals("=")
										&& x.getParameters().get(0).getAttributeConstraintVariable().getName()
												.equals("c_x_prime")
										&& x.getParameters().get(1).getAttributeConstraintVariable().getName()
												.equals("a_x")));

	}
	// private EPackage loadTestMM(){
	//
	// URI
	// uri1=URI.createPlatformResourceURI("MocaToMoflonAttributeConstrTestGenerator/model/MocaToMoflonAttributeConstrTestGenerator.ecore",false);
	//
	//
	// Resource r=rs.getResource(uri1,true);
	// EPackage pack=(EPackage) r.getContents().get(0);
	// return pack;
	//
	// }

}

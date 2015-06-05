package org.moflon.transformationzoo.fixml;

import org.eclipse.emf.ecore.EObject;
import org.junit.Ignore;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;
import org.moflon.testframework.tgg.TreeComparator;

import MocaTree.MocaTreePackage;
import fixmlPackage.CompilationUnit;
import fixmlPackage.FixmlPackagePackage;
import fixmlTGG.FixmlTGGPackage;


public class TestFixml extends IntegratorTest {

	public TestFixml() {
		super(MocaTreePackage.eINSTANCE, FixmlTGGPackage.eINSTANCE,
				FixmlPackagePackage.eINSTANCE);
	}

	@Test
	public void test0_FWD() {
		integrate("test0_FWD");
	}

	@Test
	public void test0_BWD() {
		integrate("test0_BWD");
	}

	@Test
	public void test1_FWD() {
		integrate("test1_FWD");
	}

	@Test
	public void test1_BWD() {
		integrate("test1_BWD");
	}

	@Test
	public void test2_FWD() {
		integrate("test2_FWD");
	}

	@Test
	public void test2_BWD() {
		integrate("test2_BWD");
	}

	@Test
	public void test3_FWD() {
		integrate("test3_FWD");
	}

	@Test
	public void test3_BWD() {
		integrate("test3_BWD");
	}

	@Test
	public void test4_FWD() {
		integrate("test4_FWD");
	}

	@Test
	public void test4_BWD() {
		integrate("test4_BWD");
	}

	@Test
	public void test5_FWD() {
		integrate("test5_FWD");
	}

	@Test
	@Ignore("Needs more than default memory!")
	public void test5_BWD() {
		integrate("test5_BWD");
	}

	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		if (created instanceof MocaTree.File) {
			TreeComparator.compare((MocaTree.File) created,
					(MocaTree.File) expected);
		} else {
			FixmlComparator.compare((CompilationUnit) expected,
					(CompilationUnit) created);
		}
	}

	@Override
	public void wrapUp() {
		try {
			super.wrapUp();
		} catch (Exception e) {
			System.err.println("This should be corrected: " + e.getMessage());
		}

	}
}

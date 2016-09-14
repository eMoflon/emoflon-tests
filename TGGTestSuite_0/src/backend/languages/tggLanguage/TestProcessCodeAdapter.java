package backend.languages.tggLanguage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import MocaTree.MocaTreePackage;
import ProcessCodeAdapter.ProcessCodeAdapterPackage;
import ProcessDefinition.Invocation;
import ProcessDefinition.Module;
import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition.SystemModule;
import ProcessDefinition.Task;

public class TestProcessCodeAdapter extends IntegratorTest {

	private boolean importTestFWD = false;
	private boolean invocationSameModuleTestFWD = false;
	private boolean invocationOtherModuleTestFWD = false;

	public TestProcessCodeAdapter() {
		super(MocaTreePackage.eINSTANCE, ProcessCodeAdapterPackage.eINSTANCE,
				ProcessDefinitionPackage.eINSTANCE);
	}

	@Test
	public void testImport_BWD() {
		integrate("Import_BWD");
	}

	@Test
	public void testImport_FWD() {
		importTestFWD = true;
		integrate("Import_FWD");
	}

	@Test
	public void testInvocationOtherModule_BWD() {
		integrate("InvocationOtherModule_BWD");
	}

	@Test
	public void testInvocationOtherModule_FWD() {
		invocationOtherModuleTestFWD = true;
		integrate("InvocationOtherModule_FWD");
	}

	@Test
	public void testInvocationRecursive_BWD() {
		integrate("InvocationRecursive_BWD");
	}

	@Test
	public void testInvocationRecursive_FWD() {
		integrate("InvocationRecursive_FWD");
	}

	@Test
	public void testInvocationSameModule_BWD() {
		integrate("InvocationSameModule_BWD");
	}

	@Test
	public void testInvocationSameModule_FWD() {
		invocationSameModuleTestFWD = true;
		integrate("InvocationSameModule_FWD");
	}

	@Test
	public void testModules_BWD() {
		integrate("Modules_BWD");
	}

	@Test
	public void testModules_FWD() {
		integrate("Modules_FWD");
	}

	@Test
	public void testSystemModule_BWD() {
		integrate("SystemModule_BWD");
	}

	@Test
	public void testSystemModule_FWD() {
		integrate("SystemModule_FWD");
	}

	@Test
	public void testTasks_BWD() {
		integrate("Tasks_BWD");
	}

	@Test
	public void testTasks_FWD() {
		integrate("Tasks_FWD");
	}

	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {

		// EMF compare is unreliable for the importFWD test. Therefore, compare
		// manually
		if (importTestFWD) {
			compareForImportFWDTest(created);
		} else if (invocationSameModuleTestFWD)
			compareForInvocationSameModuleFWDTest(created);
		else if (invocationOtherModuleTestFWD)
			compareForInvocationOtherModuleFWDTest(created);
		else
			super.compare(expected, created);
	}

	private void compareForInvocationOtherModuleFWDTest(EObject created) {
		
		SystemModule systemModule = (SystemModule) created;
		Module moduleA = null;
		Module moduleB = null;

		for (Module module : systemModule.getAllModules()) {
			if (module.getDescription().equals("A"))
				moduleA = module;
			if (module.getDescription().equals("B"))
				moduleB = module;
		}

		assertNotNull(moduleA);
		assertNotNull(moduleB);

		Task task1 = moduleA.getTasks().get(0);
		assertEquals("1", task1.getId());

		Task task2 = moduleB.getTasks().get(0);
		assertEquals("2", task2.getId());
		
		assertEquals(task2, task1.getInvocations().get(0).getInvokedTask());
		
		invocationOtherModuleTestFWD = false;
		
	}

	private void compareForInvocationSameModuleFWDTest(EObject created) {

		SystemModule systemModule = (SystemModule) created;
		Module moduleA = null;

		for (Module module : systemModule.getAllModules()) {
			if (module.getDescription().equals("A"))
				moduleA = module;
		}

		assertNotNull(moduleA);

		Task task1 = null;
		Task task2 = null;

		for (Task task : moduleA.getTasks()) {
			if (task.getId().equals("1"))
				task1 = task;
			if (task.getId().equals("2"))
				task2 = task;
		}

		assertNotNull(task1);
		assertNotNull(task2);

		Invocation invocation = task1.getInvocations().get(0);

		assertNotNull(invocation);

		assertEquals(task2, invocation.getInvokedTask());

		invocationSameModuleTestFWD = false;
	}

	private void compareForImportFWDTest(EObject created) {
		SystemModule systemModule = (SystemModule) created;
		Module moduleA = null;
		Module moduleB = null;

		for (Module module : systemModule.getAllModules()) {
			if (module.getDescription().equals("A"))
				moduleA = module;
			if (module.getDescription().equals("B"))
				moduleB = module;
		}

		assertNotNull(moduleA);
		assertNotNull(moduleB);

		Task task1 = moduleA.getTasks().get(0);

		assertEquals("1", task1.getId());
		assertEquals(moduleB, task1.getImports().get(0).getModule());

		Task task2 = moduleB.getTasks().get(0);
		assertEquals("2", task2.getId());

		importTestFWD = false;
	}

}

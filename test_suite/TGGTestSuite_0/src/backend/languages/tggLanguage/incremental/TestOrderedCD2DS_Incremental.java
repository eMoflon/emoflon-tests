package backend.languages.tggLanguage.incremental;

import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;
import org.moflon.tgg.algorithm.configuration.Configurator;
import org.moflon.tgg.algorithm.configuration.RuleResult;

import CDWithOrderedAttrs.CDWithOrderedAttrsPackage;
import CDWithOrderedAttrs.ClazzDiagram;
import DSWithOrderedCols.DSWithOrderedColsPackage;
import DSWithOrderedCols.Database;
import ModelDeltaCreator.ModelDeltaCreatorFactory;
import ModelDeltaCreator.OrderedCD2DS_DeltaCreator;
import OrderedCD2DS.OrderedCD2DSPackage;
import org.moflon.tgg.language.algorithm.ApplicationTypes;

public class TestOrderedCD2DS_Incremental extends IncrementalIntegratorTest {

	public TestOrderedCD2DS_Incremental() {
		super(CDWithOrderedAttrsPackage.eINSTANCE,
				OrderedCD2DSPackage.eINSTANCE,
				DSWithOrderedColsPackage.eINSTANCE);
	}

	@Test
	public void testDeleteInheritance_FWD() throws IOException, InterruptedException {
		init();
		
		setInputModel(ApplicationTypes.FORWARD, "DeleteInheritance_FWD");
		
		helper.integrateForward();
		
		helper.setChangeSrc(root -> {
			OrderedCD2DS_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createOrderedCD2DS_DeltaCreator();
			deltaCreator.deleteInheritance_FWD((ClazzDiagram) root);
		}); 

		helper.integrateForward();
		
		saveOutput("DeleteInheritance_FWD");
		compareWithExpected("DeleteInheritance_FWD", ApplicationTypes.FORWARD, helper.getTrg());
	}

	@Test
	public void testAddInheritance_FWD() throws InterruptedException, IOException {

		init(); 
		
		setInputModel(ApplicationTypes.FORWARD, "AddInheritance_FWD");
		
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			OrderedCD2DS_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createOrderedCD2DS_DeltaCreator();
			deltaCreator.addInheritance_FWD((ClazzDiagram) root);
		});

		helper.integrateForward();
		
		saveOutput("AddInheritance_FWD");
		compareWithExpected("AddInheritance_FWD", ApplicationTypes.FORWARD, helper.getTrg());
	}

	@Test
	public void testRemoveSuperAddSub_FWD() throws IOException, InterruptedException {

		init();
		
		setInputModel(ApplicationTypes.FORWARD, "RemoveSuperAddSub_FWD");
		
		helper.integrateForward();
		
		helper.setChangeSrc(root -> {
			OrderedCD2DS_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createOrderedCD2DS_DeltaCreator();
			deltaCreator.removeSuperAddSub_FWD((ClazzDiagram) root);

		});
		
		helper.integrateForward();

		saveOutput("RemoveSuperAddSub_FWD");
		compareWithExpected("RemoveSuperAddSub_FWD", ApplicationTypes.FORWARD, helper.getTrg());
	}

	@Test
	public void testRemoveAndAddAttribute_FWD() throws IOException, InterruptedException {

		init();
		
		setInputModel(ApplicationTypes.FORWARD, "RemoveAndAddAttribute_FWD");

		helper.integrateForward();
		
		helper.setChangeSrc(root -> {
			OrderedCD2DS_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createOrderedCD2DS_DeltaCreator();
			deltaCreator.removeAndAddAttribute_FWD((ClazzDiagram) root);

		}); 

		helper.integrateForward();
		
		saveOutput("RemoveAndAddAttribute_FWD");
		compareWithExpected("RemoveAndAddAttribute_FWD", ApplicationTypes.FORWARD, helper.getTrg());
	}

	@Test
	public void testPreserveInheritance_BWD() throws IOException, InterruptedException {

		init();
		
		setInputModel(ApplicationTypes.FORWARD, "PreserveInheritance_BWD");
		
		helper.integrateForward();
		
		helper.setChangeTrg(root -> {
			OrderedCD2DS_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createOrderedCD2DS_DeltaCreator();
			deltaCreator.addTable_BWD((Database) root);

		});

		helper.integrateBackward();
		 
		saveOutput("PreserveInheritance_BWD");
		compareWithExpected("PreserveInheritance_BWD", ApplicationTypes.BACKWARD, helper.getSrc());
	}

	@Test
	public void testPlaceColumnInbetween_BWD() throws IOException, InterruptedException {

		init();
		
		setInputModel(ApplicationTypes.FORWARD, "PlaceColumnInbetween_BWD");
		
		helper.integrateForward();
		
		helper.setChangeTrg(root -> {
			OrderedCD2DS_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createOrderedCD2DS_DeltaCreator();
			deltaCreator.placeColumnInbetween_BWD((Database) root);

		});

		helper.integrateBackward();
		
		saveOutput("PlaceColumnInbetween_BWD");
		compareWithExpected("PlaceColumnInbetween_BWD", ApplicationTypes.BACKWARD, helper.getSrc());
	}

	@Test
	public void testDeleteColumnInbetween_BWD() throws IOException, InterruptedException {

		init();
		
		setConfigurator(new CD2DSConfigurator());

		setInputModel(ApplicationTypes.FORWARD, "DeleteColumnInbetween_BWD");
		
		helper.integrateForward();
		
		helper.setChangeTrg(root -> {
			OrderedCD2DS_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createOrderedCD2DS_DeltaCreator();
			deltaCreator.deleteColumnInbetween_BWD((Database) root);

		});

		helper.integrateBackward();
		
		saveOutput("DeleteColumnInbetween_BWD");
		compareWithExpected("DeleteColumnInbetween_BWD", ApplicationTypes.BACKWARD, helper.getSrc());
	}
}

class CD2DSConfigurator implements Configurator {
	@Override
	public RuleResult chooseOne(Collection<RuleResult> alternatives) {
		return alternatives.stream().filter(rr -> rr.isRule("Attr2ColumnRule"))
				.findAny().orElse(Configurator.super.chooseOne(alternatives));
	}
}

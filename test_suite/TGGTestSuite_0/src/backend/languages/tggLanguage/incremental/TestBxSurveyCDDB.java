package backend.languages.tggLanguage.incremental;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.moflon.testframework.tgg.IncrementalIntegratorTest;
import org.moflon.tgg.algorithm.configuration.Configurator;
import org.moflon.tgg.algorithm.configuration.RuleResult;

import BxSurveyClassDiagram.BxClassDiagram;
import BxSurveyClassDiagram.BxClazz;
import BxSurveyClassDiagram.BxSurveyClassDiagramPackage;
import BxSurveyClassDiagramToRDBMSIntegration.BxSurveyClassDiagramToRDBMSIntegrationPackage;
import BxSurveyDatabase.BxSchema;
import BxSurveyDatabase.BxSurveyDatabasePackage;
import ModelDeltaCreator.BxCDDB_DeltaCreator;
import ModelDeltaCreator.ModelDeltaCreatorFactory;
import org.moflon.tgg.language.algorithm.ApplicationTypes;

public class TestBxSurveyCDDB extends IncrementalIntegratorTest {

	public TestBxSurveyCDDB() {
		super(BxSurveyClassDiagramPackage.eINSTANCE,
				BxSurveyClassDiagramToRDBMSIntegrationPackage.eINSTANCE,
				BxSurveyDatabasePackage.eINSTANCE);
	}

	@Before
	public void beforeTest() throws IOException {
		init();
	}

	@Test
	public void testAddSelfCol_BWD() throws InterruptedException, IOException {
		setConfigurator(new BxSurveyConfigurator());
		setInputModel(ApplicationTypes.FORWARD, "AddSelfCol_BWD");
		helper.integrateForward();

		helper.setChangeTrg(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			BxSchema s = (BxSchema) root;
			deltaCreator.createFKToSelfForTable(s.getTables().get(0));
		});

		helper.integrateBackward();

		saveOutput("AddSelfCol_BWD");
		compareWithExpected("AddSelfCol_BWD", ApplicationTypes.BACKWARD,
				helper.getSrc());
	}

	@Test
	public void createSimpleNode_FWD() throws InterruptedException, IOException {
		setInputModel(ApplicationTypes.FORWARD, "createSimpleNode_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.createAndAddClazz((BxClassDiagram) root);
		});

		helper.integrateForward();
		saveOutput("createSimpleNode_FWD");
		compareWithExpected("createSimpleNode_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
	}

	@Test
	public void createSimpleNode_BWD() throws InterruptedException, IOException {
		setInputModel(ApplicationTypes.BACKWARD, "createSimpleNode_BWD");
		helper.integrateBackward();

		helper.setChangeTrg(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.createAndAddTable((BxSchema) root);
		});

		helper.integrateBackward();

		saveOutput("createSimpleNode_BWD");
		compareWithExpected("createSimpleNode_BWD", ApplicationTypes.BACKWARD,
				helper.getSrc());
	}

	@Test
	public void deleteSimpleNode_FWD() throws InterruptedException, IOException {
		setInputModel(ApplicationTypes.FORWARD, "deleteSimpleNode_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.deleteClazz((BxClassDiagram) root);
		});

		helper.integrateForward();
		
		saveOutput("deleteSimpleNode_FWD");
		compareWithExpected("deleteSimpleNode_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
	}

	@Test
	public void deleteSimpleNode_BWD() throws InterruptedException, IOException {
		setInputModel(ApplicationTypes.BACKWARD, "deleteSimpleNode_BWD");
		helper.integrateBackward();

		helper.setChangeTrg(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.deleteTable((BxSchema) root);
		});

		helper.integrateBackward();

		saveOutput("deleteSimpleNode_BWD");
		compareWithExpected("deleteSimpleNode_BWD", ApplicationTypes.BACKWARD,
				helper.getSrc());
	}

	@Test
	public void createSimpleEdge_FWD() throws InterruptedException, IOException {
		setInputModel(ApplicationTypes.FORWARD, "createSimpleEdge_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.createSubClazzEdge((BxClassDiagram) root);
		});

		helper.integrateForward();
		saveOutput("createSimpleEdge_FWD");
		compareWithExpected("createSimpleEdge_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
	}

	@Test
	public void deleteSimpleEdge_FWD() throws InterruptedException, IOException {
		setInputModel(ApplicationTypes.FORWARD, "deleteSimpleEdge_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.deleteSubClazzEdge((BxClassDiagram) root);
		});

		helper.integrateForward();
		saveOutput("deleteSimpleEdge_FWD");
		compareWithExpected("deleteSimpleEdge_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
	}

	@Test
	public void deleteNodeAndEdgeExplicitly_FWD() throws InterruptedException,
			IOException {
		setInputModel(ApplicationTypes.FORWARD,
				"deleteNodeAndEdgeExplicitly_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.deleteClazzAndSuperEdge((BxClassDiagram) root);
		});
		
		helper.integrateForward();

		saveOutput("deleteNodeAndEdgeExplicitly_FWD");
		compareWithExpected("deleteNodeAndEdgeExplicitly_FWD",
				ApplicationTypes.FORWARD, helper.getTrg());
	}

	@Test
	public void insertSuperClazz_FWD() throws InterruptedException, IOException {
		setInputModel(ApplicationTypes.FORWARD, "insertSuperClazz_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.createSuperClazz((BxClassDiagram) root);
		});

		helper.integrateForward();
		
		saveOutput("insertSuperClazz_FWD");
		compareWithExpected("insertSuperClazz_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
	}

	@Test
	public void changeAssociationTarget_FWD() throws InterruptedException,
			IOException {
		setInputModel(ApplicationTypes.FORWARD, "changeAssociationTarget_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.changeAssociationTarget((BxClassDiagram) root);
		});
		
		helper.integrateForward();

		saveOutput("changeAssociationTarget_FWD");
		compareWithExpected("changeAssociationTarget_FWD",
				ApplicationTypes.FORWARD, helper.getTrg());
	}

	@Test
	public void changeAssociationTarget_BWD() throws InterruptedException,
			IOException {
		setInputModel(ApplicationTypes.BACKWARD, "changeAssociationTarget_BWD");
		helper.integrateBackward();

		helper.setChangeTrg(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.changeForeignKeyRef((BxSchema) root);
		});

		helper.integrateBackward();

		saveOutput("changeAssociationTarget_BWD");
		compareWithExpected("changeAssociationTarget_BWD",
				ApplicationTypes.BACKWARD, helper.getSrc());
	}

	@Test
	public void makeSelfAssociated_FWD() throws InterruptedException,
			IOException {
		setConfigurator(new SelfReferencePreferingConfigurator());
		setInputModel(ApplicationTypes.FORWARD, "makeSelfAssociated_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.makeSelfAssociated((BxClassDiagram) root);
		});
		
		helper.integrateForward();

		saveOutput("makeSelfAssociated_FWD");
		compareWithExpected("makeSelfAssociated_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
	}

	@Test
	public void makeSelfReferencing_BWD() throws InterruptedException,
			IOException {
		setConfigurator(new SelfReferencePreferingConfigurator());
		setInputModel(ApplicationTypes.BACKWARD, "makeSelfReferencing_BWD");
		helper.integrateBackward();

		helper.setChangeTrg(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.makeSelfReferencing((BxSchema) root);
		});

		helper.integrateBackward();

		saveOutput("makeSelfReferencing_BWD");
		compareWithExpected("makeSelfReferencing_BWD",
				ApplicationTypes.BACKWARD, helper.getSrc());
	}

	@Test
	@Ignore("this is an attribute delta to be handled soon")
	public void changeSimpleAttribute_FWD() throws InterruptedException,
			IOException {
		setInputModel(ApplicationTypes.FORWARD, "changeSimpleAttribute_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.changeClazzAttribute((BxClassDiagram) root);
		});

		helper.integrateForward();
		
		saveOutput("changeSimpleAttribute_FWD");
		compareWithExpected("changeSimpleAttribute_FWD",
				ApplicationTypes.FORWARD, helper.getTrg());
	}

	@Test
	@Ignore("this is an attribute delta to be handled soon")
	public void changeAttributeWithReference_FWD() throws InterruptedException,
			IOException {
		setInputModel(ApplicationTypes.FORWARD, "deleteSimpleNode_FWD");
		helper.integrateForward();

		helper.setChangeSrc(root -> {
			BxCDDB_DeltaCreator deltaCreator = ModelDeltaCreatorFactory.eINSTANCE
					.createBxCDDB_DeltaCreator();
			deltaCreator.changeClazzAttribute((BxClassDiagram) root);
		});

		helper.integrateForward();
		
		saveOutput("deleteSimpleNode_FWD");
		compareWithExpected("deleteSimpleNode_FWD", ApplicationTypes.FORWARD,
				helper.getTrg());
	}

}

class BxSurveyConfigurator implements Configurator {
	@Override
	public RuleResult chooseOne(Collection<RuleResult> alternatives) {
		Optional<RuleResult> chosen = alternatives.stream()
				.filter(rr -> rr.isRule("SubclassAssociationToColumnRule"))
				.findAny();

		if (chosen.isPresent()) {
			chosen.get().restrictMatchesTo(m -> {
				BxClazz srcClass = (BxClazz) m.getMatchedObject("srcClass");
				return srcClass.getName().equals("C2");
			});

			return chosen.get();
		}

		return Configurator.super.chooseOne(alternatives);
	}
}

class SelfReferencePreferingConfigurator implements Configurator {
	@Override
	public RuleResult chooseOne(Collection<RuleResult> alternatives) {
		return alternatives.stream()
				.filter(rr -> rr.isRule("SelfAssocToColumnRule")).findAny()
				.orElse(Configurator.super.chooseOne(alternatives));
	}
}

class SubClassReferencePreferingConfigurator implements Configurator {
	@Override
	public RuleResult chooseOne(Collection<RuleResult> alternatives) {
		return alternatives.stream()
				.filter(rr -> rr.isRule("SubClassAssociationToColumnRule"))
				.findAny().orElse(Configurator.super.chooseOne(alternatives));
	}
}
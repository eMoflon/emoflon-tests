package org.moflon.tie;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.moflon.moca.db.parser.DbParserAdapter;
import org.moflon.moca.db.unparser.DbUnparserAdapter;
import org.moflon.moca.entity.parser.EntityParserAdapter;
import org.moflon.moca.entity.unparser.EntityUnparserAdapter;
import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;

import DatabaseDSL.Appearance;
import DatabaseDSL.Database;
import DatabaseDSL.DatabaseDSLFactory;
import DatabaseDSL.DatabaseDSLPackage;
import DatabaseDSL.Entity;
import DatabaseDSL.Local_Database;
import DatabaseDSL.Mode;
import DatabaseDSL.Property;
import DatabaseDSLCodeAdapter.DatabaseDSLCodeAdapterPackage;
import DatabaseDSLCodeAdapter.validation.DatabaseValidation;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.Folder;

public class ModelGeneratorMain extends IntegratorHelper {

	public ModelGeneratorMain() throws IOException {
		// Register packages
		eMoflonEMFUtil.init(DatabaseDSLCodeAdapterPackage.eINSTANCE);
		eMoflonEMFUtil.init(DatabaseDSLPackage.eINSTANCE);

		// Load rules and set correspondence
		setCorrPackage(DatabaseDSLCodeAdapterPackage.eINSTANCE);
		loadRulesFromProject("..");
	}

	private static CodeAdapter codeAdapter;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		int modelSize = 1000;
		main(modelSize);

	}

	public static void main(int modelSize) throws IOException {
		Database db = DatabaseDSLFactory.eINSTANCE.createLocal_Database();
		db.setEntityFolderName("myEntities");
		db.setFolderName("myDatabase");
		db.setMode(Mode.READ_WRITE);
		db.setName("myDatabase");
		((Local_Database) db).setDbname(getRandomString(5));
		((Local_Database) db).setPath(getRandomString(5));

		for (int i = 0; i < modelSize / 5; i++) {
			db.getEntity().add(createEntity(4, i % 4 == 0));
		}


		ModelGeneratorMain helper = new ModelGeneratorMain();
		helper.setTrg(db);
		helper.integrateBackward();
		
		codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
		codeAdapter.getParser().add(new DbParserAdapter());
		codeAdapter.getParser().add(new EntityParserAdapter());
		codeAdapter.getUnparser().add(new DbUnparserAdapter());
		codeAdapter.getUnparser().add(new EntityUnparserAdapter());

		// Perform text-to-tree

		Folder folder = (Folder) helper.getSrc();

		Iterator it = folder.eAllContents();
		int i = 0;
		while (it.hasNext()) {
			it.next();
			i++;
		}


		File altered = new File("instances/in" + modelSize);
		FileUtils.deleteQuietly(altered);
		
		codeAdapter.unparse("instances/in" + modelSize + "/unparsed", folder);


//		System.out.println("Unparsed the changed tree");
	}

	private static Entity lastEntity = null;
	private static Entity secondLastEntity = null;

	private static Entity createEntity(int propertySize, boolean withoutId) {
		Entity entity = DatabaseDSLFactory.eINSTANCE.createEntity();
		entity.setFileName(getRandomString(5));
		entity.setName(getRandomString(5));
		entity.setMode(Mode.READ_WRITE);

		for (int i = 0; i < 4; i++) {
			entity.getProperty().add(createProperty(i == 0 ? withoutId : true));
		}

		if (secondLastEntity != null) {
			entity.getExtends().add(secondLastEntity);
		}
		if (lastEntity != null) {
			entity.getExtends().add(lastEntity);
			secondLastEntity = lastEntity;
		}
		lastEntity = entity;
		return entity;
	}

	private static Property createProperty(boolean withoutId) {
		Property p1 = DatabaseDSLFactory.eINSTANCE.createProperty();
		if (withoutId)
			p1.setAppearance(Appearance.NONE);
		else
			p1.setAppearance(Appearance.EXACTLY_ONCE);
		p1.setName(getRandomString(5));
		return p1;
	}

	private static int index = 0;

	private static String getRandomString(int length) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			buffer.append((char) (Math.random() * ('Z' - 'A' + 1) + 'A'));
		}
		return buffer.toString() + index++;
	}
}

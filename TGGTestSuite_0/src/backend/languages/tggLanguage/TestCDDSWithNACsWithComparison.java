package backend.languages.tggLanguage;

import org.eclipse.emf.ecore.EObject;
import org.junit.Assert;
import org.junit.Test;
import org.moflon.testframework.tgg.IntegratorTest;

import CD.CDPackage;
import CDDSWithNACs.CDDSWithNACsPackage;
import DS.Column;
import DS.DSPackage;
import DS.Database;
import DS.ForeignKey;
import DS.Key;
import DS.Table;


public class TestCDDSWithNACsWithComparison extends IntegratorTest {

	public TestCDDSWithNACsWithComparison() {
		super(CDPackage.eINSTANCE, CDDSWithNACsPackage.eINSTANCE,
				DSPackage.eINSTANCE);
	}

	/**
	 * This test case doesn't use EMF compare as the ordering of association
	 * columns can not be considered as deterministic.
	 */
	@Test
	public void testAssoc2ForeignKey_FWD() {
		integrate("Assoc2ForeignKey_FWD");
	}

	@Override
	public void compare(EObject expected, EObject created)
			throws InterruptedException {
		Database ds = (Database) created;

		Table source = null;
		Table target = null;

		for (Table table : ds.getTable()) {
			if (table.getName().equals("Source"))
				source = table;
			if (table.getName().equals("Target"))
				target = table;
		}

		Assert.assertNotNull(source);
		Assert.assertNotNull(target);

		Column sourceToTarget = null;
		for (Column column : source.getColumn()) {
			if (column.getName().equals("SourceToTarget"))
				sourceToTarget = column;
		}

		Assert.assertNotNull(sourceToTarget);

		ForeignKey foreignKey = null;
		for (ForeignKey fkSource : source.getForeignKey()) {
			if (fkSource.getStorage().equals(sourceToTarget))
				foreignKey = fkSource;
		}

		Assert.assertNotNull(foreignKey);

		Key foreignIdentifier = null;
		for (Key key : target.getPrimaryKey()) {
			if (key.equals(foreignKey.getForeignIdentifier()))
				foreignIdentifier = key;
		}

		Assert.assertNotNull(foreignIdentifier);
	}
}

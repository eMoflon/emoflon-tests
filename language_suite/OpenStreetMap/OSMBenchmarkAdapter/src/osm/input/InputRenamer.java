package osm.input;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.moflon.moca.osm.parser.OsmParserAdapter;
import org.moflon.moca.osm.unparser.OsmUnparserAdapter;

import Moca.CodeAdapter;
import Moca.MocaFactory;
import Moca.impl.MocaFactoryImpl;
import MocaTree.Folder;

public class InputRenamer {

	private final static String path = "D:\\Uni\\ES\\OpenStreetMapData";

	public static void main(String[] args) {
		(new InputRenamer()).renameFolderInput(new File(path));
	}

	private void renameFolderInput(File folder) {
		if (!folder.isDirectory())
			return;

		clearDirectory();

		CodeAdapter adapter = MocaFactoryImpl.eINSTANCE.createCodeAdapter();
		adapter = MocaFactory.eINSTANCE.createCodeAdapter();
		adapter.getParser().add(new OsmParserAdapter());
		adapter.getUnparser().add(new OsmUnparserAdapter());

		File[] genericNamedFiles = folder.listFiles((File f) -> f.isFile());

		Set<String> newNames = new HashSet<String>();
		for (File f : genericNamedFiles) {
			MocaTree.File mocaFile = adapter.parseFile(new File(f.getAbsolutePath()), null);
			String newName = "" + mocaFile.getRootNode().getChildren().size();

			if (f.getName().contains("ignore"))
				continue;

			if (newNames.contains(newName)) {
				String tempName = "";
				int i = 2;
				do {
					tempName = newName + " (" + i++ + ")";
				} while (newNames.contains(tempName));
				newName = tempName;
			}

			newNames.add(newName);
			try {
				FileUtils.copyFile(f, new File(path + File.separator + "renamed" + File.separator + newName + (f.getName().contains("ignored") ? "- ignored" : "") + ".osm"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private void clearDirectory() {
		File renamedFolder = new File(path + File.separator + "renamed");
		if (!renamedFolder.exists())
			return;

		File[] files = renamedFolder.listFiles();
		for (File f : files)
			f.delete();
	}
}

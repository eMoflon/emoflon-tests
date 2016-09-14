package osm.input;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.moflon.moca.MocaMain;
import org.moflon.moca.osm.parser.OsmParserAdapter;
import org.moflon.moca.osm.unparser.OsmUnparserAdapter;
import org.moflon.util.eMoflonEMFUtil;

import Moca.CodeAdapter;
import Moca.MocaFactory;
import Moca.impl.MocaFactoryImpl;
import MocaTree.Folder;
import MocaTree.MocaTreeFactory;
import MocaTree.util.MocaTreeAdapterFactory;

/**
 * class separates openstreetmaps into distinct folders
 * 
 * @author lfritsche
 *
 */
public class InputSeperator {

	private int[] seperationSteps = { 0, 10, 50, 100, 200, 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 7500, 8000, 8500, 9000, 9500, 10000, 11000, 12000, 13000, 14000, 15000, 16000, 17000, 18000, 19000, 20000, 21000, 22000, 23000, 24000, 25000, 26000, 27000, 28000, 29000, 30000};

	public static void main(String[] args) {
		System.out.println("Starting Parsing Process...");
		(new InputSeperator()).seperateIntoFolders(new File("D:\\Uni\\ES\\OpenStreetMapData\\renamed"));
		System.out.println("Parsing finished");
	}

	private void seperateIntoFolders(File folder) {
		CodeAdapter adapter = MocaFactoryImpl.eINSTANCE.createCodeAdapter();
		adapter = MocaFactory.eINSTANCE.createCodeAdapter();
		adapter.getParser().add(new OsmParserAdapter());
		adapter.getUnparser().add(new OsmUnparserAdapter());

		if (!folder.isDirectory())
			return;

		(new File(folder.getAbsolutePath() + File.separator)).mkdir();
		
		File[] files = folder.listFiles((File f) -> !f.getName().contains("ignored"));
		//Folder mocaFolder = adapter.parse(new File(folder.getAbsolutePath()));

		int lastParsingPercentage = 0;
		//ArrayList<MocaTree.File> fileList = new ArrayList<>();
		//fileList.addAll(mocaFolder.getFile());
		for (int i = 0; i < files.length; i++) {
			MocaTree.File mocaFile = adapter.parseFile(files[i], null);
			MocaTree.Folder mocaFolder = MocaTree.MocaTreeFactory.eINSTANCE.createFolder();
			
			mocaFolder.setName("osm.map");
			mocaFolder.getFile().add(mocaFile);
			
			int size = mocaFile.getRootNode().getChildren().size();

			for (int j = 0; j < seperationSteps.length; j++) {
				if (seperationSteps[j] > size) {
					int seperationStep = seperationSteps[j - 1];

					eMoflonEMFUtil.saveModel(mocaFolder, "instances/" + seperationStep + File.separator + mocaFile.getName() + ".src.xmi");
					break;
				}
				else {
					if(j == seperationSteps.length - 1)
						eMoflonEMFUtil.saveModel(mocaFolder, "instances/" + seperationSteps[j] + File.separator + mocaFile.getName() + ".src.xmi");
				}
			}
			
			int newParsingPercentage = (int) (new Double(i) / new Double(files.length) *  100);
			if(!(newParsingPercentage == lastParsingPercentage)) {
				lastParsingPercentage = newParsingPercentage;
				System.out.println(newParsingPercentage + "% finished...");
			}
				
		}
	}
}

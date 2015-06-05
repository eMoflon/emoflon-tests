package org.moflon.tie;

import java.io.File;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.moca.db.parser.DbParserAdapter;
import org.moflon.moca.db.unparser.DbUnparserAdapter;
import org.moflon.moca.entity.parser.EntityParserAdapter;
import org.moflon.moca.entity.unparser.EntityUnparserAdapter;
import org.moflon.util.eMoflonEMFUtil;

import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.Folder;

public class ParseMain {

	private static CodeAdapter codeAdapter;
	/**
	 * @param args
	 */
	public static long main(String testFolder) {	
		
		// Register parsers and unparsers
	    codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
	    codeAdapter.getParser().add(new DbParserAdapter());
	    codeAdapter.getParser().add(new EntityParserAdapter());
	    codeAdapter.getUnparser().add(new DbUnparserAdapter());
	    codeAdapter.getUnparser().add(new EntityUnparserAdapter());

	    long start = System.currentTimeMillis();
	    
	    // Perform text-to-tree
	    File containingFolder = new File(testFolder + "unparsed");
	    
	    Folder tree = codeAdapter.parse(containingFolder.listFiles()[0]);

	    long stop = System.currentTimeMillis();
	    
	    //eMoflonEMFUtil.saveModel(tree, testFolder + "sourceBatch.xmi");
	    MeasurementSocket.socket.put("source", tree);
		
	    //ObjectDeletor.delete(tree, true);
	    
		return stop - start;

	}

}

package org.moflon.tie;

import java.io.File;
import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.moflon.moca.MocaTreeSorter;
import org.moflon.moca.db.parser.DbParserAdapter;
import org.moflon.moca.db.unparser.DbUnparserAdapter;
import org.moflon.moca.entity.parser.EntityParserAdapter;
import org.moflon.moca.entity.unparser.EntityUnparserAdapter;
import org.moflon.util.EmfCompareUtil;
import org.moflon.util.eMoflonEMFUtil;

import Moca.CodeAdapter;
import Moca.MocaFactory;
import Moca.compare.Addition;
import Moca.compare.MocaCompare;
import MocaTree.Folder;
import MocaTree.Node;
import TGGLanguage.algorithm.precedence.AddedNodeDelta;
import TGGRuntime.Edge;
import TGGRuntime.TGGRuntimeFactory;

public class EMFCompareMain {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static long main(String testFolder) throws InterruptedException {

		// Register parsers and unparsers
		CodeAdapter codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
		codeAdapter.getParser().add(new DbParserAdapter());
		codeAdapter.getParser().add(new EntityParserAdapter());
		codeAdapter.getUnparser().add(new DbUnparserAdapter());
		codeAdapter.getUnparser().add(new EntityUnparserAdapter());

		// Perform text-to-tree
		File containingFolder = new File(testFolder + "unparsedChanged");

		Folder changed = codeAdapter.parse(containingFolder.listFiles()[0]);
		Folder original = (Folder) MeasurementSocket.socket.get("source");
		
		MocaTreeSorter.sort(changed);
		
		MocaCompare mc = Moca.compare.CompareFactory.eINSTANCE.createMocaCompare();
		
		ResourceSet set = new ResourceSetImpl();
		
		eMoflonEMFUtil.addToResourceSet(set, original);
		eMoflonEMFUtil.addToResourceSet(set, changed);
		eMoflonEMFUtil.addToResourceSet(set, mc);
		
		long start = System.currentTimeMillis();
		
		mc.compare(original, changed);
		
		AddedNodeDelta delta = TGGLanguage.algorithm.precedence.PrecedenceFactory.eINSTANCE.createAddedNodeDelta();
		
		for(Addition addition : mc.getAddition()){
			Node addedNode = (Node) addition.getElement();
			if(addedNode.getName().startsWith("_") || addedNode.getName().startsWith("!")){
				Edge edgeToParent = TGGRuntimeFactory.eINSTANCE.createEdge();
				edgeToParent.setName("children");
				edgeToParent.setSrc(addition.getLeftParent());
				edgeToParent.setTrg(addition.getElement());
				
				delta.getEobject().add(addition.getElement());
				delta.getEdge().add(edgeToParent);
			}
			
		}
		
		long stop = System.currentTimeMillis();
		
		MeasurementSocket.socket.put("delta", delta);
		return stop - start;
	}

}

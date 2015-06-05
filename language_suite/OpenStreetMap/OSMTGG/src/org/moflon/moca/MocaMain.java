package org.moflon.moca;
import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.moca.osm.parser.OsmParserAdapter;
import org.moflon.moca.osm.unparser.OsmUnparserAdapter;

import Moca.CodeAdapter;
import Moca.MocaFactory;

public class MocaMain 
{

  private static CodeAdapter codeAdapter;

  public static void main(String[] args) 
  {
    BasicConfigurator.configure();
    
    // Register parsers and unparsers
    codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
    codeAdapter.getParser().add(new OsmParserAdapter());
    codeAdapter.getUnparser().add(new OsmUnparserAdapter());

    // Perform text-to-tree
    MocaTree.Folder tree = codeAdapter.parse(new File("instances/in/"));

    // Save tree to file
    eMoflonEMFUtil.saveModel(tree, "instances/fwd.src.xmi"); 

    // Perform tree-to-model
    //TODO
    
    // Save model to file
    //TODO
    
    // Perform model-to-tree
    //tree = (Folder) eMoflonEMFUtil.loadModel("instances/backward/tree.xmi_FWD.xmi_BWD.xmi");
    //Folder oldTree = (Folder) eMoflonEMFUtil.loadModel("instances/backward/tree.xmi");
    
    // Perform tree-to-text (using initial tree)
    //codeAdapter.unparse("instances/out", tree); 
    //codeAdapter.unparse("instances/out", oldTree);
  }
}
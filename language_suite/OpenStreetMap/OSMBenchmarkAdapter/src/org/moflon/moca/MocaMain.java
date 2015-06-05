package org.moflon.moca;
import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.moflon.util.eMoflonEMFUtil;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;
import org.moflon.moca.osm.parser.OsmParserAdapter;
import org.moflon.moca.osm.unparser.OsmUnparserAdapter;

public class MocaMain 
{

  private static CodeAdapter codeAdapter;

  public static void main(String[] args) 
  {
    BasicConfigurator.configure();

    // Perform text-to-tree
    Folder tree = getCodeAdapter().parse(new File("instances/in/"));

    // Save tree to file
    eMoflonEMFUtil.saveModel(tree, "instances/tree.xmi");

    // Perform tree-to-model
    //TODO
    
    // Save model to file
    //TODO
    
    // Perform model-to-tree
    //TODO
    
    // Perform tree-to-text (using initial tree)
    getCodeAdapter().unparse("instances/out", tree);    
  }
  
  public static CodeAdapter getCodeAdapter(){
    if(codeAdapter == null){
	    // Register parsers and unparsers
		codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
        codeAdapter.getParser().add(new OsmParserAdapter());
        codeAdapter.getUnparser().add(new OsmUnparserAdapter());	  
     }
	  
	 return codeAdapter;
  }
}
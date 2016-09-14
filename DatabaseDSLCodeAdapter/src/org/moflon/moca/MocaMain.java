package org.moflon.moca;
import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.moflon.moca.db.parser.DbParserAdapter;
import org.moflon.moca.db.unparser.DbUnparserAdapter;
import org.moflon.moca.entity.parser.EntityParserAdapter;
import org.moflon.moca.entity.unparser.EntityUnparserAdapter;
import org.moflon.util.eMoflonEMFUtil;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;

public class MocaMain 
{

  private static CodeAdapter codeAdapter;

  public static void main(String[] args) 
  {
    BasicConfigurator.configure();

    // Register parsers and unparsers
    codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
    codeAdapter.getParser().add(new DbParserAdapter());
    codeAdapter.getParser().add(new EntityParserAdapter());
    codeAdapter.getUnparser().add(new DbUnparserAdapter());
    codeAdapter.getUnparser().add(new EntityUnparserAdapter());

    // Perform text-to-tree
    Folder tree = codeAdapter.parse(new File("instances/service_app"));

    // Save tree to file
    eMoflonEMFUtil.saveModel(tree, "instances/tree.xmi");

    // Perform tree-to-model
    //TODO
    
    // Save model to file
    //TODO
    
    // Perform model-to-tree
    //TODO
    
    // Perform tree-to-text (using initial tree)
    codeAdapter.unparse("instances/out", tree);    
  }
}
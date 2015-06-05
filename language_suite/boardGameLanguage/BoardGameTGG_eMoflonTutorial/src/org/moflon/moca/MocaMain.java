package org.moflon.moca;
import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.moflon.moca.board.parser.BoardParserAdapter;
import org.moflon.moca.board.unparser.BoardUnparserAdapter;
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
    codeAdapter.getParser().add(new BoardParserAdapter());
    codeAdapter.getUnparser().add(new BoardUnparserAdapter());

    // Perform text-to-tree
    MocaTree.File tree = codeAdapter.parseFile(new File("instances/in/chessSituation.board"), null);

    // Save tree to file
    //eMoflonEMFUtil.saveModel(tree, "instances/tree.xmi");
    eMoflonEMFUtil.saveModel(tree, "instances/target.xmi");

    // Perform tree-to-text (using initial tree)
    codeAdapter.unparseFile(tree, new File("instances/out"));
  }
}
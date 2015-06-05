package org.moflon.tie;
import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.moca.db.parser.DbParserAdapter;
import org.moflon.moca.db.unparser.DbUnparserAdapter;
import org.moflon.moca.entity.parser.EntityParserAdapter;
import org.moflon.moca.entity.unparser.EntityUnparserAdapter;
import org.moflon.util.eMoflonEMFUtil;
import Moca.CodeAdapter;
import Moca.MocaFactory;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;

public class UnparseMain 
{

  private static CodeAdapter codeAdapter;

  public static long main(String testFolder) 
  {
    BasicConfigurator.configure();

    // Register parsers and unparsers
    codeAdapter = MocaFactory.eINSTANCE.createCodeAdapter();
    codeAdapter.getParser().add(new DbParserAdapter());
    codeAdapter.getParser().add(new EntityParserAdapter());
    codeAdapter.getUnparser().add(new DbUnparserAdapter());
    codeAdapter.getUnparser().add(new EntityUnparserAdapter());

    // Perform text-to-tree

//    Folder folder = (Folder) eMoflonEMFUtil.loadAndInitModel(MocaTreePackage.eINSTANCE, testFolder + "sourceResult.xmi");

    Folder folder = (Folder) MeasurementSocket.socket.get("source");
    // Save tree to file

    
    // Perform tree-to-text (using initial tree)
    long start = System.currentTimeMillis();
    codeAdapter.unparse(testFolder + "unparsedResult", folder);    
    long stop = System.currentTimeMillis();
    
//    ObjectDeletor.delete(folder, true);
    
    return stop - start;
  }
}
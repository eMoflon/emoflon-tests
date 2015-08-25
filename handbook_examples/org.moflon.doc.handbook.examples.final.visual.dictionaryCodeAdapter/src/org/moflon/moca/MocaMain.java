package org.moflon.moca;
import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.moflon.core.moca.processing.CodeAdapter;
import org.moflon.core.moca.processing.ProcessingFactory;
import org.moflon.core.utilities.eMoflonEMFUtil;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;
import org.moflon.moca.dictionary.parser.DictionaryParserAdapter;
import org.moflon.moca.dictionary.unparser.DictionaryUnparserAdapter;

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
		codeAdapter = ProcessingFactory.eINSTANCE.createCodeAdapter();
        codeAdapter.getParser().add(new DictionaryParserAdapter());
        codeAdapter.getUnparser().add(new DictionaryUnparserAdapter());	  
     }
	  
	 return codeAdapter;
  }
}
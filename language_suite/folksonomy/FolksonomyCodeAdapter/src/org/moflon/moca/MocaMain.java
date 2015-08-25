package org.moflon.moca;
import org.apache.log4j.BasicConfigurator;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.moca.dat.unparser.DatUnparserAdapter;

import org.moflon.core.moca.processing.CodeAdapter;
import org.moflon.core.moca.processing.ProcessingFactory;
import MocaTree.Folder;
import MocaTree.MocaTreePackage;

public class MocaMain 
{

  private static CodeAdapter codeAdapter;

  public static void main(String[] args) 
  {
    BasicConfigurator.configure();

    // Register parsers and unparsers
    codeAdapter = ProcessingFactory.eINSTANCE.createCodeAdapter();
    codeAdapter.getUnparser().add(new DatUnparserAdapter());

    // load tree from file
    eMoflonEMFUtil.init(MocaTreePackage.eINSTANCE);
    Folder tree = (Folder) eMoflonEMFUtil.loadModel("instances/source.xmi_FWD.xmi");
    
    // Perform tree-to-text
    codeAdapter.unparse("instances/out", tree);    
  }
}
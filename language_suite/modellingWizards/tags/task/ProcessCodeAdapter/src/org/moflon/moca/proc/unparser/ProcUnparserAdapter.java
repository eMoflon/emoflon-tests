package org.moflon.moca.proc.unparser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import Moca.unparser.impl.TemplateUnparserImpl;

public class ProcUnparserAdapter extends TemplateUnparserImpl 
{
  
  @Override
  public boolean canUnparseFile(String fileName) 
  {
    return fileName.endsWith(".proc");
  }

  @Override
  protected String callMainRule(CommonTreeNodeStream tree, StringTemplateGroup templates) throws RecognitionException 
  {
    ProcTreeGrammar procTreeGrammar = new ProcTreeGrammar(tree);
    procTreeGrammar.setTemplateLib(templates);  
    StringTemplate st = procTreeGrammar.main().st;
    if (st==null) {
      return "";
    }
    else {
      return st.toString();
    }  
  }

  @Override
  protected StringTemplateGroup getStringTemplateGroup() throws FileNotFoundException 
  {
    //TODO provide StringTemplateGroup ...
    // ... from folder "proc" containing .st files
    // return new StringTemplateGroup("proc", "templates/proc");
    // ... from group file Proc.stg
    return new StringTemplateGroup(new FileReader(new File("./templates/Proc.stg")));
  }

  @Override
  protected String[] getTokenNames() 
  {
    return ProcTreeGrammar.tokenNames;
  }
}
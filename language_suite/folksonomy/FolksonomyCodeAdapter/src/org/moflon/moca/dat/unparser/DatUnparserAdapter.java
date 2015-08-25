package org.moflon.moca.dat.unparser;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import org.moflon.core.moca.processing.unparser.impl.TemplateUnparserImpl;

public class DatUnparserAdapter extends TemplateUnparserImpl 
{
  
  @Override
  public boolean canUnparseFile(String fileName) 
  {
    return fileName.endsWith(".dat");
  }

  @Override
  protected String callMainRule(CommonTreeNodeStream tree, StringTemplateGroup templates) throws RecognitionException 
  {
    DatTreeGrammar datTreeGrammar = new DatTreeGrammar(tree);
    datTreeGrammar.setTemplateLib(templates);  
    StringTemplate st = datTreeGrammar.main().st;
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
    return new StringTemplateGroup(new FileReader(new File("./templates/Dat.stg")));
  }

  @Override
  protected String[] getTokenNames() 
  {
    return DatTreeGrammar.tokenNames;
  }
}
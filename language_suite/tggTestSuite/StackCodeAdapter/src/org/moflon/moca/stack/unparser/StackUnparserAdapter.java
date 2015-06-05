package org.moflon.moca.stack.unparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

import Moca.unparser.impl.XMLUnparserImpl;

public class StackUnparserAdapter extends XMLUnparserImpl 
{
  @Override
  public boolean canUnparseFile(String fileName) 
  {
    return fileName.endsWith(".stack");
  }

  @Override
  protected StringTemplateGroup getStringTemplateGroup() throws FileNotFoundException 
  {
    return new StringTemplateGroup(new FileReader(new File("./templates/XML.stg")), DefaultTemplateLexer.class);
  }
}
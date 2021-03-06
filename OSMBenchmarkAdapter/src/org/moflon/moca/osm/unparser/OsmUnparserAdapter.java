package org.moflon.moca.osm.unparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.antlr.stringtemplate.StringTemplateGroup;
import Moca.unparser.impl.XMLUnparserImpl;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class OsmUnparserAdapter extends XMLUnparserImpl 
{
  @Override
  public boolean canUnparseFile(String fileName) 
  {
    return fileName.endsWith(".osm");
  }

  @Override
  protected StringTemplateGroup getStringTemplateGroup() throws FileNotFoundException 
  {
    return new StringTemplateGroup(new FileReader(new File("./templates/XML.stg")), DefaultTemplateLexer.class);
  }
}
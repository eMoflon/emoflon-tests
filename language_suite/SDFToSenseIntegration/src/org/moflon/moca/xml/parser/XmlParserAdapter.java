package org.moflon.moca.xml.parser;

import org.moflon.core.moca.processing.parser.impl.XMLParserImpl;

public class XmlParserAdapter extends XMLParserImpl 
{
  @Override
  public boolean canParseFile(String fileName) 
  {
    return fileName.endsWith(".xml");
  } 
}

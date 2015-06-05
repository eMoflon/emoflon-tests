package org.moflon.moca.xml.parser;

import Moca.parser.impl.XMLParserImpl;

public class XmlParserAdapter extends XMLParserImpl 
{
  @Override
  public boolean canParseFile(String fileName) 
  {
    return fileName.endsWith(".xml");
  } 
}

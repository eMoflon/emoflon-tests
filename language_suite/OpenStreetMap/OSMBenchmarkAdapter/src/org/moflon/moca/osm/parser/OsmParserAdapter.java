package org.moflon.moca.osm.parser;

import Moca.parser.impl.XMLParserImpl;

public class OsmParserAdapter extends XMLParserImpl 
{
  @Override
  public boolean canParseFile(String fileName) 
  {
    return fileName.endsWith(".osm");
  } 
}

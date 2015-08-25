package org.moflon.moca.osm.parser;

import org.moflon.core.moca.processing.parser.impl.XMLParserImpl;

public class OsmParserAdapter extends XMLParserImpl 
{
  @Override
  public boolean canParseFile(String fileName) 
  {
    return fileName.endsWith(".osm");
  } 
}

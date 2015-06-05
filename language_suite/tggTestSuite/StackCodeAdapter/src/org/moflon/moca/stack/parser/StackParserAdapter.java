package org.moflon.moca.stack.parser;

import Moca.parser.impl.XMLParserImpl;

public class StackParserAdapter extends XMLParserImpl 
{
  @Override
  public boolean canParseFile(String fileName) 
  {
    return fileName.endsWith(".stack");
  } 
}

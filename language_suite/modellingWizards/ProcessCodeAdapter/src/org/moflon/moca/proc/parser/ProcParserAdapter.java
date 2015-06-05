package org.moflon.moca.proc.parser;
import java.io.IOException;
import java.io.Reader;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.moflon.moca.MocaUtil;
import Moca.parser.impl.ParserImpl;
import MocaTree.Node;

public class ProcParserAdapter extends ParserImpl 
{

  @Override
  public boolean canParseFile(String fileName) 
  {
    return fileName.endsWith(".proc");
  }

  @Override
  public Node parse(Reader reader) 
  {
    try 
    {
      ProcLexer lexer = new ProcLexer(new ANTLRReaderStream(reader));
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      ProcParser parser = new ProcParser(tokens);
      CommonTree result = (CommonTree) parser.main().tree; 
      return MocaUtil.commonTreeToMocaTree(result);
    } catch (IOException e) 
    {
      e.printStackTrace();
    } catch (RecognitionException e) 
    {
      e.printStackTrace();
    } 
    return null;
  }
}
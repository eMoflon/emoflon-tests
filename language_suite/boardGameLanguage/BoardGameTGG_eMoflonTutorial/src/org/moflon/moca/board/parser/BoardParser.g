parser grammar BoardParser;

options {
  language = Java;
  tokenVocab = BoardLexer;
  output = AST;
}
tokens {
  ROW;
  COLUMN;
  BOARD_SPEC;
  BOARD;
  DIMENSIONS;
  ROWS;
  COLS;
}
@header {
package org.moflon.moca.board.parser; 
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;
import org.moflon.moca.MocaTokenFactory;
}

@members {
  int rows = 0;
  int cols = 0;	

  public Collection<Problem> problems = new ArrayList<Problem>();

      public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
          Problem problem = MocaFactory.eINSTANCE.createProblem();
          int line  = e.line;
          int charPos = e.charPositionInLine;
          int tokenLenght = 1;
          Token token = e.token;
          if(token != null) 
            tokenLenght = token.getText().length();
                  
          
          problem.setType(ProblemType.ERROR);
          problem.setLine(line); 
          problem.setCharacterPositionStart(charPos); 
          problem.setCharacterPositionEnd(charPos+tokenLenght);
          problem.setMessage("Parser: " + getErrorMessage(e, tokenNames));
          
          problems.add(problem);
          super.displayRecognitionError(tokenNames, e);
    }
}


main: (r+=row)+  
    -> ^(BOARD_SPEC ^(DIMENSIONS ^(ROWS {MocaTokenFactory.createCommonTree("NUM", rows + "", tokenNames)}) 
    						^(COLS {MocaTokenFactory.createCommonTree("NUM", cols/rows + "", tokenNames)}))
    		   ^(BOARD $r*));
row: {rows++;} (c+=column)+ COLSEP (NEWLINE | EOF) -> ^(ROW $c*);
column: {cols++;} (COLSEP f=FIGURE) -> ^(COLUMN $f) | {cols++;} (COLSEP EMPTY) -> COLUMN;


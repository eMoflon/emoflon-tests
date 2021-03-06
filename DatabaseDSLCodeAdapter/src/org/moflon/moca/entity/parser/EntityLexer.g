lexer grammar EntityLexer;

@members {
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
          problem.setMessage("Lexer: " + getErrorMessage(e, tokenNames)); 
          
          problems.add(problem);
          super.displayRecognitionError(tokenNames, e);
    }
}

@header {
package org.moflon.moca.entity.parser;
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;
}

// Lexer Rules:
CURLY_OPEN: '{';

CURLY_CLOSE: '}';

MODE_FLAG: 'r' | 'rw';

MODE_TAG: '@mode';

PROPERTY_TAG: '@properties';

SEARCH_TAG: '!' | '*' | '?' | '+' | '-';

OPEN: '[';

CLOSE: ']';

EXTENDS: '->';


// Common Token Definitions
fragment ID: ('a'..'z' | 'A'..'Z')+;
STRING: ('_' | ID | ('0'..'9') )+; 
WS : (' ' | '\t' | '\f' | '\n' | '\r')+ {skip();};
COMMENT: '//' .* '\n' {skip();};

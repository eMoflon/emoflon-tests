lexer grammar DbLexer;

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
package org.moflon.moca.db.parser;
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;
}

MODE_FLAG: 'r' | 'rw';

DB_TYPE: 'remote' | 'local';

MODE_TAG: '@mode';

PATH_TAG: '@path';

CURLY_OPEN: '{';

CURLY_CLOSE: '}';

OPEN: '[';

CLOSE: ']';

URL_TAG: '@url';
fragment ID: ('a'..'z' | 'A'..'Z')+;
STRING: ('_' | ID | ('0'..'9') | ':' | '.' | '//')+; 
WS : (' ' | '\t' | '\f' | '\n' | '\r')+ {skip();};
COMMENT: '//' .* '\n' {skip();};


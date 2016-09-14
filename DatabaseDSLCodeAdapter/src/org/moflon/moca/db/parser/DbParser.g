parser grammar DbParser;

options {
  language = Java;
  tokenVocab = DbLexer;
  output = AST;
}

// List of tokens used to structure the tree
tokens {
  MODE_TOKEN;
  URI_TOKEN;
  PATH_TOKEN;
}

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
          problem.setMessage("Parser: " + getErrorMessage(e, tokenNames));
          
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

// Parser Rules:
main: DB_TYPE CURLY_OPEN db CURLY_CLOSE -> ^(DB_TYPE db);

db: local -> local | remote -> remote;

remote: mode url -> mode url;

mode: MODE_TAG OPEN MODE_FLAG CLOSE -> ^(MODE_TOKEN MODE_FLAG);

url: URL_TAG OPEN STRING CLOSE -> ^(URI_TOKEN STRING);

local: mode path -> mode path;

path: PATH_TAG OPEN STRING CLOSE -> ^(PATH_TOKEN STRING); 
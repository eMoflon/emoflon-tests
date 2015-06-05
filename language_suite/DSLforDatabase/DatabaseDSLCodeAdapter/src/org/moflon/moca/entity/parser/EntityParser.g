parser grammar EntityParser;

options {
  language = Java;
  tokenVocab = EntityLexer;
  output = AST;
}

// List of tokens used to structure the tree
tokens {
  MODE_TOKEN;
  PROPERTIES_TOKEN;
  EXTENDS_TOKEN;
  SUPER_TOKEN; 
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
package org.moflon.moca.entity.parser; 
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;
}

// Parser Rules:
main: name=STRING EXTENDS OPEN supers+=superEntity* CLOSE CURLY_OPEN mode properties CURLY_CLOSE -> ^($name ^(EXTENDS_TOKEN $supers*) mode properties);

superEntity: STRING -> ^(SUPER_TOKEN STRING);

mode: MODE_TAG OPEN MODE_FLAG CLOSE -> ^(MODE_TOKEN MODE_FLAG);

properties: PROPERTY_TAG OPEN p+=property * CLOSE -> ^(PROPERTIES_TOKEN $p*);

property: STRING SEARCH_TAG -> ^(STRING SEARCH_TAG);
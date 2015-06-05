parser grammar ProcParser;

options {
  language = Java;
  tokenVocab = ProcLexer;
  output = AST;
}

tokens {
  TASK;
  IMPORTS;
  INVOCATIONS;
}

@header {
package org.moflon.moca.proc.parser; 
}
 

// parser rules:
main: task;

task :    moduleImport*
          KEYWORD OPEN 
            METHOD NOARGS OPEN
              taskInvocation* 
            CLOSE
          CLOSE 
       ->
          ^(TASK 
              ^(IMPORTS moduleImport*) 
              ^(INVOCATIONS taskInvocation*)
           );

moduleImport: IMPORT_KEYWORD STRING -> STRING;

taskInvocation: STRING SCOPE METHOD NOARGS -> STRING;


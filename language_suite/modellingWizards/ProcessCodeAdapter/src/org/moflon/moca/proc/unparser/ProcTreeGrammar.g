tree grammar ProcTreeGrammar;

options {
  ASTLabelType = CommonTree; 
  output       = template;
}

// Tokens used internally by Moca
// ID: ('a'..'z' | 'A'..'Z')+;
// STRING: ( ID | ('0'..'9') )+; 
// ATRIBUTE: Used as an imaginary token for coding attributes in XML files (ATTRIBUTE name=ID value=STRING)
tokens {
  ID;
  STRING;
  ATTRIBUTE; 
} 
  
@header {
package org.moflon.moca.proc.unparser;
}
// tree grammar rules:
main: ^('TASK' 
          ^('IMPORTS' moduleImports+=moduleImport*)
          ^('INVOCATIONS' taskInvocations+=taskInvocation*)) 
       -> 
          task(moduleImports={$moduleImports}, taskInvocations={$taskInvocations});

moduleImport: name=STRING -> moduleImport(name={$name});

taskInvocation: id=STRING -> taskInvocation(id={$id});
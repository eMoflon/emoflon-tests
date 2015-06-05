lexer grammar ProcLexer;

@header {
package org.moflon.moca.proc.parser;
}
// lexer rules:
KEYWORD: 'task';
METHOD: 'run';
OPEN: '{';
CLOSE: '}';
SCOPE: '::';
NOARGS: '()';
IMPORT_KEYWORD: 'import';

ID: ('a'..'z' | 'A'..'Z')+;
STRING: ('_' | ID | ('0'..'9') )+; 
WS : (' ' | '\t' | '\f' | '\n' | '\r')+ {skip();};



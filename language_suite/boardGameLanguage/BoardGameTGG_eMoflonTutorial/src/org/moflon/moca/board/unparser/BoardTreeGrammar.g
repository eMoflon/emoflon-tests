tree grammar BoardTreeGrammar;

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
package org.moflon.moca.board.unparser;
}

@members {
	public Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)	throws RecognitionException  {
		try {
        		return super.recoverFromMismatchedToken(input, ttype, follow);
            } catch(java.util.NoSuchElementException e){
                throw new IllegalArgumentException("Your tree does not comply with your tree grammar!\n"
                		+ " Problems encountered at: [" + "..." + getTreeNodeStream().LT(-1) + " " 
                		+ getTreeNodeStream().LT(1) + "..." + "] in tree.");
		}
    }
}  

// These are the grammar rules to parse
// the simple moca tree
main: ^('BOARD_SPEC' dimensions? ^('BOARD' rows+=row+)) -> board(rows={$rows});

dimensions: ^('DIMENSIONS' ^('ROWS' STRING) ^('COLS' STRING));

row: ^('ROW' columns+=column+) -> row(columns={$columns});

column: ^('COLUMN' t+=STRING?) -> column(type={$t});

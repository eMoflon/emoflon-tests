// $ANTLR 3.5.2 C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g 2014-12-22 12:23:21

package org.moflon.moca.board.parser;
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class BoardLexer extends Lexer {
	public static final int EOF=-1;
	public static final int COLSEP=4;
	public static final int EMPTY=5;
	public static final int FIGURE=6;
	public static final int NEWLINE=7;
	public static final int NUM=8;
	public static final int WHITESPACE=9;

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


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public BoardLexer() {} 
	public BoardLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public BoardLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g"; }

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:11: ( ( ' ' | '\\t' | '\\r' | '/*' ( . )* '*/' ) )
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:13: ( ' ' | '\\t' | '\\r' | '/*' ( . )* '*/' )
			{
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:13: ( ' ' | '\\t' | '\\r' | '/*' ( . )* '*/' )
			int alt2=4;
			switch ( input.LA(1) ) {
			case ' ':
				{
				alt2=1;
				}
				break;
			case '\t':
				{
				alt2=2;
				}
				break;
			case '\r':
				{
				alt2=3;
				}
				break;
			case '/':
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:14: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:20: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:27: '\\r'
					{
					match('\r'); 
					}
					break;
				case 4 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:34: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:39: ( . )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0=='*') ) {
							int LA1_1 = input.LA(2);
							if ( (LA1_1=='/') ) {
								alt1=2;
							}
							else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
								alt1=1;
							}

						}
						else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:37:39: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop1;
						}
					}

					match("*/"); 

					}
					break;

			}

			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "COLSEP"
	public final void mCOLSEP() throws RecognitionException {
		try {
			int _type = COLSEP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:38:7: ( ':' )
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:38:8: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLSEP"

	// $ANTLR start "FIGURE"
	public final void mFIGURE() throws RecognitionException {
		try {
			int _type = FIGURE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:39:7: ( 'a' .. 'z' | 'A' .. 'Z' )
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIGURE"

	// $ANTLR start "EMPTY"
	public final void mEMPTY() throws RecognitionException {
		try {
			int _type = EMPTY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:40:6: ( '_' )
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:40:8: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EMPTY"

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:41:4: ( ( '0' .. '9' )+ )
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:41:6: ( '0' .. '9' )+
			{
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:41:6: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:42:8: ( '\\r \\n' | '\\n' | '\\r' )
			int alt4=3;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==' ') ) {
					alt4=1;
				}

				else {
					alt4=3;
				}

			}
			else if ( (LA4_0=='\n') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:42:10: '\\r \\n'
					{
					match("\r \n"); 

					}
					break;
				case 2 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:42:20: '\\n'
					{
					match('\n'); 
					}
					break;
				case 3 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:42:27: '\\r'
					{
					match('\r'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:1:8: ( WHITESPACE | COLSEP | FIGURE | EMPTY | NUM | NEWLINE )
		int alt5=6;
		switch ( input.LA(1) ) {
		case '\t':
		case ' ':
		case '/':
			{
			alt5=1;
			}
			break;
		case '\r':
			{
			int LA5_2 = input.LA(2);
			if ( (LA5_2==' ') ) {
				alt5=6;
			}

			else {
				alt5=1;
			}

			}
			break;
		case ':':
			{
			alt5=2;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt5=3;
			}
			break;
		case '_':
			{
			alt5=4;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt5=5;
			}
			break;
		case '\n':
			{
			alt5=6;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}
		switch (alt5) {
			case 1 :
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:1:10: WHITESPACE
				{
				mWHITESPACE(); 

				}
				break;
			case 2 :
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:1:21: COLSEP
				{
				mCOLSEP(); 

				}
				break;
			case 3 :
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:1:28: FIGURE
				{
				mFIGURE(); 

				}
				break;
			case 4 :
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:1:35: EMPTY
				{
				mEMPTY(); 

				}
				break;
			case 5 :
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:1:41: NUM
				{
				mNUM(); 

				}
				break;
			case 6 :
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardLexer.g:1:45: NEWLINE
				{
				mNEWLINE(); 

				}
				break;

		}
	}



}

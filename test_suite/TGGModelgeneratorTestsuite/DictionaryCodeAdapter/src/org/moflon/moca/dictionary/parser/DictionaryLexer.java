// $ANTLR 3.5.2 D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g 2015-01-02 12:15:51

package org.moflon.moca.dictionary.parser;
import org.moflon.moca.MocaUtil;
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class DictionaryLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ADVANCED=4;
	public static final int BEGINNER=5;
	public static final int CLOSE=6;
	public static final int DICTIONARY=7;
	public static final int EMAIL=8;
	public static final int ENTRY=9;
	public static final int MASTER=10;
	public static final int OPEN=11;
	public static final int QUOTED_STRING=12;
	public static final int SEPARATOR=13;
	public static final int TITLE=14;
	public static final int WS=15;

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

	public DictionaryLexer() {} 
	public DictionaryLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public DictionaryLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g"; }

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:37:3: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:37:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:37:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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
	// $ANTLR end "WS"

	// $ANTLR start "TITLE"
	public final void mTITLE() throws RecognitionException {
		try {
			int _type = TITLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:39:6: ( 'title:' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:39:8: 'title:'
			{
			match("title:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TITLE"

	// $ANTLR start "EMAIL"
	public final void mEMAIL() throws RecognitionException {
		try {
			int _type = EMAIL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:41:6: ( 'email:' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:41:8: 'email:'
			{
			match("email:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EMAIL"

	// $ANTLR start "QUOTED_STRING"
	public final void mQUOTED_STRING() throws RecognitionException {
		try {
			int _type = QUOTED_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:43:14: ( '\"' ( . )* '\"' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:43:16: '\"' ( . )* '\"'
			{
			match('\"'); 
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:43:20: ( . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\"') ) {
					alt2=2;
				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:43:20: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match('\"'); 
			 MocaUtil.trim(this, 1, 1); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTED_STRING"

	// $ANTLR start "BEGINNER"
	public final void mBEGINNER() throws RecognitionException {
		try {
			int _type = BEGINNER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:45:9: ( 'beginner' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:45:11: 'beginner'
			{
			match("beginner"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BEGINNER"

	// $ANTLR start "ADVANCED"
	public final void mADVANCED() throws RecognitionException {
		try {
			int _type = ADVANCED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:47:9: ( 'advanced' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:47:11: 'advanced'
			{
			match("advanced"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADVANCED"

	// $ANTLR start "MASTER"
	public final void mMASTER() throws RecognitionException {
		try {
			int _type = MASTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:49:7: ( 'master' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:49:9: 'master'
			{
			match("master"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MASTER"

	// $ANTLR start "OPEN"
	public final void mOPEN() throws RecognitionException {
		try {
			int _type = OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:51:5: ( '{' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:51:7: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN"

	// $ANTLR start "CLOSE"
	public final void mCLOSE() throws RecognitionException {
		try {
			int _type = CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:53:6: ( '}' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:53:8: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE"

	// $ANTLR start "SEPARATOR"
	public final void mSEPARATOR() throws RecognitionException {
		try {
			int _type = SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:55:10: ( ',' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:55:12: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEPARATOR"

	// $ANTLR start "DICTIONARY"
	public final void mDICTIONARY() throws RecognitionException {
		try {
			int _type = DICTIONARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:57:11: ( 'DICTIONARY' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:57:13: 'DICTIONARY'
			{
			match("DICTIONARY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DICTIONARY"

	// $ANTLR start "ENTRY"
	public final void mENTRY() throws RecognitionException {
		try {
			int _type = ENTRY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:59:6: ( 'ENTRY' )
			// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:59:8: 'ENTRY'
			{
			match("ENTRY"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENTRY"

	@Override
	public void mTokens() throws RecognitionException {
		// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:8: ( WS | TITLE | EMAIL | QUOTED_STRING | BEGINNER | ADVANCED | MASTER | OPEN | CLOSE | SEPARATOR | DICTIONARY | ENTRY )
		int alt3=12;
		switch ( input.LA(1) ) {
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt3=1;
			}
			break;
		case 't':
			{
			alt3=2;
			}
			break;
		case 'e':
			{
			alt3=3;
			}
			break;
		case '\"':
			{
			alt3=4;
			}
			break;
		case 'b':
			{
			alt3=5;
			}
			break;
		case 'a':
			{
			alt3=6;
			}
			break;
		case 'm':
			{
			alt3=7;
			}
			break;
		case '{':
			{
			alt3=8;
			}
			break;
		case '}':
			{
			alt3=9;
			}
			break;
		case ',':
			{
			alt3=10;
			}
			break;
		case 'D':
			{
			alt3=11;
			}
			break;
		case 'E':
			{
			alt3=12;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 3, 0, input);
			throw nvae;
		}
		switch (alt3) {
			case 1 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:10: WS
				{
				mWS(); 

				}
				break;
			case 2 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:13: TITLE
				{
				mTITLE(); 

				}
				break;
			case 3 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:19: EMAIL
				{
				mEMAIL(); 

				}
				break;
			case 4 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:25: QUOTED_STRING
				{
				mQUOTED_STRING(); 

				}
				break;
			case 5 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:39: BEGINNER
				{
				mBEGINNER(); 

				}
				break;
			case 6 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:48: ADVANCED
				{
				mADVANCED(); 

				}
				break;
			case 7 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:57: MASTER
				{
				mMASTER(); 

				}
				break;
			case 8 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:64: OPEN
				{
				mOPEN(); 

				}
				break;
			case 9 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:69: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 10 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:75: SEPARATOR
				{
				mSEPARATOR(); 

				}
				break;
			case 11 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:85: DICTIONARY
				{
				mDICTIONARY(); 

				}
				break;
			case 12 :
				// D:\\modelgeneratorTestsuiteWorkspace\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryLexer.g:1:96: ENTRY
				{
				mENTRY(); 

				}
				break;

		}
	}



}

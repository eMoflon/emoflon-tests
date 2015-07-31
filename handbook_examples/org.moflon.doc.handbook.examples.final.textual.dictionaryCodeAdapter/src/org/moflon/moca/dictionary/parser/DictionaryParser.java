// $ANTLR 3.5.2 C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g 2015-07-31 10:50:58

package org.moflon.moca.dictionary.parser; 
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class DictionaryParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADVANCED", "BEGINNER", "CLOSE", 
		"DICTIONARY", "EMAIL", "ENTRY", "MASTER", "OPEN", "QUOTED_STRING", "SEPARATOR", 
		"TITLE", "WS"
	};
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public DictionaryParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public DictionaryParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return DictionaryParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g"; }


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


	public static class main_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "main"
	// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:1: main : title ( email )? OPEN ( entry )+ CLOSE -> ^( DICTIONARY title ( email )? ( entry )+ ) ;
	public final DictionaryParser.main_return main() throws RecognitionException {
		DictionaryParser.main_return retval = new DictionaryParser.main_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token OPEN3=null;
		Token CLOSE5=null;
		ParserRuleReturnScope title1 =null;
		ParserRuleReturnScope email2 =null;
		ParserRuleReturnScope entry4 =null;

		Object OPEN3_tree=null;
		Object CLOSE5_tree=null;
		RewriteRuleTokenStream stream_CLOSE=new RewriteRuleTokenStream(adaptor,"token CLOSE");
		RewriteRuleTokenStream stream_OPEN=new RewriteRuleTokenStream(adaptor,"token OPEN");
		RewriteRuleSubtreeStream stream_entry=new RewriteRuleSubtreeStream(adaptor,"rule entry");
		RewriteRuleSubtreeStream stream_title=new RewriteRuleSubtreeStream(adaptor,"rule title");
		RewriteRuleSubtreeStream stream_email=new RewriteRuleSubtreeStream(adaptor,"rule email");

		try {
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:5: ( title ( email )? OPEN ( entry )+ CLOSE -> ^( DICTIONARY title ( email )? ( entry )+ ) )
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:7: title ( email )? OPEN ( entry )+ CLOSE
			{
			pushFollow(FOLLOW_title_in_main56);
			title1=title();
			state._fsp--;

			stream_title.add(title1.getTree());
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:13: ( email )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==EMAIL) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:13: email
					{
					pushFollow(FOLLOW_email_in_main58);
					email2=email();
					state._fsp--;

					stream_email.add(email2.getTree());
					}
					break;

			}

			OPEN3=(Token)match(input,OPEN,FOLLOW_OPEN_in_main61);  
			stream_OPEN.add(OPEN3);

			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:25: ( entry )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==QUOTED_STRING) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:25: entry
					{
					pushFollow(FOLLOW_entry_in_main63);
					entry4=entry();
					state._fsp--;

					stream_entry.add(entry4.getTree());
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			CLOSE5=(Token)match(input,CLOSE,FOLLOW_CLOSE_in_main66);  
			stream_CLOSE.add(CLOSE5);

			// AST REWRITE
			// elements: title, entry, email
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 43:38: -> ^( DICTIONARY title ( email )? ( entry )+ )
			{
				// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:41: ^( DICTIONARY title ( email )? ( entry )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DICTIONARY, "DICTIONARY"), root_1);
				adaptor.addChild(root_1, stream_title.nextTree());
				// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:43:60: ( email )?
				if ( stream_email.hasNext() ) {
					adaptor.addChild(root_1, stream_email.nextTree());
				}
				stream_email.reset();

				if ( !(stream_entry.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_entry.hasNext() ) {
					adaptor.addChild(root_1, stream_entry.nextTree());
				}
				stream_entry.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "main"


	public static class title_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "title"
	// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:45:1: title : TITLE QUOTED_STRING -> QUOTED_STRING ;
	public final DictionaryParser.title_return title() throws RecognitionException {
		DictionaryParser.title_return retval = new DictionaryParser.title_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TITLE6=null;
		Token QUOTED_STRING7=null;

		Object TITLE6_tree=null;
		Object QUOTED_STRING7_tree=null;
		RewriteRuleTokenStream stream_TITLE=new RewriteRuleTokenStream(adaptor,"token TITLE");
		RewriteRuleTokenStream stream_QUOTED_STRING=new RewriteRuleTokenStream(adaptor,"token QUOTED_STRING");

		try {
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:45:6: ( TITLE QUOTED_STRING -> QUOTED_STRING )
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:45:8: TITLE QUOTED_STRING
			{
			TITLE6=(Token)match(input,TITLE,FOLLOW_TITLE_in_title87);  
			stream_TITLE.add(TITLE6);

			QUOTED_STRING7=(Token)match(input,QUOTED_STRING,FOLLOW_QUOTED_STRING_in_title89);  
			stream_QUOTED_STRING.add(QUOTED_STRING7);

			// AST REWRITE
			// elements: QUOTED_STRING
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 45:28: -> QUOTED_STRING
			{
				adaptor.addChild(root_0, stream_QUOTED_STRING.nextNode());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "title"


	public static class email_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "email"
	// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:47:1: email : EMAIL QUOTED_STRING -> QUOTED_STRING ;
	public final DictionaryParser.email_return email() throws RecognitionException {
		DictionaryParser.email_return retval = new DictionaryParser.email_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EMAIL8=null;
		Token QUOTED_STRING9=null;

		Object EMAIL8_tree=null;
		Object QUOTED_STRING9_tree=null;
		RewriteRuleTokenStream stream_EMAIL=new RewriteRuleTokenStream(adaptor,"token EMAIL");
		RewriteRuleTokenStream stream_QUOTED_STRING=new RewriteRuleTokenStream(adaptor,"token QUOTED_STRING");

		try {
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:47:6: ( EMAIL QUOTED_STRING -> QUOTED_STRING )
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:47:8: EMAIL QUOTED_STRING
			{
			EMAIL8=(Token)match(input,EMAIL,FOLLOW_EMAIL_in_email100);  
			stream_EMAIL.add(EMAIL8);

			QUOTED_STRING9=(Token)match(input,QUOTED_STRING,FOLLOW_QUOTED_STRING_in_email102);  
			stream_QUOTED_STRING.add(QUOTED_STRING9);

			// AST REWRITE
			// elements: QUOTED_STRING
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 47:28: -> QUOTED_STRING
			{
				adaptor.addChild(root_0, stream_QUOTED_STRING.nextNode());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "email"


	public static class entry_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "entry"
	// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:49:1: entry : QUOTED_STRING SEPARATOR level -> ^( ENTRY QUOTED_STRING level ) ;
	public final DictionaryParser.entry_return entry() throws RecognitionException {
		DictionaryParser.entry_return retval = new DictionaryParser.entry_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token QUOTED_STRING10=null;
		Token SEPARATOR11=null;
		ParserRuleReturnScope level12 =null;

		Object QUOTED_STRING10_tree=null;
		Object SEPARATOR11_tree=null;
		RewriteRuleTokenStream stream_SEPARATOR=new RewriteRuleTokenStream(adaptor,"token SEPARATOR");
		RewriteRuleTokenStream stream_QUOTED_STRING=new RewriteRuleTokenStream(adaptor,"token QUOTED_STRING");
		RewriteRuleSubtreeStream stream_level=new RewriteRuleSubtreeStream(adaptor,"rule level");

		try {
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:49:6: ( QUOTED_STRING SEPARATOR level -> ^( ENTRY QUOTED_STRING level ) )
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:49:8: QUOTED_STRING SEPARATOR level
			{
			QUOTED_STRING10=(Token)match(input,QUOTED_STRING,FOLLOW_QUOTED_STRING_in_entry113);  
			stream_QUOTED_STRING.add(QUOTED_STRING10);

			SEPARATOR11=(Token)match(input,SEPARATOR,FOLLOW_SEPARATOR_in_entry115);  
			stream_SEPARATOR.add(SEPARATOR11);

			pushFollow(FOLLOW_level_in_entry117);
			level12=level();
			state._fsp--;

			stream_level.add(level12.getTree());
			// AST REWRITE
			// elements: QUOTED_STRING, level
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 49:38: -> ^( ENTRY QUOTED_STRING level )
			{
				// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:49:41: ^( ENTRY QUOTED_STRING level )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ENTRY, "ENTRY"), root_1);
				adaptor.addChild(root_1, stream_QUOTED_STRING.nextNode());
				adaptor.addChild(root_1, stream_level.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "entry"


	public static class level_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "level"
	// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:51:1: level : ( BEGINNER | ADVANCED | MASTER ) ;
	public final DictionaryParser.level_return level() throws RecognitionException {
		DictionaryParser.level_return retval = new DictionaryParser.level_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set13=null;

		Object set13_tree=null;

		try {
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:51:6: ( ( BEGINNER | ADVANCED | MASTER ) )
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\parser\\DictionaryParser.g:
			{
			root_0 = (Object)adaptor.nil();


			set13=input.LT(1);
			if ( (input.LA(1) >= ADVANCED && input.LA(1) <= BEGINNER)||input.LA(1)==MASTER ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set13));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "level"

	// Delegated rules



	public static final BitSet FOLLOW_title_in_main56 = new BitSet(new long[]{0x0000000000000900L});
	public static final BitSet FOLLOW_email_in_main58 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_OPEN_in_main61 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_entry_in_main63 = new BitSet(new long[]{0x0000000000001040L});
	public static final BitSet FOLLOW_CLOSE_in_main66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TITLE_in_title87 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_QUOTED_STRING_in_title89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMAIL_in_email100 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_QUOTED_STRING_in_email102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTED_STRING_in_entry113 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_SEPARATOR_in_entry115 = new BitSet(new long[]{0x0000000000000430L});
	public static final BitSet FOLLOW_level_in_entry117 = new BitSet(new long[]{0x0000000000000002L});
}

// $ANTLR 3.5.2 C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g 2014-12-22 12:23:22

package org.moflon.moca.board.parser; 
import java.util.Collection;
import Moca.MocaFactory;
import Moca.Problem;
import Moca.ProblemType;
import org.moflon.moca.MocaTokenFactory;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class BoardParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLSEP", "EMPTY", "FIGURE", "NEWLINE", 
		"NUM", "WHITESPACE", "BOARD", "BOARD_SPEC", "COLS", "COLUMN", "DIMENSIONS", 
		"ROW", "ROWS"
	};
	public static final int EOF=-1;
	public static final int COLSEP=4;
	public static final int EMPTY=5;
	public static final int FIGURE=6;
	public static final int NEWLINE=7;
	public static final int NUM=8;
	public static final int WHITESPACE=9;
	public static final int BOARD=10;
	public static final int BOARD_SPEC=11;
	public static final int COLS=12;
	public static final int COLUMN=13;
	public static final int DIMENSIONS=14;
	public static final int ROW=15;
	public static final int ROWS=16;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public BoardParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public BoardParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return BoardParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g"; }


	  int rows = 0;
	  int cols = 0;	

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
	// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:55:1: main : (r+= row )+ -> ^( BOARD_SPEC ^( DIMENSIONS ^( ROWS ) ^( COLS ) ) ^( BOARD ( $r)* ) ) ;
	public final BoardParser.main_return main() throws RecognitionException {
		BoardParser.main_return retval = new BoardParser.main_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		List<Object> list_r=null;
		RuleReturnScope r = null;
		RewriteRuleSubtreeStream stream_row=new RewriteRuleSubtreeStream(adaptor,"rule row");

		try {
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:55:5: ( (r+= row )+ -> ^( BOARD_SPEC ^( DIMENSIONS ^( ROWS ) ^( COLS ) ) ^( BOARD ( $r)* ) ) )
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:55:7: (r+= row )+
			{
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:55:7: (r+= row )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==COLSEP) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:55:8: r+= row
					{
					pushFollow(FOLLOW_row_in_main97);
					r=row();
					state._fsp--;

					stream_row.add(r.getTree());
					if (list_r==null) list_r=new ArrayList<Object>();
					list_r.add(r.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// AST REWRITE
			// elements: r
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: r
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"token r",list_r);
			root_0 = (Object)adaptor.nil();
			// 56:5: -> ^( BOARD_SPEC ^( DIMENSIONS ^( ROWS ) ^( COLS ) ) ^( BOARD ( $r)* ) )
			{
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:56:8: ^( BOARD_SPEC ^( DIMENSIONS ^( ROWS ) ^( COLS ) ) ^( BOARD ( $r)* ) )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOARD_SPEC, "BOARD_SPEC"), root_1);
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:56:21: ^( DIMENSIONS ^( ROWS ) ^( COLS ) )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(DIMENSIONS, "DIMENSIONS"), root_2);
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:56:34: ^( ROWS )
				{
				Object root_3 = (Object)adaptor.nil();
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROWS, "ROWS"), root_3);
				adaptor.addChild(root_3, MocaTokenFactory.createCommonTree("NUM", rows + "", tokenNames));
				adaptor.addChild(root_2, root_3);
				}

				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:57:11: ^( COLS )
				{
				Object root_3 = (Object)adaptor.nil();
				root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(COLS, "COLS"), root_3);
				adaptor.addChild(root_3, MocaTokenFactory.createCommonTree("NUM", cols/rows + "", tokenNames));
				adaptor.addChild(root_2, root_3);
				}

				adaptor.addChild(root_1, root_2);
				}

				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:58:10: ^( BOARD ( $r)* )
				{
				Object root_2 = (Object)adaptor.nil();
				root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOARD, "BOARD"), root_2);
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:58:19: ( $r)*
				while ( stream_r.hasNext() ) {
					adaptor.addChild(root_2, stream_r.nextTree());
				}
				stream_r.reset();

				adaptor.addChild(root_1, root_2);
				}

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


	public static class row_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "row"
	// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:1: row : (c+= column )+ COLSEP ( NEWLINE | EOF ) -> ^( ROW ( $c)* ) ;
	public final BoardParser.row_return row() throws RecognitionException {
		BoardParser.row_return retval = new BoardParser.row_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COLSEP1=null;
		Token NEWLINE2=null;
		Token EOF3=null;
		List<Object> list_c=null;
		RuleReturnScope c = null;
		Object COLSEP1_tree=null;
		Object NEWLINE2_tree=null;
		Object EOF3_tree=null;
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleTokenStream stream_COLSEP=new RewriteRuleTokenStream(adaptor,"token COLSEP");
		RewriteRuleSubtreeStream stream_column=new RewriteRuleSubtreeStream(adaptor,"rule column");

		try {
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:4: ( (c+= column )+ COLSEP ( NEWLINE | EOF ) -> ^( ROW ( $c)* ) )
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:6: (c+= column )+ COLSEP ( NEWLINE | EOF )
			{
			rows++;
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:16: (c+= column )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==COLSEP) ) {
					int LA2_1 = input.LA(2);
					if ( ((LA2_1 >= EMPTY && LA2_1 <= FIGURE)) ) {
						alt2=1;
					}

				}

				switch (alt2) {
				case 1 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:17: c+= column
					{
					pushFollow(FOLLOW_column_in_row166);
					c=column();
					state._fsp--;

					stream_column.add(c.getTree());
					if (list_c==null) list_c=new ArrayList<Object>();
					list_c.add(c.getTree());
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			COLSEP1=(Token)match(input,COLSEP,FOLLOW_COLSEP_in_row170);  
			stream_COLSEP.add(COLSEP1);

			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:36: ( NEWLINE | EOF )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==NEWLINE) ) {
				alt3=1;
			}
			else if ( (LA3_0==EOF) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:37: NEWLINE
					{
					NEWLINE2=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_row173);  
					stream_NEWLINE.add(NEWLINE2);

					}
					break;
				case 2 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:47: EOF
					{
					EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_row177);  
					stream_EOF.add(EOF3);

					}
					break;

			}

			// AST REWRITE
			// elements: c
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: c
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"token c",list_c);
			root_0 = (Object)adaptor.nil();
			// 59:52: -> ^( ROW ( $c)* )
			{
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:55: ^( ROW ( $c)* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROW, "ROW"), root_1);
				// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:59:62: ( $c)*
				while ( stream_c.hasNext() ) {
					adaptor.addChild(root_1, stream_c.nextTree());
				}
				stream_c.reset();

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
	// $ANTLR end "row"


	public static class column_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "column"
	// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:1: column : ( ( COLSEP f= FIGURE ) -> ^( COLUMN $f) | ( COLSEP EMPTY ) -> COLUMN );
	public final BoardParser.column_return column() throws RecognitionException {
		BoardParser.column_return retval = new BoardParser.column_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token f=null;
		Token COLSEP4=null;
		Token COLSEP5=null;
		Token EMPTY6=null;

		Object f_tree=null;
		Object COLSEP4_tree=null;
		Object COLSEP5_tree=null;
		Object EMPTY6_tree=null;
		RewriteRuleTokenStream stream_FIGURE=new RewriteRuleTokenStream(adaptor,"token FIGURE");
		RewriteRuleTokenStream stream_EMPTY=new RewriteRuleTokenStream(adaptor,"token EMPTY");
		RewriteRuleTokenStream stream_COLSEP=new RewriteRuleTokenStream(adaptor,"token COLSEP");

		try {
			// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:7: ( ( COLSEP f= FIGURE ) -> ^( COLUMN $f) | ( COLSEP EMPTY ) -> COLUMN )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==COLSEP) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==FIGURE) ) {
					alt4=1;
				}
				else if ( (LA4_1==EMPTY) ) {
					alt4=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:9: ( COLSEP f= FIGURE )
					{
					cols++;
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:19: ( COLSEP f= FIGURE )
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:20: COLSEP f= FIGURE
					{
					COLSEP4=(Token)match(input,COLSEP,FOLLOW_COLSEP_in_column197);  
					stream_COLSEP.add(COLSEP4);

					f=(Token)match(input,FIGURE,FOLLOW_FIGURE_in_column201);  
					stream_FIGURE.add(f);

					}

					// AST REWRITE
					// elements: f
					// token labels: f
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_f=new RewriteRuleTokenStream(adaptor,"token f",f);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 60:37: -> ^( COLUMN $f)
					{
						// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:40: ^( COLUMN $f)
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COLUMN, "COLUMN"), root_1);
						adaptor.addChild(root_1, stream_f.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:55: ( COLSEP EMPTY )
					{
					cols++;
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:65: ( COLSEP EMPTY )
					// C:\\Workspace\\TestWorkspace_17_12_14\\TrafoZoo0\\BoardGameTGG_eMoflonTutorial\\src\\org\\moflon\\moca\\board\\parser\\BoardParser.g:60:66: COLSEP EMPTY
					{
					COLSEP5=(Token)match(input,COLSEP,FOLLOW_COLSEP_in_column218);  
					stream_COLSEP.add(COLSEP5);

					EMPTY6=(Token)match(input,EMPTY,FOLLOW_EMPTY_in_column220);  
					stream_EMPTY.add(EMPTY6);

					}

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 60:80: -> COLUMN
					{
						adaptor.addChild(root_0, (Object)adaptor.create(COLUMN, "COLUMN"));
					}


					retval.tree = root_0;

					}
					break;

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
	// $ANTLR end "column"

	// Delegated rules



	public static final BitSet FOLLOW_row_in_main97 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_column_in_row166 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_COLSEP_in_row170 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_NEWLINE_in_row173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EOF_in_row177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLSEP_in_column197 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_FIGURE_in_column201 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLSEP_in_column218 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_EMPTY_in_column220 = new BitSet(new long[]{0x0000000000000002L});
}

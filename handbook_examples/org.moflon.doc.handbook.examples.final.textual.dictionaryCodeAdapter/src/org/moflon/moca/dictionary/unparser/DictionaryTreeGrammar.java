// $ANTLR 3.5.2 C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g 2015-07-31 10:50:58

package org.moflon.moca.dictionary.unparser;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings("all")
public class DictionaryTreeGrammar extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ID", "STRING", "'DICTIONARY'", 
		"'ENTRY'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int ATTRIBUTE=4;
	public static final int ID=5;
	public static final int STRING=6;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public DictionaryTreeGrammar(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public DictionaryTreeGrammar(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected StringTemplateGroup templateLib =
	  new StringTemplateGroup("DictionaryTreeGrammarTemplates", AngleBracketTemplateLexer.class);

	public void setTemplateLib(StringTemplateGroup templateLib) {
	  this.templateLib = templateLib;
	}
	public StringTemplateGroup getTemplateLib() {
	  return templateLib;
	}
	/** allows convenient multi-value initialization:
	 *  "new STAttrMap().put(...).put(...)"
	 */
	@SuppressWarnings("serial")
	public static class STAttrMap extends HashMap<String, Object> {
		public STAttrMap put(String attrName, Object value) {
			super.put(attrName, value);
			return this;
		}
	}
	@Override public String[] getTokenNames() { return DictionaryTreeGrammar.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g"; }


		public Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)	throws RecognitionException  {
			try {
	        		return super.recoverFromMismatchedToken(input, ttype, follow);
	            } catch(java.util.NoSuchElementException e){
	                throw new IllegalArgumentException("Your tree does not comply with your tree grammar!\n"
	                		+ " Problems encountered at: [" + "..." + getTreeNodeStream().LT(-1) + " " 
	                		+ getTreeNodeStream().LT(1) + "..." + "] in tree.");
			}
	    }


	public static class main_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "main"
	// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:34:1: main : ^( 'DICTIONARY' name= STRING (author= STRING )? (entries+= entry )+ ) -> dictionary(name=$nameauthor=$authorentires=$entries);
	public final DictionaryTreeGrammar.main_return main() throws RecognitionException {
		DictionaryTreeGrammar.main_return retval = new DictionaryTreeGrammar.main_return();
		retval.start = input.LT(1);

		CommonTree name=null;
		CommonTree author=null;
		List<Object> list_entries=null;
		RuleReturnScope entries = null;
		try {
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:34:5: ( ^( 'DICTIONARY' name= STRING (author= STRING )? (entries+= entry )+ ) -> dictionary(name=$nameauthor=$authorentires=$entries))
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:34:7: ^( 'DICTIONARY' name= STRING (author= STRING )? (entries+= entry )+ )
			{
			match(input,7,FOLLOW_7_in_main86); 
			match(input, Token.DOWN, null); 
			name=(CommonTree)match(input,STRING,FOLLOW_STRING_in_main90); 
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:34:40: (author= STRING )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==STRING) ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:34:40: author= STRING
					{
					author=(CommonTree)match(input,STRING,FOLLOW_STRING_in_main94); 
					}
					break;

			}

			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:34:56: (entries+= entry )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==8) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:34:56: entries+= entry
					{
					pushFollow(FOLLOW_entry_in_main99);
					entries=entry();
					state._fsp--;

					if (list_entries==null) list_entries=new ArrayList<Object>();
					list_entries.add(entries.getTemplate());
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 35:14: -> dictionary(name=$nameauthor=$authorentires=$entries)
			{
				retval.st = templateLib.getInstanceOf("dictionary",new STAttrMap().put("name", name).put("author", author).put("entires", list_entries));
			}



			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "main"


	public static class entry_return extends TreeRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "entry"
	// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:37:1: entry : ^( 'ENTRY' entryLabel= STRING level= STRING ) -> entry(entry=$entryLabellevel=$level);
	public final DictionaryTreeGrammar.entry_return entry() throws RecognitionException {
		DictionaryTreeGrammar.entry_return retval = new DictionaryTreeGrammar.entry_return();
		retval.start = input.LT(1);

		CommonTree entryLabel=null;
		CommonTree level=null;

		try {
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:37:6: ( ^( 'ENTRY' entryLabel= STRING level= STRING ) -> entry(entry=$entryLabellevel=$level))
			// C:\\Users\\rkluge\\Documents\\data\\workspaces\\eMoflon-runtime-workspaces\\emoflon-workspace_temp\\DictionaryCodeAdapter\\src\\org\\moflon\\moca\\dictionary\\unparser\\DictionaryTreeGrammar.g:37:8: ^( 'ENTRY' entryLabel= STRING level= STRING )
			{
			match(input,8,FOLLOW_8_in_entry128); 
			match(input, Token.DOWN, null); 
			entryLabel=(CommonTree)match(input,STRING,FOLLOW_STRING_in_entry132); 
			level=(CommonTree)match(input,STRING,FOLLOW_STRING_in_entry136); 
			match(input, Token.UP, null); 

			// TEMPLATE REWRITE
			// 38:9: -> entry(entry=$entryLabellevel=$level)
			{
				retval.st = templateLib.getInstanceOf("entry",new STAttrMap().put("entry", entryLabel).put("level", level));
			}



			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "entry"

	// Delegated rules



	public static final BitSet FOLLOW_7_in_main86 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_STRING_in_main90 = new BitSet(new long[]{0x0000000000000140L});
	public static final BitSet FOLLOW_STRING_in_main94 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_entry_in_main99 = new BitSet(new long[]{0x0000000000000108L});
	public static final BitSet FOLLOW_8_in_entry128 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_STRING_in_entry132 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_STRING_in_entry136 = new BitSet(new long[]{0x0000000000000008L});
}

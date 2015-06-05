package org.moflon.moca.board.unparser;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import Moca.unparser.impl.TemplateUnparserImpl;

public class BoardUnparserAdapter extends TemplateUnparserImpl {

	@Override
	public boolean canUnparseFile(String fileName) {
		return fileName.endsWith(".board");
	}

	@Override
	protected String callMainRule(CommonTreeNodeStream tree,
			StringTemplateGroup templates) throws RecognitionException {
		BoardTreeGrammar boardTreeGrammar = new BoardTreeGrammar(tree);
		boardTreeGrammar.setTemplateLib(templates);
		StringTemplate st = boardTreeGrammar.main().st;
		if (st == null) {
			return "";
		} else {
			return st.toString();
		}
	}

	@Override
	protected StringTemplateGroup getStringTemplateGroup()
			throws FileNotFoundException {
		return new StringTemplateGroup(new FileReader(new File(
				"./templates/board-text.stg")));
	}

	@Override
	protected String[] getTokenNames() {
		return BoardTreeGrammar.tokenNames;
	}
}
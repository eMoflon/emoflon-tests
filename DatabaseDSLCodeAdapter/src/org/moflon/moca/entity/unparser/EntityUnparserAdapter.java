package org.moflon.moca.entity.unparser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.moflon.moca.MocaTreeSorter;

import Moca.unparser.impl.UnparserImpl;
import MocaTree.Node;

public class EntityUnparserAdapter extends UnparserImpl 
{
  
  @Override
  public boolean canUnparseFile(String fileName) 
  {
    return fileName.endsWith(".entity");
  }

  @Override
	public String unparse(Node root) {
	    MocaTreeSorter.sort(root);
		StringTemplate main = null;
		try {
			main = getStringTemplateGroup().getInstanceOf("main");
			main.setAttribute("root", root);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return main.toString();
	}

	protected StringTemplateGroup getStringTemplateGroup() throws FileNotFoundException {
		return new StringTemplateGroup(new FileReader(new File("templates/Entity.stg")));
	}
}
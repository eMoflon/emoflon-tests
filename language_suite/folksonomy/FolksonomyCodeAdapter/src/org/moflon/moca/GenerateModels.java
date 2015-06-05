package org.moflon.moca;

import org.moflon.core.utilities.eMoflonEMFUtil;

import FolksonomyLanguage.Folksonomy;
import FolksonomyLanguage.FolksonomyLanguageFactory;


public class GenerateModels {
	public static void main(String[] args) {
		Folksonomy folksonomy = FolksonomyLanguageFactory.eINSTANCE.createFolksonomy();
		
		// Create 20 users
		for (int i = 0; i < 20; i++) {
			folksonomy.createUser("Jane Doe " + i);			
		}
		
		// Add 5 friendships for 3 of the users
		for (int i = 0; i < 3; i++) {	
			for(int j = 0; j < 5; j++)
				folksonomy.makeNewFriendForUser(folksonomy.getUsers().get(i)); 
		}
	
		// Save model
		eMoflonEMFUtil.saveModel(folksonomy, "instances/source.xmi");
	}
}

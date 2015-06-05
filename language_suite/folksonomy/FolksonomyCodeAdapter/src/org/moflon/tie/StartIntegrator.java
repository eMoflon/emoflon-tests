package org.moflon.tie;

import org.apache.log4j.BasicConfigurator;
import org.moflon.core.utilities.eMoflonEMFUtil;

import FolksonomyCodeAdapter.FolksonomyCodeAdapterPackage;
import FolksonomyLanguage.FolksonomyLanguagePackage;

public class StartIntegrator {

	public static void main(String[] args) throws Exception {

		// Set up logging
		BasicConfigurator.configure();

		// Register packages
		eMoflonEMFUtil.init(FolksonomyCodeAdapterPackage.eINSTANCE);
		eMoflonEMFUtil.init(FolksonomyLanguagePackage.eINSTANCE);

		// Start integrator
		// TODO[aanjorin,eleblebici] How to fix this?
		// IntegratorApp.startIntegrator(args);
	}
}
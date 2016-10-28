HowTo Build and Test the GRaViTY Test Workspace:

Requirements:
1. Eclipse Modeling Tools (tested with Mars and Neon)
2. MoDisco Plugin (install from Eclipse Modeling Components)
3. The eMoflon Plugin you want to test

Build:
1. Build the "org.gravity.typegraph.basic" project from the 
   eap-file in the "org.gravity.metamodels.typegraph" project.
2. Build the "org.gravity.modisco" and the "org.garvity.tgg.modisco"
   projects from the eap-file in the "org.gravity.metamodels.modisco" project

Tests:
1. If you are executing the testes the first time:
 	a) Execute the "GRaViTY_Java_Test_Src.launch" Runtime configuration from the
	"org.gravity.tgg.modisco.test" project
	b) import all projects contained in the "java_src" fodler into the workspace.
	c) Close the Eclipse instance launched in a)
2. Execute the "JUnitAllTests.launch" Runtime configuration.

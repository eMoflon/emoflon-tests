package launchconfig;

import ioutil.FILEWRITER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class LaunchConfigGenerator {

	// CHANGE THIS AS DESIRED: how is your running project called?
	static final String projectName = "FamilyToPersonTGG";


	// CHANGE THIS AS DESIRED: how is the main class called?
	static final String mainClassName = "TGGMain";

	// CHANGE THIS AS DESIRED: in which package is your main Class?
	static final String[] mainClassPackageFragments = { "org", "moflon", "tie" };

	// CHANGE THIS AS DESIRED: each model size is passed as argument (args[]) into a launch. (for example, TGGMain_
	static final String[] modelSizes = { "125", "250", "500", "1000", "2000",
			"3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000",
			"20000", "30000", "40000", "50000", "100000", "200000", "300000",
			"400000", "500000", "1000000" };

	// CHANGE THIS AS DESIRED: how many time should your measurements repeated?
	static final int repeat = 10;

	// CHANGE THIS AS DESIRED: vm arguments
	static final String vmArguments = "-Xms8G -Xmx8G -XX:PermSize=512m -XX:MaxPermSize=512m";

	//DON'T CHANGE ANYTHING BELOW
	
	public static void main(String[] args) throws IOException {

		for (String argument : modelSizes) {
			generateLaunchConfig(argument);
		}
		generateLaunchGroup();
	}

	private static void generateLaunchConfig(String argument)
			throws FileNotFoundException, IOException {
		StringTemplateGroup stg = new StringTemplateGroup(new FileReader(
				new File("./templates/launchconfig.stg")),
				DefaultTemplateLexer.class);
		StringTemplate launchConfig = stg.getTemplateDefinition("launchConfig");
		launchConfig.setAttribute("projectName", projectName);
		launchConfig.setAttribute("fragments", mainClassPackageFragments);
		launchConfig.setAttribute("vmarguments", vmArguments);
		launchConfig.setAttribute("programarguments", argument);
		launchConfig.setAttribute("className", mainClassName);

		String content = launchConfig.toString();

		File file = new File("./launchconfig/" + mainClassName + "_" + argument
				+ ".launch");
		file.getParentFile().mkdirs();
		file.createNewFile();

		FILEWRITER.write(file, content);

	}

	private static void generateLaunchGroup() throws IOException {

		File file = new File(
				"./launchconfig/GROUP.launch");
		file.createNewFile();

		StringTemplateGroup stg = new StringTemplateGroup(new FileReader(
				new File("./templates/launchconfig.stg")),
				DefaultTemplateLexer.class);
		StringTemplate start = stg.getTemplateDefinition("launchGroupStart");

		FILEWRITER.write(file, start.toString());

		int index = 0;
		for (String argument : modelSizes) {
			for (int i = 0; i < repeat; i++) {
				StringTemplate body = stg.getTemplateDefinition("launchGroup");
				body.setAttribute("index", index++);
				body.setAttribute("config", mainClassName + "_" + argument);
				FILEWRITER.writeLine(file, body.toString());
				body.reset();
			}
		}
		StringTemplate end = stg.getTemplateDefinition("launchGroupEnd");
		FILEWRITER.writeLine(file, end.toString());
	}

}

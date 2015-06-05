package osm.input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.moflon.tie.OSMTGGTrafo;

public class LaunchGenerator {

	private int benchmarks = 0;
	private int elementCounter = 0;
	private int launchCounter = 0;

	private final static String path = System.getProperty("user.dir");
	private final static String testDataPath = path + File.separator + "instances" + File.separator;
	private final static String groupPath = path + File.separator + "run" + File.separator + "OSM_Benchmarking_Launch_Group.launch";
	private final static String calledPath = path + File.separator + "run" + File.separator + "called" + File.separator + "OSMBenchmark_";

	public static void main(String[] args) {
		(new LaunchGenerator()).generateMultipleConfig();
	}

	private void generateMultipleConfig() {
		StringBuffer groupBuffer = initializeConfig();
		
		File[] folders = new File(testDataPath).listFiles();
		Arrays.sort(folders, (a, b) -> Integer.parseInt(a.getName()) - Integer.parseInt(b.getName()));

		for (File folder : folders) {
			if (!folder.isDirectory())
				continue;

			File[] files = folder.listFiles((File f) -> f.getName().endsWith("src.xmi"));
			System.out.println("-------- Folder: " + folder.getName() + " ---------");
			for (File sourceFile : files) {
				System.out.println("adding: " + sourceFile.getName());
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath(), "FORWARD");
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath().replace("src", "trg"), "BACKWARD");
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath(), "FORWARD_SYNC");
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath().replace("src", "trg"), "BACKWARD_SYNC");
				
				if(elementCounter >= 99) {
					finalizeConfig(groupBuffer);
					save(groupPath + "_" + launchCounter + ".launch", groupBuffer);
					
					groupBuffer = initializeConfig();
					launchCounter++;
					elementCounter = 0;
				}
			}
		}
		
		finalizeConfig(groupBuffer);
		save(groupPath  + "_" + launchCounter + ".launch", groupBuffer);
	}
	
	private void generateLaunchConfig() {
		StringBuffer groupBuffer = initializeConfig();
		
		File[] folders = new File(testDataPath).listFiles(/*(File f) -> Integer.parseInt(f.getName()) <= 100*/);
		Arrays.sort(folders, (a, b) -> Integer.parseInt(a.getName()) - Integer.parseInt(b.getName()));

		for (File folder : folders) {
			if (!folder.isDirectory())
				continue;

			File[] files = folder.listFiles();
			System.out.println("-------- Folder: " + folder.getName() + " ---------");
			for (File sourceFile : files) {
				System.out.println("adding: " + sourceFile.getName());
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath(), "FORWARD");
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath().replace("src", "trg"), "BACKWARD");
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath(), "FORWARD_SYNC");
				addBenchmarkToConfig(groupBuffer, sourceFile.getAbsolutePath().replace("src", "trg"), "BACKWARD_SYNC");
			}
		}
		
		finalizeConfig(groupBuffer);
		save(groupPath + ".launch", groupBuffer);
	}

	private void addBenchmarkToConfig(StringBuffer groupBuffer, String path, String direction) {
		groupBuffer.append("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup." + elementCounter + ".action\" value=\"WAIT_FOR_TERMINATION\"/>\n");
		groupBuffer.append("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup." + elementCounter + ".enabled\" value=\"true\"/>\n");
		groupBuffer.append("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup." + elementCounter + ".mode\" value=\"run\"/>\n");
		groupBuffer.append("<stringAttribute key=\"org.eclipse.cdt.launch.launchGroup." + elementCounter + ".name\" value=\"OSMBenchmark_" + benchmarks + "\"/>\n");
		
		StringBuffer benchmarkLaunch = new StringBuffer();
		benchmarkLaunch.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
		benchmarkLaunch.append("<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">\n");
		benchmarkLaunch.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">\n");
		benchmarkLaunch.append("<listEntry value=\"/OSMBenchmarkAdapter/src/osm/benchmark/OSMBenchmark.java\"/>\n");
		benchmarkLaunch.append("</listAttribute>\n");
		benchmarkLaunch.append("<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">\n");
		benchmarkLaunch.append("<listEntry value=\"1\"/>\n");
		benchmarkLaunch.append("</listAttribute>\n");
		benchmarkLaunch.append("<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"osm.benchmark.OSMBenchmark\"/>\n");
		benchmarkLaunch.append("<stringAttribute key=\"org.eclipse.jdt.launching.PROGRAM_ARGUMENTS\" value=\"" + path + " " + direction + "\"/>\n");
		benchmarkLaunch.append("<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"OSMBenchmarkAdapter\"/>\n");
		benchmarkLaunch.append("<stringAttribute key=\"org.eclipse.jdt.launching.VM_ARGUMENTS\" value=\"-Dosgi.requiredJavaVersion=1.5 -XX:+UseParallelGC -Xms256M -Xmx6144M\"/>");
		benchmarkLaunch.append("</launchConfiguration>\n");

		save(calledPath + benchmarks + ".launch", benchmarkLaunch);
		
		benchmarks++;
		elementCounter++;
	}

	private StringBuffer initializeConfig() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
		buffer.append("<launchConfiguration type=\"org.eclipse.cdt.launch.launchGroup\">\n");
		buffer.append("<stringAttribute key=\"bad_container_name\" value=\"\\OSMBenchmarkAdapter\\running\\\"/>\n");
		
		return buffer;
	}

	private void finalizeConfig(StringBuffer buffer) {
		buffer.append("<listAttribute key=\"org.eclipse.debug.ui.favoriteGroups\">\n");
		buffer.append("<listEntry value=\"org.eclipse.debug.ui.launchGroup.run\"/>\n");
		buffer.append("</listAttribute>\n");
		buffer.append("</launchConfiguration>\n");
	}

	private void save(String path, StringBuffer buffer) {
		File outputFile = new File(path);
		try {
			outputFile.createNewFile();
			FileWriter writer = new FileWriter(outputFile);
			writer.append(buffer.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

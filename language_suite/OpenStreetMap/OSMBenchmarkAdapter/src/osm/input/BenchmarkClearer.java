package osm.input;

import java.io.File;
import java.io.IOException;

public class BenchmarkClearer {

	private final static String path = System.getProperty("user.dir");
	private final static String loggingPath = path + File.separator + "benchmarkOutput" + File.separator;
	private final static String calledPath = path + File.separator + "run" + File.separator + "called" + File.separator;
	private final static String instancePath = path + File.separator + "instances" + File.separator;
	private final static String plotPath = path + File.separator + "plot" + File.separator;

	public static void main(String[] args) {
		if (args.length == 0)
			new BenchmarkClearer().clearAllButLogging();

		switch (args[0]) {
		case "CLEAR_ALL":
			new BenchmarkClearer().clearAll();
			break;
		case "CLEAR_ALL_BUT_LOGGING":
			new BenchmarkClearer().clearAllButLogging();
			break;
		default: new BenchmarkClearer().clearAllButLogging(); break;
		}
	}

	public void clearAllButLogging() {
		removeInstances();
		removeBenchmarkConfigs();
	}

	public void clearAll() {
		removeInstances();
		removeBenchmarkConfigs();
		removeLogging();
		removePlot();
	}

	private void removeBenchmarkConfigs() {
		File calledFolder = new File(calledPath);
		File[] callings = calledFolder.listFiles();
		for (File f : callings) {
			f.delete();
		}
	}

	private void removeInstances() {
		File instanceFolder = new File(instancePath);
		File[] instanceFolders = instanceFolder.listFiles();
		for (File folder : instanceFolders) {
			File[] instances = folder.listFiles();
			for (File instance : instances) {
				if (instance.isDirectory()) {
					File[] subFolderFiles = instance.listFiles();
					for (File subFolderFile : subFolderFiles)
						subFolderFile.delete();
				}
				instance.delete();
			}
			folder.delete();
		}

	}

	private void removeLogging() {
		File loggingFolder = new File(loggingPath);
		File[] loggingFolders = loggingFolder.listFiles();
		for (File f : loggingFolders) {
			File[] logs = f.listFiles();
			for (File log : logs) {
				log.delete();
			}
			f.delete();
		}
	}
	
	private void removePlot() {
		File plotFolder = new File(plotPath);
		File[] plots = plotFolder.listFiles();
		for(File f : plots)
			f.delete();
	}
}

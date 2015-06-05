package osm.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public interface BenchmarkOutput {
	
	final static String path = System.getProperty("user.dir");
	final static String loggingPath = path + File.separator + "benchmarkOutput" + File.separator;
	
	
	default void saveToLog(String folderName, String fileName, double time, int modelSize) {
		File loggingFile = new File(loggingPath + folderName + File.separator + fileName + ".txt");
		if (!loggingFile.exists())
			try {
				new File (loggingPath + folderName).mkdirs();
				loggingFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		FileWriter writer = null;
		try {
			writer = new FileWriter(loggingFile, true);
			writer.append(modelSize + " " + time + "\n");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

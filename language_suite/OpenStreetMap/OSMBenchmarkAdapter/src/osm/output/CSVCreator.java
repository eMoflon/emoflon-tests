package osm.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CSVCreator {

	
	final static String path = System.getProperty("user.dir");
	final static String loggingPath = path + File.separator + "benchmarkOutput" + File.separator;
	final static String plottingPath = path + File.separator + "plot" + File.separator;
	
	private static String[] benchmarkNames = {
		"TRANS_BATCH_FOWARD",
		"TRANS_BATCH_BACKWARD",
		"TRANS_SYNC_FORWARD",
		"TRANS_SYNC_BACKWARD",
		"PREC_FOWARD",
		"PREC_BACKWARD",
		"PREC_FORWARD_SYNC",
		"PREC_BACKWARD_SYNC",
		"ALL_FORWARD",
		"ALL_BACKWARD",
		"ALL_FORWARD_SYNC",
		"ALL_BACKWARD_SYNC"
	};
	
	public static void main(String[] args) {
		new CSVCreator().createCSV();
	}
	
	private void createCSV() {
		for(String benchmark : benchmarkNames)
			createCSV(benchmark);
	}
	
	private void createCSV(String benchmarkName) {
		File[] folders = new File(loggingPath).listFiles(/*(File f) -> Integer.parseInt(f.getName()) <= 100*/);
		Arrays.sort(folders, (a, b) -> Integer.parseInt(a.getName()) - Integer.parseInt(b.getName()));

		// create new plotting file
		File plotFile = new File(plottingPath + benchmarkName + ".csv");
		if(!plotFile.exists()) {
			new File(plottingPath).mkdirs();
			try {
				plotFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileWriter writer = null;
		try {
			writer = new FileWriter(plotFile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(File folder : folders) {
			double sum = 0;
			
			File loggingFile = new File(loggingPath + folder.getName() + File.separator + benchmarkName + ".txt");
			if(!loggingFile.exists()) {
				System.err.println("Couldn't find " + benchmarkName + ".txt in loggingfolder " + folder.getName());
				continue;
			}
			List<String> content = null;
			try {
				content = Files.readAllLines(Paths.get(loggingFile.getAbsolutePath()));
				if(content == null) {
					System.err.println("Could not read file " + benchmarkName + ".txt in loggingfolder " + folder.getName());
					continue;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for(String line : content) {
				String[] strings = line.trim().split(" ");
				sum += Double.parseDouble(strings[1]);
			}
			
			double mean = sum / content.size();
			try {
				writer.append(folder.getName() + " " + mean + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

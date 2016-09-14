package ioutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FILEWRITER {

	public static void writeLine(File file, String content){
		
		writeText(file, content, true);
		
	}

	
	
	public static void write(File file, String content){
		
		writeText(file, content, false);
	}
	
	private static void writeText(File file, String content, boolean newLine) {
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(file, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if(newLine){
				output.newLine();
			}
			output.append(content);					
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

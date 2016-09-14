package org.moflon.tie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.commons.math3.stat.descriptive.rank.Median;

public class MeasureAllMain {

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		
		int modelSizes[] = {Integer.valueOf(args[0])};
		boolean incremental = true;

		for (int size : modelSizes) {

			String folderArg = "instances/in" + size + "/";

			ModelGeneratorMain.main(size);
			int iteration = 1;

			double[] parseArray = new double[iteration];
			double[] tggFwdArray = new double[iteration];
			double[] precedenceArray = new double[iteration];
			double[] sdmValidationArray = new double[iteration];
			double[] tggBwdArray = new double[iteration];
			double[] unparseArray = new double[iteration];

			for (int i = 0; i < iteration; i++) {

				
				long parse = ParseMain.main(folderArg);
				parseArray[i] = parse;


				long tggFwd = TGGBatchFWDMain.main(folderArg);
				tggFwdArray[i] = tggFwd;


				if(incremental){
					long precedence = PrecedenceAnalysisMain.main(folderArg);
					precedenceArray[i] = precedence;
				}

				long sdmValidation = SDMValidationMain.main(folderArg);
				sdmValidationArray[i] = sdmValidation;

				long tggBwd = TGGBatchBWDMain.main(folderArg, incremental);
				tggBwdArray[i] = tggBwd;

				long unparse = UnparseMain.main(folderArg);
				unparseArray[i] = unparse;
				
//				MeasurementSocket.reset();
			}

			Median median = new Median();

			Writer output;
			output = new BufferedWriter(new FileWriter("Messungen_Mit_incremental_BWD.txt", true));
			output.append("\n" + size + ";" + (int) median.evaluate(parseArray) + ";"
					+ (int) median.evaluate(tggFwdArray) + ";"
					+ (int) median.evaluate(precedenceArray) + ";"
					+ (int) median.evaluate(sdmValidationArray) + ";"
					+ (int) median.evaluate(tggBwdArray) + ";"
					+ (int) median.evaluate(unparseArray) + ";");
			output.close();			

		}

	}

}

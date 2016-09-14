package osm.benchmark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import osm.output.BenchmarkOutput;
import TGGLanguage.algorithm.GraphTriple;
import TGGLanguage.algorithm.Translator;
import TGGLanguage.algorithm.protocol.impl.TranslationProtocolImpl;

public class OSMTranslationConfigurator extends TranslationProtocolImpl implements BenchmarkOutput{
	
	private long translationStartTime = 0;
	
	@Override
	public void startTranslation(GraphTriple inputTriple) {
		// TODO Auto-generated method stub
		translationStartTime = System.nanoTime();
	}
	
	@Override
	public void finishTranslation(Translator translator, GraphTriple gTriple) {
		// TODO Auto-generated method stub
		double translationDuration = new Double(System.nanoTime() - translationStartTime) / 1000000000;
		if(translator.isIncremental())
			saveToLog(OSMBenchmark.currentFolder, "TRANS_SYNC_" + translator.getApplicationType().toString(), translationDuration, OSMBenchmark.modelSize);
		else
			saveToLog(OSMBenchmark.currentFolder, "TRANS_BATCH_" + translator.getApplicationType().toString(), translationDuration, OSMBenchmark.modelSize);
	}
}

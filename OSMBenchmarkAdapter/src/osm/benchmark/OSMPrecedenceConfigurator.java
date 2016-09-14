package osm.benchmark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import osm.output.BenchmarkOutput;
import TGGLanguage.algorithm.ApplicationTypes;
import TGGLanguage.algorithm.GraphTriple;
import TGGLanguage.algorithm.precedence.PrecedenceAnalysis;
import TGGLanguage.algorithm.protocol.impl.PrecedenceProtocolImpl;

public class OSMPrecedenceConfigurator extends PrecedenceProtocolImpl implements BenchmarkOutput {
	private long startCollectionTime = 0;
	
	@Override
	public void matchCollectionStarted(GraphTriple triple) {
		// TODO Auto-generated method stub
		super.matchCollectionStarted(triple);
		startCollectionTime = System.nanoTime();
	}
	
	@Override
	public void matchCollectionFinished(PrecedenceAnalysis analysis) {
		// TODO Auto-generated method stub
		double collectionDuration = new Double(System.nanoTime() - startCollectionTime) / (1000000000);
		super.matchCollectionFinished(analysis);
		if(analysis.isIncremental()) {
			saveToLog(OSMBenchmark.currentFolder, "PREC_" + analysis.getApplicationType().toString() + "_SYNC", collectionDuration, OSMBenchmark.modelSize);			
		}
		else
		{
			saveToLog(OSMBenchmark.currentFolder, "PREC_" + analysis.getApplicationType().toString(), collectionDuration, OSMBenchmark.modelSize);			
		}
	}
}

package osm.benchmark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.apache.log4j.FileAppender;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.moflon.moca.MocaTreeSorter;
import org.moflon.moca.ModelToTreeConverter;
import org.moflon.testframework.tgg.TreeComparator;
import org.moflon.testframework.tgg.xml.unparser.XmlUnparserAdapter;
import org.moflon.tie.OSMTGGSync;
import org.moflon.tie.OSMTGGTrafo;
import org.moflon.util.IntegratorHelper;

import Moca.CodeAdapter;
import Moca.MocaFactory;
import Moca.impl.CodeAdapterImpl;
import ModelDeltaCreator_OSM.impl.ModelDeltaCreator_OSMFactoryImpl;
import OSMLanguage.OSMapContainer;
import osm.output.BenchmarkOutput;

public class OSMBenchmark implements BenchmarkOutput {

	protected static String currentFolder = "";
	protected static int modelSize = 0;
	private final int nano = 1000 * 1000 * 1000;

	private IntegratorHelper helper;

	public static void main(String[] args) {
		String path = "";
		String direction = "";

		for (int i = 0; i < args.length - 1; i++) {
			path += args[i] + " ";
			if (i == args.length - 2)
				direction = args[args.length - 1];
		}
		path = path.trim();

		new OSMBenchmark().benchmark(path, direction);
	}

	private void benchmark(String path, String direction) {
		try {
			if (direction.equals("FORWARD") || direction.equals("BACKWARD")) {
				helper = new OSMTGGTrafo();
				helper.setTranslationProtocol(new OSMTranslationConfigurator());
				helper.setPrecedenceProtocol(new OSMPrecedenceConfigurator());
			} else {
				helper = new OSMTGGSync() {
					@Override
					public void changeSrc(EObject root) {
						try {
							ModelDeltaCreator_OSMFactoryImpl.eINSTANCE.createOSMModelDeltaCreator().addDeleteWay_FWD((MocaTree.Folder) root);
						} catch(IllegalStateException e) {
							
						}
					}

					@Override
					public void changeTrg(EObject root) {
						try {
							ModelDeltaCreator_OSMFactoryImpl.eINSTANCE.createOSMModelDeltaCreator().addDeleteWay_BWD((OSMapContainer) root);
						} catch (IllegalStateException e) {
						}
					}

					@Override
					public void syncForward(String corr) {
						loadTriple(corr);
						setModelSize((MocaTree.Folder) getSrc());
						integrateForward();
						System.out.println("Completed forward synchronization");
					}

					@Override
					public void syncBackward(String corr) {
						loadTriple(corr);
						setModelSize((OSMapContainer) getTrg());
						integrateBackward();
						System.out.println("Completed backward synchronization");
					}
				};
				helper.setTranslationProtocol(new OSMTranslationConfigurator());
				helper.setPrecedenceProtocol(new OSMPrecedenceConfigurator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch (direction) {
		case "FORWARD":
			benchmarkFWD(path);
			break;
		case "BACKWARD":
			benchmarkBWD(path);
			break;
		case "FORWARD_SYNC":
			benchmarkFWDSync(path);
			break;
		case "BACKWARD_SYNC":
			benchmarkBWDSync(path);
			break;
		}
	}

	private void benchmarkFWD(String path) {
		File sourceFile = new File(path);
		currentFolder = sourceFile.getParentFile().getName();
		helper.loadSrc(sourceFile.getAbsolutePath());
		setModelSize((MocaTree.Folder) helper.getSrc());
		((MocaTree.Folder) helper.getSrc()).getFile().get(0).getRootNode().enableCachingForTree();

		long startingTime = System.nanoTime();
		helper.integrateForward();
		long afterForward = System.nanoTime();

		double forwardTime = new Double(afterForward - startingTime) / (nano);

		helper.saveTrg(path.replace("src", "trg"));

		modelSize = ((MocaTree.Folder) helper.getSrc()).getFile().get(0).getRootNode().getChildren().size();
		saveToLog(sourceFile.getParentFile().getName(), "ALL_FORWARD", forwardTime, modelSize);
	}

	private void benchmarkBWD(String path) {
		File targetFile = new File(path);
		currentFolder = targetFile.getParentFile().getName();
		helper.loadTrg(targetFile.getAbsolutePath());
		setModelSize((OSMapContainer) helper.getTrg());
		((OSMapContainer) helper.getTrg()).getName();

		long startingTime = System.nanoTime();
		helper.integrateBackward();
		long afterBackward = System.nanoTime();

		double backwardTime = new Double(afterBackward - startingTime) / (nano);

		helper.saveSrc(path.replace("trg", "src").replace("map", "out\\map"));
		helper.saveCorr(path.replace("trg", "trg.corr").replace("map", "out\\map"));

		saveToLog(targetFile.getParentFile().getName(), "ALL_BACKWARD", backwardTime, modelSize);
	}

	private void benchmarkFWDSync(String path) {
		File sourceFile = new File(path);
		currentFolder = sourceFile.getParentFile().getName();

		long startingTime = System.nanoTime();
		((OSMTGGSync) helper).syncForward(path.replace("src", "trg.corr").replace("map", "out\\map"));
		long afterForward = System.nanoTime();

		double forwardTime = new Double(afterForward - startingTime) / (nano);

		helper.saveTrg(path.replace("src", "src.sync.fwd").replace("map", "out\\map"));
		// helper.saveCorr(path.replace("src", "corr.sync.fwd").replace("map",
		// "out\\map"));

		saveToLog(sourceFile.getParentFile().getName(), "ALL_FORWARD_SYNC", forwardTime, modelSize);
	}

	private void benchmarkBWDSync(String path) {
		File targetFile = new File(path);
		currentFolder = targetFile.getParentFile().getName();

		long startingTime = System.nanoTime();
		((OSMTGGSync) helper).syncBackward(path.replace("trg", "trg.corr").replace("map", "out\\map"));
		long afterForward = System.nanoTime();

		double forwardTime = new Double(afterForward - startingTime) / (nano);

		helper.saveSrc(path.replace("src", "trg.sync.bwd").replace("map", "out\\map"));
		// helper.saveCorr(path.replace("src", "corr.sync.bwd").replace("map",
		// "out\\map"));

		modelSize = ((MocaTree.Folder) helper.getSrc()).getFile().get(0).getRootNode().getChildren().size();
		saveToLog(targetFile.getParentFile().getName(), "ALL_BACKWARD_SYNC", forwardTime, modelSize);
	}

	private static void setModelSize(MocaTree.Folder f) {
		modelSize = f.getFile().get(0).getRootNode().getChildren().size();
	}

	private static void setModelSize(OSMapContainer container) {
		modelSize = 1;
		modelSize += container.getOsmap().get(0).getOsmnode().size();
		modelSize += container.getOsmap().get(0).getOsmway().size();
		modelSize += container.getOsmap().get(0).getOsmrelation().size();
	}
}

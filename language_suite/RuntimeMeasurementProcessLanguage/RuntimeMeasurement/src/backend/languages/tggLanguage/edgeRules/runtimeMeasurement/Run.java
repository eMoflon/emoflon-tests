package backend.languages.tggLanguage.edgeRules.runtimeMeasurement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.moflon.util.IntegratorHelper;
import org.moflon.util.eMoflonEMFUtil;

import ProcessCodeAdapter.ProcessCodeAdapterPackage;
import ProcessCodeAdapter_EdgeRules.ProcessCodeAdapter_EdgeRulesPackage;
import ProcessDefinition.ProcessDefinitionPackage;
import ProcessDefinition_EdgeRules.ProcessDefinition_EdgeRulesPackage;
import TGGLanguage.algorithm.Translator;
import TGGLanguage.algorithm.impl.NodeSequencerImpl;
import TGGLanguage.analysis.StaticAnalysis;
import TGGLanguage.analysis.analysisfacade.AnalysisfacadePackage;


public class Run {

   /**
    * Integration invoked from ant file run.xml 
    * @param args
    * @throws IOException
    */
	public static void main(String[] args) throws IOException {
		if (args.length!=1) {
			System.err.println("file name required");
		}
		else {
			System.out.println(args[0] + "/50");
			run(args[0]); 
		}
	}

	private static BufferedWriter writer;
	
	private static void run(String name) {
		File out = new File("./results.csv");
		try {
			writer = new BufferedWriter(new FileWriter(out, true));
			writer.newLine();

			
			/**
			 * switch between integration with node rules and edge rules
			 */
			nodeRule(new File("./resources/RuntimeMeasurement/nodeRules/"+name));
			//edgeRule(new File("./resources/RuntimeMeasurement/edgeRules/"+name));
			
			
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private static void nodeRule(File file) throws IOException {
		IntegratorHelper integratorHelper = new IntegratorHelper();
		integratorHelper.setCorrPackage(ProcessCodeAdapterPackage.eINSTANCE);
		integratorHelper.setRules((StaticAnalysis) eMoflonEMFUtil.loadModel(
				AnalysisfacadePackage.eINSTANCE,
				"../ProcessCodeAdapter/model/ProcessCodeAdapter.gen.sma.xmi",
				null));
		integratorHelper.setNodeSequencer(new NodeSequencerImpl() {
			@Override
			public void getUnprocessedSequence(Translator translator) {
				int size = translator.getUnprocessedNodes().size()
						+ translator.getUnprocessedEdges().size();
				try {
					writer.write(size + ";" + translator.getUnprocessedNodes().size() + ";" + translator.getUnprocessedEdges().size() + ";");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		integratorHelper.setTrg(eMoflonEMFUtil.loadModel(
				ProcessDefinitionPackage.eINSTANCE, file.getAbsolutePath(),
				null));
		long before = System.nanoTime();
		integratorHelper.integrateBackward();
		long time = Math.round((System.nanoTime() - before) / 1000000);
		writer.write(new Long(time).toString()+";");
		System.out.println(time);
	}

	private static void edgeRule(File file) throws IOException {
		IntegratorHelper integratorHelper = new IntegratorHelper();
		integratorHelper.setCorrPackage(ProcessCodeAdapter_EdgeRulesPackage.eINSTANCE);
		integratorHelper.setRules((StaticAnalysis) eMoflonEMFUtil.loadModel(
				AnalysisfacadePackage.eINSTANCE,
				"../ProcessCodeAdapter_EdgeRules/model/ProcessCodeAdapter_EdgeRules.gen.sma.xmi",
				null));		
		integratorHelper.setNodeSequencer(new NodeSequencerImpl() {
			@Override
			public void getUnprocessedSequence(Translator translator) {
				int size = translator.getUnprocessedNodes().size()
						+ translator.getUnprocessedEdges().size();
				try {
					writer.write(size + ";" + translator.getUnprocessedNodes().size() + ";" + translator.getUnprocessedEdges().size() + ";");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		integratorHelper.setTrg(eMoflonEMFUtil.loadModel(
				ProcessDefinition_EdgeRulesPackage.eINSTANCE,
				file.getAbsolutePath(),
				null));		
		long before = System.nanoTime();
		integratorHelper.integrateBackward();
		long time = Math.round((System.nanoTime() - before) / 1000000);
		writer.write(new Long(time).toString());
		System.out.println(time);
	}
	
}

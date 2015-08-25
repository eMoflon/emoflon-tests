package org.moflon.moca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.eclipse.emf.ecore.EObject;
import org.moflon.moca.xml.parser.XmlParserAdapter;
import org.moflon.moca.xml.unparser.XmlUnparserAdapter;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.tie.SDFToSenseIntegrationTrafo;
import org.moflon.core.utilities.eMoflonEMFUtil;

import org.moflon.core.moca.processing.CodeAdapter;
import org.moflon.core.moca.processing.ProcessingFactory;
import SDFToSenseIntegration.SDFToSenseIntegrationPackage;
import Sense.Actor;
import Sense.Capability;
import Sense.Channel;
import Sense.ProcessorType;
import Sense.SenseModel;

public class SDFToSenseMocaMain {

	private static String[] inputFiles = { "Figure15", "Figure18", "Figure20" };

	public static CodeAdapter codeAdapter;

	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();

		FileUtils.cleanDirectory(new File("instances/models"));
		FileUtils.cleanDirectory(new File("instances/out"));

		init();
		
		for (int i = 0; i < inputFiles.length; i++)
			performRoundtrip(inputFiles[i]);		
	}

	public static void init(){
		// Register parsers and unparsers
		codeAdapter = ProcessingFactory.eINSTANCE.createCodeAdapter();
		codeAdapter.getParser().add(new XmlParserAdapter());
		codeAdapter.getUnparser().add(new XmlUnparserAdapter()); 
	}
	
	private static void performRoundtrip(String input) throws IOException {
		// Perform text-to-tree
		MocaTree.File tree = codeAdapter.parseFile(new File("instances/in/"
				+ input + ".xml"), null);

		// Save tree to file
		String treeFile = "instances/models/" + input + "tree.xmi";
		eMoflonEMFUtil.saveModel(tree, treeFile);

		// Perform tree-to-model
		SDFToSenseIntegrationTrafo transformer = new SDFToSenseIntegrationTrafo();
		transformer.performForward(treeFile);

		// Perform model-to-tree
		transformer = new SDFToSenseIntegrationTrafo();
		transformer.performBackward(treeFile + "_FWD.xmi");

		// Perform tree-to-text (using initial tree)
		MocaTree.File outFile = (MocaTree.File) transformer.getSrc();
		outFile.setName(input + ".xml");
		codeAdapter.unparseFile(outFile, new File("instances/out"));
		
		FileUtils.writeStringToFile(new File("instances/out/" + input + ".sense"), modelToNormalizedText((SenseModel) transformer.getTrg())); 
	}

	public static String modelToNormalizedText(SenseModel model)
			throws FileNotFoundException {
		ArrayList<Actor> actors = new ArrayList<>(model.getActors());
		ArrayList<ProcessorType> processors = new ArrayList<>(model.getProcessors());
		ArrayList<Channel> channels = new ArrayList<>(model.getChannels());
		ArrayList<Capability> capabilities = new ArrayList<>(model.getCapabilities());
		
		Collections.sort(actors, new NameComparator());
		Collections.sort(processors, new NameComparator());
		Collections.sort(channels, new NameComparator());
		Collections.sort(capabilities, new CapabilityComparator());

		StringTemplateGroup senseGroup = new StringTemplateGroup(
				new FileReader(new File("../SDFToSenseIntegration/templates/Sense.stg")),
				AngleBracketTemplateLexer.class);
		
		HashMap<String, Object> attributes = new HashMap<>();
		attributes.put("actors", actors);
		attributes.put("processors", processors);
		attributes.put("channels", channels);
		attributes.put("capabilities", capabilities);
		
		StringTemplate rootTemplate = senseGroup.getInstanceOf("senseModel", attributes);

		return rootTemplate.toString();
	}

}

class NameComparator implements Comparator<EObject> {
	@Override
	public int compare(EObject o1, EObject o2) {
		return eMoflonEMFUtil.getName(o1).compareTo(eMoflonEMFUtil.getName(o2));
	}
}

class CapabilityComparator extends NameComparator {
	@Override
	public int compare(EObject o1, EObject o2) {
		Capability c1 = (Capability) o1;
		Capability c2 = (Capability) o2;
		return super.compare(c1.getPerforms(), c2.getPerforms());
	}
}
package org.moflon.test.derivedfeatures.network.language.NetworkTest;

import org.eclipse.emf.common.util.EList;
import org.moflon.test.derivedfeatures.network.language.Group;
import org.moflon.test.derivedfeatures.network.language.LanguageFactory;
import org.moflon.test.derivedfeatures.network.language.Link;
import org.moflon.test.derivedfeatures.network.language.NetworkSystem;
import org.moflon.test.derivedfeatures.network.language.Node;

public class TestSetup {
	
	private static LanguageFactory factory = LanguageFactory.eINSTANCE;
	private static NetworkSystem network;
	
	public static NetworkSystem createNetworkSystem() {
			network = factory.createNetworkSystem();
			createGroups();
			createNodes();
			assignNodesToGroups();
			linkNodes();
			return network;
	}
	
	private static void createGroups() {
		Group group1 = factory.createGroup();
		group1.setInterest("interest1");
		group1.setSystem(network);
		
		Group group2 = factory.createGroup();
		group2.setInterest("interest2");
		group2.setSystem(network);
		
		Group group1_1 = factory.createGroup();
		group1_1.setInterest("interest1_1");
		group1_1.setParent(group1);
		group1_1.setSystem(network);
		
		Group group1_2 = factory.createGroup();
		group1_2.setInterest("interest1_2");
		group1_2.setParent(group1);
		group1_2.setSystem(network);
		
		Group group1_2_1 = factory.createGroup();
		group1_2_1.setInterest("interest1_2_1");
		group1_2_1.setParent(group1_2);
		group1_2_1.setSystem(network);
		
		network.getGroups().add(group1);
		network.getGroups().add(group2);
		network.getGroups().add(group1_1);
		network.getGroups().add(group1_2);
		network.getGroups().add(group1_2_1);
	}

	private static void createNodes() {
		Node node1 = factory.createNode();
		node1.setFirstName("F1");
		node1.setLastName("L1");
		node1.setLatitude(1);
		node1.setLongitude(1);
		node1.setSystem(network);
		
		Node node2 = factory.createNode();
		node2.setFirstName("F2");
		node2.setLastName("L2");
		node2.setLatitude(2);
		node2.setLongitude(2);
		node2.setSystem(network);
		
		Node node3 = factory.createNode();
		node3.setFirstName("F3");
		node3.setLastName("L3");
		node3.setLatitude(3);
		node3.setLongitude(3);
		node3.setSystem(network);
		
		Node node4 = factory.createNode();
		node4.setFirstName("F4");
		node4.setLastName("L4");
		node4.setLatitude(4);
		node4.setLongitude(4);
		node4.setSystem(network);
		
		Node node5 = factory.createNode();
		node5.setFirstName("F5");
		node5.setLastName("L5");
		node5.setLatitude(5);
		node5.setLongitude(5);
		node5.setSystem(network);
	}
	
	private static void assignNodesToGroups() {
		EList<Group> groups = network.getGroups();
		EList<Node> nodes = network.getNodes();
		
		groups.get(0).getMembers().add(nodes.get(0));
		groups.get(1).getMembers().add(nodes.get(1));
		groups.get(2).getMembers().add(nodes.get(2));
		groups.get(2).getMembers().add(nodes.get(4));
		groups.get(3).getMembers().add(nodes.get(3));
		groups.get(3).getMembers().add(nodes.get(4));
	}
	
	private static void linkNodes() {
		EList<Node> nodes = network.getNodes();
		
		Link link1 = factory.createLink();
		link1.setSource(nodes.get(0));
		link1.setTarget(nodes.get(1));
		
		Link link2 = factory.createLink();
		link2.setSource(nodes.get(0));
		link2.setTarget(nodes.get(4));
		
		Link link3 = factory.createLink();
		link3.setSource(nodes.get(1));
		link3.setTarget(nodes.get(3));
	}
}

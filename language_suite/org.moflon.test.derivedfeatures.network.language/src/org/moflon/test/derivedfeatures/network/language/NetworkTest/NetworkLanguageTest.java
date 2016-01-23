package org.moflon.test.derivedfeatures.network.language.NetworkTest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.moflon.test.derivedfeatures.network.language.Group;
import org.moflon.test.derivedfeatures.network.language.LanguageFactory;
import org.moflon.test.derivedfeatures.network.language.Link;
import org.moflon.test.derivedfeatures.network.language.NetworkSystem;
import org.moflon.test.derivedfeatures.network.language.Node;

public class NetworkLanguageTest {

	private static LanguageFactory factory = LanguageFactory.eINSTANCE;
	
	@BeforeClass
	public static void initializeNetwork() {
		//completeNetwork = TestSetup.createNetworkSystem();
	}
	
	@Test
	public void testSystemGetNodeCount() {
		NetworkSystem network = factory.createNetworkSystem();
		network.getNodes().add(factory.createNode());
		network.getNodes().add(factory.createNode());
		
		int actual = network.getNodeCount(); 
		Assert.assertEquals(2, actual);
	}
	
	@Test
	public void testSystemGetNodeCount_NoNodesRegistered() {
		NetworkSystem network = factory.createNetworkSystem();
		
		int actual = network.getNodeCount(); 
	 	Assert.assertEquals(0, actual);
	}
		
	@Test
	public void testNodeGetFullName() {
		Node node = factory.createNode();
		node.setFirstName("first");
		node.setLastName("last");
		String expected = "first last";
		
		String actual = node.getFullName();
		Assert.assertEquals(expected, actual);
	}

	@Ignore("Unfortunately, we always have to initialize Strings.")
	@Test
	public void testNodeGetFullName_EmptyNames() {
		Node node = factory.createNode();
		String expected = " ";
		
		String actual = node.getFullName();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testNodeTransmittingRange() {
		Node node = factory.createNode();
		node.setTransmittingPower(5);
		
		double actual = node.getTransmittingRange();
		double expected = Math.sqrt(node.getTransmittingPower());
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void testNodeGetInDegree() {
		Node node = factory.createNode(); 
		Link link0 = factory.createLink();
		Link link1 = factory.createLink();
		link0.setTarget(node);
		link1.setTarget(node);
		
		int actual = node.getInDegree();
		Assert.assertEquals(2, actual);
	}
	
	@Test
	public void testNodeGetInDegree_NoLinksRegistered() {
		Node node = factory.createNode(); 
		
		int actual = node.getInDegree();
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void testNodeGetOutDegree() {
		Node node = factory.createNode(); 
		Link link0 = factory.createLink();
		Link link1 = factory.createLink();
		link0.setSource(node);
		link1.setSource(node);
		
		int actual = node.getOutDegree();
		Assert.assertEquals(2, actual);
	}
	
	@Test
	public void testNodeGetOutDegree_NoLinksRegistered() {
		Node node = factory.createNode(); 
		
		int actual = node.getOutDegree();
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void testNodeGetTotalDegree() {
		Node node = factory.createNode(); 
		Link link0 = factory.createLink();
		Link link1 = factory.createLink();
		Link link2 = factory.createLink();
		Link link3 = factory.createLink();
		link0.setSource(node);
		link1.setSource(node);
		link2.setTarget(node);
		link3.setTarget(node);
		
		int actual = node.getTotalDegree();
		Assert.assertEquals(4, actual);
	}
	
	@Test
	public void testLinkGetDistance() {
		Node sourceNode = factory.createNode();
		sourceNode.setLatitude(0);
		sourceNode.setLongitude(0);
		
		Node targetNode = factory.createNode();
		sourceNode.setLatitude(1);
		sourceNode.setLongitude(1);
		
		Link link = factory.createLink();
		link.setSource(sourceNode);
		link.setTarget(targetNode);
		
		double actual = link.getDistance(); 
		Assert.assertTrue(actual > 150000);
		Assert.assertTrue(actual < 160000);
	}
	
	@Test(expected=NullPointerException.class)
	public void testLinkGetDistance_NoNodesConnected() {
		Link link = factory.createLink();
		
		link.getDistance(); 
	}
	
	@Test
	public void testGroupIsPopulated_True() {
		Group group = factory.createGroup();
		group.getMembers().add(factory.createNode());
		
		boolean actual = group.isPopulated(); 
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void testGroupIsPopulated_False() {
		Group group = factory.createGroup();
		
		boolean actual = group.isPopulated(); 
		Assert.assertEquals(false, actual);
	}
	
	@Test
	public void testGroupGetSize() {
		Group group = factory.createGroup();
		group.getMembers().add(factory.createNode());
		group.getMembers().add(factory.createNode());
		
		int actual = group.getSize(); 
		Assert.assertEquals(2, actual);
	}
	
	@Test
	public void testGroupGetSize_NoNodesRegistered() {
		Group group = factory.createGroup();

		int actual = group.getSize(); 
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void testGroupGetTreeSize() {
		Group groupParent = factory.createGroup();
		Group group = factory.createGroup();
		Group groupChild = factory.createGroup();
		
		group.setParent(groupParent);
		groupChild.setParent(group);
		
		Node node0 = factory.createNode();
		Node node1 = factory.createNode();
		
		groupParent.getMembers().add(node0);
		groupParent.getMembers().add(node1);
		group.getMembers().add(node0);
		group.getMembers().add(node1);
		groupChild.getMembers().add(node0);
		groupChild.getMembers().add(node1);
		
		Assert.assertEquals(6, groupParent.getTreeSize());
		Assert.assertEquals(4, group.getTreeSize());
		Assert.assertEquals(2, groupChild.getTreeSize());
	}
	
	@Test
	public void testGroupGetSystemName() {
		NetworkSystem system = factory.createNetworkSystem();
		Group group = factory.createGroup();
		system.getGroups().add(group);
		
		String expected = "testName";
		system.setName(expected);

		String actual = group.getSystemName(); 
		Assert.assertEquals(expected, actual);
	}
	
	@Ignore //TODO@aaltenkirch: Provide an Implemenatation / fix fals 'unknown type' bug
	@Test
	public void testGroupAddLeader() throws Exception {
		NetworkSystem system = factory.createNetworkSystem();
		Group group = factory.createGroup();
		system.getGroups().add(group);
		final Node leader = factory.createNode();
		Assert.assertEquals(leader, group.getLeader());
	}
}

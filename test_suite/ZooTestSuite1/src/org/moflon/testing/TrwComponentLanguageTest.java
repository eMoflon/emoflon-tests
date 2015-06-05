package org.moflon.testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;
import org.moflon.core.utilities.eMoflonEMFUtil;

import ComponentLanguage.Component;
import ComponentLanguage.ComponentLanguagePackage;
import ComponentLanguage.PathTreeNode;
import ComponentLanguage.Port;
import ComponentLanguage.ProvidePort;
import ComponentLanguage.SoftwareSystem;

public class TrwComponentLanguageTest {
	
	SoftwareSystem softwareSystem;
	@Before
	public void setUp() throws Exception {
		EObject model =eMoflonEMFUtil.loadAndInitModel(ComponentLanguagePackage.eINSTANCE, "../ZooTestSuite1/instances/TRW/instanceSmall.xmi");
		if(model instanceof SoftwareSystem)
		{
			softwareSystem=(SoftwareSystem) model;
			
			Component mainCompoment=null;
			for (Component component : softwareSystem.getComponents()) {
				if(component.getName().equals("Main"))
				{
					mainCompoment=component;
				}
				
			}
			
			ProvidePort providePort=null;
			for (Port port : mainCompoment.getPorts()) {
				if(port.getName().equals("op_Main_p0")){
					providePort=(ProvidePort) port;
				}
				
			}
			softwareSystem.createChangeRequest("cr1");
			softwareSystem.getChangeRequests().get(0).createPathTree(0, 0, 0.9, providePort);
		}
		
		
		
		
		
		
	}

	//Ensures that each provided port has at most one pathtreenode
	@Test
	public void testNoTwoPaths(){
		TreeIterator<EObject> it=softwareSystem.eAllContents();
		EObject obj=null;
		for(;it.hasNext();obj=it.next()){
			if(obj instanceof ProvidePort){
				ProvidePort port=(ProvidePort) obj;
				assertFalse(port.getCorrespondingNode().size()>1);
									
			}
			
		}
	}
	
	@Test
	public void	testCompareResultsWithDFS(){
		EObject modelDFS =eMoflonEMFUtil.loadAndInitModel(ComponentLanguagePackage.eINSTANCE, "../ZooTestSuite1/instances/TRW/instanceSmallDFS.xmi");
				
		TreeIterator<EObject> it=softwareSystem.eAllContents();
		EObject obj=null;
		for(;it.hasNext();obj=it.next()){
			if(obj instanceof ProvidePort){
				ProvidePort port=(ProvidePort) obj;
				assertFalse(port.getCorrespondingNode().size()>1);
				if(port.getCorrespondingNode().size()>0){
					Double maxcost=getMaxCost(port.getName(),modelDFS);
					assertTrue(port.getCorrespondingNode().get(0).getCost()==maxcost);
								
				}
					
					
				
			}
		
		}
	}
			
	public static double getMaxCost(String portName, EObject model){
		TreeIterator<EObject> it=model.eAllContents();
		EObject obj=null;
		for(;it.hasNext();obj=it.next()){
			if(obj instanceof ProvidePort){
				ProvidePort port=(ProvidePort) obj;
				if(port.getName().equals(portName)){
					double max;
					max=0;
					for (PathTreeNode node : port.getCorrespondingNode()) {
						if(max<node.getCost())
							max=node.getCost();
					}
				return max;	
				}
						
			}
		}
		
		
	 return 0;
		
	}

}

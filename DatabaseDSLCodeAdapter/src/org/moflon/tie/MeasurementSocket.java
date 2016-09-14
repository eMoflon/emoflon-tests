package org.moflon.tie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class MeasurementSocket {

	public static HashMap<String, EObject> socket = new HashMap<String, EObject>();
	
	public static void reset() throws IOException{
		HashSet<ResourceSet> sets = new HashSet<ResourceSet>();
		for(EObject object : socket.values()){
			if(object.eResource() != null){
				sets.add(object.eResource().getResourceSet());
				object.eResource().getResourceSet().eAdapters().clear();
				object.eResource().unload();
				
			}
				
			
			EcoreUtil.delete(object, true);
		}
		
		socket.clear();
		
	}
}

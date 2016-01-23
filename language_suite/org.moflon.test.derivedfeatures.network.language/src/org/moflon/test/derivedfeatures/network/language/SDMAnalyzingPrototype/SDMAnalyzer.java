package org.moflon.test.derivedfeatures.network.language.SDMAnalyzingPrototype;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.moflon.test.derivedfeatures.network.language.LanguageFactory;
import org.moflon.test.derivedfeatures.network.language.Node;

public class SDMAnalyzer {
	
	private static LanguageFactory factory = LanguageFactory.eINSTANCE;
	
	public static void main(String[] args) {
		
		Node node = factory.createNode();
				
		for (EOperation operation : node.eClass().getEAllOperations()) {
			EStructuralFeature eContainingFeature = operation.eContainingFeature();
			Object eGet = operation.eGet(eContainingFeature);
			Resource eResource = operation.eResource();
			
			TreeIterator<EObject> allContents = operation.eAllContents();
		
			while (allContents.hasNext()) {
				
				EObject object = allContents.next();
				
				if (object instanceof EGenericType) {
					EGenericType genericType = (EGenericType)object;
					System.out.println(genericType);
				}
				
			}
		}
	}
}

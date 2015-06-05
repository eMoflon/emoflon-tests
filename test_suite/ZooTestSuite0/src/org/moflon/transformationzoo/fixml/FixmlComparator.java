package org.moflon.transformationzoo.fixml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.eclipse.emf.common.util.EList;

import fixmlPackage.CompilationUnit;
import fixmlPackage.FixmlAttribute;
import fixmlPackage.FixmlClass;
import fixmlPackage.FixmlObjectAttribute;
import fixmlPackage.FixmlObjectAttributeAttribute;

public class FixmlComparator {
	static StringTemplateGroup st;
	
	public static void compare(CompilationUnit expected, CompilationUnit created) {
		try {
			st = new StringTemplateGroup(new FileReader(new File("./templates/fixml.stg")));

			StringTemplate cuCreated = st.getTemplateDefinition("CompilationUnit");
			StringTemplate cuExpected = st.getTemplateDefinition("CompilationUnit");

			toText(cuCreated, created);
			toText(cuExpected, expected);
			
			assertEquals(cuCreated.toString(), cuExpected.toString());

		} catch (FileNotFoundException e) {
			fail();
		}
	}

	private static void toText(StringTemplate template, CompilationUnit created) {
		
		// Handle classes
		EList<FixmlClass> fixClasses = created.getFixmlClass();
		ArrayList<String> fixClassesText = new ArrayList<>();

		for (FixmlClass fixmlClass : fixClasses) {
			fixClassesText.add(toText(fixmlClass));
		}
		
		Collections.sort(fixClassesText);
		template.setAttribute("fixClasses", fixClassesText);

		// handle attributes
		
		EList<FixmlAttribute> fixAttrs = created.getFixmlAttribute();
		ArrayList<String> fixAttrsText = new ArrayList<>();

		for (FixmlAttribute fixmlAttr : fixAttrs) {
			fixAttrsText.add(fixmlAttr.getName() + ": " +  fixmlAttr.getValue() + " -> " + fixmlAttr.getFixmlClass().getName());
		}
		
		Collections.sort(fixAttrsText);
		template.setAttribute("fixAttrs", fixAttrsText); 
	}

	private static String toText(FixmlClass fixmlClass) {
		StringTemplate stClass = st.getTemplateDefinition("FixmlClass");
		
		String name = fixmlClass.getName();
		stClass.setAttribute("name", name);
		
		int level = fixmlClass.getLevel(); 
		stClass.setAttribute("level", level);
		
		ArrayList<String> refObjAttrs = new ArrayList<>();
		for (FixmlObjectAttribute objAttr : fixmlClass.getRefObjectAttribute()) {
			refObjAttrs.add(objAttr.getType());
		}
		Collections.sort(refObjAttrs);
		stClass.setAttribute("refObjAttrs", refObjAttrs);
		
		ArrayList<String> attrs = new ArrayList<>();
		for (FixmlAttribute attr : fixmlClass.getAttribute()) {
			attrs.add(attr.getName() + ":" + attr.getValue());
		}
		Collections.sort(attrs);
		stClass.setAttribute("attrs", attrs);
		
		// handle object attributes
		ArrayList<String> objAttrs = new ArrayList<>();
		for (FixmlObjectAttribute objAttr : fixmlClass.getFixmlObjectAttribute()) {
			objAttrs.add(toText(objAttr));
		}
		Collections.sort(objAttrs);
		stClass.setAttribute("objAttrs", objAttrs);		
		
		return stClass.toString();
	}

	private static String toText(FixmlObjectAttribute objAttr) {
		StringTemplate stObjAttr = st.getTemplateDefinition("FixmlObjAttr");
		
		String type = objAttr.getType();
		stObjAttr.setAttribute("type", type);
		
		String refClass = objAttr.getRefClass().getName();
		stObjAttr.setAttribute("refClass", refClass);
		
		if(objAttr.getFixmlClass() != null){
			String fixmlClass = objAttr.getFixmlClass().getName();
			stObjAttr.setAttribute("fixmlClass", fixmlClass); 
		}
			
		// handle object attributes
		ArrayList<String> objAttrAttrs = new ArrayList<>();
		for (FixmlObjectAttributeAttribute objAttrAttr : objAttr
				.getFixmlObjectAttributeAttribute()) {
			objAttrAttrs.add(objAttrAttr.getName() + ":" + objAttrAttr.getValue());
		}
		Collections.sort(objAttrAttrs);
		stObjAttr.setAttribute("objAttrAttrs", objAttrAttrs);

		ArrayList<String> objAttrs = new ArrayList<>();
		for (FixmlObjectAttribute objAttrSub : objAttr
				.getFixmlObjectAttributeElement()) {
			objAttrs.add(toText(objAttrSub));
		}
		Collections.sort(objAttrs);
		stObjAttr.setAttribute("objAttrs", objAttrs);

		
		return "";
	}

}

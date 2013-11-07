package com.example.charactergenerator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import android.content.res.Resources;

public class Characteristics {
	private Resources resources;
	private HashMap<String, HashMap<String, ArrayList<String>>> values;
	
	private ArrayList<Group> groups;
	
	public Characteristics(Resources resources) {
		this.resources = resources;
		setupData();
		values = new HashMap<String, HashMap<String,ArrayList<String>>>();
		
		ArrayList<String> hair = new ArrayList<String>();
		hair.add("Blonde");
		hair.add("Black");
		hair.add("Red");
		
		ArrayList<String> eyes = new ArrayList<String>();
		eyes.add("Blue");
		eyes.add("Black");
		eyes.add("Green");
		
		HashMap<String, ArrayList<String>> group = new HashMap<String, ArrayList<String>>();
		group.put("Hair Color", hair);
		group.put("Eye Color", eyes);
		
		values.put("Physical Traits", group);
		
		ArrayList<String> type = new ArrayList<String>();
		type.add("Villain");
		type.add("Hero");
		type.add("Common folk");
		
		ArrayList<String> archetype = new ArrayList<String>();
		archetype.add("Charming Villain");
		archetype.add("Enigmatic Villain");
		archetype.add("Sadistic Villain");
		
		group = new HashMap<String, ArrayList<String>>();
		group.put("Character Type", type);
		group.put("Archetype", archetype);
		
		values.put("Character Archetype", group);
	}

	public HashMap<String, HashMap<String, ArrayList<String>>> values() {
		return values;
	}
	
	private void setupData() {
		SAXBuilder builder = new SAXBuilder();
		InputStream xmlFile = resources.openRawResource(R.raw.data);
		try {
			System.err.println("COMECANDO");
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			for (Element attribute : rootNode.getChildren("attribute")) {
				System.out.println("Attribute : " + attribute.getChildText("name"));
				for(Element option : attribute.getChildren("option")) {
					System.out.println("\tOption: " + option.getChildText("name"));
					System.out.println("\tWeight: " + option.getChildText("weight"));
				}
			}
			
			for (Element affix : rootNode.getChildren("affix")) {
				System.out.println("Affix: " + affix.getChildText("name"));
				for (Element option : affix.getChildren("option")) {
					System.out.println("\tOption: " + option.getText());
				}
			}
			System.err.println("TERMINOU");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}

package com.example.charactergenerator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import android.content.res.Resources;

public class Characteristics {
	private Resources resources;

	private ArrayList<Group> groups;

	public Characteristics(Resources resources) {
		this.resources = resources;
		setupData();
	}
	
	public Group getGroup(String name) {
		return groups.get(groups.indexOf(name));
	}

	private void setupData() {
		groups = new ArrayList<Group>();
		try {
			SAXBuilder builder = new SAXBuilder();
			InputStream xmlFile = resources.openRawResource(R.raw.data);
			Document document = (Document) builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			for (Element groupNode : rootNode.getChildren("group")) {
				Group group = new Group(groupNode.getChildText("name"));
				groups.add(group);
				for (Element attributeNode : groupNode.getChildren("attribute")) {
					Attribute attribute = new Attribute(attributeNode.getChildText("id"), 
							attributeNode.getChildText("name"));
					group.add(attribute);
					for (Element optionNode : attributeNode.getChildren("option")) {
						String name = optionNode.getChildText("name");
						Integer weight = Integer.parseInt(optionNode.getChildText("weight")); 
						attribute.add(new Option(name, weight));
					}
				}
			}

			for (Element affix : rootNode.getChildren("affix")) {
				for (Element option : affix.getChildren("option")) {
					// System.out.println("\tOption: " + option.getText());
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}

}

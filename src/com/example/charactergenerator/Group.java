package com.example.charactergenerator;

import java.util.ArrayList;

public class Group {
	private String name;
	private ArrayList<Attribute> attributes;
	
	public Group(String name) {
		super();
		this.name = name;
		this.attributes = new ArrayList<Attribute>();
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}
	
	public boolean add(Attribute attribute) {
		return attributes.add(attribute);
	}
}

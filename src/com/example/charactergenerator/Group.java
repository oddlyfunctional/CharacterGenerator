package com.example.charactergenerator;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Attribute> getAttributes(String name) {
		return new ListWrapper<Attribute>(attributes).find(name);
	}
	
	public boolean add(Attribute attribute) {
		return attributes.add(attribute);
	}
	
	@Override
	public boolean equals(Object o) {
		return name.equals(o);
	}
}

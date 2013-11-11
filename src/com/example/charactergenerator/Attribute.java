package com.example.charactergenerator;

import java.util.ArrayList;

public class Attribute {
	private String name;
	private String id;
	private ArrayList<Option> options;

	public Attribute(String id, String name) {
		this.name = name;
		this.id = id;
		this.options = new ArrayList<Option>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Option> getOptions() {
		return options;
	}
	
	public ArrayList<String> getOptionsAsStringList() {
		ArrayList<String> strings = new ArrayList<String>();
		for (Option option : options) {
			strings.add(option.getName());
		}
		return strings;
	}
	
	public boolean add(Option option) {
		return options.add(option);
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		String string;
		if (o instanceof String) {
			string = (String) o;
		} else {
			string = ((Attribute) o).getId();
		}
		return name.equals(string) || id.equals(string);
	}

	@Override
	public String toString() {
		return id + ": " + name;
	}
}

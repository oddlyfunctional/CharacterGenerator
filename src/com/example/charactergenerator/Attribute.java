package com.example.charactergenerator;

import java.util.ArrayList;

public class Attribute {
	private String name;
	private ArrayList<Option> options;

	public Attribute(String name) {
		this.name = name;
		this.options = new ArrayList<Option>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Option> getOptions() {
		return options;
	}
	
	public boolean add(Option option) {
		return options.add(option);
	}
}

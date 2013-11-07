package com.example.charactergenerator;

public class Option {
	
	private String name;
	private Integer weight;
	
	public Option(String option, Integer weight) {
		this.name = option;
		this.weight = weight;
	}
	
	public Integer getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}

}

package com.example.charactergenerator.tests;

import java.util.Arrays;

import com.example.charactergenerator.Characteristics;

import junit.framework.TestCase;

public class CharacteristicsTest extends TestCase {
	
	private Characteristics characteristics;

	protected void setUp() throws Exception {
		characteristics = new Characteristics(null);
	}
	
	public void testGroups() {
		System.out.println(characteristics.values());
		assertTrue(characteristics.values().containsKey("Physical Traits"));
	}
	
	public void testAttributes() {
		assertTrue(characteristics.values().get("Physical Traits").containsKey("Hair Color"));
	}
	
	public void testOptions() {
		assertTrue(characteristics.values().get("Physical Traits").get("Hair Color").contains("Blonde"));
	}

}

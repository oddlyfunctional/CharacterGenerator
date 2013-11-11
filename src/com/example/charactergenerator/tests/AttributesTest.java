package com.example.charactergenerator.tests;

import junit.framework.TestCase;

import com.example.charactergenerator.Attribute;

public class AttributesTest extends TestCase {
	private Attribute attribute;
	
	protected void setUp() throws Exception {
		attribute = new Attribute("attributeId", "Attribute Name");
	}
	
	public void testEqualsWithName() {
		assertEquals(attribute, attribute.getName());
	}
	
	public void testEqualsWithId() {
		assertEquals(attribute, attribute.getId());
	}

}

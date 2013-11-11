package com.example.charactergenerator.tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.example.charactergenerator.Attribute;
import com.example.charactergenerator.Group;

public class GroupsTest extends TestCase {
	
	private Group group;
	private Attribute attribute;

	protected void setUp() throws Exception {
		group = new Group("Group Name");
		attribute = new Attribute("attributeId", "Attribute Name");
		group.add(attribute);
	}

	public void testEquals() {		
		assertEquals(group, group.getName());
	}
	
	public void testGetAttributesById() {
		assertEquals(group.getAttributes(attribute.getId()).get(0), attribute);
	}
	
	public void testGetAttributesWithByName() {
		Attribute anotherAttribute = new Attribute("anotherAttribute", attribute.getName());
		group.add(anotherAttribute);
		assertEquals(group.getAttributes(attribute.getName()).get(0), attribute);
		assertEquals(group.getAttributes(attribute.getName()).get(1), anotherAttribute);
	}
}

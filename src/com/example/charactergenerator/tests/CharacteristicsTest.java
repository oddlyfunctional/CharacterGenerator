package com.example.charactergenerator.tests;

import junit.framework.TestCase;

import com.example.charactergenerator.Characteristics;
import com.example.charactergenerator.Group;

public class CharacteristicsTest extends TestCase {
	
	private Characteristics characteristics;

	protected void setUp() throws Exception {
		characteristics = new Characteristics(null);
	}
	
	public void testGetGroup() {
		assertNotNull(characteristics.getGroup("Physical Traits"));
	}
//	
//	public void testGetAttribute() {
//		assertNotNull(characteristics.getGroup("Physical Traits").getAttribute("Hair Color"));
//	}
//	
//	public void testGetOption() {
//		assertNotNull(characteristics.getGroup("Physical Traits").getAttribute("Hair Color").getOption("Blonde"));
//	}

}

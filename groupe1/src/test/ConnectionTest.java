package test;

import static org.junit.Assert.*;

import org.junit.Test;

import control.*;

public class ConnectionTest {
	private static Connection co = new Connection("Vk", "mdr");
	private static Connection co1 = new Connection("Jean", "lol");
	private static Connection co2 = new Connection("JauneAttend", "mdr");

	@Test
	public void testConnection() {
		
		assertEquals(co.getConnect(), true);
		assertEquals(co1.getConnect(), false);
		assertEquals(co2.getConnect(), false);
		
	}
	
	@Test
	public void testCreateSession() {
		
		assertTrue(co.createSession() instanceof Admin);
		assertTrue(co.createSession() instanceof User);
		assertTrue(co.createSession() instanceof User);
		
	}

}

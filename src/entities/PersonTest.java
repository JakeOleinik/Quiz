package entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
	@Test
	public void validEmailTest() {
		Person testPerson = new Person();
		testPerson.setEmail("test_email@gmail.com");
		assertEquals(testPerson.getEmail(), "test_email@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidEmailTest() {
		Person testPerson = new Person();
		testPerson.setEmail("support.google.com");
	}
	
	@Test
	public void validNameTest() {
		Person testPerson = new Person();
		testPerson.setLastName("Jones");
		testPerson.setFirstName("Bob");
		assertEquals(testPerson.getFirstName(), "Bob");
		assertEquals(testPerson.getLastName(), "Jones");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalidNameTest() {
		Person testPerson = new Person();
		testPerson.setLastName("Abc123");
	}
}

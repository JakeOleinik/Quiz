package persistency;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import entities.*;

public class PersonMapperTester {

	private Person myPerson;
	private Group myGroup;

	@Before
	public void setUp() throws Exception {
		this.myGroup = new Group("just a group");	// group is a prerequesite for a person
		GroupMapper.INSTANCE.createGroup(this.myGroup);
		this.myPerson = new Person("Jackson", "Michael", "+1111111111", "mjackson@gmail.com", "1958-08-29", this.myGroup);
	}
	
	/*
	 * Test method for 'persistency.PersonMapper.createPerson(Person)'
	 */
	@Test
	public void testCreatePerson() {
		int id = PersonMapper.INSTANCE.createPerson(this.myPerson);
		Person createdPerson = PersonMapper.INSTANCE.getPersonById(id);
		assertEquals("No consistent ID's when creating a person", id,
				createdPerson.getId());
		PersonMapper.INSTANCE.deletePerson(createdPerson);
	}

	/*
	 * Test method for 'persistency.PersonMapper.deletePerson(int)'
	 */
//	@Test
//	public void testDeletePerson() {
//		int id = PersonMapper.UNIQUEINSTANCE.createPerson(this.myPerson);
//		assertEquals("Person not deleted",1 , PersonMapper.UNIQUEINSTANCE.deletePerson(id));
//	}
//
//	/*
//	 * Test method for 'persistency.PersonMapper.updatePerson(Person)'
//	 */
//	@Test
//	public void testUpdatePerson() {
//		int id = PersonMapper.UNIQUEINSTANCE.createPerson(this.myPerson);
//		Person testPerson = PersonMapper.UNIQUEINSTANCE.getPersonById(id);
//		testPerson.setFirstname("Janet");
//		assertEquals("Update not succeded",1,PersonMapper.UNIQUEINSTANCE.updatePerson(testPerson));
//		assertEquals("Updated value not changed",
//				testPerson.getFirstname(),
//				PersonMapper.UNIQUEINSTANCE.getPersonById(id).getFirstname());
//		PersonMapper.UNIQUEINSTANCE.deletePerson(id);
//	}

}

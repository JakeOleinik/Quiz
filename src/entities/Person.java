package entities;

import java.time.LocalDate;

public class Person {
	private Team team;
	private String lastName;
	private String firstName;
	private String phone;
	private String email;
	private LocalDate dateOfBirth;

	/**
	 * 
	 * @param name
	 * @param firstName
	 * @param phone
	 * @param email
	 */
	public Person(String name, String firstName, String phone, String email) {
		// TODO - implement Person.Person
		throw new UnsupportedOperationException();
	}

	public String getName() {
		// TODO - implement Person.getName
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		// TODO - implement Person.setName
		throw new UnsupportedOperationException();
	}

	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return this.phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * 
	 * @param dateOfBirth
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
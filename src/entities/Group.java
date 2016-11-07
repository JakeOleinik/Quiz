package entities;

import java.util.*;

public class Group {
	private Collection<Person> members;
	private Collection<Team> teams;
	private String name;
	private int id;

	/**
	 * 
	 * @param name
	 */
	public Group(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Group(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param name
	 */
	public Team createTeam(String name) {
		// TODO - implement Group.createTeam
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param person
	 * @param team
	 */
	public void addPersonToTeam(Person person, Team team) {
		// TODO - implement Group.addPersonToTeam
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "" + this.id + ": " + this.name;
	}
}
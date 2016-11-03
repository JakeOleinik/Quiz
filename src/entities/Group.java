package entities;

import java.util.*;

public class Group {
	private Collection<Person> members;
	private Collection<Team> teams;
	private String name;

	/**
	 * 
	 * @param name
	 */
	public Group(String name) {
		// TODO - implement Group.Group
		throw new UnsupportedOperationException();
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
}
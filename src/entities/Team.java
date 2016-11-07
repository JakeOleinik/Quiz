package entities;

import java.util.*;

public class Team {
	private Collection<Person> members;
	private Collection<QuizReport> quizReports;
	private String name;
	private int id;

	public String getName() {
		return this.name;
	}
	
	public Team(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Team(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Person> getMembers() {
		// TODO - implement Team.getMembers
		throw new UnsupportedOperationException();
	}
}
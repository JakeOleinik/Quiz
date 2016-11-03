package entities;

import java.util.*;

public class Team {
	private Collection<Person> members;
	private Collection<QuizReport> quizReports;
	private String name;

	public String getName() {
		return this.name;
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
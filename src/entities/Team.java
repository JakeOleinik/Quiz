package entities;

import java.util.*;

public class Team {
	private Collection<Person> members;
	private Collection<QuizReport> quizReports;
	private String name;
	private int id;
	private int groupId;

	public String getName() {
		return this.name;
	}
	
	public Team(int id, String name, int groupId) {
		this.id = id;
		this.name = name;
		this.groupId = groupId;
	}
	
	public Team(String name, int groupId) {
		this.name = name;
		this.groupId = groupId;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGroupId() {
		return this.groupId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public ArrayList<Person> getMembers() {
		// TODO - implement Team.getMembers
		throw new UnsupportedOperationException();
	}
}
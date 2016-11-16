package entities;

import java.util.*;

public class Team implements IHasId {
	private Collection<Person> members;
	private Collection<QuizReport> quizReports;
	private String name;
	private int id;
	private Group group;

	public String getName() {
		return this.name;
	}
	
	public Team(int id, String name, Group group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}
	
	public Team(String name, Group group) {
		this.name = name;
		this.group = group;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public int getGroupId() {
		return this.group.getId();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}

	public void addMember(Person member) {
		this.members.add(member);
	}
	
	public Collection<Person> getMembers() {
		return members;
	}
	
	public String toString() {
		return "" + this.id + ": " + this.name;
	}

	public Collection<QuizReport> getQuizReports() {
		return quizReports;
	}
}
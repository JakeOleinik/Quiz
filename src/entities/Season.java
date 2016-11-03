package entities;


import java.util.*;

public class Season {
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
}
package entities;


import java.util.*;

public class Season {
	private Collection<QuizReport> quizReports;
	private String name;
	private int id;
	
	public Season(String name) {
		this.name = name;
	}
	
	public Season(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addQuizReport(QuizReport quizReport) {
		this.quizReports.add(quizReport);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
package entities;

import java.util.*;

import util.Helpers;

import java.time.LocalDate;

public class Quiz implements IHasId {
	private Collection<Round> rounds;
	private Collection<QuizReport> quizReports;
	private int currentRoundIdx;
	private String location;
	private LocalDate date;
	private Season season;
	private int id;
	
	public Quiz(String location, LocalDate date, Season season) {
		this.location = location;
		this.date = date;
		this.season = season;
	}
	
	public Quiz(int id, String location, LocalDate date, Season season) {
		this.id = id;
		this.location = location;
		this.date = date;
		this.season = season;
	}
	
	public Quiz(int id, String location, String date) {
		this.id = id;
		this.location = location;
		this.date = Helpers.StringToDate(date);
		//this.season = season;
	}

	public void addRound(Round round) {
		rounds.add(round);
	}
	
	public void addReport(QuizReport report) {
		quizReports.add(report);
	}
	
	public QuizReport addTeam(Team team)
	{
		return new QuizReport(team, this, season);
	}
	
	public void getNextQuestion() {
		// TODO - implement Quiz.getNextQuestion
		throw new UnsupportedOperationException();
	}

	public void answerQuestion(Team team, Answer answer) {
		// TODO - implement Quiz.answerQuestion
		throw new UnsupportedOperationException();
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String toString() {
		return "" + this.id + ": @" + this.location + " on " + this.date.toString();
	}
}
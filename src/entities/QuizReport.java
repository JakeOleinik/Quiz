package entities;

import java.util.ArrayList;

public class QuizReport {
	private Quiz quiz;
	private Team team;
	private ArrayList<Integer> roundScores;
	private Season season;

	public QuizReport(Team team, Quiz quiz, Season season) {
		this.team = team;
		this.quiz = quiz;
		this.season = season;
		season.addQuizReport(this);
	}
	
	public QuizReport(Team team, Quiz quiz) {
		this.team = team;
		this.quiz = quiz;
	}

	public int getTotalScore() {
		int sum = 0;
		for (int x : roundScores)
			sum += x;
		
		return sum;
	}

	public int getRoundScore(int roundIdx) {
		return roundScores.get(roundIdx);
	}
	
	public ArrayList<Integer> getRoundScores() {
		return this.roundScores;
	}

	public void incrementRoundScore(int roundIdx, int amount) {
		roundScores.set(roundIdx, roundScores.get(roundIdx));
	}
	
	public Quiz getQuiz()
	{
		return this.quiz;
	}
	
	public Team getTeam()
	{
		return this.team;
	}
	
	public Season getSeason()
	{
		return this.season;
	}
}
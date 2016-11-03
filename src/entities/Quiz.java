import java.util.*;

public class Quiz {

	Collection<Round> rounds;
	Collection<QuizReport> quizReports;
	private int currentRoundIdx;
	private String location;
	private DateTime date;

	public void getNextQuestion() {
		// TODO - implement Quiz.getNextQuestion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param team
	 * @param answer
	 */
	public void answerQuestion(Team team, Answer answer) {
		// TODO - implement Quiz.answerQuestion
		throw new UnsupportedOperationException();
	}

	public String getLocation() {
		return this.location;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public DateTime getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(DateTime date) {
		this.date = date;
	}

}
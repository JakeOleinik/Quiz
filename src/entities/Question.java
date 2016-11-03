package entities;

import java.util.*;

public class Question {
	private Collection<Picture> pictures;
	private Collection<Answer> answers;
	private String text;
	private String explanation;
	private int mark;

	/**
	 * 
	 * @param text
	 * @param explanation
	 * @param mark
	 */
	public Question(String text, String explanation, int mark) {
		// TODO - implement Question.Question
		throw new UnsupportedOperationException();
	}

	public String getText() {
		return this.text;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public int getMark() {
		return this.mark;
	}

	/**
	 * 
	 * @param answer
	 */
	public void addAnswer(Answer answer) {
		// TODO - implement Question.addAnswer
		throw new UnsupportedOperationException();
	}

}
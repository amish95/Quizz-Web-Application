package com.QuizzApplication.QuizzWebApplication.Models;

public class QuestionResult {

	private String questionText;
	private OptionForAnswers options;
	private int correctAnswerIndex;

	public QuestionResult(String questionText, OptionForAnswers options, int correctAnswerIndex) {
		super();
		this.questionText = questionText;
		this.options = options;
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public OptionForAnswers getOptions() {
		return options;
	}

	public void setOptions(OptionForAnswers options) {
		this.options = options;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}

	@Override
	public String toString() {
		return "QuestionResult [questionText=" + questionText + ", options=" + options + ", correctAnswerIndex="
				+ correctAnswerIndex + "]";
	}

}

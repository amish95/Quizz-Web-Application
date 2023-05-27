package com.QuizzApplication.QuizzWebApplication.Models;

import java.util.List;

public class QuizResult {

	private Integer quizId;
	private List<QuestionResult> questionResults;

	public QuizResult(Integer quizId, List<QuestionResult> questionResults) {
		super();
		this.quizId = quizId;
		this.questionResults = questionResults;
	}

	public QuizResult() {
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public List<QuestionResult> getQuestionResults() {
		return questionResults;
	}

	public void setQuestionResults(List<QuestionResult> questionResults) {
		this.questionResults = questionResults;
	}

	@Override
	public String toString() {
		return "QuizResult [quizId=" + quizId + ", questionResults=" + questionResults + "]";
	}

}

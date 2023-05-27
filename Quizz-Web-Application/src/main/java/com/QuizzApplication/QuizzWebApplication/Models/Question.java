package com.QuizzApplication.QuizzWebApplication.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String questionText;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ans_option_id")
	private OptionForAnswers optionForAnswers;

	@JsonProperty(access = Access.WRITE_ONLY)
	private int correctAnswerIndex;

	public Question(Integer id, String questionText, OptionForAnswers optionForAnswers, int correctAnswerIndex) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.optionForAnswers = optionForAnswers;
		this.correctAnswerIndex = correctAnswerIndex;
	}

	public Question() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public OptionForAnswers getAnswerOption() {
		return optionForAnswers;
	}

	public void setAnswerOption(OptionForAnswers optionForAnswers) {
		this.optionForAnswers = optionForAnswers;
	}

	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}

	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}

}

package com.QuizzApplication.QuizzWebApplication.Models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OptionForAnswers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ansOptionId;

	@ElementCollection
	private List<String> options;

	public OptionForAnswers(List<String> options) {
		if (options.size() != 4) {
			throw new IllegalArgumentException("Answer option must contain exactly 4 elements");
		}
		this.options = options;
	}

	public OptionForAnswers(Integer ansOptionId, List<String> options) {
		super();
		this.ansOptionId = ansOptionId;
		this.options = options;
	}
	public OptionForAnswers() {
	}

	public Integer getAnsOptionId() {
		return ansOptionId;
	}

	public void setAnsOptionId(Integer ansOptionId) {
		this.ansOptionId = ansOptionId;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "AnswerOption [ansOptionId=" + ansOptionId + ", options=" + options + "]";
	}
	
	

}

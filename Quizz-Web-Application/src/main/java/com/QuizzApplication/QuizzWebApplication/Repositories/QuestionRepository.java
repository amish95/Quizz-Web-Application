package com.QuizzApplication.QuizzWebApplication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizzApplication.QuizzWebApplication.Models.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{

	
}

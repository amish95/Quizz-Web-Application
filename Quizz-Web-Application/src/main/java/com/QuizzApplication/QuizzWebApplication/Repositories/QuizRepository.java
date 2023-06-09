package com.QuizzApplication.QuizzWebApplication.Repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.QuizzApplication.QuizzWebApplication.Models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	@Query("SELECT q FROM Quiz q WHERE q.startDate <= :currentTime AND q.endDate >= :currentTime")
	Optional<Quiz> findActiveQuiz(LocalDateTime currentTime);

}

package com.QuizzApplication.QuizzWebApplication.service;

import java.util.List;

import com.QuizzApplication.QuizzWebApplication.Models.Quiz;
import com.QuizzApplication.QuizzWebApplication.Models.QuizResult;
import com.QuizzApplication.QuizzWebApplication.Models.User;
import com.QuizzApplication.QuizzWebApplication.exception.QuizNotFoundException;
import com.QuizzApplication.QuizzWebApplication.exception.ResultNotAvailableException;
import com.QuizzApplication.QuizzWebApplication.exception.UserNotFoundException;

public interface QuizService {
	
	public User createUser(User user);
	public Quiz createQuiz(Quiz quiz,Integer userId)throws UserNotFoundException;
	public List<Quiz> getAllQuizzes();
	public Quiz getQuizById(Integer quizId)throws QuizNotFoundException;
	public Quiz getActiveQuiz() throws QuizNotFoundException;
	public QuizResult getQuizResult(Integer quizId) throws QuizNotFoundException,ResultNotAvailableException;
}

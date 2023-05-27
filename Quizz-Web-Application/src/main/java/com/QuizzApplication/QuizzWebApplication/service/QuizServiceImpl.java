package com.QuizzApplication.QuizzWebApplication.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizzApplication.QuizzWebApplication.Models.OptionForAnswers;
import com.QuizzApplication.QuizzWebApplication.Models.Question;
import com.QuizzApplication.QuizzWebApplication.Models.QuestionResult;
import com.QuizzApplication.QuizzWebApplication.Models.Quiz;
import com.QuizzApplication.QuizzWebApplication.Models.QuizResult;
import com.QuizzApplication.QuizzWebApplication.Models.User;
import com.QuizzApplication.QuizzWebApplication.Repositories.QuizRepository;
import com.QuizzApplication.QuizzWebApplication.Repositories.UserRepository;
import com.QuizzApplication.QuizzWebApplication.exception.QuizNotFoundException;
import com.QuizzApplication.QuizzWebApplication.exception.ResultNotAvailableException;
import com.QuizzApplication.QuizzWebApplication.exception.UserNotFoundException;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository qr;

	//@Autowired
	//private QuestionRepository questionRepository;

	@Autowired
	private UserRepository ur;

	@Autowired
	private QuizStatusService quizStatusService;

	public User createUser(User user) {
		return ur.save(user);
	}

	@Override
	public Quiz createQuiz(Quiz quiz, Integer userId) throws UserNotFoundException {
		LocalDateTime now = LocalDateTime.now();

		LocalDateTime endDate = now.plusMinutes(5);

		quiz.setStartDate(now);
		quiz.setEndDate(endDate);
		

		//Functional logic
		 ur.findById(userId).orElseThrow(() -> new UserNotFoundException("Invalid user ID: " + userId));

		Quiz createdQuiz = qr.save(quiz);

		quizStatusService.updateQuizStatus();

		return createdQuiz;
	}

	@Override
	public List<Quiz> getAllQuizzes() {
		return qr.findAll();
	}

	@Override
	public Quiz getQuizById(Integer quizId) throws QuizNotFoundException {
		return qr.findById(quizId).orElseThrow(() -> new QuizNotFoundException("Quiz not found"));
	}

	@Override
	public Quiz getActiveQuiz() throws QuizNotFoundException {

		LocalDateTime currentTime = LocalDateTime.now();
		Optional<Quiz> activeQuiz = qr.findActiveQuiz(currentTime);

		return activeQuiz.orElseThrow(() -> new QuizNotFoundException("No active quiz found."));
	}

	@Override
	public QuizResult getQuizResult(Integer quizId) throws QuizNotFoundException, ResultNotAvailableException {
		Quiz quiz = qr.findById(quizId).orElseThrow(() -> new QuizNotFoundException("Quiz not found."));

		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime quizEndTime = quiz.getEndDate().plusMinutes(5);
		if (currentTime.isBefore(quizEndTime)) {
			throw new ResultNotAvailableException("Quiz result is not available yet.");
		}

		Set<Question> questions = quiz.getQuestions();
		List<QuestionResult> questionResults = new ArrayList<>();

		for (Question question : questions) {
			int correctAnswerIndex = question.getCorrectAnswerIndex();
			String questionText = question.getQuestionText();
			OptionForAnswers options = question.getAnswerOption();
			QuestionResult questionResult = new QuestionResult(questionText, options, correctAnswerIndex);
			questionResults.add(questionResult);
		}

		return new QuizResult(quizId, questionResults);
	}

}

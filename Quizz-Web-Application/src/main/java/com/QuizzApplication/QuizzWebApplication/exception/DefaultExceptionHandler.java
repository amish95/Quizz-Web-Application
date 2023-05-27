package com.QuizzApplication.QuizzWebApplication.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class DefaultExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Errors> UserNotFoundException(UserNotFoundException nfe, WebRequest req) {
		Errors error = new Errors(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<Errors>(error, HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Errors> dataValidationExceptionHandler(MethodArgumentNotValidException ne) {

		Errors error = new Errors();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validaton error");
		error.setDetails(ne.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<Errors>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Errors> exceptionClassHandler(Exception pe, WebRequest req) {

		Errors error = new Errors(LocalDateTime.now(), pe.getMessage(), req.getDescription(false));

		return new ResponseEntity<Errors>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Errors> noUriHandlerFoundException(NoHandlerFoundException nfe, WebRequest req) {
		Errors error = new Errors(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<Errors>(error, HttpStatus.OK);
	}

	@ExceptionHandler(ResultNotAvailableException.class)
	public ResponseEntity<Errors> ResultNotAvailableException(ResultNotAvailableException nfe, WebRequest req) {
		Errors error = new Errors(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<Errors>(error, HttpStatus.OK);
	}

}

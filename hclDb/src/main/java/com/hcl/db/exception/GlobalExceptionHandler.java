package com.hcl.db.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { NoSuchElementException.class })
	public ResponseEntity<String> emptyId(NoSuchElementException noSuchEx) {
		return new ResponseEntity<String>(
				"No Id found in DB Exception Cause: " + noSuchEx.getCause() + " Message: " + noSuchEx.getMessage(),
				HttpStatus.NOT_FOUND);
	}
}

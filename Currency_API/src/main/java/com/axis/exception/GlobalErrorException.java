package com.axis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorException {

	@ExceptionHandler(DateNotFoundException.class)
	public ResponseEntity<ErrorInfo> dateNotFound(DateNotFoundException exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DuplicateDateFound.class)
	public ResponseEntity<ErrorInfo> dateFound(DuplicateDateFound exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.FOUND.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.FOUND);
	}
	@ExceptionHandler(USD_NotFound.class)
	public ResponseEntity<ErrorInfo> USDNotFound(USD_NotFound exception){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(exception.getMessage());
		errorInfo.setHttpStatus(HttpStatus.FOUND.toString());
		errorInfo.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.FOUND);
	}
}

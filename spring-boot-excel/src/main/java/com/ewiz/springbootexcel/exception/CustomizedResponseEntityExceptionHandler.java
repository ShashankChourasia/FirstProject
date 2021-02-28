package com.ewiz.springbootexcel.exception;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//				request.getDescription(false));
//		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().toString());
		List<FieldError> br= ex.getBindingResult().getFieldErrors();
		Iterator<FieldError> it= br.iterator();
		while(it.hasNext())
		logger.error("{}", it.next().getDefaultMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}

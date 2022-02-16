package com.esanchez.demo.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice //intercepta las excepciones
public class GlobalExceptionHandler {
	/*
	@ExceptionHandler
	public ResponseEntity<ErrorDetails> DBEmpty(DBEmptyException exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails("13232222222222222232", exception.getMessage());
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
*/	
	
	 @ExceptionHandler(DBEmptyException.class)
	    public ResponseEntity<ErrorDetails> DBEmpty(DBEmptyException exception,
	                                                                        WebRequest webRequest){
	        ErrorDetails errorDetails = new ErrorDetails( "ERROR 1500", exception.getMessage());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	 
	 
	/*
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> handleErrorSaludoDuplicado(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException,
																		WebRequest webRequest){
		
		
		ErrorDetails errorDetails = new ErrorDetails("900", "Tipo de saludo existente");
		
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		 
	}*/

}

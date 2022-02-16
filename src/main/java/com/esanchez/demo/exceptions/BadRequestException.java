package com.esanchez.demo.exceptions;

public class BadRequestException extends RuntimeException {

	public BadRequestException() {
		
	}
	
	public BadRequestException(String mensaje) {
		super(mensaje);
	}
}

package com.esanchez.demo.exceptions;

public class DBEmptyException extends RuntimeException{
	
	public DBEmptyException() {
		super("La tabla no cuenta con ningun registro");
	}

}

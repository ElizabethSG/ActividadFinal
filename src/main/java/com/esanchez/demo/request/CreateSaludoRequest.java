package com.esanchez.demo.request;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSaludoRequest {
 
	private Long id;
	 
	private String tipo;
	 
	private String saludo;
}

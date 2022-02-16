package com.esanchez.demo.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePersonaRequest {

	private String nombre;

	private int edad;
	
	private String direccion;
	
	//Empresa
	private String empresa;
	
	private String direccion_empresa;
}

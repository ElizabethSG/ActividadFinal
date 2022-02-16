package com.esanchez.demo.response;

import org.springframework.web.client.RestTemplate;

import com.esanchez.demo.entity.Persona;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaResponseAgregar {
	
	private String saludo;
	
	private Long id;
	
	private String nombre;

	private int edad;
	
	private String direccion;

	//Empresa
	private String empresa;
		
	private String direccion_empresa;
	
	
	public PersonaResponseAgregar (Persona persona) {
		String uri ="http://localhost:8080/microservice/saludo/getSaludo";
		RestTemplate restTemplate = new RestTemplate();
		this.saludo= restTemplate.getForObject(uri, String.class);
		
		this.id= persona.getId();
		this.nombre = persona.getNombre();
		this.edad = persona.getEdad();
		this.direccion = persona.getDireccion();
		
		this.empresa = persona.getEmpresa().getEmpresa();
		this.direccion_empresa = persona.getEmpresa().getDireccion_empresa();
	}

}

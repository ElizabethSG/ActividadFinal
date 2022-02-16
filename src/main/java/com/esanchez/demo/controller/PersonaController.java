package com.esanchez.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.esanchez.demo.entity.Persona;
import com.esanchez.demo.request.CreatePersonaRequest;
import com.esanchez.demo.response.PersonaResponse;
import com.esanchez.demo.response.PersonaResponseAgregar;
import com.esanchez.demo.service.PersonaService;

@RestController
@RequestMapping("/microservice/persona")
public class PersonaController {
	
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public PersonaController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Autowired
	PersonaService personaService;
	

	//POST - AGREGAR PERSONA
			@PostMapping("/crearPersona")
			public PersonaResponseAgregar agregarPersona(@RequestBody CreatePersonaRequest createPersonaRequest) {
					Persona persona = personaService.agregarPersona(createPersonaRequest);
					 
					return   new PersonaResponseAgregar( persona);
			}
		
						
		
	//GET- VER TODAS LAS PERSONAS
		@GetMapping("/verPersonas")
		public List<Persona> getTodasLasPersonas() {
			return personaService.getTodasLasPersonas();
		}
		
		
	//GET- OBTENER PERSONA POR NOMBRE	
		@GetMapping("/obtenerPersonaPorNombre/{nombre}")
		public PersonaResponse getByNombre (@PathVariable String nombre) {
			return new PersonaResponse(personaService.getByNombre(nombre));
		}
}

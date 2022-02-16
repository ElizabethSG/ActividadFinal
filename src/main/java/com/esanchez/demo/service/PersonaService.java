package com.esanchez.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esanchez.demo.entity.Persona;
import com.esanchez.demo.exceptions.BadRequestException;
import com.esanchez.demo.exceptions.DBEmptyException;
import com.esanchez.demo.exceptions.NotFoundException;
import com.esanchez.demo.entity.Empresa;
import com.esanchez.demo.repository.EmpresaRepository;
import com.esanchez.demo.repository.IPersonaRepository;
import com.esanchez.demo.request.CreatePersonaRequest;

@Service
public class PersonaService {
	
	@Autowired
	IPersonaRepository iPersonaRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;

	//POST- AGREGAR PERSONA
		public Persona agregarPersona (CreatePersonaRequest createPersonaRequest) {
			
			Persona persona = new Persona(createPersonaRequest); //creando objeto persona
			
			Empresa empresa = new Empresa();//creando objeto empresa
			empresa.setEmpresa(createPersonaRequest.getEmpresa());
			empresa.setDireccion_empresa(createPersonaRequest.getDireccion_empresa());

			
			empresa = empresaRepository.save(empresa);
			
			persona.setEmpresa(empresa); //llave foranea
			persona = iPersonaRepository.save(persona);
			return persona;
		}
		
	//GET- VER TODAS LAS PERSONAS
		public List<Persona> getTodasLasPersonas() {
		/*	if(getTodasLasPersonas().isEmpty() ) {
				throw new DBEmptyException();
			}*/
			
			return iPersonaRepository.findAll();
		}
		

		
	//GET- OBTENER PERSONA POR NOMBRE
		public Persona getByNombre (String nombre) {
			if (nombre==null || nombre.isEmpty()) {
				throw new DBEmptyException();
			}
			
			return iPersonaRepository.getByNombre(nombre);
		}
}

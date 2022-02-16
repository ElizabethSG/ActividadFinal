package com.esanchez.demo.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esanchez.demo.entity.Saludo;
import com.esanchez.demo.repository.ISaludoRepository;
import com.esanchez.demo.request.CreateSaludoRequest;

@Service
public class SaludoService {
	
	@Autowired 
	ISaludoRepository iSaludoRepository;
	
	
	//Los saludos
	
	public List<Saludo> getAllSaludos(){
		return iSaludoRepository.findAll();
	}
			
	//AGREGAR SALUDO

	public Saludo agregarSaludo (CreateSaludoRequest createSaludoRequest) {
		
		Saludo saludo = new Saludo(createSaludoRequest);
		
		saludo = iSaludoRepository.save(saludo);
		return saludo;
		
	}
	
	
			//GET SALUDO POR TIPO
	public Saludo getByTipo(String tipo) {
		return iSaludoRepository.getByTipo(tipo);
		
	}
	
 
}


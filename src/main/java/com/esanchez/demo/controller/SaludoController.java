package com.esanchez.demo.controller;


import java.text.SimpleDateFormat;
import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esanchez.demo.entity.Saludo;
import com.esanchez.demo.request.CreateSaludoRequest;
import com.esanchez.demo.response.SaludoResponse;
import com.esanchez.demo.response.getSaludoResponse;
import com.esanchez.demo.service.SaludoService;
						//localhost:8070/microservice/saludo/getSaludo
@RestController
@RequestMapping("/microservice/saludo")
public class SaludoController {
	
	@Autowired
	SaludoService saludoService;
	
	
				//POST AGREGAR SALUDO
	@PostMapping("/crearSaludo")
	public SaludoResponse agregarSaludo(@RequestBody CreateSaludoRequest createSaludoRequest) {
		Saludo saludo = saludoService.agregarSaludo(createSaludoRequest);
						
		return new SaludoResponse(saludo);

	}
	
				//GET SALUDO POR TIPO
	@GetMapping("/getSaludoPorTipo/{tipo}")
	public SaludoResponse getByTipo (@PathVariable String tipo) {
		return new SaludoResponse(saludoService.getByTipo(tipo));
	}
	
	
	
	//GET SALUDO 
	@GetMapping("/getSaludo")
	public getSaludoResponse getSaludo () {
		
		Date h= new Date();
		SimpleDateFormat dateFormat;
		dateFormat = new SimpleDateFormat("kk");
		
		String hour=dateFormat.format(h);
		int hora=Integer.parseInt(hour);
		
	
		String tipo="";
		if (hora>=05 && hora<=11) {
			 tipo="mañana";

		} else if (hora>=12 && hora<=18) {
			tipo="tarde";
		}else if ((hora>=19) && (hora<=24)) {
			tipo="noche";
		}else if ((hora>=00) && (hora<=04)) {
			tipo="noche";
		}

		System.out.println(tipo);
		return new getSaludoResponse(saludoService.getByTipo(tipo));
	}


}

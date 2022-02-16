package com.esanchez.demo.response;


import com.esanchez.demo.entity.Saludo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaludoResponse {

	
	private Long id;
	private String tipo;
	private String saludo;
	
	public SaludoResponse (Saludo saludo) {
		this.id = saludo.getId();
		this.tipo = saludo.getTipo();
		this.saludo = saludo.getSaludo();
	}
	
 
	
}
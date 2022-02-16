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
public class getSaludoResponse {


	private String saludo;

	
	public getSaludoResponse (Saludo saludo) {
		this.saludo = saludo.getSaludo();
	}
}

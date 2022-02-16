package com.esanchez.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.esanchez.demo.request.CreatePersonaRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name="persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre",unique = true)
	private String nombre;
	
	@Column(name = "edad")
	private int edad;
	
	@Column(name = "direccion")
	private String direccion;
	
	@OneToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	public Persona(CreatePersonaRequest createPersonaRequest) {
		this.nombre = createPersonaRequest.getNombre();
		this.edad = createPersonaRequest.getEdad();
		this.direccion = createPersonaRequest.getDireccion();
		
	}
	
}

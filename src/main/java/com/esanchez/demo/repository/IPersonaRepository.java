package com.esanchez.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esanchez.demo.entity.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

	 //GET persona por nombre
	   @Query("From Persona where nombre = :nombre")
		Persona getByNombre (@Param("nombre") String nombre);
	   
	 //GET - Ver todas las personas
	   @Query("From Persona")
		Persona getTodasLasPersonas ();
	   
	   

}

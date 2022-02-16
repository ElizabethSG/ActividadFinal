package com.esanchez.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esanchez.demo.entity.Saludo;


@Repository
public interface ISaludoRepository extends JpaRepository<Saludo, Long>{
	
	//GET SALUDO POR TIPO
	@Query("From Saludo where tipo =:tipo")
	Saludo getByTipo (@Param("tipo") String tipo);


}

package com.arturo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arturo.model.Cesta;

public interface CestasRepository extends JpaRepository<Cesta, Integer> {
	
	List<Cesta> findByIdUsuarioAndTipo(Integer idUsuario, String tipo);	
	Optional<Cesta> findById(Integer id);

}

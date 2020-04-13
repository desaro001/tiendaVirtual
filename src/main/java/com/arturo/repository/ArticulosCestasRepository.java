package com.arturo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.arturo.model.ArticuloCesta;

public interface ArticulosCestasRepository extends JpaRepository<ArticuloCesta, Integer> {	
	
	List<ArticuloCesta> findByIdCesta(int idCesta);
	ArticuloCesta findByIdArticuloAndIdCesta(int idArticulo, int idCesta);		
	void deleteById(Integer idAc);

}
